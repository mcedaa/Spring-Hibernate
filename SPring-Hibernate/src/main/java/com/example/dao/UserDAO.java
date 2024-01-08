package com.example.dao;

import java.util.ArrayList;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Note;
import com.example.demo.User;

import org.hibernate.Transaction;

import jakarta.persistence.Query;

@Repository
@Transactional
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	//CRUD
	
    public Long insert(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(user);
            transaction.commit();
            return user.getId();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
	
	public void update(User user) {
		   Session session = sessionFactory.getCurrentSession();
	        Transaction transaction = null;

	        try {
	            transaction = session.beginTransaction();
	            session.merge(user);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            throw e;
	        }
	}
	/*

	@Transactional
    public void delete(Note note) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try {
		    transaction = session.beginTransaction();
		    
		    // Nesneyi oturuma ekle
		    Note attachedNote = session.merge(note);
		    
		    // Nesneyi sil
		    session.remove(attachedNote);
		    
		    transaction.commit();
		} catch (Exception e) {
		    if (transaction != null) {
		        transaction.rollback();
		    }
		    throw e;
		}

    }
	*/
	
	//READ İŞLEMLERİ
	
	//tek bir notu id ye göre çağırma
	
	@SuppressWarnings({"deprecation", "rawtypes" })
	public User getFindByUsernameAndPass(String username, String pass) {
	        Session session = sessionFactory.getCurrentSession();
	        Transaction transaction = null;
	        User user = null;
	        try {
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("FROM User WHERE username = :username AND pass =: pass AND active=:active");
	            query.setParameter("username", username);
	            query.setParameter("pass", pass);
	            query.setParameter("active", true);
	            user = (User) ((org.hibernate.query.Query) query).uniqueResult();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            throw e;
	        }
	        return user;
	    }
	
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public User getFindByUsername(String username) {
	        Session session = sessionFactory.getCurrentSession();
	        Transaction transaction = null;
	        User user = null;
	        try {
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("FROM User WHERE username = :username");
	            query.setParameter("username", username);
	            user = (User) ((org.hibernate.query.Query) query).uniqueResult();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            throw e;
	        }
	        return user;
	    }
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public User getFindByKey(String user_key) {
	    Session session = sessionFactory.getCurrentSession();
	    Transaction transaction = null;
	    User user = null;
	    try {
	        transaction = session.beginTransaction();
	        Query query = session.createQuery("FROM User WHERE user_key = :user_key");
	        query.setParameter("user_key", user_key);
	        user = (User) ((org.hibernate.query.Query) query).uniqueResult();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        throw e;
	    }
	    return user;
	}





}
