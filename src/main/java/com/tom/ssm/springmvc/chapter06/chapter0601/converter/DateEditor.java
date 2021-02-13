package com.tom.ssm.springmvc.chapter06.chapter0601.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateEditor
 *
 * @author Tom on 2021/2/13
 */
public class DateEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = dateFormat.parse(text);
            setValue(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
}
