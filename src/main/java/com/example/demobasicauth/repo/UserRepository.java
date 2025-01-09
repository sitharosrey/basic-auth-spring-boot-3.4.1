package com.example.demobasicauth.repo;

import com.example.demobasicauth.entity.UserApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("""
                SELECT username, password from user_tb where username = #{username}
            """)
    UserApp getUserByUsername(String username);
}