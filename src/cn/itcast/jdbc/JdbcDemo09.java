package cn.itcast.jdbc;


import cn.itcast.util.JDBCtools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : JdbcDemo02
 * @date :2022��08��23��14:06
 */
public class JdbcDemo09 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("�������û���;");
        String username = sc.nextLine();
        Scanner sc2=new Scanner(System.in);
        System.out.println("�������û�����;");
        String passwd = sc2.nextLine();
        boolean flag = new JdbcDemo09().login(username, passwd);
        if(flag){
            System.out.println("��¼�ɹ�");
        }else {
            System.out.println("�û������������������");
        }
    }

    public boolean login(String username,String passwd){
        if(username ==null || passwd ==null){
            return false;
        }
        Connection conn =null;
        Statement stmt =null;
        ResultSet rs =null;
        try {
            conn = JDBCtools.getConnection();
            String sql="select * from users where username='"+username+"' and passwd='"+passwd+"'";
            String sql2="select * from users where username=? and passwd=? ";
//           sqlע�� a 'or 'a'='a
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return  rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCtools.close(rs,stmt,conn);
        }

        return false;
    }

}
