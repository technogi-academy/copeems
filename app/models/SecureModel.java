package models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import play.db.jpa.Model;
import utils.Encrypt;
import static play.Logger.debug;

@MappedSuperclass
public abstract class SecureModel extends Model{
	
	@PrePersist
	public void encryptFields() {
		debug("Entro");
		Field[] fields = this.getClass().getFields();
		for(Field f:fields){
			Annotation[] annotations = f.getAnnotations();
			for(Annotation a:annotations){
				if(a instanceof Encrypt){
					try {
						f.set(this, f.get(this)+"encrypted");
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

}
