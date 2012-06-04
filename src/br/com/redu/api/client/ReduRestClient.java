package br.com.redu.api.client;

import org.scribe.model.Verb;

import br.com.redu.api.ReduConf;
import br.com.redu.api.auth.OAuthClientCredentials;
import br.com.redu.api.auth.ReduOAuthManager;
import br.com.redu.api.handler.ReduRequestHandler;
import br.com.redu.api.resource.user.User;

public class ReduRestClient implements IReduRestClient {

	private OAuthClientCredentials credentials;
	private ReduOAuthManager manager;
	private ReduRequestHandler handler;

	public ReduRestClient() {
		this.init(ReduConf.getInstance());
	}

	private void init(ReduConf config) {
		this.credentials = new OAuthClientCredentials(config.getConsumerKey(),
				config.getConsumerSecretKey(), config.getCallback());
		this.manager = new ReduOAuthManager(this.credentials);
		this.handler = new ReduRequestHandler(this.manager);
	}

	public User getUser(int id) {
		return null;
	}

	public User getUser(String login) {
		return null;
	}

	public User me() {
		Object a = handler.request(Verb.GET, User.me() + ".json");
		System.out.println(a);
		return null;
	}

}
