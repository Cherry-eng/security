package com.oracle.service.Impl;

import com.github.pagehelper.PageHelper;
import com.oracle.dao.PermissionDao;
import com.oracle.domain.Permission;
import com.oracle.service.PermissionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    public PermissionDao permissionDao;
    @Override
    public List<Permission> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return permissionDao.findAll(page,size);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(int id) {
        return permissionDao.findOtherPermission(id);
    }
}
