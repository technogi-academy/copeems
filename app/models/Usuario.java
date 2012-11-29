package models;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.db.jpa.Model;
import utils.Encrypt;

@Entity
public class Usuario extends SecureModel{

	
	public String username;
	@Email(message="Pon_un_correo_valido")
	public String email;
	
	@Override
	public String toString() {
		return "Usuario [username=" + username + ", email=" + email + "]";
	}
	
	@PrePersist
	public void encrypt(){
		
	}
	
	public String getFormatted(){
		return this.username+"-"+this.email;
	}
	
	public static boolean login(String username, String password){
		
		Usuario u = Usuario.find("byUsername", username).first();
		if(u==null)return false;
		if(u.email.equals(password))
			return true;
		return false;
		
	}
}
