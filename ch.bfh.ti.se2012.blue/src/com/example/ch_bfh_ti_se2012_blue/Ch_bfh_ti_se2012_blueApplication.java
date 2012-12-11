package com.example.ch_bfh_ti_se2012_blue;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class Ch_bfh_ti_se2012_blueApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Ch_bfh_ti_se2012_blue Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
