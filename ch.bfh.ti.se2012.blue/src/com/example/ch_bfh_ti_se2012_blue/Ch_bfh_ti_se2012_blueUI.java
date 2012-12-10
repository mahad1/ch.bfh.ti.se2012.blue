package com.example.ch_bfh_ti_se2012_blue;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

public class Ch_bfh_ti_se2012_blueUI extends UI {
	@Override
	public void init(VaadinRequest request) {
		Label label = new Label("Hello Vaadin user");
		setContent(label);
	}

}
