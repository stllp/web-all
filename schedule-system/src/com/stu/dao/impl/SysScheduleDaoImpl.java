package com.stu.dao.impl;

import com.stu.dao.BasicDao;
import com.stu.dao.SysScheduleDao;
import com.stu.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BasicDao<SysSchedule> implements SysScheduleDao {
    @Override
    public int addSysSchedule(SysSchedule sysSchedule) {
        String ls_sql = "insert into sys_schedule values(null,?,?,?)";
        return update(ls_sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
    }

    @Override
    public List<SysSchedule> findAll() {
        String ls_sql="select * from sys_schedule ";
        List<SysSchedule> sysSchedules = queryMulti(ls_sql, SysSchedule.class);
        return sysSchedules;
    }
}