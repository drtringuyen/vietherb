package org.hcmiu.vnu.vietherb.CRUDS;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hcmiu.vnu.vietherb.model.Herb;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;

public class VietHerbDatabaseClass {

	private static Map<Long, Herb> herbList = new HashedMap();
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private static Session session;

	public static Map<Long, Herb> getAllHerbs() {
		return herbList;
	}

	public static void insertHerbToDB(Herb herb) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(herb);
		session.getTransaction().commit();
		session.close();

		herb = getNewestHerb();
		System.out.println(herb.getScientificName() + herb.getId() + "sucess added ");
	}

	public static Herb getNewestHerb() {
		session = sessionFactory.openSession();
		session.beginTransaction();
		return (Herb) session.get(Herb.class, getHerbLastID());
	}

	public static Herb getHerb(int id) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return (Herb) session.get(Herb.class, id);
		} catch (Exception e) {
		}
		return null;
	}

	public static void refreshDB() {
		int lastID = getHerbLastID();
		Herb herb;
		System.out.println("last Herb id" + lastID);
		for (int i = 1; i <= lastID; i++) {
			herb = getHerb(i);
			if (herb != null)
				herbList.put((long) i, herb);
		}
	}

	public static int getHerbLastID(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		int lastID;
		try{
			Criteria criteria = session
				    .createCriteria(Herb.class)
				    .setProjection(Projections.max("id"));
			lastID = (Integer)criteria.uniqueResult();
		}
		catch(HibernateException e){
			System.out.println();
			session.getTransaction().rollback();
			throw e;
		}
		return lastID;
	}
}
