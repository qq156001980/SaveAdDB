import sun.tools.jconsole.Tab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hunter on 14/11/2.
 */
public class DBConn {



    private static final String URL = "jdbc:mysql://localhost:3306/";

    private static String MyDatabase = "ad";

    private static String UserName = "root";

    private static String Password = "root";

    private static String TableName = "users";

    public static String getTableName() {
        return TableName;
    }

    /* 获取数据库连接的函数*/
    public static Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

            con = DriverManager.getConnection(URL + MyDatabase, UserName, Password);// 创建数据连接

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con; //返回所建立的数据库连接
    }

}
