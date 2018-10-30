package bookStore.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
    private static DataSource dataSource = null;

    static {
        //创建数据库连接池
        dataSource = new ComboPooledDataSource("bookStore");
    }

    //获得数据库的连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库连接错误");
        }

    }


    public static void release(Connection connection) {
        try {
            if (connection != null) {

                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库连接错误");
        }
    }

    public static void release(PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {

                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库连接错误");
        }

        try {
            if (preparedStatement != null) {

                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("数据库连接错误");
        }
    }
}
