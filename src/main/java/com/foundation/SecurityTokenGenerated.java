package com.foundation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class SecurityTokenGenerated {

	@Autowired
	private SecurityAutoConfiguration sa;
	
	public String getToken() {
		return sa.securityProperties().getUser().getPassword();
	}
}
