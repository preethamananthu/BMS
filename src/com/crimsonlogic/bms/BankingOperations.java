package com.crimsonlogic.bms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingOperations {

	int bankOperation;
	int loginOperation;

	Scanner in = new Scanner(System.in);
	List<User> userList = new ArrayList<>();

	
	
	
	public void readUserChoice() {
		System.out.println("Enter choice: ");

		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("0. Exit");

		bankOperation = in.nextInt();

	}
	
	
	

	public void bankingMenu() {

		do {
			readUserChoice();
			switch (bankOperation) {
			case 1:
				registerUser();
				break;
			case 2:
				login();
				break;

			default:
				System.out.println("Enter valid choice.");
				break;
			}
		} while (bankOperation != 0);
	}
	
	
	
	

	private void login() {
		System.out.println("Enter username: ");
		String username = in.next();

		try {
			for (User user : userList) {
				if (username.equals(user.getUsername())) {
					System.out.println("Enter password: ");
					String password = in.next();
					if (password.equals(user.getPassword())) {
						LoginOptions(user);
					} else {
						throw new InvalidCredentialsException("Invalid Password");
					}
				} else {
					throw new InvalidCredentialsException("Invalid Username");
				}
			}
		} catch (InvalidCredentialsException e) {
			e.printStackTrace();
		}
	}
	
	
	

	private void readLoginChoice() {
		System.out.println("Login Successful");
		System.out.println("Enter banking options: ");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("0. Logout");
		loginOperation = in.nextInt();
	}
	
	
	

	private void LoginOptions(User user) {
		do {

			readLoginChoice();
			switch (loginOperation) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double dep = in.nextDouble();
				try {
					if (dep > 0) {
						user.deposit(dep);
					} else {
						throw new BankingException("Deposit amount cannot be zero.");
					}
				} catch (BankingException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.print("Enter amount to withdraw: ");
				double with = in.nextDouble();
				try {
					if (with < user.getBalance(user.getAccNumber())) {
						user.withdraw(with);
					} else {
						throw new BankingException("Withdrawl amount has to be greater than the balance");
					}
				} catch (BankingException e) {
					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println(user.getBalance(user.getAccNumber()));
			default:
				System.out.println("Enter valid choice");
				break;
			}
		} while (loginOperation != 0);

	}
	
	
	
	

	private void registerUser() {

		System.out.println("Enter Account ID, Username, Password and Account Number");
		int accId = in.nextInt();
		String username = in.next();
		String password = in.next();
		int accNumber = in.nextInt();

		userList.add(new User(accId, username, password, accNumber));
		System.out
				.println("User registration successful for \nUsername: " + username + "\nAccount number: " + accNumber);
	}
}
