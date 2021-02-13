package com.tom.ssm.springmvc.chapter06.chapter0601.binding;

import com.tom.ssm.springmvc.chapter06.chapter0601.converter.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.util.Date;

/**
 * DateBindingInitializer
 *
 * @author Tom on 2021/2/13
 */
public class DateBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}
