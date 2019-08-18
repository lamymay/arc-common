package com.arc.model.domain.mq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author may
 * @since 2019/6/18 12:36
 */
@Setter
@Getter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String nickName;

   private String email;

    private String cardNumber;

    public User() {
    }

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String nickName) {
        this.nickName = nickName;
    }
}

