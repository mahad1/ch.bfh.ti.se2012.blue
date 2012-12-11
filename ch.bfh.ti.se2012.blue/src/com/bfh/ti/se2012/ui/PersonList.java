package com.bfh.ti.se2012.ui;

import com.bfh.ti.se2012.Se_1Application;
import com.bfh.ti.se2012.data.PersonContainer;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;

public class PersonList extends Table {
     public PersonList(Se_1Application app) {
    	 setSizeFull();
         setContainerDataSource(app.getDataSource());
         setVisibleColumns(PersonContainer.NATURAL_COL_ORDER);
         setColumnHeaders(PersonContainer.COL_HEADERS_ENGLISH);
         /*
          * Make table selectable, react immediatedly to user events, and pass events to the
          * controller (our main application)
          */
         setSelectable(true);
         setImmediate(true);
         addListener((Property.ValueChangeListener) app);
         /* We don't want to allow users to de-select a row */
         setNullSelectionAllowed(false);
     }
 }