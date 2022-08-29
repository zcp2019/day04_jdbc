package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.domain.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : JdbcDemo02
 * @date :2022年08月23日14:06
 */
public class JdbcDemo08 {
    String url="jdbc:mysql://localhost:3308/dd?characterEncoding=utf-8&serverTimezone=UTC&&allowPublicKeyRetrieval=true&useSSL=false";
    String user="root";
    String password="888888";
    Connection conn=null;
    Statement stmt =null;
    ResultSet rs =null;
    List<Users> list=null;

    public static void main(String[] args) {
        List<Users> list = new JdbcDemo08().findAll();
        System.out.println(list);
    }
    public List<Users> findAll(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String sql="insert into users values(null,'fr5','f3f2')";
            String sql="select  * from users";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            循环判断游标是否是最后一行末尾 rs.next()
            Users u=null;
            list=new ArrayList<Users>();
            while (rs.next()){
//                获取数据
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String passwd=rs.getString(3);

                u=new Users();

                u.setId(id);
                u.setName(name);
                u.setPasswd(passwd);
                list.add(u);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;

    }

}
