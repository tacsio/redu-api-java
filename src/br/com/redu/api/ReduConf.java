package br.com.redu.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReduConf {

	private static final String FILE = "redu.properties";
	private static final String AUTH_URL = "redu.auth_url";
	private static final String ACCESS_TOKEN_URL = "redu.access_token_url";
	private static final String CONSUMER_KEY = "redu.consumer_key";
	private static final String CONSUMER_SECRET_KEY = "redu.consumer_secret_key";
	private static final String CALLBACK = "redu.callback";
	private static final String BASE_URL = "redu.base_url";

	private Properties properties = new Properties();
	private static ReduConf instance;

	public static synchronized ReduConf getInstance() {
		if (instance == null) {
			instance = new ReduConf();
		}
		return instance;
	}

	private ReduConf() {
		try {
			InputStream in = new FileInputStream(FILE);
			properties.load(in);
		} catch (FileNotFoundException e) {
			System.err.println("You should define redu.properties, with OAuth configurations. \nSee README.");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public String getAuthUrl() {
		return properties.getProperty(AUTH_URL);
	}

	public String getConsumerKey() {
		return properties.getProperty(CONSUMER_KEY);
	}

	public String getConsumerSecretKey() {
		return properties.getProperty(CONSUMER_SECRET_KEY);
	}

	public String getAccessTokenUrl() {
		return properties.getProperty(ACCESS_TOKEN_URL);
	}

	public String getCallback() {
		return properties.getProperty(CALLBACK, "");
	}

	public String getBaseUrl() {
		return properties.getProperty(BASE_URL);
	}
}
