package com.oracle.service;

import com.oracle.domain.Permission;

import java.util.List;

public interface PermissionService {
    //[1]查询
    public List<Permission> findAll(int page,int size);
    //[2]添加
    public void save(Permission permission);
    //[3]通过角色id查找当前角色没有的权限
    public List<Permission> findOtherPermission(int id);
}
