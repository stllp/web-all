package com.stu.service;

import com.stu.pojo.SysUser;

/**
 * 该接口定义了以sys_user数据库表为核心的业务处理功能
 */
public interface SysUserService {
    /**
     * 人员注册
     * @param sysUser 人员实体表
     * @return 换回数据改变行数
     */
    int regist(SysUser sysUser);

    SysUser findByUsername(String username);

    SysUser findByUsernameAndPwd(String username, String pwd);

}
