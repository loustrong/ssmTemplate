package com.tom.ssm.spring5.chapter0706.config;

import com.tom.ssm.spring5.chapter0706.Axe;
import com.tom.ssm.spring5.chapter0706.Person;
import com.tom.ssm.spring5.chapter0706.impl.Chinese;
import com.tom.ssm.spring5.chapter0706.impl.SteelAxe;
import com.tom.ssm.spring5.chapter0706.impl.StoneAxe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @descriptions: AppConfig
 * @author: Tom
 * @date: 2021/2/5 下午 06:20
 * @version: 1.0
 */
@Configuration
public class AppConfig {
    @Value("孫悟空") String personName;
    // 配置bean:stoneAxe
    @Bean(name="stoneAxe")
    public com.tom.ssm.spring5.chapter0706.Axe stoneAxe(){
        return new StoneAxe();
    }
    // 配置Bean: steelAxe
    @Bean(name="steelAxe")
    public com.tom.ssm.spring5.chapter0706.Axe steelAxe(){
        return new SteelAxe();
    }
    @Bean(name="chinese")
    public Person person(){
        Chinese p = new Chinese();
        p.setAxe(this.stoneAxe());
        p.setName(personName);
        return p;
    }
}
