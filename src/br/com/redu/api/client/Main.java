package br.com.redu.api.client;

import br.com.redu.api.resource.user.User;

public class Main {

	public static void main(String[] args) {

		IReduRestClient rest = new ReduRestClient();
		User tacsio = rest.me();
		System.out.println(tacsio.getLogin());
		System.out.println();
	}
}
