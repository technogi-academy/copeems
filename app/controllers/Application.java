package controllers;

import play.*;
import play.cache.Cache;
import play.db.jpa.JPA;
import play.db.jpa.NoTransaction;
import play.db.jpa.Transactional;
import play.libs.Codec;
import play.libs.F.Promise;
import play.libs.WS;
import play.mvc.*;

import java.util.*;

import javax.persistence.EntityTransaction;

import models.*;

public class Application extends Controller {

    public static void index() {
    	
    	Object o = null;
    	
        renderText(o.toString());
    }
	
    public static void index2(String arg) {
    	
    	Usuario u = new Usuario();
    	u.username=arg;
    	u.email=arg+"email";
    	u.save();
    	
        renderText(arg+" - ");
    }
    
    public static void transactions(String username){

    	
    	EntityTransaction et = JPA.em().getTransaction();
    	Usuario u = new Usuario();
    	u.username=username;
    	u.save();
    	
    	u = new Usuario();
    	u.username=username+"2";
    	u.save();
    	et.commit();
    	
    	Usuario u2 = Usuario.findById(9L);
    	renderText(u);
    }
    
    public static void otros(){
    
    	Usuario u = Usuario.findById(12344L);
    	if(u==null){
    		notFound();
    	}
    }
    @Util
    public static void utilMethod(){
    	
    }
	
    public static void login() {
    	
    	Map<String, String> map = session.all();
		Logger.debug("before");

    	Set<String> keys = map.keySet();
    	for(String k:keys){
    		Logger.debug("%s -> %s", k,map.get(k) );
    	}
    	
    	session.put("sec_key", "iljliuj");
    	session.put("sec_key2", "errtt");
    	
    	Logger.debug("after");

    	keys = map.keySet();
    	for(String k:keys){
    		Logger.debug("%s -> %s", k,map.get(k) );
    	}
        renderText("login");
    }

	@Catch(value=NullPointerException.class)
	public static void nullPointerError(NullPointerException npe){
		renderText("Se encontró un error");
	}
	
	@Before(unless={"login"})
	public static void before1(){
		String k = session.get("sec_key");
		if(k==null){
			login();
		}
		
	}
	

}