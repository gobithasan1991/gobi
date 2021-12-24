package com.basic.exception.module;

public class DuplicateException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 100001L;

	public DuplicateException() {
		super();
	}

	public DuplicateException(String message, Throwable cause) {
		super(message, cause);

	}

	public DuplicateException(String message) {
		super(message);

	}

	public DuplicateException(Throwable cause) {
		super(cause);
	}
}
