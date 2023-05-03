package com.nhnacademy.edu.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final DataSource DATASOURCE;

    private DBUtils() {}
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/module06",
                    "root",
                    "1234");
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    public static DataSource getDatasource() {return  DATASOURCE;}

     static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost/module06");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(10);

        DATASOURCE = basicDataSource;
    }
}
