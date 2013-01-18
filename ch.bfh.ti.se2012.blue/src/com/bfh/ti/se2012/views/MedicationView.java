/**
 * The class MedicationView display data from Login Handler Controller
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.views;

import java.util.ArrayList;

import com.bfh.ti.se2012.StartApplication;
import com.bfh.ti.se2012.components.Body;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class MedicationView extends AbstractView {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * The constructor should first body structur and than add the actual view.
	 */
	public MedicationView() {
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
		view.setCaption("Medikation");
		
		// Create the table
		Table table = new Table("");	
				
		// Define the names and data types of columns.
		table.addContainerProperty("ID", Integer.class, null);
		table.addContainerProperty("Name", String.class,  null);
		table.addContainerProperty("Hersteller",  String.class,  null);
		table.addContainerProperty("Einnahme", String.class, null);
		table.addContainerProperty("show details", Button.class,null);
		
		table.setWidth("768px");
		
		ArrayList buttonList = new ArrayList<Button>();
		
		for (int i=0; i<10; i++) {
			Button detailsField = new Button();
			Integer itemId = new Integer(i);
			detailsField.setCaption("Details");
			detailsField.addListener(new ClickListener() {
		        public void buttonClick(ClickEvent event) {
		            // Get the item identifier from the user-defined data.
		            Integer itemId = (Integer)event.getButton().getData();
		            StartApplication.getProject().getMainWindow().showNotification("Link");
		        } 
		    });
			//detailsField.setData(itemId);
			buttonList.add(i, detailsField);			
		}

		// Add a few items in the table
		table.addItem(new Object[] {new Integer(1), "Methadon","Streuli Phrama A", "Tablette 5mg (Oral)",buttonList.get(0)},new Integer(1));
		table.addItem(new Object[] {new Integer(2), "Ritalin","Novartis", "Tablette 1mg (Oral) ",buttonList.get(1)},new Integer(2));
		table.addItem(new Object[] {new Integer(3), "Crack","Street Supplies SA", "Inhalation(Pfeife) ",buttonList.get(2)},new Integer(3));
		table.addItem(new Object[] {new Integer(4), "Temesta","Pfizer AG", "Tablette 2.5mg (Oral) ",buttonList.get(3)},new Integer(4));
		table.addItem(new Object[] {new Integer(5), "Inderal"," AstraZeneca AG", "Tablette 40mg (Oral) ",buttonList.get(4)},new Integer(5));
		table.addItem(new Object[] {new Integer(6), " Delima Feminin","Pekana", "Zäpfchen ( Vaginal)",buttonList.get(5)},new Integer(6));
		table.addItem(new Object[] {new Integer(7), "Ilomedin","Bayer AG", "Ampulle 1ml (Subkultan)",buttonList.get(6)},new Integer(7));
		table.addItem(new Object[] {new Integer(8), "Bayer Contour","Bayer AG", "Sensorstreifen 50St.",buttonList.get(7)},new Integer(8));
		table.addItem(new Object[] {new Integer(9), "Benocten”, “Medinova AG", "Tablette 60mg (Oral)",buttonList.get(8)},new Integer(9));
		table.addItem(new Object[] {new Integer(10), "Otipax”, “Zambon Svizzera", "Tröpfchen (Ohreninstillationslösung)",buttonList.get(9)},new Integer(10));

					
		
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
