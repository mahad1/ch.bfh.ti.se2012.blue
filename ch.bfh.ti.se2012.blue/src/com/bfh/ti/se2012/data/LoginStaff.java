package com.bfh.ti.se2012.data;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginStaff implements Idb {

	
    private Statement stmt;
    private ResultSet rs;
    private Connection con;
	/**
	 * @param args
	 */
	public LoginStaff(){
		con = new Connection();
		Connection.connect();
        stmt = conection.getstatement();
        rs = conection.getresultset();
	}

}
