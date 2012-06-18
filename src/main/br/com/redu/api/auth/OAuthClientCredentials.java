package br.com.redu.api.auth;

import org.scribe.model.Token;

public class OAuthClientCredentials {

	private String apiKey, apiSecretKey, callback, scope;
	private Token accessToken = null;

	public OAuthClientCredentials(String apiKey, String apiSecretKey, String callback, String scope) {
		this.apiKey = apiKey;
		this.apiSecretKey = apiSecretKey;
		this.callback = callback;
		this.scope = scope;
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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
