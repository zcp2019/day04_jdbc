package cn.itcast.jdbctemplate;

import cn.itcast.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbctemplate
 * @NAME : JdbcTemplateDemo
 * @date :2022Äê08ÔÂ25ÈÕ10:57
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update users set username = ? where id = ?";
        int count = jt.update(sql, "f444", 6);
        System.out.println(count);
    }
}
