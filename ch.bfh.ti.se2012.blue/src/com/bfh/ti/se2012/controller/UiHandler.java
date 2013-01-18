/**
 * The class UIHandler define which components we want to add to our UI
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.controller;

import java.util.HashMap;


import com.bfh.ti.se2012.StartApplication;
import com.bfh.ti.se2012.components.Header;
import com.bfh.ti.se2012.views.AbstractView;
import com.bfh.ti.se2012.views.HomeView;
import com.bfh.ti.se2012.views.LogInView;
import com.bfh.ti.se2012.views.LogoutView;
import com.bfh.ti.se2012.views.MedicationView;
import com.bfh.ti.se2012.views.PatientFormView;
import com.bfh.ti.se2012.views.PatientView;
import com.bfh.ti.se2012.views.SettingView;
import com.vaadin.Application.UserChangeEvent;
import com.vaadin.Application.UserChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class UiHandler extends VerticalLayout implements UserChangeListener {

	private static final long serialVersionUID = 1L;
	private Header header;
	private LogInView defaultView;
	final PatientFormView patientDetail = new PatientFormView();
	/* Used to keep track of the current main view.
	 * All views in viewList HashMap
	 */
	private HashMap<String, AbstractView> viewList = new HashMap<String, AbstractView>();
	
	

	/*
	 * Constructor of the handler. Creates and styles all default components.
	 * 
	 * @param window main window of the application
	 */
	public UiHandler(Window window) {
		
		header = new Header();
		defaultView = new LogInView();

		// Add the main components for the UI.
		addComponent(header);
		addComponent(defaultView);
		setComponentAlignment(header, Alignment.TOP_CENTER);
		setComponentAlignment(defaultView, Alignment.TOP_CENTER);

		setExpandRatio(defaultView, 1);
		setMargin(false);
		setSpacing(true); 
		
		window.setContent(this);
	}

	
	/*
	 * Load Components if user is logged in
	 * */
	public void userLoggedIn(){
		
		// Remove LogginView
		removeComponent(defaultView);
		
		// Set HomeView to body 
		HomeView home = new HomeView();
		addComponent(home);
		setComponentAlignment(home, Alignment.TOP_CENTER);
		
		// Create ViewList
		viewList.put("HomeView", new HomeView());
		viewList.put("PatientView", new PatientView());
		viewList.put("MedicationView", new MedicationView());
		viewList.put("SettingView", new SettingView());
		viewList.put("LogoutView", new LogoutView());
		viewList.put("PatientFormView", patientDetail);
		
		// Inform defaultView of the UI that the user has logged in.
		defaultView.userLoggedIn();
		
		
		StartApplication.getProject().getMainWindow().showNotification("Login Successful");
		

	}
	
	/*
	 * Remove currentView and screen defaultScreen -> LoginView.
	 */
	public void userLoggedOut() {

		try {
			// Remove currentView
			//removeComponent(this.getComponent(1));
			LogInView login = new LogInView();
			// Add the loginView.
			replaceComponent(this.getComponent(1), login);
			setExpandRatio(login, 1);
			setComponentAlignment(login, Alignment.TOP_CENTER);

			// Tell the LoginView that the user logged off.
			defaultView.userLoggedOut();

		} catch (Exception e) {

		}
	}
	/*
	 * Updates the main view when the user clicks an item in the menu.
	 * 
	 * @param event Event
	 */
	public void switchView(String viewName) {
		setMainView(viewList.get(viewName));
	}

	
	/*
	 * Helper method for setting the main view.
	 * 
	 * @param c View that we want to display
	*/ 
	public void setMainView(AbstractView c) {
		// If components exist.
		try {
			// Remove the split panel including menu and userView.
			
			// Add the default view.
			replaceComponent(this.getComponent(1), c);
			setExpandRatio(c, 1);
			setComponentAlignment(c, Alignment.TOP_CENTER);
		
		} catch (Exception e) {
		
		}
	}
	
	public PatientFormView getPatientDetailView(){
		return patientDetail;
		
	}
	/*
	 * Listener UserChanges on Application
	 * */
	public void applicationUserChanged(UserChangeEvent event) {
		//Application user check
		if (event.getNewUser() == null) {
			userLoggedOut();
		} else {
			userLoggedIn();
		}
		
	}

}
