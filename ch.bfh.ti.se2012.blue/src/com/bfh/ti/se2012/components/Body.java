/**
 * The class Body is the HTML Body Template Design
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.components;


import com.bfh.ti.se2012.StartApplication;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;


public class Body extends VerticalLayout {

	
	private static final long serialVersionUID = 1L;
	private HorizontalLayout topMenu;
	private Button button_Edit;
	private Button button_Back;
	private Button btnLogout;
	private Button btnSettings;
	private Button btnMedication;
	private Button btnPatienten;	
	private Panel panel = new Panel("");


	/**
	 * Body Constructor
	 * Build body of HTML
	 */
	public Body() {
	
		
		setWidth("768px");
		setHeight("100%");
		setImmediate(false);
		setMargin(false);

		
	}

	/*
	 *  Body without TopNavigation
	 *  
	*/
	public void setBodyMainView(Component cu){
		panel.setSizeFull();
		panel.setScrollable(true);
		panel.addComponent(cu);
		
		//TopMenu
		HorizontalLayout menu = createMenu();
		
		//Add Components to Body
		addComponent(menu);
		setComponentAlignment(menu, Alignment.TOP_RIGHT);
		addComponent(panel);
		
		setExpandRatio(panel, 1);
	}
	
	/*
	 *  Body with Top and Bottom navigation
	 *  
	 */
	public void setBodySubView(Component cu){
		panel.setSizeFull();
		panel.setScrollable(true);
		panel.addComponent(cu);
		
		//ToolBar
		HorizontalLayout toolbar = createToolbar();
		addComponent(toolbar);
		setComponentAlignment(toolbar, Alignment.TOP_RIGHT);
		
		
		addComponent(panel);
		
		//TopMenu is set to Footer
		HorizontalLayout footerMenu = (createMenu());
		addComponent(footerMenu);
		setComponentAlignment(footerMenu, Alignment.TOP_CENTER);
		
		setExpandRatio(panel, 1);

	}

	/*
	 *  Body for defaultViews - LoginViews, without any Navigation
	 *  
	 */
	public void setBodyLoginView(Component cu){
		panel.setSizeFull();
		panel.setScrollable(true);
		panel.addComponent(cu);
		
		addComponent(panel);
		setExpandRatio(panel, 1);

	}
	
	public void removeBodyView(){
		panel.removeAllComponents();
		removeAllComponents();
	}
	
	/*
	 *  Toolbar for Views
	 *  
	 */
	private HorizontalLayout createToolbar() {
		
		
		// create button Back
		button_Back = new Button();
		button_Back.setCaption("Back");
		button_Back.setImmediate(false);
		button_Back.setWidth("100px");
		button_Back.setHeight("-1px");
		button_Back.setStyleName("navButton");
		
		
		// create button Edit
		button_Edit = new Button();
		button_Edit.setCaption("Edit");
		button_Edit.setImmediate(false);
		button_Edit.setWidth("100px");
		button_Edit.setHeight("-1px");
		button_Edit.setStyleName("navButton");

		HorizontalLayout naviTop = new HorizontalLayout();	
		naviTop.addComponent(button_Back);
		naviTop.setExpandRatio(button_Back, 1);
		naviTop.addComponent(button_Edit);
		naviTop.setExpandRatio(button_Back, 1);
		
		return naviTop;
	}

	
	/*
	 *  Body with Top and Bottom navigation
	 *  
	 */
	private HorizontalLayout createMenu() {
		
		// Home
		Button btnHome = new Button();
		btnHome.setCaption("Home");
		btnHome.setImmediate(false);
		btnHome.setWidth("100px");
		btnHome.setHeight("-1px");
		btnHome.setStyleName("navButton");
		btnHome.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("HomeView");
            }
        });

		// Patient
		btnPatienten = new Button();
		btnPatienten.setCaption("Patienten");
		btnPatienten.setImmediate(false);
		btnPatienten.setWidth("100px");
		btnPatienten.setHeight("-1px");
		btnPatienten.setStyleName("navButton");
		btnPatienten.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("PatientView");
            }
        });
		
		
		// Medication
		btnMedication = new Button();
		btnMedication.setCaption("Medikation");
		btnMedication.setImmediate(false);
		btnMedication.setWidth("100px");
		btnMedication.setHeight("-1px");
		btnMedication.setStyleName("navButton");
		btnMedication.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("MedicationView");
            }
        });
		
		// Settings
		btnSettings = new Button();
		btnSettings.setCaption("Settings");
		btnSettings.setImmediate(false);
		btnSettings.setWidth("100px");
		btnSettings.setHeight("-1px");
		btnSettings.setStyleName("navButton");
		btnSettings.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("SettingView");
            }
        });
		
		// Logout
		btnLogout = new Button();
		btnLogout.setCaption("LogOut");
		btnLogout.setImmediate(false);
		btnLogout.setWidth("100px");
		btnLogout.setHeight("-1px");
		btnLogout.setStyleName("navButton");
		btnLogout.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().userLoggedOut();
            }
        });
		
		topMenu = new HorizontalLayout();
		topMenu.setImmediate(false);
		topMenu.setHeight("-1px");
		topMenu.setMargin(true);
		
		topMenu.addComponent(btnHome);
		topMenu.setComponentAlignment(btnHome, new Alignment(48));
		topMenu.addComponent(btnPatienten);
		topMenu.setComponentAlignment(btnPatienten, new Alignment(48));
		topMenu.addComponent(btnMedication);
		topMenu.setComponentAlignment(btnMedication, new Alignment(48));
		topMenu.addComponent(btnSettings);
		topMenu.setComponentAlignment(btnSettings, new Alignment(48));
		topMenu.addComponent(btnLogout);
		topMenu.setComponentAlignment(btnLogout, new Alignment(48));
		
		return topMenu;
	}

}
