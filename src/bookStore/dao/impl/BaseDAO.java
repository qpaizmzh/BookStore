package bookStore.dao.impl;

import bookStore.dao.Dao;
import bookStore.db.JDBCUtils;
import bookStore.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;
import java.util.List;

public class BaseDAO<T> implements Dao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;

    public BaseDAO() {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    @Override
    public long insert(String sql, Object... args) {
        long num = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if (args != null) {
                for (int i = 1; i <= args.length; i++) {
                    preparedStatement.setObject(i, args[i - 1]);
                }
            }

            preparedStatement.executeUpdate();

            //获取生成的主键值
            resultSet = preparedStatement.getGeneratedKeys();


            if (resultSet != null) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(preparedStatement, resultSet);
            JDBCUtils.release(connection);
        }
        return 0;
    }

    @Override
    public void update(String sql, Object... args) {
        Connection connection = null;
        try {

            connection = JDBCUtils.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection);
        }
    }

    @Override
    public T query(String sql, Object... args) {
        Connection connection = null;
        T t = null;
        try {
            connection = JDBCUtils.getConnection();
            t = queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection);
        }

        return t;
    }

    @Override
    public List queryForList(String sql, Object... args) {
        Connection connection = null;
        List<T> t = null;
        try {
            connection = JDBCUtils.getConnection();
            t = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection);
        }

        return t;
    }

    //批处理的意思，就是同时处理多条数据
    @Override
    public void batch(String sql, Object[]... params) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            queryRunner.batch(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection);
        }
    }

    @Override
    public <V> V getSingleVal(String sql, Object... args) {
        Connection connection = null;
        V v = null;
        try {
            connection = JDBCUtils.getConnection();
            v =(V)queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }
}
