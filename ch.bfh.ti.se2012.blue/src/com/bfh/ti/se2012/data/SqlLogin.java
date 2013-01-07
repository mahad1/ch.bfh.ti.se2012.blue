package com.bfh.ti.se2012.data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlLogin{

     private Statement stmt;
     private ResultSet rs;
     private SqlConnection conection;

     public SqlLogin(){
         conection = new SqlConnection();
         conection.connect();
         stmt = conection.getstatement();
         rs = conection.getresultset();
     }

     private String result="";

     public String getpassword(String username) {
         try {
             String query = "SELECT loginPassword FROM LoginStaff WHERE loginUsername='"+ username + "'";
             rs = stmt.executeQuery(query);
             
             while (rs.next()) {
                 // Loop through the result set
                 result = rs.getString(1);
             }
             // Close the result set, statement and the connection
             rs.close();

         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         conection.disconnect();
         return result;
     }

     public boolean validateLogin(String username, String password) {
         String password1 = getpassword(username);
         System.out.println(password1);
         if (password1.equals(password)) {
             return true;
         } else
             return false;

     }

}

