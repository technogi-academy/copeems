package controllers;

import org.junit.Test;

import play.mvc.Http.Response;
import play.mvc.Router;
import play.test.FunctionalTest;

public class EstadosTest extends FunctionalTest {

	@Test
	public void testGetEstados(){
		Response resp = GET(Router.getFullUrl("getEstados"));
		
	}
}
