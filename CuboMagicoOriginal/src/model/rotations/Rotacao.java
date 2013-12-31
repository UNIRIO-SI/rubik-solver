package model.rotations;

import java.lang.reflect.Method;

import model.cubos.CuboMagico;

public class Rotacao {

	private String abreviacao;
	
	private Method metodo;
	
	public Rotacao(String abreviacao, String metodo){
		super();
		
		this.abreviacao = abreviacao;
		
		try {
			this.metodo = Rotations.class.getMethod(metodo, CuboMagico.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public Method getMetodo() {
		return metodo;
	}

	public void setMetodo(Method metodo) {
		this.metodo = metodo;
	}
	
}
