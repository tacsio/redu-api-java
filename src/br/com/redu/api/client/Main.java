package br.com.redu.api.client;

public class Main {

	public static void main(String[] args) {

		IReduRestClient rest = new ReduRestClient();
		System.out.println(rest.me());
	}
}
