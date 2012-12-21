package com.bfh.ti.se2012.ui;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;

public class HomeScreen extends AbsoluteLayout{
	
	
	Embedded Patient_Logo = null;
	Embedded Medi_Logo = null;
	Embedded Settings_Logo = null;
	Embedded LogOut_Logo = null;
	Label MEDAPP_Titel = null;
	
	public HomeScreen(){
		
		setImmediate(false);
		setWidth("1024");
		setHeight("768px");
		setMargin(false);
		
		// Patient_Logo
		Patient_Logo = new Embedded();
		Patient_Logo.setImmediate(false);
		Patient_Logo.setWidth("256px");
		Patient_Logo.setHeight("256px");
		Patient_Logo.setSource(new ThemeResource("img/medical_record.png"));
		Patient_Logo.setType(1);
		Patient_Logo.setMimeType("image/png");
		addComponent(Patient_Logo, "top:142.0px;left:72.0px;");
		
		// Medi_Logo
		Medi_Logo = new Embedded();
		Medi_Logo.setImmediate(false);
		Medi_Logo.setWidth("256px");
		Medi_Logo.setHeight("256px");
		Medi_Logo.setSource(new ThemeResource("img/prescription_drugs.png"));
		Medi_Logo.setType(1);
		Medi_Logo.setMimeType("image/png");
		addComponent(Medi_Logo, "top:141.0px;left:360.0px;");
		
		// Settings_Logo
		Settings_Logo = new Embedded();
		Settings_Logo.setImmediate(false);
		Settings_Logo.setWidth("256px");
		Settings_Logo.setHeight("256px");
		Settings_Logo.setSource(new ThemeResource("img/settings.png"));
		Settings_Logo.setType(1);
		Settings_Logo.setMimeType("image/png");
		addComponent(Settings_Logo, "top:429.0px;left:60.0px;");
		
		// LogOut_Logo
		LogOut_Logo = new Embedded();
		LogOut_Logo.setImmediate(false);
		LogOut_Logo.setWidth("256px");
		LogOut_Logo.setHeight("256px");
		LogOut_Logo.setSource(new ThemeResource("img/shutdown.png"));
		LogOut_Logo.setType(1);
		LogOut_Logo.setMimeType("image/png");
		addComponent(LogOut_Logo, "top:429.0px;left:360.0px;");
		
		
	}

}
