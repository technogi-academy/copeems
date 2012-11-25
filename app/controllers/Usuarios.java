package controllers;

import models.Usuario;
import play.Logger;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.With;
import static play.Logger.debug;

@With({Application.class})
public class Usuarios extends Controller{
	
	public static void get(Long id,String f){
		debug("%s", f);
		if(f.equals("xml"))
			renderXml(Usuario.findById(id));
		else
			renderJSON(Usuario.findById(id));
	}
	
	public static void newUsuario(Usuario u){
	
		u.save();
		renderXml(u);
	}
	
	public static void delete(Long id){
		Usuario u = new Usuario();
		u.id=id;
		renderXml(u.delete());
		
	}

}
