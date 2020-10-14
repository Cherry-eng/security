package com.oracle.service;

import com.oracle.domain.Role;
import com.oracle.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    //[1]查询所有账号信息
    public List<UserInfo> findAll(int page,int size);
    //[2]添加用户
    public void save(UserInfo userInfo);
    //[3]用户详情
    public UserInfo findById(int id);
    //[4]通过用户id查找对应的角色
    public List<Role> findRoleById(int id);
    //[5]给某个用户添加角色
    public void addRoleToUser(int userId,int[] ids);
}
