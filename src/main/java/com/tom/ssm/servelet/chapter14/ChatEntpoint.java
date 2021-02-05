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
 * @date: 2021/2/4 ���� 11:46
 * @version: 1.0
 */
@ServerEndpoint(value = "/websocket/chat")
public class ChatEntpoint {
    private static final String GUEST_PREFIX = "�L��";
    private static final AtomicInteger connectionIds =
            new AtomicInteger(0);
    // ���xһ������,��춱������н����ߵ�websocket�͑���
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
        String message = String.format("[%s %s]",nickname, "������������");
        broadcast(message);
    }
    @OnClose
    public void end(){
        clientSet.remove(this);
        String message = String.format("[ %s %s]", nickname, "�x�_��������!");
        broadcast(message);
    }
    @OnMessage
    public void incoming(String message){
        String filteredMessage = String.format("[ %s %s]", nickname, filter(message));
        broadcast(message);
    }
    @OnError
    public void onError(Throwable t) throws Throwable{
        System.out.println("Websocket���ն��e�` " + t);
    }
    private static void broadcast(String msg){
        for(ChatEntpoint client: clientSet){
            try{
                synchronized (client){
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                System.out.println("�����e�`,��͑���" + client + " �l����Ϣ���F�e�`");
                clientSet.remove(client);
                try{
                    client.session.close();
                } catch (IOException ex) {
                    String message = String.format("[ %s %s]",
                            client.nickname, "�ѽ����_���B��");
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
            // ���ƌ�������̖�������ַ��M���D�x
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
