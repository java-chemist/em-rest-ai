package com.poc.services.pojo;

import java.sql.Timestamp;

public class AssistanceDetails {
	private String id;
	private Timestamp timestamp;
	private String lang;
	private AssistanceResult result;
	private AssistanceStatus status;
	private String sessionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public AssistanceResult getResult() {
		return result;
	}

	public void setResult(AssistanceResult result) {
		this.result = result;
	}

	public AssistanceStatus getStatus() {
		return status;
	}

	public void setStatus(AssistanceStatus status) {
		this.status = status;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
