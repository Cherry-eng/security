package com.oracle.service.Impl;

import com.github.pagehelper.PageHelper;
import com.oracle.dao.UserDao;
import com.oracle.domain.Role;
import com.oracle.domain.UserInfo;
import com.oracle.service.UserService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    /*
    [1]调用dao，查询账号信息（张三）
    [2]查询该对象的密码和表单中提交得密码是否一致
    [3]查看一下角色是否匹配（ROLE_ADMIN,ROLE_USER）
    */
    @Autowired
    private UserDao userDao;
    public UserDetails loadUserByUsername(String username){
        UserInfo userInfo=null;//数据库中的用户信息
        try {
            userInfo=userDao.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(userInfo);
       //[1]创建User对象，一个是构造方法中三个参数的构造器，一个是构造方法中七个参数的构造器
      //User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),this.getAuthority(userInfo.getRoles()));
       // [3]验证用户是或否可用status
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
       /* List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));//为每一个成功登陆的账号一个角色（与配置一样）
        return list;*/
        List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
        for (Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
         return list;
    }

    @Override
    public List<UserInfo> findAll(int page,int size) {

        PageHelper.startPage(page,size);
        return userDao.findAll(page,size);
    }
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findRoleById(int id) {
        return userDao.findRoleById(id);
    }

    @Override
    public void addRoleToUser(int userId, int[] ids) {
        for (int id:ids){
            //遍历角色ids数组，进行逐条添加（循环添加数据）
            userDao.addRoleToUser(userId,id);
        }

    }
}
