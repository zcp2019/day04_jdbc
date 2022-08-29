package com.ssq.test;

import cn.itcast.druid.JDBCUtils;
import com.ssq.dao.SSQ_history;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.List;

/**
 * @author :zh
 * @PACKAGE_NAME :com.ssq.test
 * @NAME : SSQ_main
 * @date :2022Äê08ÔÂ25ÈÕ16:51
 */
public class SSQ_main {

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select * from ssq_2";
        List<SSQ_history> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SSQ_history>(SSQ_history.class));
        for (SSQ_history ssq_history : list) {
            System.out.println(ssq_history);
        }
    }


}
