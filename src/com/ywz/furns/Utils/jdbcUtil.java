package com.ywz.furns.Utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author 于汶泽
 */
public class jdbcUtil {
    private static Connection conn = null;
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("com.ywz.furns.Utils.jdbc");
        driver = rb.getString("driver");
        url = rb.getString("url");
        user = rb.getString("user");
        password = rb.getString("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
    public static void allClose(Connection co, PreparedStatement st, ResultSet re)
    {
        if(re!=null)
        {
            try{
                re.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(st!=null)
        {
            try {
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(co!=null){
            try {
                co.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
