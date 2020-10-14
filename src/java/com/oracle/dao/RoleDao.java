package com.oracle.dao;

import com.oracle.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{id})")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,many = @Many(select = "com.oracle.dao.PermissionDao.findPermissionByRoleId")),

    })
    public List<Role> findRoleByUserId(int id);
    //[2]查询所有角色
    @Select("select * from role")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,many = @Many(select = "com.oracle.dao.PermissionDao.findPermissionByRoleId")),

    })
    public List<Role> findAll(int page,int size);
    //[3]添加角色
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    public void save(Role role);
    //[4]通过角色id查找角色对象
    @Select("select * from role where id=#{id}")
    public Role findRoleById(int id);
    //[5]给角色添加权限
    @Insert("insert into role_permission (permissionId,roleId) values (#{id},#{roleId})")
    public void addPermission(@Param("roleId") int roleId,@Param("id") int id);//roleId角色id，id权限主键
}
