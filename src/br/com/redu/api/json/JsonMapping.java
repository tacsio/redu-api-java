package br.com.redu.api.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonMapping {

	private Gson gson;
	private static JsonMapping mapper;

	private JsonMapping() {
		this.gson = new Gson();
	}

	public static synchronized Object evalResource(String json, Class<?> resouce) {

		Object resource = null;

		if (mapper == null) {
			mapper = new JsonMapping();
		}

		try {
			resource = mapper.gson.fromJson(json, resouce);
		} catch (JsonSyntaxException e) {
			System.err.println("Malformed json. ");
			System.err.println(e.getMessage());
		}
		return resource;
	}
}
