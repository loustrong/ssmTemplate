package com.tom.ssm.springmvc.chapter06.chapter0601.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * MyFormatterRegistrar
 *
 * @author Tom on 2021/2/13
 */
public class MyFormatterRegistrar implements FormatterRegistrar {

    private DateFormatter dateFormatter;
    public void setDateFormatter(DateFormatter dateFormatter){
        this.dateFormatter = dateFormatter;
    }
    @Override
    public void registerFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(dateFormatter);
    }
}
