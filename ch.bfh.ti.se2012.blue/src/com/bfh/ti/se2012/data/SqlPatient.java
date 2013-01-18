/**
 * The class SQLPatient is the Model Class for PatientView and PatientFormView
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.data;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SqlPatient implements Serializable{

     private Statement stmt;
     private ResultSet rs;
     private DatabaseConnection conection;

     public SqlPatient(){
         conection = new DatabaseConnection();
         conection.connect();
         stmt = conection.getstatement();
         rs = conection.getresultset();
     }

     private ArrayList<Patient> patientList = new ArrayList<Patient>();

     public ArrayList<Patient> getPatientList() {
         try {
             String query = "SELECT pid,lastname,firstnamee,birthdate,Gender,city,address,mail,phonenumber,healthInsuranceCompany FROM Patient";
             rs = stmt.executeQuery(query);
             
             while (rs.next()) {
            	 patientList.add(new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10)));
             }
             // Close the result set, statement and the connection
             rs.close();

         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         conection.disconnect();
         return patientList;
     }

}

