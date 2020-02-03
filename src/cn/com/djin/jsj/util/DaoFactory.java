package cn.com.djin.jsj.util;

import java.util.ResourceBundle;

/**
 * 生产Dao实现类对象的工厂
 */
public class DaoFactory {

    //目的：不让在其他类中创建工厂对象，单例模式
    private DaoFactory(){}

    //生产Dao的实现类对象  DaoUrl为传入的dao层实现类的全路径对应的key值
    public static Object getDaoInstance(String DaoUrl){
        //加载配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("daoUrl");
        try {
            //bundle.getString(DaoUrlName)获取配置文件中的key对应的value值
            //获取封装类
            Class clazz = Class.forName(bundle.getString(DaoUrl));
            //通过封装类创建dao层对象
            return  clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
