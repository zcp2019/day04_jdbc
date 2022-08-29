package cn.itcast.jdbc;

import cn.itcast.domain.Users;
import cn.itcast.util.JDBCtools;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : Jdbctoolsdemo      改进数据库连接通用
 * @date :2022年08月23日14:06
 */
public class JdbcToolsDemo {

    Connection conn=null;
    Statement stmt =null;
    ResultSet rs =null;
    List<Users> list=null;

    public static void main(String[] args) {
        List<Users> list = new JdbcToolsDemo().findAll();
        System.out.println(list);
    }
    public List<Users> findAll(){

        try {

//            String sql="insert into users values(null,'fr5','f3f2')";
            String sql="select  * from users";
            conn = JDBCtools.getConnection();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           JDBCtools.close(rs,stmt,conn);
        }
        return list;

    }

}
