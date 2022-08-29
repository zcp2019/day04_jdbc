package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : JdbcDemo02
 * @date :2022年08月23日14:06
 */
public class JdbcDemo04 {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3308/dd?characterEncoding=utf-8&serverTimezone=UTC&&allowPublicKeyRetrieval=true&useSSL=false";
        String user="root";
        String password="888888";
        Connection conn=null;
        Statement stmt =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String sql="insert into users values(null,'fr5','f3f2')";
            String sql="delete from users where id=4";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if(count>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
}
