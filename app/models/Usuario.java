package models;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.db.jpa.Model;
import utils.Encrypt;

@Entity
public class Usuario extends SecureModel{

	@Encrypt
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
	
}
