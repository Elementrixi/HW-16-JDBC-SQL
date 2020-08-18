package main.java.com.alpashaev.executor;

import java.sql.*;

import static java.util.jar.Pack200.Packer.PASS;
import static main.java.com.alpashaev.database.Database.*;
import static main.java.com.alpashaev.service.Service.*;

public class Executor {
    public static void startApp() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "CREATE TABLE STUDENTS " +
                    "(id INTEGER not NULL, " +
                    " first_name VARCHAR(255), " +
                    " second_name VARCHAR(255), " +
                    " age INTEGER, " +
                    " city VARCHAR(255))";
            stmt.executeUpdate(sql);
            inserts(stmt);
            allUsers(stmt);
            sortByAge(stmt);
            numberOfUsers(stmt);
            findByFirstCharacter(stmt);
            deleteByAge(stmt);
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
