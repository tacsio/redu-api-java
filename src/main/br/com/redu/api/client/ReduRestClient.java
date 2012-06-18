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

		ReduConf config = ReduConf.getInstance();
		this.credentials = new OAuthClientCredentials(config.getConsumerKey(),
				config.getConsumerSecretKey(), config.getCallback(),
				config.getScope());

		this.init();
	}

	public ReduRestClient(String consumerKey, String secretKey) {
		ReduConf config = ReduConf.getInstance();
		this.credentials = new OAuthClientCredentials(consumerKey, secretKey,
				config.getCallback(), config.getScope());
		this.init();
	}

	private void init() {
		this.manager = new ReduOAuthManager(this.credentials);
		this.handler = new ReduRequestHandler(this.manager);
	}

	public User getUser(int id) {
		return (User) handler.request(Verb.GET, User.class, User.show(), id);
	}

	public User getUser(String login) {
		return (User) handler.request(Verb.GET, User.class, User.show(), login);
	}

	public User me() {
		return (User) handler.request(Verb.GET, User.class, User.me());
	}

}
