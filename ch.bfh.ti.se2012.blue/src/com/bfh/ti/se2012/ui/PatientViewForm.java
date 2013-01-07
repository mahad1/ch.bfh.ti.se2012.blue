package com.bfh.ti.se2012.ui;


import com.vaadin.data.Property;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.Action;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;


public class PatientViewForm extends CustomComponent implements Property.ValueChangeListener {

	private GridLayout base_grid;
	private GridLayout high_grid;
	private GridLayout low_grid;
	private GridLayout center_grid;
	private GridLayout center_high_grid;
	private Button button_Edit;
	private Button button_Back;
	private Button button_6;
	private Button button_5;
	private Button button_4;
	private Button button_3;	

	private static final String[] info = new String[] { "Case", "Medikation"};

	
	static final Action ACTION_DATE = new Action("Date");


	/**
	 * The constructor should first build the base gridLayout, set the
	 * composition root and then do any custom initialization.
	 */
	public PatientViewForm() {

		base_grid();
		high_grid();
		low_grid();
		center_grid();
		center_high_grid();

		setCompositionRoot(base_grid);

		setSpacing(true);


	}

	private GridLayout center_high_grid() {
		center_high_grid = new GridLayout();
		center_high_grid.setImmediate(false);
		center_high_grid.setWidth("1024px");
		center_high_grid.setHeight("50px");
		center_high_grid.setMargin(false);
		center_high_grid.setRows(2);
		center_high_grid.setColumns(2);

		Label Pat_name= new Label ("Patient Name : ");
		Label Pat_PID= new Label ("Patient PID : ");

		Label Pat_name_bsp= new Label ("Max Mustermann");
		Label Pat_PID_bsp= new Label ("1233433333 ");

		//	 Pat_name.setImmediate(true);
		//    Pat_name.addListener(this);
		//   Pat_name.setHeight("-5px");


		center_high_grid.addComponent(Pat_name,0,0);
		center_high_grid.addComponent(Pat_PID,0,1);
		center_high_grid.addComponent(Pat_name_bsp,1,0);
		center_high_grid.addComponent(Pat_PID_bsp,1,1); 
		return center_high_grid;


	}

	private GridLayout center_grid() {

		center_grid = new GridLayout();
		center_grid.setImmediate(false);
		center_grid.setWidth("1024px");
		center_grid.setHeight("668px");
		center_grid.setMargin(false);
		center_grid.setRows(3);

		// create combobox
		ComboBox l = new ComboBox("Please select Patient Info");
		for (int i = 0; i < info.length; i++) {
			l.addItem(info[i]);  }

		l.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		l.setImmediate(true);
		l.addListener(this);
		l.setHeight("-5px");

		Table table = new Table("  ");
	
		// size
        table.setWidth("1024px");
        table.setHeight("478px");
        
	/**	
		// Label to indicate current selection
		final Label selected = new Label("No selection");
		addComponent(selected);
		
	
        // selectable
        table.setSelectable(true);
       table.setMultiSelect(true);
       table.setImmediate(true); // react at once when something is selected

    

        // turn on column reordering and collapsing
        table.setColumnReorderingAllowed(true);
       table.setColumnCollapsingAllowed(true);

        // set column headers
       table.setColumnHeaders(new String[] { "Date", "Case" });

**/

		center_high_grid = center_high_grid();
		center_grid.addComponent(center_high_grid,0,0);

		center_grid.addComponent(l,0,1);
		center_grid.addComponent(table,0,2);

		return center_grid;


	}


	private void setSpacing(boolean b) {
		// TODO Auto-generated method stub

	}


	private GridLayout base_grid() {

		// create basis gridlayout
		base_grid = new GridLayout();
		base_grid.setImmediate(false);
		base_grid.setWidth("1024");
		base_grid.setHeight("768");
		base_grid.setMargin(false);
		base_grid.setRows(3);


		// add gridLayout oben
		high_grid = high_grid();
		base_grid.addComponent(high_grid, 0, 0);

		// add gridLayout in center
		center_grid = center_grid();
		base_grid.addComponent(center_grid, 0, 1);

		// add gridLayout unten
		low_grid = low_grid();
		base_grid.addComponent(low_grid, 0, 2);



		return base_grid;
	}

	private GridLayout high_grid() {

		high_grid = new GridLayout();
		high_grid.setImmediate(false);
		high_grid.setWidth("1024px");
		high_grid.setHeight("50px");
		high_grid.setMargin(false);
		high_grid.setColumns(3);

		// create button Back
		button_Back = new Button();
		button_Back.setCaption("Back");
		button_Back.setImmediate(false);
		button_Back.setWidth("100px");
		button_Back.setHeight("-1px");
		high_grid.addComponent(button_Back, 0, 0);
		high_grid.setComponentAlignment(button_Back, new Alignment(33));

		// create button Edit
		button_Edit = new Button();
		button_Edit.setCaption("Edit");
		button_Edit.setImmediate(false);
		button_Edit.setWidth("100px");
		button_Edit.setHeight("-1px");
		high_grid.addComponent(button_Edit, 2, 0);
		high_grid.setComponentAlignment(button_Edit, new Alignment(34));

		return high_grid;
	}

	private GridLayout low_grid() {

		low_grid = new GridLayout();
		low_grid.setImmediate(false);
		low_grid.setWidth("1024px");
		low_grid.setHeight("50px");
		low_grid.setMargin(false);
		low_grid.setColumns(4);

		// button_3
		button_3 = new Button();
		button_3.setCaption("Beispiel");
		button_3.setImmediate(false);
		button_3.setWidth("100px");
		button_3.setHeight("-1px");
		low_grid.addComponent(button_3, 0, 0);
		low_grid.setComponentAlignment(button_3, new Alignment(48));

		// button_4
		button_4 = new Button();
		button_4.setCaption("Beispiel");
		button_4.setImmediate(false);
		button_4.setWidth("100px");
		button_4.setHeight("-1px");
		low_grid.addComponent(button_4, 1, 0);
		low_grid.setComponentAlignment(button_4, new Alignment(48));

		// button_5
		button_5 = new Button();
		button_5.setCaption("Beispiel");
		button_5.setImmediate(false);
		button_5.setWidth("100px");
		button_5.setHeight("-1px");
		low_grid.addComponent(button_5, 2, 0);
		low_grid.setComponentAlignment(button_5, new Alignment(48));

		// button_6
		button_6 = new Button();
		button_6.setCaption("Beispiel");
		button_6.setImmediate(false);
		button_6.setWidth("100px");
		button_6.setHeight("-1px");
		low_grid.addComponent(button_6, 3, 0);
		low_grid.setComponentAlignment(button_6, new Alignment(48));

		return low_grid;
	}


	/*
	 * Shows a notification when a selection is made.
	 */
	public void valueChange(ValueChangeEvent event) {
		getWindow().showNotification("Selected Patient Info: " + event.getProperty());

	}


}
