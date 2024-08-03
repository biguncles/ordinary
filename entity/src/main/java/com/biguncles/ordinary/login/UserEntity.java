package com.biguncles.ordinary.login;

import jakarta.persistence.Table;
import lombok.Data;


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
