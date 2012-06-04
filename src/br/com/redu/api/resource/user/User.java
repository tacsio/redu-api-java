package br.com.redu.api.resource.user;

import br.com.redu.api.ReduConf;
import br.com.redu.api.resource.Base;

public class User extends Base {

	public static String me() {
		return ReduConf.getInstance().getBaseUrl() + "/me";
	}

}
