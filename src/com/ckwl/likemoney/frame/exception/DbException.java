package com.ckwl.likemoney.frame.exception;

public class DbException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbException() {
		super();
	}

	public DbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

	public DbException(String message) {
		super(message);
	}

	public DbException(Throwable cause) {
		super(cause);
	}

}
