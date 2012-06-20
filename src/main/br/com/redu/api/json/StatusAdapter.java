package br.com.redu.api.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;

public class StatusAdapter<T> implements JsonDeserializer<T> {


	public T deserialize(JsonElement element, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		final JsonObject json = (JsonObject) element;
		final JsonElement type = get(json, "type");
		
		return null;
	}

	private JsonElement get(final JsonObject json, String memberName) {
        final JsonElement element = json.get(memberName);
        if (element == null) throw new JsonParseException("no '" + memberName + "' member found in what was expected.");
        return element;
    }
}
