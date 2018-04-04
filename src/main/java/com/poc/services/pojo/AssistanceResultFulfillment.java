package com.poc.services.pojo;

import java.util.List;

public class AssistanceResultFulfillment {
	private String speech;
	private List<AssistanceResultMessages> messages;
	private AssistanceResultFulfillmentData data;

	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	public List<AssistanceResultMessages> getMessages() {
		return messages;
	}

	public void setMessages(List<AssistanceResultMessages> messages) {
		this.messages = messages;
	}

	public AssistanceResultFulfillmentData getData() {
		return data;
	}

	public void setData(AssistanceResultFulfillmentData data) {
		this.data = data;
	}

}
