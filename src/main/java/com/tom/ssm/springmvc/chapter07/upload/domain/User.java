package com.tom.ssm.springmvc.chapter07.upload.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * User
 *
 * @author Tom on 2021/2/13
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private MultipartFile image;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
