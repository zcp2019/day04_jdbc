package cn.itcast.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.druid
 * @NAME : JDBCUtils
 * @date :2022年08月25日10:06
 */
public class JDBCUtils {
    private static DataSource ds =null;
    static {

        try {
            Properties pro=new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close( PreparedStatement pstmt,Connection conn){
        close(null,pstmt,conn);
    }
    public static void close(ResultSet rs, PreparedStatement pstmt,Connection conn){
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(pstmt !=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn !=null){
            try {
                conn.close(); //归还连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static DataSource getDataSource(){
        return  ds;
    }
}
