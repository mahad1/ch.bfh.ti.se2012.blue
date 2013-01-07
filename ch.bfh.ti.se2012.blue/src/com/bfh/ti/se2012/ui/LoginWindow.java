package com.bfh.ti.se2012.ui;

import com.bfh.ti.se2012.data.SqlLogin;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Window;

public class LoginWindow  extends Window{


   public LoginWindow() {
        setCaption("Login");
        
        addComponent(new Label("Bitte melden Sie sich an:", Label.CONTENT_XHTML));
        setModal(true);
        setWidth("400px");
        this.setPositionX(150);
        this.setPositionY(250);
        
		LoginForm loginForm_1 = new LoginForm();
		loginForm_1.setStyleName("v-loginform");
		loginForm_1.setImmediate(false);
		loginForm_1.setWidth("-1px");
		loginForm_1.setHeight("-1px");
		
		loginForm_1.addListener(new LoginForm.LoginListener() {
            public void onLogin(LoginForm.LoginEvent event) {
                String pw = event.getLoginParameter("password");
                String username = event.getLoginParameter("username");
                
                SqlLogin checkLogin = new SqlLogin();
                if(checkLogin.validateLogin(username, pw)&&pw!=""&&username!=""){
                	getWindow().showNotification("Logged in user: " + username);
                	getApplication().getMainWindow().removeWindow(getWindow());
                }else{
                	getWindow().showNotification("Wrong user/password. Try again.",Notification.TYPE_WARNING_MESSAGE);
                }
            }
        });
		
		
		addComponent(loginForm_1);
    }
}
