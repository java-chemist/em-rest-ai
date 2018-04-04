package com.poc.services.pojo;

public class AssistanceStatus {

	private int code;
	private String errorType;
	private boolean webhookTimedOut;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public boolean isWebhookTimedOut() {
		return webhookTimedOut;
	}

	public void setWebhookTimedOut(boolean webhookTimedOut) {
		this.webhookTimedOut = webhookTimedOut;
	}

}
