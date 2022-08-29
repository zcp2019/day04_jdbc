package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.util
 * @NAME : JDBCtools
 * @date :2022Äê08ÔÂ24ÈÕ12:39
 */
public class JDBCtools {
    private static String url;
    private static String user;
    private static String passwd;
    private static String driver;
    static {

        try {
            Properties pro=new Properties();
            ClassLoader classLoader = JDBCtools.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path=res.getPath();
            pro.load(new FileReader(path));
            url =pro.getProperty("url");
            user=pro.getProperty("user");
            passwd=pro.getProperty("passwd");
            driver=pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,passwd);
    }
    public static void close(Statement stmt,Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
