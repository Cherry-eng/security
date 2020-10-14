package com.oracle.service;

import com.oracle.domain.Role;

import java.util.List;

public interface RoleService {
    //[1]角色查询（所有角色信息）
    public List<Role> findAll(int page,int size);
    //[2]添加角色
    public void save(Role role);
    //[3]通过id查询当前角色
    public Role findRoleById(int id);
    //[4]角色添加权限
    public void addPermission(int roleId,int[] ids);
}
