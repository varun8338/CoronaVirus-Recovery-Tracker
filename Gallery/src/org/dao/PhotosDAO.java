package org.dao;

import java.util.List;

import org.entity.Photos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PhotosDAO {

	
	
	
	
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Photos.class).buildSessionFactory();

	public List<Photos> getPhotos(String username) {
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Photos> photos = session.createQuery("from photos where user_name = '"+username+"'").getResultList();
		
		return photos;
	}

	public void add(Photos photo) {
		Session session = factory.getCurrentSession();
		
		
		session.beginTransaction();
		
		session.save(photo);
		
		session.getTransaction().commit();
		
		
	}

	public void update(int id, String label, String caption) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Photos photo = session.get(Photos.class, id);
		photo.setPhotoLabel(label);
		photo.setPhotoCaption(caption);
		
		session.update(photo);
		
		session.getTransaction().commit();
		
	}

	public String getPhoto(int id) {
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Photos photo = session.get(Photos.class, id);
		
		return photo.getPhotoName();
	}
	
	
	
}
