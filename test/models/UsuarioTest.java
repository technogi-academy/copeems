package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class UsuarioTest extends UnitTest{

	@Before
	public void setUp(){
		
		Fixtures.loadModels("data.yml");	
	}
	
	@After
	public void tearDown(){
		Fixtures.deleteDatabase();
		//Usuario.deleteAll();
	}
	
	
	@Test
	public void testLogin(){
		
		//Probar nulos
		assertFalse("Probar nulos",Usuario.login(null, null));
		//Probar password nulo
		assertFalse("Probar password nulos",Usuario.login("usuario1", null));
		//Probar user nulo
		assertFalse("Probar user nulos",Usuario.login(null, ""));
		//Probar usuario correcto, password incorrecto
		assertFalse(Usuario.login("usuario1", "t@e.com"));
		//Probar login correcto
		assertTrue("Login correcto",Usuario.login("usuario1", "p@ss.com"));
		
		
	}
	
	@Test
	public void testFormat(){
		Usuario u = Usuario.find("byUsername", "usuario1").first();
		assertEquals("Correcto", u.username+"-"+u.email,u.getFormatted());
		assertNotSame("Incorrecto", u.username+"."+u.email,u.getFormatted());

	}
}
