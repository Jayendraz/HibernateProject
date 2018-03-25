package org.javabrains.jayendra.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private int userId;
	private String usedrName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsedrName() {
		return usedrName;
	}
	public void setUsedrName(String usedrName) {
		this.usedrName = usedrName;
	}
	
	
}
