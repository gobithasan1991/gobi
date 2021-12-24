package com.basic.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.basic.exception.module.DuplicateException;

@ControllerAdvice
public class GlobalControllerAdvice {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StringBuilder> handleConstraintViolationException(ConstraintViolationException ex) {
		ex.printStackTrace();
		int i = 0;
		StringBuilder errorMessage = new StringBuilder("");
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errorMessage.append(++i + ". " + violation.getMessage() + "\n");
		}
		return ResponseEntity.status(1062).body(errorMessage);
	}

	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<String> handleDuplicateException(Throwable e) {
		return ResponseEntity.status(1063).body(e.getMessage());
	}
}
