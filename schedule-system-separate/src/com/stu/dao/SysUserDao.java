package com.stu.dao;

import com.stu.pojo.SysUser;

import java.util.List;

public interface SysUserDao {
    /**
     * SysUser 向数据库中添加一行操作员信息
     *
     * @param sysUser
     * @return
     */
    int addSysUser(SysUser sysUser);

    /**
     * 查询数据库sys_user 表的所有数据
     *
     * @return 返回SysUser 数据集合
     */
    List<SysUser> findAll();

    SysUser findByUsername(String username);

    SysUser findByUsernameAndPwd(String username, String pwd);
}
