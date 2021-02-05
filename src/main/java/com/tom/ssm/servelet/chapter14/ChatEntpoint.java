package com.tom.ssm.servelet.chapter14;

import javax.swing.text.AbstractDocument;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @descriptions: ChartEntPoint
 * @author: Tom
 * @date: 2021/2/4 下午 11:46
 * @version: 1.0
 */
@ServerEndpoint(value = "/websocket/chat")
public class ChatEntpoint {
    private static final String GUEST_PREFIX = "訪客";
    private static final AtomicInteger connectionIds =
            new AtomicInteger(0);
    // 定義一個集合,用於保存所有接入者的websocket客戶端
    private static final Set<ChatEntpoint> clientSet =
            new CopyOnWriteArraySet<>();
    private final String nickname;
    private Session session;
    public ChatEntpoint(){
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();

    }
    @OnOpen
    public void start(Session session){
        this.session = session;
        clientSet.add(this);
        String message = String.format("[%s %s]",nickname, "加入了聊天室");
        broadcast(message);
    }
    @OnClose
    public void end(){
        clientSet.remove(this);
        String message = String.format("[ %s %s]", nickname, "離開了聊天室!");
        broadcast(message);
    }
    @OnMessage
    public void incoming(String message){
        String filteredMessage = String.format("[ %s %s]", nickname, filter(message));
        broadcast(message);
    }
    @OnError
    public void onError(Throwable t) throws Throwable{
        System.out.println("Websocket服務端錯誤 " + t);
    }
    private static void broadcast(String msg){
        for(ChatEntpoint client: clientSet){
            try{
                synchronized (client){
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                System.out.println("聊天錯誤,向客戶端" + client + " 發送消息出現錯誤");
                clientSet.remove(client);
                try{
                    client.session.close();
                } catch (IOException ex) {
                    String message = String.format("[ %s %s]",
                            client.nickname, "已經斷開了連接");
                    broadcast(message);
                }
            }
        }

    }
    private static String filter(String message){
        if(message == null){ return null;}
        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuilder result= new StringBuilder(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            // 控制對劍尖括號等特殊字符進行轉義
            switch (content[i]){
                case '<' :
                    result.append("&lt;");
                    break;
                case '>' :
                    result.append("&gt;");
                    break;
                case '&' :
                    result.append("&amp;");
                    break;
                case '"' :
                    result.append("&quot;");
                    break;
                default :
                    result.append(content[i]);
                    break;
            }
        }

        return (result.toString());
    }
}
