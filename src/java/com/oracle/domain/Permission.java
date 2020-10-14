package com.oracle.domain;

public class Permission {
   private int id;
   private String permissionName;
   private String url;

    public Permission() {
    }

    public Permission(int id, String permissionName, String url) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
