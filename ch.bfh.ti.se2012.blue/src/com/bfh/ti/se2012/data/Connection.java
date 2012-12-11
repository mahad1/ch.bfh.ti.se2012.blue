package com.bfh.ti.se2012.data;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class Connection extends Window {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	JDBCConnectionPool connectionPool = null;
	private SQLContainer LoginStaffContainer = null;

	public Connection() throws SQLException{
      
		initConnectionPool();
		initContainers();
		
		@SuppressWarnings("deprecation")
		SQLContainer container = new SQLContainer(new FreeformQuery("SELECT * FROM LoginStaff WHERE personId=1", Arrays.asList("personId"), connectionPool));
        Table table = new Table();
 
        
        table.setContainerDataSource(container);
        
        TextField tName = new TextField("test");
        //tName.setValue(table);
        setCaption("Login");
        
        addComponent(new Label("Bitte melden Sie sich an:", Label.CONTENT_XHTML));
        setModal(true);
        setWidth("50%");
		//addComponent(tName);
		addComponent(table);
	}
	
	private void initConnectionPool() {
        try {
            connectionPool = new SimpleJDBCConnectionPool(
			        "com.microsoft.sqlserver.jdbc.SQLServerDriver",
			        "jdbc:sqlserver://corpus.bfh.ch:55783;databaseName=db_blue", "se2012_blue", "9uBeseTaf7", 2, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	 private void initContainers() {
	        try {
	            /* TableQuery and SQLContainer for personaddress -table */
	            TableQuery q1 = new TableQuery("LoginStaff", connectionPool);
	            q1.setVersionColumn("VERSION");
	            //q1.setDebug(debugMode);
	            LoginStaffContainer = new SQLContainer(q1);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
