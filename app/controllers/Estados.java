package controllers;

import java.util.LinkedList;
import java.util.List;

import play.mvc.Controller;

public class Estados extends Controller {

	public static void getEstados(Long paisId){
		List<Estado> estados = new LinkedList<Estados.Estado>();
		estados.add(new Estado(1L,"Mexico"));
		estados.add(new Estado(2L,"Nuevo Leon"));
		estados.add(new Estado(3L,"Yucatan"));
		estados.add(new Estado(4L,"Aguascalientes"));
		renderJSON(new EstadoWrapper(estados, "codigo"));
	}
	
	public static class Estado{
		public Long id;
		public String name;
		public Estado(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		
	}
	
	public static class EstadoWrapper{
		public final List<Estado> estdos;
		public final String code;
		public EstadoWrapper(List<Estado> estdos, String code) {
			super();
			this.estdos = estdos;
			this.code = code;
		}
		
	}
}
