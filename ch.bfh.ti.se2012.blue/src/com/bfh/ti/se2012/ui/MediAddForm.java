package com.bfh.ti.se2012.ui;


import com.vaadin.data.Property;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TextField;


public class MediAddForm extends CustomComponent implements Property.ValueChangeListener {

	private GridLayout base_grid;
	private GridLayout high_grid;
	private GridLayout low_grid;
	private GridLayout center_grid;
	private Button button_Save;
	private Button button_Back;
	private Button button_6;
	private Button button_5;
	private Button button_4;
	private Button button_3;	
	private Label Med_name;
	private Label Med_producer;
	private TextField editor;
	private static final String[] Medi = new String[] { "Aspirin", "Analgin","Spasmalgon", "QQQ", "ASSDSD"};
	


	/**
	 * The constructor should first build the base gridLayout, set the
	 * composition root and then do any custom initialization.
	 */
	public MediAddForm() {

		base_grid();
		high_grid();
		low_grid();
		center_grid();
		
		setCompositionRoot(base_grid);
		setSpacing(true);

	}

	
	private GridLayout center_grid() {

		center_grid = new GridLayout();
		center_grid.setImmediate(false);
		center_grid.setWidth("1024px");
		center_grid.setHeight("168px");
		center_grid.setMargin(false);
		center_grid.setRows(3);
		center_grid.setColumns(3);
	
		Label Med_name= new Label ("Medication Name : ");
		Label Med_producer= new Label ("Manufacture: ");
		TextField editor = new TextField ();
		Label Med_Num= new Label ("Nummer: ");
		TextField Num = new TextField ();
		
		// editor 
	//	setSpacing(true);

        editor.addListener(this);
        editor.setImmediate(false);
        editor.setColumns(5); // guarantees that at least 5 chars fit
        editor.setWidth("250px");
    	editor.setHeight("-1px");
		
    
    	 Num.addListener(this);
         Num.setImmediate(false);
         Num.setColumns(5); // guarantees that at least 5 chars fit
         Num.setWidth("250px");
     	 Num.setHeight("-1px");
 		
    	
    	
     // create combobox
     		ComboBox med = new ComboBox();
     		for (int i = 0; i < Medi.length; i++) {
     			med.addItem(Medi[i]);  }

     		med.setFilteringMode(Filtering.FILTERINGMODE_OFF);
     		med.setImmediate(true);
     		med.addListener(this);
     		med.setHeight("-5px");
     		
        //add component in gridlayout center
				
		center_grid.addComponent(Med_name,0,0);
		center_grid.addComponent(med, 1, 0);
		
		center_grid.addComponent(Med_producer,0,1);
		center_grid.addComponent(editor, 1, 1);
		
		center_grid.addComponent(Med_Num, 0,2);
		center_grid.addComponent(Num, 1,2);
		
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
		button_Save = new Button();
		button_Save.setCaption("Save");
		button_Save.setImmediate(false);
		button_Save.setWidth("100px");
		button_Save.setHeight("-1px");
		high_grid.addComponent(button_Save, 2, 0);
		high_grid.setComponentAlignment(button_Save, new Alignment(34));

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
     * Catch the valuechange event of the textfield and update the value of the
     * label component
     */
    public void valueChange(ValueChangeEvent event) {
        // Show the new value we received
      //  getWindow().showNotification((String) editor.getValue());
    }

	

}
