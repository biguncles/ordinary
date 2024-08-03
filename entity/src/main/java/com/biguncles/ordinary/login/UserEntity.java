package com.biguncles.ordinary.login;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "user")
@Data
public class UserEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * M密码
     */
    private String password;
}
