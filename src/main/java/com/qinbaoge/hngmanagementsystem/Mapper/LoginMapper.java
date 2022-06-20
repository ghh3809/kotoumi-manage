package com.qinbaoge.hngmanagementsystem.Mapper;

import com.qinbaoge.hngmanagementsystem.Entity.Username;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public Username find_this_username(String username);
}
