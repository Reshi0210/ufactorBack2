package com.example.demo.DTOs;

public class TokenDto {
	private String AuthToken;

	public TokenDto(String authToken) {
		AuthToken = authToken;
	}

	public String getAuthToken() {
		return AuthToken;
	}

	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}

}
