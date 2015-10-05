package org.hcmiu.vnu.vietherb.CRUDS;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hcmiu.vnu.vietherb.model.Herb;
import org.hcmiu.vnu.vietherb.model.SingleTerm;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;

public class VietHerbDatabaseClass {

	private static Map<Long, Herb> herbList = new HashedMap();
	private static Map<Long,SingleTerm> singleTermList = new HashedMap();
	private static SessionFactory herbSessionFactory = new Configuration().configure().buildSessionFactory();
	private static SessionFactory singleTermSessionFactory = new Configuration().configure().buildSessionFactory();
	private static Session session;

	public static Map<Long, Herb> getAllHerbs() {
		return herbList;
	}

	public static void insertHerbToDB(Herb herb) {
		session = herbSessionFactory.openSession();
		session.beginTransaction();
		session.save(herb);
		session.getTransaction().commit();
		session.close();

		herb = getNewestHerb();
		System.out.println(herb.getScientificName() + herb.getId() + "sucess added ");
	}

	public static Herb getNewestHerb() {
		session = herbSessionFactory.openSession();
		session.beginTransaction();
		return (Herb) session.get(Herb.class, getHerbLastID());
	}

	public static Herb getHerb(int id) {
		session = herbSessionFactory.openSession();
		session.beginTransaction();
		try {
			return (Herb) session.get(Herb.class, id);
		} catch (Exception e) {
		}
		return null;
	}

	public static void refreshDB() {
		int lastHerbID = getHerbLastID();
		Herb herb;
		SingleTerm singleTerm;
		int lastSingleTermID = getSingleTermLastID();
		
		System.out.println("last Herb id" + lastHerbID);
		System.out.println("last SingleTerm id" + lastSingleTermID);
		for (int i = 1; i <= lastHerbID; i++) {
			herb = getHerb(i);
			if (herb != null)
				herbList.put((long) i, herb);
		}
		
		for (int i = 1; i <= lastSingleTermID; i++) {
			singleTerm = getSingleTerm(i);
			if (singleTerm != null)
				singleTermList.put((long) i, singleTerm);
		}
	}

	private static SingleTerm getSingleTerm(int id) {
		session = singleTermSessionFactory.openSession();
		session.beginTransaction();
		try {
			return (SingleTerm) session.get(SingleTerm.class, id);
		} catch (Exception e) {
		}
		return null;
	}

	public static int getHerbLastID(){
		Session session = herbSessionFactory.getCurrentSession();
		session.beginTransaction();
		
		int lastID;
		try{
			Criteria criteria = session
				    .createCriteria(Herb.class)
				    .setProjection(Projections.max("id"));
			criteria.setFirstResult(0);
			lastID = (Integer)criteria.uniqueResult();
		}
		catch(HibernateException e){
			System.out.println();
			session.getTransaction().rollback();
			throw e;
		}
		return lastID;
	}

	public static void insertSingleTermToDB(SingleTerm content) {
		session = singleTermSessionFactory.openSession();
		session.beginTransaction();
		session.save(content);
		session.getTransaction().commit();
		session.close();

		content = getNewestSingleTerm();
		System.out.println(content.getContent() + content.getId() + "sucess added ");
	}

	private static SingleTerm getNewestSingleTerm() {
		session = singleTermSessionFactory.openSession();
		session.beginTransaction();
		return (SingleTerm) session.get(SingleTerm.class, getSingleTermLastID());
		
	}
	
	public static int getSingleTermLastID(){
		Session session = singleTermSessionFactory.getCurrentSession();
		session.beginTransaction();
		
		int lastID;
		try{
			Criteria criteria = session
				    .createCriteria(SingleTerm.class)
				    .setProjection(Projections.max("id"));
			criteria.setFirstResult(0);
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
