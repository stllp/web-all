package com.stu.dao;

import com.stu.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    /**
     * SysSchedule 向数据库中添加一行日程记录
     *
     * @param sysSchedule
     * @return 返回操作成功的行数
     */
    int addSysSchedule(SysSchedule sysSchedule);

    /**
     * 查询数据库sys_schedule 表的所有数据
     *
     * @return 返回SysSchedule 数据集合
     */
    List<SysSchedule> findAll();
}