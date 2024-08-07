package com.crimsonlogic.bms;

public class BankAccount implements Account{
	private double balance=0.0;
	
	public double getBalance(int accNumber) {
		return balance;
	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double depositAmt) {
		this.balance += depositAmt;
	}

	public void withdraw(double withdrawlAmt) {
		this.balance -= withdrawlAmt;
	}
}
