package com.foundation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.foundation.dto.BasicResponseDTO;


@ControllerAdvice
public class EmailExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<BasicResponseDTO> validacaoExceptionHandler(EmailException ve) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new BasicResponseDTO(ve.getCustomMessage()));
	}

}
