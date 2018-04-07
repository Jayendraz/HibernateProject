package org.jayendra.hibernate;

import java.util.List;

import org.hibernate.Query;
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
		
//		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
//		session.delete(user);
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 8);
		
		session.getTransaction().commit();			
		session.close();
		
		user.setUsedrName("changed Name");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		
		Query query = session.createQuery("from UserDetails");
		
		List<UserDetails> userDetails = (List<UserDetails>) query.list();
		
		System.out.println(userDetails.size());
		
		for (UserDetails object : userDetails) {
			System.out.println(object.getUsedrName());
		}
		
		session.getTransaction().commit();
		session.close();

	}

}
