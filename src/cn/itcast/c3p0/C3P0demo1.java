package cn.itcast.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.c3p0
 * @NAME : C3P0demo1
 * @date :2022Äê08ÔÂ25ÈÕ8:39
 */
public class C3P0demo1 {
    private static DataSource ds=null;
    public static void main(String[] args) {
        DataSource ds2=new ComboPooledDataSource("otherc3p0");
        Connection conn = null;
        for (int i = 0; i <=9 ; i++) {

            try {
                conn = ds2.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(i+"--"+conn);
         /*   if(i==5){
                try {
                    if(conn!=null){
                        conn.close();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/

        }


    }
//    static {
//        ds=new ComboPooledDataSource();
//    }
//    public static DataSource getDateSource(){
//        return ds;
//    }
//    public static Connection getConnection() throws SQLException {
//        return ds.getConnection();
//    }
}
