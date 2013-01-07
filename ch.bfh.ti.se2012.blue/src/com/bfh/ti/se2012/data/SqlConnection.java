package com.bfh.ti.se2012.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class SqlConnection {

     private Connection conn;
     private Statement stmt;
     private ResultSet rs;

     public void connect() {

         try {
             // Load the database driver
             Class.forName("net.sourceforge.jtds.jdbc.Driver");

             // Get a connection to the database
             String url = "jdbc:jtds:sqlserver://corpus.bfh.ch:55783;DatabaseName=db_blue";
             Connection conn = DriverManager.getConnection(url, "se2012_blue",
                     "9uBeseTaf7");

             // Get a statement from the connection
             stmt = conn.createStatement();

             // Print all warnings
             for (SQLWarning warn = conn.getWarnings(); warn != null; warn = warn
                     .getNextWarning()) {
                 System.out.println("SQL Warning:");
                 System.out.println("State  : " + warn.getSQLState());
                 System.out.println("Message: " + warn.getMessage());
                 System.out.println("Error  : " + warn.getErrorCode());
             }
         } catch (SQLException se) {
             System.out.println("SQL Exception:");

             // Loop through the SQL Exceptions
             while (se != null) {
                 System.out.println("State  : " + se.getSQLState());
                 System.out.println("Message: " + se.getMessage());
                 System.out.println("Error  : " + se.getErrorCode());

                 se = se.getNextException();
             }
         } catch (Exception e) {
             System.out.println(e);
         }

     }

     public Connection getconnection(){
         return conn;
     }
     public Statement getstatement(){
         return stmt;
     }
     public ResultSet getresultset(){
         return rs;
     }

     public void disconnect() {
         try {
             // Close the result set, statement and the connection
             conn.close();

         } catch (SQLException se) {
             System.out.println("SQL Exception:");

             // Loop through the SQL Exceptions
             while (se != null) {
                 System.out.println("State  : " + se.getSQLState());
                 System.out.println("Message: " + se.getMessage());
                 System.out.println("Error  : " + se.getErrorCode());

                 se = se.getNextException();
             }
         } catch (Exception e) {
             System.out.println(e);
         }
     }
}

