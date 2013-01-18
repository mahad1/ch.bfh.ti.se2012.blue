/**
 * The class Logout display data from Login Handler Controller
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;


import com.bfh.ti.se2012.components.Body;
import com.vaadin.ui.GridLayout;



public class LogoutView extends AbstractView {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * The constructor should first body structur and than add the actual view.
	 */
	public LogoutView() {
		setHeight("100%");
		setWidth("768px");
		Body layout = new Body();
		setCompositionRoot(layout);
		layout.setBodyMainView(this.setView());

	}

	/**
	 * this methode define the actual design of this view
	 */
	private GridLayout setView() {
		GridLayout view = new GridLayout(2,2);
		view.setMargin(false);
		view.setWidth("100%");
		view.setCaption("Logout View");
		return view;

	}
	
	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
