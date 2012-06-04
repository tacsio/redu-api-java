package br.com.redu.api.resource;

import java.util.List;

import br.com.redu.api.ReduConf;

public class Base {

	protected final String base_url = ReduConf.getInstance().getBaseUrl();

	protected int id;
	protected List<?> links;

}
