package org.javabrains.jayendra.dto;

import javax.persistence.Table;

@Table
public class Account {
	private int accountNumber;
	private String accountName;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
}
