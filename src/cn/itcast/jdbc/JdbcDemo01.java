package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : JdbcDemo01
 * @date :2022年08月23日9:52
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws  SQLException {
       String url="jdbc:mysql://localhost:3308/dd?characterEncoding=utf-8&serverTimezone=UTC&&allowPublicKeyRetrieval=true&useSSL=false";
       String user="root";
       String password="888888";
//       1导入驱动jar包
//         2注册驱动  可以省略注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        3 获取数据库连接对象
        Connection conn = DriverManager.getConnection(url, user, password);
//         4定义sql语句
        String sql="update users set passwd='s2d456' where id =1";
//         5获取执行sql对象
        Statement stmt = conn.createStatement();
//        6执行sql语句
        int count = stmt.executeUpdate(sql);
//        7处理结果
        System.out.println(count);

//        8释放资源
        stmt.close();
        conn.close();

    }
}
