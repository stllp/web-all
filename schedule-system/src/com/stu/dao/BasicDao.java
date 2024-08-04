package com.stu.dao;

import com.stu.utils.JdbcUtilesByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"all"})
public class BasicDao<T> {
    private QueryRunner qr = new QueryRunner();
//    private  String

    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JdbcUtilesByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
//            throw new RuntimeException(e);
        } finally {
            JdbcUtilesByDruid.close(null, null, connection);
        }
    }

    //返回多个对象
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JdbcUtilesByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtilesByDruid.close(null, null, connection);
        }
    }
    //返回单个对象
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JdbcUtilesByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtilesByDruid.close(null, null, connection);
        }
    }
    //查询单列
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JdbcUtilesByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtilesByDruid.close(null, null, connection);
        }
    }
}
