package cn.itcast.druid;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.druid
 * @NAME : DruidDemo2 ʹ���µ�druid���ݿ⹤����
 * @date :2022��08��25��10:28
 */
public class DruidDemo2 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into users values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "dfdf");
            pstmt.setString(2, "5656");
            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("��ӳɹ�");
            } else {
                System.out.println("���ʧ��");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

    }

}
