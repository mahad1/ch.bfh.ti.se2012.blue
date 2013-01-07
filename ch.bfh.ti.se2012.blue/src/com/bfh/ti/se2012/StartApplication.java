  package com.bfh.ti.se2012;

import java.sql.*;

import com.bfh.ti.se2012.ui.*;
import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;


public class StartApplication extends Application{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */

    public static GridLayout layout;
   
    
    @Override
    public void init() {
	    try {
			buildMainLayout();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void buildMainLayout() throws IllegalArgumentException, NullPointerException, SQLException {
    	
    	
    	Window startWindow = new Window("Medicus App");
        
        
        this.setMainWindow(startWindow);
        this.setTheme("medicus");
        
        //Grundstruktur 
 		layout = new GridLayout();
 		layout.setImmediate(false);
 		layout.setWidth("768px");
 		layout.setMargin(false);
 		layout.setRows(2);
 		
    
        layout.addComponent(createHeader(),0,0);
        setView(null);

       getMainWindow().setContent(layout);
       
       getMainWindow().addWindow(new LoginWindow());
       
      
    }
   
    private GridLayout createHeader() {
    	GridLayout header = new GridLayout(2,1);

    	Embedded em = new Embedded(null, new ThemeResource("img/Logo_MedApp.jpg"));
    	header.addComponent(em);
    	header.setComponentAlignment(em, Alignment.MIDDLE_RIGHT);
    	header.setHeight("150px");
    	header.setStyleName("header");
    	//header.setColumnExpandRatio(em, 1);
		return header;
	}
    
    public static void setView(Component com){
    	if(com!=null){
    		layout.addComponent(com,0,1);
    	}else{
    		layout.addComponent(new HomeScreen(),0,1);
    	}
    }


}