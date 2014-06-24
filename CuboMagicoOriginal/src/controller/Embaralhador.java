package controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.cubos.CuboMagico;
import model.rotations.Rotacao;
import model.rotations.Rotations;
import model.rotations.RotationsImpl;
import view.component.TimeLinePanel;

public class Embaralhador {

	private TimeLinePanel timelinePanel;

	private List<String> rot = new ArrayList<String>();

	private Map<Integer, Rotacao> rotacoesAbreviacao = new HashMap<Integer, Rotacao>();

	private Map<String, Method> metodosPorAbreviacao = new HashMap<String, Method>();

	public Embaralhador(TimeLinePanel timelinePanel) {
		super();

		this.timelinePanel = timelinePanel;

		int index = 0;

		addRotacao(index++, "U", "girarCimaSentidoHorario");
		addRotacao(index++, "U_", "girarCimaSentidoAntiHorario");
		addRotacao(index++, "D", "girarBaseSentidoHorario");
		addRotacao(index++, "D_", "girarBaseSentidoAntiHorario");

		addRotacao(index++, "F", "girarFrenteSentidoHorario");
		addRotacao(index++, "F_", "girarFrenteSentidoAntiHorario");
		addRotacao(index++, "B", "girarAtrasSentidoHorario");
		addRotacao(index++, "B_", "girarAtrasSentidoAntiHorario");

		addRotacao(index++, "R", "girarDireitaSentidoHorario");
		addRotacao(index++, "R_", "girarDireitaSentidoAntiHorario");
		addRotacao(index++, "L", "girarEsquerdaSentidoHorario");
		addRotacao(index++, "L_", "girarEsquerdaSentidoAntiHorario");

	}	

	public void embaralha(CuboMagico cubo, int passos) {

		for(int i=0;i<passos;i++) {

			rotacionaAleatorio(cubo);

		}

	}

	private void rotacionaAleatorio(CuboMagico cubo) {

		Random random = new Random();

		Rotations rotacao = new RotationsImpl();

		int numero = random.nextInt(rotacoesAbreviacao.size());

		if(rotacoesAbreviacao.get(numero)==null) {
			System.out.println(numero +" is null.");
		}
		
		Method metodo = rotacoesAbreviacao.get(numero).getMetodo();
				
		String rotationName = rotacoesAbreviacao.get(numero).getAbreviacao();

		timelinePanel.addRotation(rotationName);

		rot.add(rotationName+" ");

		try {

			metodo.invoke(rotacao, cubo);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addRotacao(int index, String abreviacao, String nomeMetodo) {
		
		Rotacao rotacao = new Rotacao(abreviacao, nomeMetodo);
		
		rotacoesAbreviacao.put(index, rotacao);
		metodosPorAbreviacao.put(abreviacao, rotacao.getMetodo());

	}
	
	public Method getMetodo(String abreviacao) {
		return metodosPorAbreviacao.get(abreviacao);
	}

}
