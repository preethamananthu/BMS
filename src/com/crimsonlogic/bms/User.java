package com.crimsonlogic.bms;

public class User extends BankAccount{
	private int userId;
	private String username;
	private String password;
	private int accNumber;
	
	public User() {
		
	}
	
	

	public User(int userId, String username, String password, int accNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.accNumber = accNumber;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}
	
	

	public String getPassword() {
		return password;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNumber;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accNumber != other.accNumber)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [username=" + username + "] , Balance = " + getBalance(67);
	}

}
