package com.oracle.service.Impl;

import com.github.pagehelper.PageHelper;
import com.oracle.dao.RoleDao;
import com.oracle.domain.Role;
import com.oracle.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    public RoleDao roleDao;
    @Override
    public List<Role> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return roleDao.findAll(page,size);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findRoleById(int id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public void addPermission(int roleId, int[] ids) {
        for (int id:ids){
            roleDao.addPermission(roleId,id);
        }

    }
}
