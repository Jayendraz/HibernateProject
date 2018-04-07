package org.jayendra.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;
import org.hibernate.classic.Session;
import org.javabrains.jayendra.dto.UserDetails;

public class CRUD_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i=1; i<=10; i++) {
			UserDetails user = new UserDetails();
			user.setUsedrName("User " + i);
			session.save(user);
		}
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		session.delete(user);
		
		user = (UserDetails) session.get(UserDetails.class, 8);
		user.setUsedrName("Updated Name");
		
		session.getTransaction().commit();
		
		
		System.out.println("User Name is: " + user.getUsedrName());		
		
		
		session.close();

	}

}
