package br.com.redu.api.resource.user;

import java.util.List;

import br.com.redu.api.ReduConf;
import br.com.redu.api.resource.Base;

public class User extends Base {

	private String first_name;
	private String last_name;
	private String birthday;
	private String login;
	private int friends_count;
	private String email;
	private String birth_localization;
	private String mobile;
	private String localization;

	public User(int id, List<?> links, String first_name, String last_name,
			String birthday, String login, int friends_count, String email,
			String birth_localization, String mobile, String localization) {
		super(id, links);
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.login = login;
		this.friends_count = friends_count;
		this.email = email;
		this.birth_localization = birth_localization;
		this.mobile = mobile;
		this.localization = localization;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBirthLocalization() {
		return birth_localization;
	}

	public void setBirthLocalization(String birth_localization) {
		this.birth_localization = birth_localization;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getFriendsCount() {
		return friends_count;
	}

	public void setFriendsCount(int friendsCount) {
		this.friends_count = friendsCount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String me() {
		return ReduConf.getInstance().getBaseUrl() + "/me";
	}

	public static String show() {
		return ReduConf.getInstance().getBaseUrl() + "/api/users/%s";
	}

}
