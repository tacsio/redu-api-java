package br.com.redu.api.auth;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class ReduOAuthManager {

	private OAuthClientCredentials credentials;
	private OAuthService service;

	public ReduOAuthManager(OAuthClientCredentials credentials) {
		this.credentials = credentials;
		this.service = new ServiceBuilder().provider(ReduOAuth20.class)
				.apiKey(credentials.getApiKey())
				.apiSecret(credentials.getApiSecretKey())
				.callback(credentials.getCallback()).build();
	}

	public String getAuthorizationUrl() {
		return this.service.getAuthorizationUrl(null);
	}

	public boolean authenticated() {
		return this.credentials.getAccessToken() != null;
	}

	public void signRequest(OAuthRequest request) {
		this.service.signRequest(this.credentials.getAccessToken(), request);
	}

	// TODO: learn aboud oob auth(non web applications)
	public void getAccessToken(String pin) {
		this.credentials.setAccessToken(this.service.getAccessToken(null,
				new Verifier(pin.trim())));
	}

	// TODO: learn aboud oob auth(non web applications)
	public void setup() {
		System.out.println(this.getAuthorizationUrl());
		Scanner pin = new Scanner(System.in);
		this.getAccessToken(pin.nextLine());

	}

}
