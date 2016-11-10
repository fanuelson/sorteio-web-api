package com.foundation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foundation.properties.EmailAuthProperties;

import br.com.any.configuration.AutenticacaoEmail;
import br.com.any.configuration.EmailConfiguration;
import br.com.any.model.Email;
import br.com.any.service.EmailService;

@Service
public class CustomEmailService extends AbstractService{
	
	@Autowired
	private EmailAuthProperties emailAuthPropertyUtils;

	public EmailService create() {
		String username = emailAuthPropertyUtils.getUsername();
		String pass = emailAuthPropertyUtils.getPassword();
		AutenticacaoEmail authEmail = AutenticacaoEmail.configure(username, pass);
		EmailConfiguration emailConfig = EmailConfiguration.configure(authEmail);
		return EmailService.create(emailConfig);
	}

	public void enviar(Email email) {
        EmailService es = create();
        es.enviar(email);
	}
	
}
