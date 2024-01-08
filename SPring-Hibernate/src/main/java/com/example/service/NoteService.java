package com.example.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.NoteDAO;
import com.example.demo.Note;

import jakarta.servlet.http.HttpServletRequest;



@Service
@Transactional
public class NoteService {
	@Autowired
	private NoteDAO noteDAO;
	
	
	public Long createNote(Note note, HttpServletRequest request) {
		note.setUser_id(1l);
		return noteDAO.insert(note);
	}
	public Long updateNote(Note note, HttpServletRequest request) {
		
		noteDAO.update(note);
		return 1l;
	}
	public Long deleteNote(Note note, HttpServletRequest request) {
		
		noteDAO.delete(note);
		return 1l;
	}
	public ArrayList<Note> getAll(){
		return noteDAO.getAll();
		
	}
	public ArrayList<Note> getAll(Long userId){
		return noteDAO.getAll(userId);
	}
	public Note getNoteFindById(Long id){
		return noteDAO.getFindById(id);
	}
	


}
