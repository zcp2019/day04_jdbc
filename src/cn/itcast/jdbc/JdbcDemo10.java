package cn.itcast.jdbc;


import cn.itcast.util.JDBCtools;

import java.sql.*;
import java.util.Scanner;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbc
 * @NAME : JdbcDemo02
 * @date :2022��08��23��14:06
 */
public class JdbcDemo10 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("�������û���;");
        String username = sc.nextLine();
        Scanner sc2=new Scanner(System.in);
        System.out.println("�������û�����;");
        String passwd = sc2.nextLine();
        boolean flag = new JdbcDemo10().login(username, passwd);
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
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            conn = JDBCtools.getConnection();

            String sql="select * from users where username=? and passwd=? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,passwd);
            rs = pstmt.executeQuery();
            return  rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCtools.close(rs,pstmt,conn);
        }

        return false;
    }

}
