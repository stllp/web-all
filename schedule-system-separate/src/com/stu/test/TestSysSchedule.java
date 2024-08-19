package com.stu.test;

import com.stu.dao.impl.SysScheduleDaoImpl;
import com.stu.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestSysSchedule {
    private static SysScheduleDaoImpl sysScheduleDao;
    @BeforeClass
    public static void iniSysScheduleDaoImpl(){
        sysScheduleDao = new SysScheduleDaoImpl();
    }
    @Test
    public void TestaddSysSchedule(){
        int i = sysScheduleDao.addSysSchedule(new SysSchedule(null, 1, "学习java", 0));
        System.out.println(i);
    }
    @Test
    public void TestfindAll(){
        List<SysSchedule> all = sysScheduleDao.findAll();
        System.out.println(all);
    }
}
