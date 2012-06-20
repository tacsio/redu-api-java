package br.com.redu.api.json;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonMapping {

	private Gson gson;
	private static JsonMapping mapper;

	private JsonMapping() {
		this.gson = new Gson();
	}

	public static synchronized Object evalResource(String json, Type clazz) {

		Object resource = null;

		if (mapper == null) {
			mapper = new JsonMapping();
		}

		try {
			resource = mapper.gson.fromJson(json, clazz);
		} catch (JsonSyntaxException e) {
			System.err.println("Malformed json. ");
			System.err.println(e.getMessage());
		}
		return resource;
	}
}
