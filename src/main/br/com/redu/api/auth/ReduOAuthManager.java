package br.com.redu.api.auth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import java.util.Scanner;

public class ReduOAuthManager {

	private OAuthClientCredentials credentials;
	private OAuthService service;

	public ReduOAuthManager(OAuthClientCredentials credentials) {
		this.credentials = credentials;

		ServiceBuilder builder = new ServiceBuilder()
				.provider(ReduOAuth20.class).apiKey(credentials.getApiKey())
				.apiSecret(credentials.getApiSecretKey())
				.callback(credentials.getCallback());

		//Scope
		if (null != credentials.getScope()) {
			builder = builder.scope(credentials.getScope());
		}

		this.service = builder.build();
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

	// TODO: learn about oob auth(non web applications) and how ulr callback works at scribe
	public void getAccessToken(String pin) {
		this.credentials.setAccessToken(this.service.getAccessToken(null,
				new Verifier(pin.trim())));
	}

	// TODO: learn about oob auth(non web applications) and how ulr callback works at scribe
	// FIXME: external auth || sub-workflow >__<
	public void setup() {
		System.out.println(this.getAuthorizationUrl());
		System.out.println("Trust me... it's temporary ;D");
		Scanner pin = new Scanner(System.in); // FIXME: remove Oo"
		this.getAccessToken(pin.nextLine());


	}

}
