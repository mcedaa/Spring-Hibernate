package com.example.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.NoteDAO;
import com.example.demo.LoginFilter;
import com.example.demo.Note;
import com.example.demo.User;
import com.example.dto.UserLoginDTO;

import jakarta.servlet.http.HttpServletRequest;



@Service
@Transactional
public class NoteService {
	@Autowired
	private NoteDAO noteDAO;
	@Autowired
	private UserService userService;
	
	
	public Long createNote(Note note, HttpServletRequest request) {
		note.setUser_id(LoginFilter.user.getId());
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
	public ArrayList<Note> getAll(UserLoginDTO login){
		User userm=new User();
		userm.setUsername(login.getUsername());
		userm.setPass(login.getPassword());
		
		User user=userService.getNoteFindByUsernameAndPass(userm);
		return noteDAO.getAll(user.getId());
	}
	


}
