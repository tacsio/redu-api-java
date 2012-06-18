package br.com.redu.api.handler;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.redu.api.auth.ReduOAuthManager;
import br.com.redu.api.json.JsonMapping;

public class ReduRequestHandler {

	private ReduOAuthManager manager;

	public ReduRequestHandler(ReduOAuthManager manager) {
		this.manager = manager;
	}

	public Object request(Verb verb, Class<?> clazz, String url,
			Object... args) {
		if (!this.manager.authenticated()) {
			this.manager.setup();
		}
		
		if(args != null && args.length > 0){
			url = String.format(url, args);
		}
		
		OAuthRequest request = new OAuthRequest(verb, url + ".json");//TODO: is necessary?  (.json)
		request.addHeader("Content-Type", "application/json");
		request.addHeader("charset", "utf-8");
		this.manager.signRequest(request);
		Response response = request.send();
		// TODO: handling errors (http error code)

		return JsonMapping.evalResource(response.getBody(), clazz);
	}
}
