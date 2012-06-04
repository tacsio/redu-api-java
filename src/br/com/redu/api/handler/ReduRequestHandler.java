package br.com.redu.api.handler;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.redu.api.auth.ReduOAuthManager;

public class ReduRequestHandler {

	private ReduOAuthManager manager;

	public ReduRequestHandler(ReduOAuthManager manager) {
		this.manager = manager;
	}

	public Object request(Verb verb, String url, Object... params) {
		if (!this.manager.authenticated()) {
			this.manager.setup();
		}
		OAuthRequest request = new OAuthRequest(verb, url);
		this.manager.signRequest(request);
		Response response = request.send();

		return response.getBody();
	}
}
