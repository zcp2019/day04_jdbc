package cn.itcast.jdbctemplate;

import cn.itcast.domain.Users;
import cn.itcast.druid.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

/**
 * @author :zh
 * @PACKAGE_NAME :cn.itcast.jdbctemplate
 * @NAME : JdbcTemplateDemo2
 * @date :2022年08月25日11:31
 */
public class JdbcTemplateDemo2   {
    private  JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());


    @Test
    public void insertinto(){
        String sql="insert into users values(null,?,?)";
        int add = jt.update(sql, "ssd", "6666");
        System.out.println(add);
    }
    @Test
    public  void delete(){
        String sql ="delete from users where id=?";
        int delete = jt.update(sql, 8);
        System.out.println(delete);
    }
    @Test
    public  void find1(){
        String sql="select * from users where id =1";
        Map<String, Object> smap = jt.queryForMap(sql);
        System.out.println(smap);
    }

//    5. 查询所有记录，将其封装为List
//				6. 查询所有记录，将其封装为Users对象的List集合
//				7. 查询总记录数
    @Test
    public void findall(){
        String sql ="select * from users";
        List<Map<String, Object>> list = jt.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);

        }

    }
    @Test
    public void findall2(){
        String sql ="select * from users";
        List<Users> list = jt.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
        for (Users users : list) {
            System.out.println(users);
        }

    }
    @Test
    public void findalltotal(){
        String sql ="select count(id) from users";
        Long total = jt.queryForObject(sql, Long.class);
        System.out.println(total);


    }
}
