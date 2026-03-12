package com.sparta.rs.ApiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post405{

	@JsonProperty("message")
	private String message;

	@JsonProperty("responseCode")
	private int responseCode;

	public String getMessage(){
		return message;
	}

	public int getResponseCode(){
		return responseCode;
	}
}