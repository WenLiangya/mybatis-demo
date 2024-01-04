package gittest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * [给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/9 11:32]
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            db1();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败");
            System.exit(1);
        }
    }

    static void db1() throws SQLException, ClassNotFoundException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        Properties prorerties = new Properties();

        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/mybatis?useSSL=false";
        String user = "root";
        String password = "123456";

        prorerties.setProperty("user",user);
        prorerties.setProperty("psssword",password);

        Connection connection = DriverManager.getConnection(url,prorerties);
        PreparedStatement ps = connection.prepareStatement("Insert Into test_db values (?,?,?,?,?)");
        for (int i = 1; i < 10; i++) {
            ps.setInt(1, i);
            ps.setString(2, "张三"+i);
            ps.setString(3, "123");
            ps.setString(4, "男");
            ps.setString(5, "北京");
            ps.addBatch();
        }
        ps.executeBatch();
        connection.commit();
        //关闭连接
        ps.close();
        connection.close();
    }
}