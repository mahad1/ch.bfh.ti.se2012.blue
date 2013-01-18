/**
 * The class LoginView display data from Login Handler Controller
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;
import com.bfh.ti.se2012.components.Body;
import com.bfh.ti.se2012.controller.LoginHandler;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;



public class LogInView extends AbstractView {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginHandler loginhandler = new LoginHandler();

	/**
	 * The constructor should first body structur and than add the actual view.
	 */
	public LogInView() {
		setHeight("100%");
		setWidth("768px");
		Body layout = new Body();

		setCompositionRoot(layout);
		layout.setBodyLoginView(this.setView());
		

	}

	/**
	 * this methode define the actual design of this view
	 */
	private HorizontalLayout setView() {
		HorizontalLayout view = new HorizontalLayout();
		view.setMargin(false);
		view.setWidth("100%");
		view.setCaption("");
		view.addComponent(loginhandler);
		view.setComponentAlignment(loginhandler, Alignment.TOP_CENTER);
		return view;

	}
	
	/*
	 * Method to change the visuals of the header when a user logs in.
	 */
	public void userLoggedIn() {

		// If for some reason the loginhandler has not been initialized.
		try {
			loginhandler.createLogoutComponents();

		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method to change the visuals of the header when a user logs out.
	 */
	public void userLoggedOut() {

		// If for some reason the loginhandler has not been initialized.
		try {
			loginhandler.createLoginComponents();

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
