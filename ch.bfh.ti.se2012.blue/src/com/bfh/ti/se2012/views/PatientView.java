/**
 * The class Patientview display data from Patients
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.bfh.ti.se2012.StartApplication;
import com.bfh.ti.se2012.components.Body;
import com.bfh.ti.se2012.data.Patient;
import com.bfh.ti.se2012.data.Person;
import com.bfh.ti.se2012.data.SqlPatient;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table.ColumnResizeEvent;



public class PatientView extends AbstractView {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor should first build the base gridLayout, set the
	 * composition root and then do any custom initialization.
	 */
	public PatientView() {
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
		view.setCaption("Patienten");
		
		// Create the table
		Table table = new Table("");	
				
		// Define the names and data types of columns.
		table.addContainerProperty("ID", Integer.class, null);
		table.addContainerProperty("First Name", String.class,  null);
		table.addContainerProperty("Last Name",  String.class,  null);
		table.addContainerProperty("Gender", String.class, null);
		table.addContainerProperty("Birthdate", Date.class,null);
		table.addContainerProperty("show details", Button.class,null);
		
		
		table.setWidth("720px");

		//Create PatientList
		SqlPatient patient = new SqlPatient();

		//Iterate all Patient and add DetailButtton
		Iterator<Patient> iterator = patient.getPatientList().iterator();
		while (iterator.hasNext()) {
			final Patient p1 = iterator.next();
			Integer pid = p1.getPid();
			String LastName = p1.getLastName();
			String FirstName = p1.getFirstName(); 
			String Genre =  p1.getGenre();
			Date Birthdate = p1.getBirthdate();
			
			Button detailsField = new Button();
			detailsField.setCaption("Details");
			detailsField.addListener(new ClickListener() {
		        public void buttonClick(ClickEvent event) {
		        	StartApplication.getUiHandler().getPatientDetailView().setPatient(p1);
		            StartApplication.getUiHandler().switchView("PatientFormView");
		        } 
		    });
			
			table.addItem(new Object[] {pid,LastName,FirstName,Genre,Birthdate,detailsField},pid);
		}
		// Allow selecting
		table.setSelectable(true);

		// Send changes in selection immediately to server.
		table.setImmediate(true);

		// Shows feedback from selection.
		final Label current = new Label("Selected: -");

		        
		// Must be immediate to send the resize events immediately
		table.setImmediate(true);
		view.addComponent(table);
		return view;
	    

	}
	
	@Override
	protected void close() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
