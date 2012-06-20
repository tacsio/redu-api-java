package br.com.redu.api.client;

import br.com.redu.api.resource.user.User;

public interface IReduRestClient {

	//public User getUser(int id);
	//public User getUser(String login);
	public User me();
}
