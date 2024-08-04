package com.stu.dao.impl;

import com.stu.dao.BasicDao;
import com.stu.dao.SysUserDao;
import com.stu.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BasicDao<SysUser> implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String ls_sql = "insert into sys_user values(null,?,?)";
        return update(ls_sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

    @Override
    public List<SysUser> findAll() {
        String ls_sql = "select * from sys_user";
        List<SysUser> sysUsers = queryMulti(ls_sql, SysUser.class);
        return sysUsers;
    }

    @Override
    public SysUser findByUsername(String username) {
        String ls_sql = "select * from sys_user where username=?";
        SysUser sysUser = querySingle(ls_sql, SysUser.class,username);
        return sysUser;
    }

    @Override
    public SysUser findByUsernameAndPwd(String username, String pwd) {
        String ls_sql = "select * from sys_user where username=? and user_pwd = ?";
        SysUser sysUser = querySingle(ls_sql, SysUser.class,username,pwd);
        return sysUser;
    }
}
