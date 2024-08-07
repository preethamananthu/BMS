package com.crimsonlogic.bms;

public interface Account {
	double getBalance(int accId);
	void deposit(double depositAmt);
	void withdraw(double withdrawlAmt);
	
}


//used for loose coupling - advantage of using interfaces