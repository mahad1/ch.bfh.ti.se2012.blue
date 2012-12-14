  package com.bfh.ti.se2012;

import java.sql.*;

import com.bfh.ti.se2012.data.*;
import com.bfh.ti.se2012.data.Connection;
import com.bfh.ti.se2012.ui.*;
import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class StartApplication extends Application implements Button.ClickListener,Property.ValueChangeListener{
    /**
     * 
     */
    private Button newContact;
    private Button search;
    private Button share;
    private Button help;
    private HorizontalSplitPanel horizontalSplit;
    private ListView listView;
    private PersonList personList;
    private PersonForm personForm;
    private PersonContainer dataSource;
    private SearchView searchView;
    private HelpWindow helpWindow;
   
    
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
    	Window startWindow = new Window("medApp");
        setMainWindow(startWindow);
        
        newContact = new Button("Add contact");
        search = new Button("Search");
        share = new Button("Share");
        help = new Button("Help");
        
        NavigationTree tree = new NavigationTree();
        //horizontalSplit = new HorizontalSplitPanel();
        
        VerticalSplitPanel layout = new VerticalSplitPanel();
        layout.setSizeFull();
        layout.setLocked(true);
        
        // Set the position of the splitter as percentage
        layout.setSplitPosition(150, Sizeable.UNITS_PIXELS);
        
        layout.setFirstComponent(createHeader());
        layout.setSecondComponent(new HomeScreen());
        //layout.addComponent(horizontalSplit);

    		   
       //setMainComponent(getListView());
       getMainWindow().setContent(layout);
       startWindow.setWidth(100,Sizeable.UNITS_PIXELS);
       startWindow.setHeight(100,Sizeable.UNITS_PIXELS);
       startWindow.center();
       layout.setSizeFull();
       setTheme("reindeer");
       //getMainWindow().addWindow(new LoginWindow());
       
      
    }
   
    private VerticalLayout createHeader() {
    	VerticalLayout header = new VerticalLayout();
    	header.addComponent(new Embedded("",new ThemeResource("img/Logo_MedApp.jpg")));
		return header;
	}

	public PersonContainer getDataSource() {
        return dataSource;
   }
    
    
   //VIEWS
    private ListView getListView() {
        if (listView == null) {
        	personList = new PersonList(this);
            personForm = new PersonForm();
            listView = new ListView(personList, personForm);
        }
        return listView;
    }
    
    private SearchView getSearchView() {
         if (searchView == null) {
             searchView = new SearchView(this);
         }
         return searchView;
     }
    
    
    //Toolbar wird zusammengestellt
    public HorizontalLayout createToolbar() {

        HorizontalLayout lo = new HorizontalLayout();
         lo.addComponent(newContact);
         lo.addComponent(search);
         lo.addComponent(share);
         lo.addComponent(help);
         search.addListener((Button.ClickListener) this);
         help.addListener((Button.ClickListener) this);
        return lo;

    }
    private HelpWindow getHelpWindow() {
        if (helpWindow == null) {
            helpWindow = new HelpWindow();
        }
        return helpWindow;
    }

    
    public void buttonClick(ClickEvent event){
    	final Button source = event.getButton();
    	 if (source == search) {
             showSearchView();
         } else if (source == help) {
             showHelpWindow();
          }
    }  
    
    private void showHelpWindow() {
        getMainWindow().addWindow(getHelpWindow());
    }
    private void showSearchView() {
        setMainComponent(getSearchView());
    }
    
    private void setMainComponent(Component c) {
        horizontalSplit.setSecondComponent(c);
    }

    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == personList) {
            Item item = personList.getItem(personList.getValue());
            if (item != personForm.getItemDataSource()) {
                personForm.setItemDataSource(item);
            }
        }
    }


}