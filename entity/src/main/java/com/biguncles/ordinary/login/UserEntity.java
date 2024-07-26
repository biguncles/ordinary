package com.biguncles.ordinary.login;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
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
