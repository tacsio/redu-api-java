package br.com.redu.api.resource;

import java.util.List;

import br.com.redu.api.ReduConf;

public class Base {

	protected final String base_url = ReduConf.getInstance().getBaseUrl();

	protected int id;
	protected List<?> links;

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

}
