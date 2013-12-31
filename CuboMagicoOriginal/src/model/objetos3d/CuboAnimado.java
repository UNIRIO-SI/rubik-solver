package model.objetos3d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import model.objetos3d.adesivo.Adesivo3D;

public abstract class CuboAnimado {
	
	protected final float SPACING = 0.1f;
	
	protected int velocidadeRotacao = 1;
	
	protected boolean animado = false;

	protected Adesivo3D[][][] adesivos;

	private int anguloB = 0;
	
	private int anguloF = 0;	

	private int anguloD = 0;

	private int anguloU = 0;

	private int anguloR = 0;

	private int anguloL = 0;

	public CuboAnimado(){
		super();

		adesivos = new Adesivo3D[6][3][3];

	}

	public abstract void coloreCubo();
	
	public void anima(){

		try {
			
			animaB();
			
			animaF();

			animaD();

			animaR();

			animaL();

			animaU();
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private void animaRotacao(int angulo, String metodo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		if(angulo>0){

			if(angulo<90){
				angulo+=velocidadeRotacao;
			}else{
				angulo = 0;
				coloreCubo();
				animado = false;
			}

			Method method = this.getClass().getMethod(metodo, int.class);
			method.invoke(this, angulo);
			
		}else if(angulo<0){

			if(angulo>-90){
				angulo-=velocidadeRotacao;
			}else{
				angulo = 0;
				coloreCubo();
				animado = false;
			}

			Method method = this.getClass().getMethod(metodo, int.class);
			method.invoke(this, angulo);

		}
		
	}

	private void animaD() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		animaRotacao(anguloD, "giraBaixo");
		
	}

	private void animaR() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		animaRotacao(anguloR, "giraDireita");
		
	}

	private void animaL() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		animaRotacao(anguloL, "giraEsquerda");
		
	}

	private void animaU() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		animaRotacao(anguloU, "giraCima");
		
	}

	private void animaF() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		animaRotacao(anguloF, "giraFrente");
		
	}
	
	private void animaB() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		animaRotacao(anguloB, "giraTras");
		
	}
	
	private void giraFace(int i, int anguloX, int anguloY, int anguloZ){
		
		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				adesivos[i][j][k].setAngleX(anguloX);
				adesivos[i][j][k].setAngleY(anguloY);
				adesivos[i][j][k].setAngleZ(anguloZ);
			}
		}
		
	}
	
	public void giraBaixo(int angulo){

		giraFace(5, 0, angulo, 0);
		
		//Azul
		adesivos[0][2][0].setAngleY(angulo);
		adesivos[0][2][1].setAngleY(angulo);
		adesivos[0][2][2].setAngleY(angulo);

		//Verde
		adesivos[2][2][0].setAngleY(angulo);
		adesivos[2][2][1].setAngleY(angulo);
		adesivos[2][2][2].setAngleY(angulo);

		//Laranja
		adesivos[3][2][0].setAngleY(angulo);
		adesivos[3][2][1].setAngleY(angulo);
		adesivos[3][2][2].setAngleY(angulo);

		//Vermelho
		adesivos[1][2][0].setAngleY(angulo);
		adesivos[1][2][1].setAngleY(angulo);
		adesivos[1][2][2].setAngleY(angulo);

		anguloD = angulo;

	}

	public void giraCima(int angulo){

		giraFace(4, 0, angulo, 0);

		//Azul
		adesivos[0][0][0].setAngleY(angulo);
		adesivos[0][0][1].setAngleY(angulo);
		adesivos[0][0][2].setAngleY(angulo);

		//Verde
		adesivos[2][0][0].setAngleY(angulo);
		adesivos[2][0][1].setAngleY(angulo);
		adesivos[2][0][2].setAngleY(angulo);

		//Laranja
		adesivos[3][0][0].setAngleY(angulo);
		adesivos[3][0][1].setAngleY(angulo);
		adesivos[3][0][2].setAngleY(angulo);

		//Vermelho
		adesivos[1][0][0].setAngleY(angulo);
		adesivos[1][0][1].setAngleY(angulo);
		adesivos[1][0][2].setAngleY(angulo);

		anguloU = angulo;

	}
	
	public void giraDireita(int angulo){

		giraFace(1, angulo, 0, 0);
		
		//Azuis
		adesivos[0][0][2].setAngleX(angulo);
		adesivos[0][1][2].setAngleX(angulo);
		adesivos[0][2][2].setAngleX(angulo);

		//Verdes
		adesivos[2][0][0].setAngleX(angulo);
		adesivos[2][1][0].setAngleX(angulo);
		adesivos[2][2][0].setAngleX(angulo);

		//Amarela
		adesivos[4][0][2].setAngleX(angulo);
		adesivos[4][1][2].setAngleX(angulo);
		adesivos[4][2][2].setAngleX(angulo);

		//Branca
		adesivos[5][0][2].setAngleX(angulo);
		adesivos[5][1][2].setAngleX(angulo);
		adesivos[5][2][2].setAngleX(angulo);

		anguloR = angulo;

	}

	public void giraEsquerda(int angulo){

		giraFace(3, angulo, 0, 0);

		//Azuis
		adesivos[0][0][0].setAngleX(angulo);
		adesivos[0][1][0].setAngleX(angulo);
		adesivos[0][2][0].setAngleX(angulo);

		//Verdes
		adesivos[2][0][2].setAngleX(angulo);
		adesivos[2][1][2].setAngleX(angulo);
		adesivos[2][2][2].setAngleX(angulo);

		//Amarela
		adesivos[4][0][0].setAngleX(angulo);
		adesivos[4][1][0].setAngleX(angulo);
		adesivos[4][2][0].setAngleX(angulo);

		//Branca
		adesivos[5][0][0].setAngleX(angulo);
		adesivos[5][1][0].setAngleX(angulo);
		adesivos[5][2][0].setAngleX(angulo);

		anguloL = angulo;

	}

	public void giraFrente(int angulo){

		giraFace(0, 0, 0, angulo);

		//Vermelho
		adesivos[1][0][0].setAngleZ(angulo);
		adesivos[1][1][0].setAngleZ(angulo);
		adesivos[1][2][0].setAngleZ(angulo);

		//Laranja
		adesivos[3][0][2].setAngleZ(angulo);
		adesivos[3][1][2].setAngleZ(angulo);
		adesivos[3][2][2].setAngleZ(angulo);

		//Amarela
		adesivos[4][2][0].setAngleZ(angulo);
		adesivos[4][2][1].setAngleZ(angulo);
		adesivos[4][2][2].setAngleZ(angulo);
		
		//Branca
		adesivos[5][0][0].setAngleZ(angulo);
		adesivos[5][0][1].setAngleZ(angulo);
		adesivos[5][0][2].setAngleZ(angulo);


		anguloF = angulo;

	}
	
	public void giraTras(int angulo){

		giraFace(2, 0, 0, angulo);

		//Vermelho
		adesivos[1][0][2].setAngleZ(angulo);
		adesivos[1][1][2].setAngleZ(angulo);
		adesivos[1][2][2].setAngleZ(angulo);

		//Laranja
		adesivos[3][0][0].setAngleZ(angulo);
		adesivos[3][1][0].setAngleZ(angulo);
		adesivos[3][2][0].setAngleZ(angulo);

		//Amarela
		adesivos[4][0][0].setAngleZ(angulo);
		adesivos[4][0][1].setAngleZ(angulo);
		adesivos[4][0][2].setAngleZ(angulo);
		
		//Branca
		adesivos[5][2][0].setAngleZ(angulo);
		adesivos[5][2][1].setAngleZ(angulo);
		adesivos[5][2][2].setAngleZ(angulo);


		anguloB = angulo;

	}

	public boolean isAnimado() {
		return animado;
	}	

}
