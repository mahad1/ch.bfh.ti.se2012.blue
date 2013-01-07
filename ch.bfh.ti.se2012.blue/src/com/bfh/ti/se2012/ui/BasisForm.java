package com.bfh.ti.se2012.ui;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;


public class BasisForm extends CustomComponent {

	
	
	private GridLayout base_grid;
	private GridLayout high_grid;
	private GridLayout low_grid;
	private Button button_Edit;
	private Button button_Back;
	private Button button_6;
	private Button button_5;
	private Button button_4;
	private Button button_3;	
	


	/**
	 * The constructor should first build the base gridLayout, set the
	 * composition root and then do any custom initialization.
	 */
	public BasisForm() {
	
		base_grid();
		high_grid();
		low_grid();
	
	setCompositionRoot(base_grid);

		
	}


	private GridLayout base_grid() {
	
		// create basis gridlayout
		base_grid = new GridLayout();
		base_grid.setImmediate(false);
		base_grid.setWidth("768px");
		base_grid.setHeight("768px");
		base_grid.setMargin(false);
		base_grid.setRows(3);
		
		
		
		// add gridLayout oben
		high_grid = high_grid();
		base_grid.addComponent(high_grid, 0, 0);
		
		// add gridLayout oben
		//high_grid = high_grid();
		//base_grid.addComponent(new HomeScreen(), 0, 1);
		
		// add gridLayout unten
		low_grid = low_grid();
		base_grid.addComponent(low_grid, 0, 2);
		
		return base_grid;
	}

	private GridLayout high_grid() {
		
		high_grid = new GridLayout();
		high_grid.setImmediate(false);
		high_grid.addStyleName("navigationTop");
		high_grid.setWidth("768px");
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
		low_grid.setWidth("768px");
		low_grid.setHeight("-1px");
		low_grid.setMargin(true);
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

}