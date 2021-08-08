/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.db_utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author くろくん
 */
public class MyConnection {

    public static Connection MakeConnection() {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName= CoffeeShop";
            cn = DriverManager.getConnection(url, "sa", "1");
        } catch (Exception e) {
        }
        return cn;

    }
}
