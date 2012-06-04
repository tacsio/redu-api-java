package br.com.redu.api.auth;

import org.scribe.model.Token;

public class OAuthClientCredentials {

	private String apiKey, apiSecretKey, callback;
	private Token accessToken = null;

	public OAuthClientCredentials(String apiKey, String apiSecretKey) {
		this.apiKey = apiKey;
		this.apiSecretKey = apiSecretKey;
		this.callback = "";
	}

	public OAuthClientCredentials(String apiKey, String apiSecretKey, String callback) {
		this.apiKey = apiKey;
		this.apiSecretKey = apiSecretKey;
		this.callback = callback;
	}

	public Token getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(Token accessToken) {
		this.accessToken = accessToken;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecretKey() {
		return apiSecretKey;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

}
