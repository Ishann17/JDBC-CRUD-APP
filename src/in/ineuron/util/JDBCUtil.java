package in.ineuron.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    private JDBCUtil(){
        //SO that no one can create object of this class.
    }

    public static Connection getJDBCConnection() throws SQLException, IOException {
        HikariConfig config = new HikariConfig("D:\\Java Programs\\JDBC Project\\src\\in\\ineuron\\util\\jdbclogin.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource.getConnection();
    }

}
