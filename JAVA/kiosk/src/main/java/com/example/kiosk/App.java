package com.example.kiosk;

import com.example.kiosk.common.login.Login;
import com.example.kiosk.common.login.LoginPanel;

public class App
{
    public static void main( String[] args ) {
//    	new LoginPanel();
    	
        Login login = new Login();
        
        login.login();
    }
}
