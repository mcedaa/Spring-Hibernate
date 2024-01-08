package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.demo.MailService;
import com.example.demo.User;

import jakarta.servlet.http.HttpServletRequest;



@Service
@Transactional
public class UserService {
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private UserDAO userDAO;
	
	
	public Long insert(User user) {
		String uuid = UUID.randomUUID().toString();
		user.setKey(uuid);
		if(userDAO.insert(user)>0) {
			mailService.registerMail(user.getEmail(), user.getKey());
			
		}
		return 1l;
	}
	public void update(User user) {
		
		userDAO.update(user);
	}

	
	public User getNoteFindByUsernameAndPass(User user){
		return userDAO.getFindByUsernameAndPass(user.getUsername(), user.getPass());	
		}
	
	
	public User getNoteFindByUsername(String username){
		return userDAO.getFindByUsername(username);
	}
	public boolean getNoteFindByKey(String user_key){
		User user=userDAO.getFindByKey(user_key);
		if(user !=null) {
			user.setActive(true);
			update(user);
			return true;
		}
			
		else
			return false;
			
	}

}
