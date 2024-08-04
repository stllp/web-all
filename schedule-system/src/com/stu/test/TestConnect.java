package com.stu.test;

import com.stu.dao.SysUserDao;
import com.stu.dao.impl.SysUserDaoImpl;
import com.stu.pojo.SysUser;
import com.stu.utils.JdbcUtilesByDruid;
import com.stu.utils.Md5Util;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnect {
    @Test
    public void connectTest() throws SQLException {
        Connection connection = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            connection = JdbcUtilesByDruid.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时="+(end - start));
    }
    @Test
    public void test01(){
//        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();
//        Object o = sysUserDao.queryScalar("select count(1) from sys_user");
//        System.out.println(o);

        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();
        int i = sysUserDao.addSysUser(new SysUser(null, "王五", Md5Util.getMD5String("123456")));
        System.out.println(i);
    }
}
