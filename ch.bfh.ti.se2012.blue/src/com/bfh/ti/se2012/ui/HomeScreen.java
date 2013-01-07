package com.bfh.ti.se2012.ui;
import com.bfh.ti.se2012.StartApplication;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class HomeScreen extends GridLayout{
	
	
	Embedded Patient_Logo = null;
	Embedded Medi_Logo = null;
	Embedded Settings_Logo = null;
	Embedded LogOut_Logo = null;
	Label MEDAPP_Titel = null;
	
	public HomeScreen(){
		
		this.setRows(2);
		this.setColumns(2);
		this.setImmediate(false);
		this.setWidth("768");
		this.setHeight("600");
		this.setMargin(false);
		this.setStyleName("test");
		
		Button btnPatient = new Button(null);
		btnPatient.setIcon(new ThemeResource("img/medical_record.png"));
		btnPatient.setImmediate(false);
		btnPatient.setWidth("256px");
		btnPatient.setHeight("256px");
		btnPatient.addStyleName("nobackground");
		addComponent(btnPatient);
		btnPatient.addListener(new ClickListener() {
            public void buttonClick(ClickEvent event) {
            	removeAllComponents();
            	StartApplication.setView(new BasisForm());
            }
        });
		
		
		// Medi_Logo
		Medi_Logo = new Embedded();
		Medi_Logo.setImmediate(false);
		Medi_Logo.setWidth("256px");
		Medi_Logo.setHeight("256px");
		Medi_Logo.setSource(new ThemeResource("img/prescription_drugs.png"));
		Medi_Logo.setType(1);
		Medi_Logo.setMimeType("image/png");
		addComponent(Medi_Logo);
		
		// Settings_Logo
		Settings_Logo = new Embedded();
		Settings_Logo.setImmediate(false);
		Settings_Logo.setWidth("256px");
		Settings_Logo.setHeight("256px");
		Settings_Logo.setSource(new ThemeResource("img/settings.png"));
		Settings_Logo.setType(1);
		Settings_Logo.setMimeType("image/png");
		addComponent(Settings_Logo);
		
		// LogOut_Logo
		LogOut_Logo = new Embedded();
		LogOut_Logo.setImmediate(false);
		LogOut_Logo.setWidth("256px");
		LogOut_Logo.setHeight("256px");
		LogOut_Logo.setSource(new ThemeResource("img/shutdown.png"));
		LogOut_Logo.setType(1);
		LogOut_Logo.setMimeType("image/png");
		addComponent(LogOut_Logo);
		
		
	}

}
