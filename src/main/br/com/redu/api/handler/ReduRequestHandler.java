package br.com.redu.api.handler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import br.com.redu.api.auth.ReduOAuthManager;
import br.com.redu.api.json.JsonMapping;
import br.com.redu.api.resource.Base;

public class ReduRequestHandler {

	private ReduOAuthManager manager;

	public ReduRequestHandler(ReduOAuthManager manager) {
		this.manager = manager;
	}

	public Object request(Verb verb, Type clazz, String url,
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
		
		Object resource = JsonMapping.evalResource(response.getBody(), clazz);
		
		if(resource instanceof List<?>){
			for(Object item : ArrayList.class.cast(resource)) {
				System.out.println(clazz);
				System.out.println(clazz.getClass());
				System.out.println(clazz.getClass().getComponentType());
				System.out.println(resource.getClass());
				System.out.println(resource.getClass().getComponentType());
				System.out.println(resource.getClass().getComponentType());
				//if(clazz.getClass().getComponentType())
				Base.class.cast(item).setHandler(this); //TODO: define InstanceCreator for statuses classes
			}
			return null;
			
		} else {
			Base.class.cast(resource).setHandler(this);
			return resource;
		}
	}
}
