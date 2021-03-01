package com.bank.ui;

import java.util.Scanner;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNametaken;
import com.bank.exception.UserNotFound;

public interface Menu {

	public Menu advance();
	
	public void displayOptions() throws InvalidPassword, UserNotFound, UserNametaken;
	
	public Menu previousMenu();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);
}
