package com.poc.services.pojo;

public class AssistanceResultMetadata {
	private String intentId;
	private String webhookUsed;
	private String webhookForSlotFillingUsed;
	private String webhookResponseTime;
	private String intentName;

	public String getIntentId() {
		return intentId;
	}

	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}

	public String getWebhookUsed() {
		return webhookUsed;
	}

	public void setWebhookUsed(String webhookUsed) {
		this.webhookUsed = webhookUsed;
	}

	public String getWebhookForSlotFillingUsed() {
		return webhookForSlotFillingUsed;
	}

	public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
		this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
	}

	public String getWebhookResponseTime() {
		return webhookResponseTime;
	}

	public void setWebhookResponseTime(String webhookResponseTime) {
		this.webhookResponseTime = webhookResponseTime;
	}

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}
}
