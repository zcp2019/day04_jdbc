package cn.itcast.druid;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.druid
 * @NAME : DruidDemo2 使用新的druid数据库工具类
 * @date :2022年08月25日10:28
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
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

    }

}
