package com.bank;

import java.util.Scanner;

import com.bank.dao.UserDao;
import com.bank.dao.UserDaoImpl;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNametaken;
import com.bank.exception.UserNotFound;
import com.bank.service.AuthService;
import com.bank.service.AuthServiceImpl;
import com.bank.ui.LoginMenu;
import com.bank.ui.Menu;
import com.bank.ui.RegistrationMenu;
import com.bank.ui.WelcomeMenu;

public class Driver {

	public static void main(String[] args) throws InvalidPassword, UserNotFound, UserNametaken {
		

		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoImpl();
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu register = new RegistrationMenu();
		
		Menu login = new LoginMenu(authService);
		
		Menu welcomeMenu = new WelcomeMenu(login, register);
		
		((RegistrationMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistrationMenu)register).setAuthService(authService);
		
		login.setScanner(scan);
		
		register.setScanner(scan);
		
		welcomeMenu.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
			
		} while (nextMenu != null);
		

		
	}

}
