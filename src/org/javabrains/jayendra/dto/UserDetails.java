package org.javabrains.jayendra.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto generate Id
	@Column(name="USERID")
	private int userId;
	
	@Column(name="USERNAME")
	private String usedrName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column(name="JOINEDDATE")
	private Date joinedDate;
	
	@Lob //large character object because data type is String
	@Column(name="DESCRIPTION")
	private String description;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
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
	public void setJoinedDate(Date date) {
		this.joinedDate = date;		
	}
	
	
}
