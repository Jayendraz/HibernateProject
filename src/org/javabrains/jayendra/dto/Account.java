package org.javabrains.jayendra.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	
	@Id @GeneratedValue
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;
	
	@Column(name="ACCOUNT_NAME")
	private String accountName;
	
	@ManyToMany(mappedBy= "accounts")
	private Collection<UserDetails> userDetails = new ArrayList<>();
	
	
	public Collection<UserDetails> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Collection<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}
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
