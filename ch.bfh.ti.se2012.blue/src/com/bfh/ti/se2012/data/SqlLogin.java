/**
 * The class SQLLogin is the Model Class for LoginView
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.data;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlLogin implements Serializable{

     private Statement stmt;
     private ResultSet rs;
     private DatabaseConnection conection;
     private String result = null;

 	/*
 	 * Constructor SQL LOGIN
 	 * Database Connection
 	 * 
 	 */
     public SqlLogin(){
         conection = new DatabaseConnection();
         conection.connect();
         stmt = conection.getstatement();
         rs = conection.getresultset();
     }

     // Read Passwort from User
     public String getpassword(String username) {
         try {
             String query = "SELECT loginPassword FROM LoginStaff WHERE loginUsername='"+ username + "'";
             rs = stmt.executeQuery(query);
             
             while (rs.next()) {
                 result = rs.getString(1);
             }
             rs.close();

         } catch (SQLException e) {
             e.printStackTrace();
         }
         conection.disconnect();
         return result;
     }

     // Authenicate Methode with param Username and Passwort
     // return User Object
     public User Authenticate(String username, String password) {
         String password1 = getpassword(username);
         if (password1.equals(password)) {
             return new User(username,username);
         } else
             return null;

     }

}

