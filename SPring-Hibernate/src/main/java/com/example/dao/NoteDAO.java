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
		sessionFactory.getCurrentSession().merge(note);
	}
	public void delete(Note note) {
		sessionFactory.getCurrentSession().remove(note);
	}
	
	//READ İŞLEMLERİ
	
	//tek bir notu id ye göre çağırma
	@Transactional
    public Note getFindById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE id = :id",Note.class);
        query.setParameter("id", id);
        Note note = (Note) query.getSingleResult();
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
