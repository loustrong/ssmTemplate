package com.tom.ssm.springmvc.chapter06.chapter0601.validator;

import com.tom.ssm.springmvc.chapter06.chapter0601.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * UserValidator
 *
 * @author Tom on 2021/2/13
 */
//@Repository("userValidator")
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // User指定的Class参数所表示的类或接口是否相同,或是否是其超类或者超接口
        return User.class.isAssignableFrom(clazz);
    }
    // 对目标类target进行校验，并将校验错误记录在error中
    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 使用@ValidationUtil中的一个静态方法rejectIfEmpty()来对loginname进行属性校验
         * 假若loginname属性时bull或者空字符串，就拒绝验证通过
         */
        ValidationUtils.rejectIfEmpty(errors,"loginname", null, "登陆名字不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password", null, "密码不能为空");
        User user = (User) target;
        if(user.getLoginname().length() > 10){
            errors.rejectValue("loginname", null, "用户名不能超过10个字符");
        }
        if(user.getPassword()!= null && !user.getPassword().equals("")
        && user.getPassword().length() < 6){
            errors.rejectValue("password", null, "密码不能小于6位");
        }

    }
}
