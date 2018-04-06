package org.jayendra.hibernate;

import java.util.Date;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.util.NodeTraverser.VisitationStrategy;
import org.javabrains.jayendra.dto.Account;
import org.javabrains.jayendra.dto.Address;
import org.javabrains.jayendra.dto.UserDetails;
import org.javabrains.jayendra.dto.Vehicle;
import org.omg.CORBA.PRIVATE_MEMBER;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		
		Address address = new Address();
		address.setCity("Singapore");
		address.setState("Singapore");
		address.setStreet("Buona Vista road");
		address.setPincode("123456");
		
		Address address2 = new Address();
		address2.setStreet("Serangoon street");
		address2.setCity("Fairfax");
		address2.setState("Washington");
		address2.setPincode("987654");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Audi");
		
		Account savingAcc = new Account();
		savingAcc.setAccountName("Savings");
		
		Account currentAcc = new Account();
		currentAcc.setAccountName("Current");
		
		user.setUserId(1);
		user.setUsedrName("First Name");
		user.setJoinedDate(new Date());
		user.setDescription("Description goes here");
		
		user.setVehicle(vehicle);
		
		user.getAccounts().add(savingAcc);
		user.getAccounts().add(currentAcc);
		
		user.getListOfAddresses().add(address);
		user.getListOfAddresses().add(address2);
		
//		savingAcc.setUser(user);
//		currentAcc.setUser(user);
		
//		user.setHomeAddress(address);
//		user.setOfficeAddress(address2);
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(currentAcc);
		session.save(savingAcc);
		session.getTransaction().commit();
		
//		user = null;
//		session = sessionFactory.openSession();
//		
//		user = (UserDetails) session.get(UserDetails.class, 1);
//		session.close();
//		System.out.println(user.getListOfAddresses().size());
		
		
	}

}
