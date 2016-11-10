package com.foundation.exception;

public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String customMessage;

	public EmailException(String mensagem) {
		this.customMessage = mensagem;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

}
