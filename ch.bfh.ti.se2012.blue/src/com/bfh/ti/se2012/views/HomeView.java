/**
 * The class HomeView display data from Controller
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;
import com.bfh.ti.se2012.StartApplication;
import com.bfh.ti.se2012.controller.LoginHandler;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;

public class HomeView extends AbstractView{
	
	public LoginHandler loginhandler = new LoginHandler();
	
	private static final long serialVersionUID = 1L;
	Embedded Patient_Logo = null;
	Embedded Medi_Logo = null;
	Embedded Settings_Logo = null;
	Embedded LogOut_Logo = null;
	
	
	/*
 	 * Constructor HomeView 
 	 * 
 	 */
	public HomeView(){
	

		setWidth("768px");
		Panel panel = new Panel();
		panel.setSizeFull();
		
		panel.addComponent(this.setView());
		setCompositionRoot(panel);
		
		
	}
	public GridLayout setView(){
		
		// Button Patient
		Button btnPatient = new Button(null);
		btnPatient.setIcon(new ThemeResource("img/medical_record.png"));
		btnPatient.setImmediate(false);
		btnPatient.setWidth("275px");
		btnPatient.setHeight("275px");
		btnPatient.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("PatientView");
            }
        });
		
		// Button Patient
		Button btnMedication = new Button(null);
		btnMedication.setIcon(new ThemeResource("img/prescription_drugs.png"));
		btnMedication.setImmediate(false);
		btnMedication.setWidth("275px");
		btnMedication.setHeight("275px");
		
		btnMedication.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("MedicationView");
            }
        });

		// Button Patient
		Button btnSettings = new Button(null);
		btnSettings.setIcon(new ThemeResource("img/settings.png"));
		btnSettings.setImmediate(false);
		btnSettings.setWidth("275px");
		btnSettings.setHeight("275px");
		
		btnSettings.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().switchView("SettingView");
            }
        });
		
		
		// Button Patient
		Button btnLogOut = new Button(null);
		btnLogOut.setIcon(new ThemeResource("img/shutdown.png"));
		btnLogOut.setImmediate(false);
		btnLogOut.setWidth("275px");
		btnLogOut.setHeight("275px");
		
		btnLogOut.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	StartApplication.getUiHandler().userLoggedOut();
            }
        });
		
		GridLayout home = new GridLayout(2,2);
		home.setMargin(false);
		home.setWidth("100%");
		home.addComponent(btnPatient,0,0);
		home.setComponentAlignment(btnPatient, Alignment.TOP_CENTER);
		home.addComponent(btnMedication,0,1);
		home.setComponentAlignment(btnMedication, Alignment.TOP_CENTER);
		home.addComponent(btnSettings,1,0);
		home.setComponentAlignment(btnSettings, Alignment.TOP_CENTER);
		home.addComponent(btnLogOut,1,1);
		home.setComponentAlignment(btnLogOut, Alignment.TOP_CENTER);
		
		return home;
	}
	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	


}
