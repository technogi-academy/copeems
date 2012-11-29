package controllers;

import java.util.List;
import java.util.Properties;

import models.Usuario;
import play.Logger;
import play.data.validation.Valid;
import play.i18n.Lang;
import play.mvc.Controller;

public class ViewController extends Controller{
	
	public static void index(){
		
		
		Usuario u = new Usuario();
		List<Usuario> usuarios = Usuario.findAll();
		u.username = "Carlos";
		render(u,usuarios);
	}
	
	public static void form(){
		
		render();
	}
	
	public static void myFormw(Usuario u){
		checkAuthenticity();
		renderText("OK");
	}
	
	public static void printToConsole(){
		Logger.debug("Mensaje debug ");
		
		Logger.info("Mensaje info ");
		Logger.warn("Mensaje de warning");
		Logger.error("Mensaje de error");
		Logger.fatal("Mensaje fatal");
		renderText("OK");

	}
}
