package com.foundation.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/Users/fanuca/Documents/sorteio-web-api-properties/email-auth.properties")
public class EmailAuthProperties {

	@Value("${email.username}")
	private String username;

	@Value("${email.password}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}