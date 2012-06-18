package br.com.redu.api.resource.wall;

import java.util.List;

public class Activity extends Status {

	public Activity(int id, List<?> links) {
		super(id, links);
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
