package com.oracle.domain;

import java.util.List;

public class Role {
    private int id;
    private String roleName;
    private List<Permission> permissions;
    private String roleDesc;

    public Role() {
    }

    public Role(int id, String roleName, List<Permission> permissions, String roleDesc) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
