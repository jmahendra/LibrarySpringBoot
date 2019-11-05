package com.tyss;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.User;

@RestController
@RequestMapping("/send")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class RootController {
	@Autowired
	private SmtpMailSender sender;

	@PostMapping(path = "/send", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendMail(@RequestBody User user) throws MessagingException {

		sender.send(user.getuEmail(), "mail via java mail",
				" Email -->" + user.getuEmail() + "  Password-->" + user.getuPassword());
		System.out.println("mail sent");
		System.out.println(" Email -->" + user.getuEmail() + "  Password-->" + user.getuPassword());
	}
}
