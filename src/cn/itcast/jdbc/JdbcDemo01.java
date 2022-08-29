package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : JdbcDemo01
 * @date :2022��08��23��9:52
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws  SQLException {
       String url="jdbc:mysql://localhost:3308/dd?characterEncoding=utf-8&serverTimezone=UTC&&allowPublicKeyRetrieval=true&useSSL=false";
       String user="root";
       String password="888888";
//       1��������jar��
//         2ע������  ����ʡ��ע������
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        3 ��ȡ���ݿ����Ӷ���
        Connection conn = DriverManager.getConnection(url, user, password);
//         4����sql���
        String sql="update users set passwd='s2d456' where id =1";
//         5��ȡִ��sql����
        Statement stmt = conn.createStatement();
//        6ִ��sql���
        int count = stmt.executeUpdate(sql);
//        7������
        System.out.println(count);

//        8�ͷ���Դ
        stmt.close();
        conn.close();

    }
}
