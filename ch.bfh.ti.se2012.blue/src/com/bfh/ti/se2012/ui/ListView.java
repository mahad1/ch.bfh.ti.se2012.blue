package com.bfh.ti.se2012.ui;

import com.vaadin.ui.VerticalSplitPanel;

public class ListView extends VerticalSplitPanel {
    public ListView(PersonList personList, PersonForm personForm) {
        setFirstComponent(personList);
        setSecondComponent(personForm);
        setSplitPosition(40);
    }
 }