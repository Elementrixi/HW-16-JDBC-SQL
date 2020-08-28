package com.alpashaev.executor;

import com.alpashaev.dao.StudentDao;
import com.alpashaev.database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.util.jar.Pack200.Packer.PASS;

public class Executor {
    public static void startApp() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(Database.JDBC_DRIVER);
            conn = DriverManager.getConnection(Database.DB_URL, Database.USER, PASS);
            stmt = conn.createStatement();
            String sql = "CREATE TABLE STUDENTS " +
                    "(id INTEGER not NULL, " +
                    " first_name VARCHAR(255), " +
                    " second_name VARCHAR(255), " +
                    " age INTEGER, " +
                    " city VARCHAR(255))";
            stmt.executeUpdate(sql);
            StudentDao.inserts(stmt);
            StudentDao.allUsers(stmt);
            StudentDao.sortByAge(stmt);
            StudentDao.numberOfUsers(stmt);
            StudentDao.findByFirstCharacter(stmt);
            StudentDao.deleteByAge(stmt);
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
