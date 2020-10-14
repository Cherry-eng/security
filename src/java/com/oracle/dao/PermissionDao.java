package com.oracle.dao;

import com.oracle.domain.Permission;
import com.oracle.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(int id);
    @Select("select * from permission")
    public List<Permission> findAll(int page,int size);

    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    public void save(Permission permission);
    //[4]查找权限（通过用户当前角色没有的）
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findOtherPermission(int id);
 }
