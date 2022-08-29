package cn.itcast.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.druid
 * @NAME : DruidDemo
 * @date :2022Äê08ÔÂ25ÈÕ9:48
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties pro=new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);


    }
}
