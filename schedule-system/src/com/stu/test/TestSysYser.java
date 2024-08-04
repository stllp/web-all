package com.stu.test;

import com.stu.dao.impl.SysUserDaoImpl;
import com.stu.pojo.SysUser;
import com.stu.utils.Md5Util;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestSysYser {
    private static SysUserDaoImpl sysUserDaoImpl;

    @BeforeClass
    public static void iniSysScheduleDaoImpl() {
        sysUserDaoImpl = new SysUserDaoImpl();
    }

    @Test
    public void TestaddSysSchedule() {
        int i = sysUserDaoImpl.addSysUser(new SysUser(null, "马六", Md5Util.getMD5String("123456")));
        System.out.println(i);
    }

    @Test
    public void TestfindAll() {
        List<SysUser> all = sysUserDaoImpl.findAll();
        System.out.println(all);
    }
}
