package com.biguncles.ordinary.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.biguncles.ordinary.login.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
