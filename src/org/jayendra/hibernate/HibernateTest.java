package org.jayendra.hibernate;

import java.util.Date;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.util.NodeTraverser.VisitationStrategy;
import org.javabrains.jayendra.dto.Address;
import org.javabrains.jayendra.dto.UserDetails;

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
		
		user.setUserId(1);
		user.setUsedrName("First Name");
		
		user.getListOfAddresses().add(address);
		user.getListOfAddresses().add(address2);
		
//		user.setHomeAddress(address);
//		user.setOfficeAddress(address2);
		
		user.setJoinedDate(new Date());
		user.setDescription("Description goes here");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		user = null;
		session = sessionFactory.openSession();
		
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddresses().size());
		
		
	}

}
