package com.poc.services.pojo;

import java.util.List;

public class AssistanceResult {

	private String source;
	private String resolvedQuery;
	private String action;
	private String actionIncomplete;
	private AssistanceResultParameters parameters;
	private List<AssistanceResultContexts> contexts;
	private AssistanceResultMetadata metadata;
	private AssistanceResultFulfillment fulfillment;
	private int score;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getResolvedQuery() {
		return resolvedQuery;
	}

	public void setResolvedQuery(String resolvedQuery) {
		this.resolvedQuery = resolvedQuery;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionIncomplete() {
		return actionIncomplete;
	}

	public void setActionIncomplete(String actionIncomplete) {
		this.actionIncomplete = actionIncomplete;
	}

	public AssistanceResultParameters getParameters() {
		return parameters;
	}

	public void setParameters(AssistanceResultParameters parameters) {
		this.parameters = parameters;
	}

	public List<AssistanceResultContexts> getContexts() {
		return contexts;
	}

	public void setContexts(List<AssistanceResultContexts> contexts) {
		this.contexts = contexts;
	}

	public AssistanceResultMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(AssistanceResultMetadata metadata) {
		this.metadata = metadata;
	}

	public AssistanceResultFulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(AssistanceResultFulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
