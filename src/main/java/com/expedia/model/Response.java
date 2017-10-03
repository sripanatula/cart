package com.expedia.model;

public class Response {

	// I use these as the defaults so we can initialize them but let the developer set other values in their code
	// It worked with saving face as well as doing its job. Admittedly there are different ways to do it as well
	private boolean success = true;
	private int errorCode = 0;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
