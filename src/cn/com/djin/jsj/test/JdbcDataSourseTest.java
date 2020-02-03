package cn.com.djin.jsj.test;

import cn.com.djin.jsj.util.JdbcDataSourseUtil;
import org.junit.Test;

import javax.sql.DataSource;

/**
 *   数据库链接数据源测试类
 */
public class JdbcDataSourseTest {

    @Test
    public void test01(){
        DataSource dataSource = JdbcDataSourseUtil.getDataSource();
        System.out.println(dataSource);
    }
}
