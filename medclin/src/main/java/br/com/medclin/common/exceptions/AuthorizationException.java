package br.com.medclin.common.exceptions;

public class AuthorizationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthorizationException() {
		super();
	}

	public AuthorizationException(String message) {
		super(message);
	}
	
	public AuthorizationException(String message, Throwable cause) {
		super(message, cause);
	}

}
