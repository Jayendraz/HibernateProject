package org.javabrains.jayendra.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto generate Id
	@Column(name="USERID")
	private int userId;
	
	@Column(name="USERNAME")
	private String usedrName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="JOINEDDATE")
	private Date joinedDate;
	
	@Lob //large character object because data type is String
	@Column(name="DESCRIPTION")
	private String description;
	
	@ElementCollection(fetch= FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type= @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<>();
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(ArrayList<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
//	@Embedded
//	@AttributeOverrides({
//	@AttributeOverride (name= "street", column= @Column(name= "HOME_STREET")),
//	@AttributeOverride (name= "city", column= @Column(name= "HOME_CITY")),
//	@AttributeOverride (name= "state", column= @Column(name= "HOME_STATE")),
//	@AttributeOverride (name= "pincode", column= @Column(name="HOME_PINCODE"))
//	})
//	private Address homeAddress;
	
//	public Address getHomeAddress() {
//		return homeAddress;
//	}
//
//	public void setHomeAddress(Address homeAddress) {
//		this.homeAddress = homeAddress;
//	}
//	@Embedded
//	private Address officeAddress;
//	
//	public Address getOfficeAddress() {
//		return officeAddress;
//	}
//
//	public void setOfficeAddress(Address officeAddress) {
//		this.officeAddress = officeAddress;
//	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
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
