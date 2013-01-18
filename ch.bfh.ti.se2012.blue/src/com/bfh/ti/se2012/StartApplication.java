/**
 * The class StartApplication creates the main thread
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012;

import com.bfh.ti.se2012.controller.UiHandler;
import com.vaadin.Application;
import com.vaadin.service.ApplicationContext;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Window;


public class StartApplication extends Application  implements ApplicationContext.TransactionListener{
	
	
	private static final long serialVersionUID = 1L;
	protected static ThreadLocal<StartApplication> thisApplication = new ThreadLocal<StartApplication>();

	
	/*
	 *  Set ThreadLocal application.
	 *  @param StartApplication t	
	 */
	public static void setProject(StartApplication t) {
		thisApplication.set(t);
	}

	/*
	 *  Get ThreadLocal application.
	 */
	public static StartApplication getProject() {
		return thisApplication.get();
	}

    public static GridLayout layout;
    public static UiHandler ui;
    
    @Override
    public void init() {
    	
	    	setMainWindow(new Window("Medicus App"));
	        this.setTheme("medicus");
	        
	        // Adds a TransactionListener for this class.
			getContext().addTransactionListener(this);
			
			// UI Controller
	        ui = new UiHandler(getMainWindow());
	        
	        // Register user change listener for UiHandler.
			addListener(ui);
    }
   
	/*
	 * Helper to return the uiHandler attached to a unique application.
	 */
	public static UiHandler getUiHandler() {
		return thisApplication.get().ui;
	}

	/*
	 * For ThreadLocal pattern.
	 */
	public void transactionStart(Application application, Object transactionData) {

		if (application == StartApplication.this) {
			thisApplication.set(this);
		}
	}

	/*
	 * For ThreadLocal pattern, remove application reference
	 */
	public void transactionEnd(Application application, Object transactionData) {
		if (application == StartApplication.this) {
			thisApplication.set(null);
		}
	}
    


}