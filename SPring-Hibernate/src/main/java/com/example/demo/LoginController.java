package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/login", method = RequestMethod.GET)

	public String login(@RequestParam(value="status", required=false) String status, Model model) {
		if(status != null) {
			System.out.println(status);
			if(status.equals("ok")){
				model.addAttribute("status","Üyeliğiniz başarıyla tamamlandı..");
			}else {
				model.addAttribute("status","Hata, Tekrar deneyiniz.");
			}
		}
		return "login";
	}
	@RequestMapping(value = "/reg/{user_key}", method = RequestMethod.GET)
	public String regOK(@PathVariable("user_key") String userKey, Model model) {
	    if (userService.getNoteFindByKey(userKey)) {
	        return "redirect:/login?status=ok";
	    }
	    return "redirect:/login?status=error";
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)

	public String regist(Model model) {
		return "register";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user, HttpServletRequest request) {
		int status=control(user);
		if(status!=0)
			return new ResponseEntity<>(status+"", HttpStatus.OK);
		System.out.println(user.toString());
		if(userService.insert(user).equals(1l)) {
			return new ResponseEntity<>("OK", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("ERROR", HttpStatus.CREATED);
	}
	@RequestMapping(value = "/controlUser", method = RequestMethod.POST)
	public ResponseEntity<String> controlUser(@RequestBody User user, HttpServletRequest request) {
		User userm = userService.getNoteFindByUsernameAndPass(user);
		if(userm !=null ){
			return new ResponseEntity<>("OK", HttpStatus.OK);
		}
		return new ResponseEntity<>("ERROR", HttpStatus.OK);
	}
				
	private int control(User user) {
		if(!user.getPass2().equals(user.getPass())){
			return 1;
		}
		return 0;
		
	}

}
