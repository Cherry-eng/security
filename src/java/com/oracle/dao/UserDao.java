package com.oracle.dao;

import com.oracle.domain.Role;
import com.oracle.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserDao {
    //[1]通过用户名查找用户对象
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "email",property = "email"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.oracle.dao.RoleDao.findRoleByUserId")),

    })
    public UserInfo findByUsername(String username);
    //[2]查询所有账号信息
    @Select("select * from users")
    public List<UserInfo> findAll(int page,int size);
    //[3]添加账户
    @Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo);
    //[4]通过用户id查找当前用户信息
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "email",property = "email"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.oracle.dao.RoleDao.findRoleByUserId")),

    })
    public UserInfo findById(int id);
    //[5]通过用户id查找该用户 没有 的角色
    @Select("select * from role where id not in (select RoleId from users_role where userId=#{id})")
    public List<Role> findRoleById(int id);
    //[6]给用户添加角色
    @Insert("insert into users_role (userId,roleId) values (#{userId},#{id})")
    public void addRoleToUser(@Param("userId") int userId,@Param("id") int id);
}
