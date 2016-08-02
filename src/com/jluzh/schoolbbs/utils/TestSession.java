package com.jluzh.schoolbbs.utils;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class TestSession {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Test
	public void test() {
		 
		 System.out.println(this.sessionFactory.getCurrentSession());
		
	}

}
