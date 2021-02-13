package com.tom.ssm.springmvc.chapter06.chapter0601.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormatter
 *
 * @author Tom on 2021/2/13
 */
public class DateFormatter implements Formatter<Date> {
    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern){
        this.dateFormat = new SimpleDateFormat(datePattern);
    }
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        try{
            return dateFormat.parse(s);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
//        return null;
    }

    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
//        return null;
    }
}
