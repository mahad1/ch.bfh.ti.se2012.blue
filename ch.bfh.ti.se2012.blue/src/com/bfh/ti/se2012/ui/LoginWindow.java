package com.bfh.ti.se2012.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Window;

public class LoginWindow  extends Window{


   public LoginWindow() {
        setCaption("Login");
        
        addComponent(new Label("Bitte melden Sie sich an:", Label.CONTENT_XHTML));
        setModal(true);
        setWidth("50%");
        center();
        
        
		LoginForm loginForm_1 = new LoginForm();
		loginForm_1.setStyleName("v-loginform");
		loginForm_1.setImmediate(false);
		loginForm_1.setWidth("-1px");
		loginForm_1.setHeight("-1px");
		
		loginForm_1.addListener(new LoginForm.LoginListener() {
            public void onLogin(LoginForm.LoginEvent event) {
                String pw = event.getLoginParameter("password");
                String username = event.getLoginParameter("username");
                
                if (pw.equals("1234")) {
                    //setUser(username);
                    //currentUser.setValue(username);
                    getWindow().showNotification(
                            "Logged in user: " + username);
                   // getWindow().replaceComponent(loginForm_1,maiPanel);
                    //el.expand(mainPanel);
                } else {
                    //getMainWindow().showNotification(
                    //        "Wrong password. Hint, try '1234' ",
                    //       Notification.TYPE_WARNING_MESSAGE);
                }
            }
        });
		
		
		addComponent(loginForm_1);
    }
}
