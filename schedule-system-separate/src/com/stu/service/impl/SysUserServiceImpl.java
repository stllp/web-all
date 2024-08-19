package com.stu.service.impl;

import com.stu.dao.SysUserDao;
import com.stu.dao.impl.SysUserDaoImpl;
import com.stu.pojo.SysUser;
import com.stu.service.SysUserService;
import com.stu.utils.Md5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {
        sysUser.setUserPwd(Md5Util.getMD5String(sysUser.getUserPwd()));
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public SysUser findByUsernameAndPwd(String username, String pwd) {
        return userDao.findByUsernameAndPwd(username, Md5Util.getMD5String(pwd));
    }
}
