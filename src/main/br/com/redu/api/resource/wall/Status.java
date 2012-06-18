package br.com.redu.api.resource.wall;

import java.util.List;

import br.com.redu.api.ReduConf;
import br.com.redu.api.resource.Base;

public abstract class Status extends Base {

	public Status(int id, List<?> links) {
		super(id, links);
	}

	protected String type;

	protected String created_at;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(String createdAt) {
		this.created_at = createdAt;
	}
	
	public static String show(){
		return ReduConf.getInstance().getBaseUrl() + "/api/statuses/%s";
	}
}
