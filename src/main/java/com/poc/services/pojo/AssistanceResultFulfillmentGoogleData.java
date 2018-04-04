package com.poc.services.pojo;

import java.util.List;

public class AssistanceResultFulfillmentGoogleData {
	private Boolean expect_user_response;
	private Boolean is_ssml;
	private List<String> no_input_prompts;

	public Boolean getExpect_user_response() {
		return expect_user_response;
	}

	public void setExpect_user_response(Boolean expect_user_response) {
		this.expect_user_response = expect_user_response;
	}

	public Boolean getIs_ssml() {
		return is_ssml;
	}

	public void setIs_ssml(Boolean is_ssml) {
		this.is_ssml = is_ssml;
	}

	public List<String> getNo_input_prompts() {
		return no_input_prompts;
	}

	public void setNo_input_prompts(List<String> no_input_prompts) {
		this.no_input_prompts = no_input_prompts;
	}

}
