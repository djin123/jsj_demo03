package cn.com.djin.jsj.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @author：djin
 * @date：2019/05/13 09:21:39
 *    c3p0连接池数据源工具类
 **/
public class JdbcDataSourseUtil {

    /**
     * 设置为静态的数据源对象
     * 可以直接通过数据源去操作数据库的增删查改等等操作
     * 此方法可以自动去读取根目录下的xx-config.xml文件
     */
    private static DataSource dataSource = new ComboPooledDataSource();

    //取到数据源对象
    public static DataSource getDataSource() {
        return dataSource;
    }
}
