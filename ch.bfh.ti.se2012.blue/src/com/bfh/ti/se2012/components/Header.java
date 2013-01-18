/**
 * The class Header has the header div of HTML Site
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.components;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

public class Header extends HorizontalLayout{
	
	private static final long serialVersionUID = 1L;
	private final Embedded em = new Embedded(null,  new ThemeResource("img/Logo_MedApp.jpg"));
	
	/**
	 * Header Constructor
	 * Build Header of HTML
	 */
	public Header() {

		setWidth("768px");
		
		Panel panel = new Panel();
		panel.setSizeFull();
		panel.setScrollable(false);
		panel.setHeight("150");
		
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(em);
		layout.setComponentAlignment(em, Alignment.MIDDLE_LEFT);
		layout.setWidth("100%");
		
		panel.addComponent(layout);
		addComponent(panel);
	}
	
}
