package br.com.redu.api.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.redu.api.ReduConf;

public class Base {

	protected final String base_url = ReduConf.getInstance().getBaseUrl();

	protected int id;
	protected List<?> links;
	protected Map<String, String> resourceLinks;

	public Base(int id, List<?> links) {
		this.id = id;
		this.links = links;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<?> getLinks() {
		return links;
	}

	public void setLinks(List<?> links) {
		this.links = links;
	}
	
	public Object getLink(String key) {
		if(null == this.resourceLinks){
			this.processLinks();
		}
		return this.resourceLinks.get(key);
	}

	@SuppressWarnings("unchecked")
	private void processLinks() {
		this.resourceLinks = new HashMap<String, String>();
		for (Object i : this.links) {
			String key = ((Map<String, String>) i).get("rel");
			String value = ((Map<String, String>) i).get("href");
			this.resourceLinks.put(key, value);
		}
	}

}
