package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // private static final String URL = "jdbc:mysql://database-1.cf7g410jr7vi.eu-central-1.rds.amazonaws.com:3306/jdbc_test";

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        int i = 0;
        System.out.println("id   Name    Age");
        System.out.println("---------------------");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/football", "root", "");
            statement = connection.createStatement();
            try {
                ResultSet result = statement.executeQuery("SELECT *  FROM players");
                /*if (result!=null){
                    System.out.println("OK");
                }*/
                resOfQuary(result);
            } catch (SQLException e) {
                e.getMessage();
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            statement.close();
        }

    }

  private static void resOfQuary(ResultSet result) throws SQLException {
      while (result.next()) {
          StringBuilder row = new StringBuilder();
          int id = result.getInt(1);
          row.append(id);
          row.append(" ");
          String name = result.getString(2);
          int age = result.getInt(3);
          row.append(name);
          row.append(" ");
          row.append(age);
          //System.out.printf("id: %d, name: %s, age: %s %n", id, name, age);
          System.out.println(row);
      }

  }
}