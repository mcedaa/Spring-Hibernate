package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	public void registerMail(String mail, String key) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("edanuryetis5@gmail.com");
		email.setTo(mail);
		email.setSubject("Üyeliği Tamamla");
		email.setText("Üyeliği tamamlamak için aşağıdaki linke tıklayınız.\n\n"
				+NotAlmaController.url+"/reg/"+key);
		mailSender.send(email);
		
	}

}
