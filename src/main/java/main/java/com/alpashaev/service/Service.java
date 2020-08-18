package main.java.com.alpashaev.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {

    public static void inserts(Statement statement) throws SQLException {
        String sql;
        sql = "INSERT INTO STUDENTS " + "VALUES(1" + ",'Gary','Potter',24,'Berlin')";
        statement.executeUpdate(sql);
        sql = "INSERT INTO STUDENTS " + "VALUES(2,'Zangezo','Blade',48,'Kiev')";
        statement.executeUpdate(sql);
        sql = "INSERT INTO STUDENTS " + "VALUES(3,'Bruce','Wayne',36,'Gotham')";
        statement.executeUpdate(sql);
        sql = "INSERT INTO STUDENTS " + "VALUES(4,'Jalex','Mercer',23,'London')";
        statement.executeUpdate(sql);
    }
    public static void allUsers(Statement statement) throws SQLException {
        String sql = "SELECT id, first_name, second_name, age,city FROM STUDENTS";
        ResultSet result = statement.executeQuery(sql);
        System.out.println("Table of users : ");
        while (result.next()) {
            int id = result.getInt("id");
            int age = result.getInt("age");
            String first_name = result.getString("first_name");
            String second_name = result.getString("second_name");
            String city = result.getString("City");

            System.out.print("Id: " + id +
                    ", age: " + age +
                    ", first name : " + first_name +
                    ", second name : " + second_name +
                    ", city: " + city +
                    "\n");
        }
    }

    public static void sortByAge(Statement statement) throws SQLException {
        String sql = "SELECT id, first_name, second_name, age,city FROM STUDENTS ORDER BY age";
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("\nSorting by age");
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first_name = rs.getString("first_name");
            String second_name = rs.getString("second_name");
            String city = rs.getString("City");

            System.out.print("Id: " + id +
                    ", age: " + age +
                    ", first name : " + first_name +
                    ", second name : " + second_name +
                    ", city: " + city +
                    "\n");
        }
    }

    public static void numberOfUsers(Statement statement) throws SQLException {
        String sql = "SELECT count(*) FROM STUDENTS";
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("\nNumber of users :");
        int count;
        if (rs.next()) {
            count = rs.getInt(1);
            System.out.println(count);
        }
    }

    public static void findByFirstCharacter(Statement statement) throws SQLException {
        String sql = "SELECT * FROM STUDENTS WHERE first_name LIKE 'J%'";
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("\nUsers with first 'J' in name");
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first_name = rs.getString("first_name");
            String second_name = rs.getString("second_name");
            String city = rs.getString("city");

            System.out.print("Id: " + id +
                    ", age: " + age +
                    ", first name : " + first_name +
                    ", second name : " + second_name +
                    ", city: " + city +
            "\n");
        }
    }

    public static void deleteByAge(Statement statement) throws SQLException {
        String sql = "SELECT * FROM STUDENTS WHERE age NOT BETWEEN 20 AND 45";
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("\nTable of users without users with 20 < age < 45");
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("second_name");
            String city = rs.getString("city");

            System.out.print("Id: " + id +
                    ", age: " + age +
                    ", first name: " + first_name +
                    ", second name: " + last_name +
                    ", city: " + city +
                    "\n");
        }
    }
}
