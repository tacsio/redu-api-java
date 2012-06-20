package br.com.redu.api.resource;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.redu.api.resource.user.User;

public class UserJsonTest {

	@Before
	public void setUp() throws Exception {
		Reader json = new InputStreamReader(new FileInputStream("resorce/user.json"));
		List<String> links = new ArrayList<String>();
		
		//User user = new User(4203, );
		
	}

	@Test
	public void renderUser() {
		
	}

}
