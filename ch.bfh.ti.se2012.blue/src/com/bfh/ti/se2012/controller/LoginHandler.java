/**
 * The class LoginHandler authentificate the user and setup user to application
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.controller;

import com.bfh.ti.se2012.StartApplication;
import com.bfh.ti.se2012.data.SqlLogin;
import com.bfh.ti.se2012.data.User;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;

public class LoginHandler  extends VerticalLayout implements Handler{


	private static final long serialVersionUID = 1L;
	/*
	 * TextField,Button outside declared
	 * */
	public User user;
	private final TextField userField = new TextField("Username");
	private final TextField passwordField = new TextField("Password");
	private final Button submit = new Button("Login",
			new Button.ClickListener() {
				public void buttonClick(ClickEvent e) {
					if(userField.getValue()!=""&&passwordField.getValue()!=""){
						login((String) userField.getValue(), (String) passwordField.getValue());
					}else{
						getWindow().showNotification("Wrong user/password. Try again.",Notification.TYPE_WARNING_MESSAGE);
					}
				}
	
			});
	private final Button logoutButton = new Button("Logout",
			new Button.ClickListener() {
				public void buttonClick(ClickEvent e) {
					logout();
				}
			});
	
	// Authentication method for the project.
	private SqlLogin auth = new SqlLogin();
	private VerticalLayout loginForm = new VerticalLayout();
	
	// Allow input with the enter button.
	private final Action ACTION_LOGIN = new ShortcutAction("Login ",ShortcutAction.KeyCode.ENTER, null);
	
	public LoginHandler() {
        
        addComponent(new Label("Bitte melden Sie sich an:", Label.CONTENT_XHTML));
		setMargin(true);
		setWidth("200");
		
        passwordField.setSecret(true);
        createLoginComponents();
		
		addComponent(loginForm);
    }
	
	
	/*
	 * Try to log in and set credentials.
	 * 
	 * @param loginname login name value retrieved from the form
	 * @param password login password value retrieved from the form
	 */
	private void login(String loginname, String password) {

		// Empty the text boxes.
		userField.setValue("");
		passwordField.setValue("");

		// Try to authenticate the user.
		user = auth.Authenticate(loginname, password);

		if (user != null) {
			//Setup Application User
			StartApplication.getProject().setUser((Object) user.getFirstName() + " ");

		} else {
			
			getWindow().showNotification("Wrong user/password. Try again.",Notification.TYPE_WARNING_MESSAGE);

		}

	}

	/*
	 * Inserts the login-"Form" for the user.
	 */
	public void createLoginComponents() {

		// Clears all current components in case the user already logged in.
		removeAllComponents();

		// Adds the "Form" for the login event.
		loginForm.addComponent(userField);
		loginForm.setComponentAlignment(userField, Alignment.TOP_LEFT);

		loginForm.addComponent(passwordField);
		loginForm.setComponentAlignment(passwordField, Alignment.MIDDLE_LEFT); 
		loginForm.addComponent(submit);
		submit.setStyleName("submitButton");
		loginForm.setComponentAlignment(submit, Alignment.BOTTOM_LEFT);

	}

	
	/*
	 * Creates the login information box and the logout button.
	 */
	public void createLogoutComponents() {

		// User name
		Label welcome = new Label("Welcome, ");
		Label person = new Label("Admin");

		// Clears all current components.
		removeAllComponents();

		VerticalLayout vert = new VerticalLayout();
		vert.setWidth("100");

		vert.addComponent(welcome);
		vert.addComponent(person);
		vert.addComponent(logoutButton);
		
		addComponent(vert);
		setComponentAlignment(vert, Alignment.BOTTOM_RIGHT);

	}
	
	/*
	 * Used to inform the application that a user has logged off.
	 */
	public void logout() {

		// Sets the current user as NULL and fires an UserChangeEvent.
		StartApplication.getProject().setUser(null);
		user = null;

		// Add back the ActionHandler for the Enter key.
		StartApplication.getProject().getMainWindow().addActionHandler(this);
	}

	public Action[] getActions(Object target, Object sender) {
		return new Action[] { ACTION_LOGIN };
	}

	public void handleAction(Action action, Object sender, Object target) {
		// Handle only events that originate from Login window

		if (action == ACTION_LOGIN) {
			login((String) userField.getValue(), (String) passwordField
					.getValue());
		}

	}
}
