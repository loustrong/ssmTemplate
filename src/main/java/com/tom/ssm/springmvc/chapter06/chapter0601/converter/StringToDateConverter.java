package com.tom.ssm.springmvc.chapter06.chapter0601.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * StringToConverter
 *
 * @author Tom on 2021/2/13
 */
public class StringToDateConverter implements Converter<String, Date> {
    private String datePattern;
    public void setDatePattern(String dataPattern){
        this.datePattern = dataPattern;
    }
    @Override
    public Date convert(String date) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
            return dateFormat.parse(date);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("日期转换失败");
            return null;
        }

    }
}
