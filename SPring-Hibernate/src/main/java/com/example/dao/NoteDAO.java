package com.example.dao;

import java.util.ArrayList;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Note;
import org.hibernate.Transaction;

import jakarta.persistence.Query;

@Repository
@Transactional
public class NoteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	//CRUD
	
    public Long insert(Note note) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(note);
            transaction.commit();
            return note.getId();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
	
	public void update(Note note) {
		   Session session = sessionFactory.getCurrentSession();
	        Transaction transaction = null;

	        try {
	            transaction = session.beginTransaction();
	            session.merge(note);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            throw e;
	        }
	}

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
	
	//READ İŞLEMLERİ
	
	//tek bir notu id ye göre çağırma
	
	   @SuppressWarnings("rawtypes")
	public Note getFindById(Long id) {
	        Session session = sessionFactory.getCurrentSession();
	        Transaction transaction = null;
	        Note note = null;
	        try {
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("FROM Note WHERE id = :id");
	            query.setParameter("id", id);
	            note = (Note) ((org.hibernate.query.Query) query).uniqueResult();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            throw e;
	        }
	        return note;
	    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<Note> getAll() {
	    Query query = sessionFactory.getCurrentSession().createQuery("FROM Note", Note.class);
		List<Note> noteList = query.getResultList();
	    return new ArrayList<>(noteList);
	}
	
	//birden fazla notu çağırma

	 public ArrayList<Note> getAll(Long user_id) {
	        Session session = sessionFactory.getCurrentSession();
	        Transaction transaction = session.beginTransaction();
	        try {
	            Query query = session.createQuery("FROM Note WHERE user_id = :user_id order by id desc", Note.class);
	            query.setParameter("user_id", user_id);
	            ArrayList<Note> notes = (ArrayList<Note>) query.getResultList();
	            transaction.commit();
	            return notes;
	        } catch (Exception e) {
	            transaction.rollback();
	            throw e;
	        }
	    }




}
