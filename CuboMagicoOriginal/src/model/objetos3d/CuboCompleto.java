package model.objetos3d;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.cubos.Cor;
import model.cubos.CuboMagico3x3x3;
import model.objetos3d.adesivo.Adesivo3D;
import model.objetos3d.adesivo.AdesivoBaixo;
import model.objetos3d.adesivo.AdesivoCima;
import model.objetos3d.adesivo.AdesivoDireita;
import model.objetos3d.adesivo.AdesivoEsquerda;
import model.objetos3d.adesivo.AdesivoFrente;
import model.objetos3d.adesivo.AdesivoTras;
import model.rotations.RotationsImpl;

import org.jgl.GLAUX;

import br.com.etyllica.util.SVGColor;
import br.com.luvia.GLDrawable;

public class CuboCompleto extends CuboAnimado implements GLDrawable{

	private final float SIZE = 0.2f;

	private CuboMagico3x3x3 cuboMagico;
	
	private RotationsImpl rotation;
	
	private List<CuboCompletoListener> listeners;
	
	public CuboCompleto(CuboMagico3x3x3 cuboMagico){
		super();
		
		this.listeners = new ArrayList<CuboCompletoListener>();

		this.cuboMagico = cuboMagico;
		
		rotation = new RotationsImpl();

		criaFaces();

		coloreCubo();

	}

	private void criaFaces(){

		criaFaceFrente();

		criaFaceDireita();

		criaFaceTras();

		criaFaceEsquerda();

		criaFaceCima();

		criaFaceBaixo();
	}

	private void criaFaceFrente(){
		//Azul
		int i = 0;

		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				Adesivo3D ad = new AdesivoFrente((1.0f+SPACING)*k, (1.0f+SPACING)*j, (1.0f+SPACING)*2);
				adesivos[i][j][k] = ad;			
			}
		}
	}

	private void criaFaceTras(){
		//Verde
		int i = 2;

		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				Adesivo3D ad = new AdesivoTras((1.0f+SPACING)*(2-k), (1.0f+SPACING)*j, (1.0f+SPACING)*0);
				adesivos[i][j][k] = ad;		
			}
		}
	}

	private void criaFaceDireita(){
		//Vermelho
		int i = 1;

		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				Adesivo3D ad = new AdesivoDireita((1.0f+SPACING)*2, (1.0f+SPACING)*(j), (1.0f+SPACING)*(2-k));
				adesivos[i][j][k] = ad;
			}
		}
	}

	private void criaFaceEsquerda(){
		//Laranja
		int i = 3;

		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				Adesivo3D ad = new AdesivoEsquerda((1.0f+SPACING)*0, (1.0f+SPACING)*(j), (1.0f+SPACING)*(k));
				adesivos[i][j][k] = ad;
			}
		}
	}

	private void criaFaceCima(){
		//Amarela
		int i = 4;

		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				Adesivo3D ad = new AdesivoBaixo((1.0f+SPACING)*k, (1.0f+SPACING)*0, (1.0f+SPACING)*(j));
				adesivos[i][j][k] = ad;
			}
		}
	}

	private void criaFaceBaixo(){				
		//Branca
		int i = 5;

		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){

				Adesivo3D ad = new AdesivoCima((1.0f+SPACING)*(k), (1.0f+SPACING)*2, (1.0f+SPACING)*(2-j));
				adesivos[i][j][k] = ad;
			}
		}

	}

	public void coloreCubo(){

		for(int i=0;i<6;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					adesivos[i][j][k].setColor(convertColor(cuboMagico.getCubo()[i][j][k].getCor()));
				}
			}
		}

	}

	public void giraR(){
		if(podeGirar()){
			giraDireita(1);
			rotation.girarDireitaSentidoHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraR();
			}
		}
	}

	public void giraR_(){
		if(podeGirar()){
			giraDireita(-1);
			rotation.girarDireitaSentidoAntiHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraR_();
			}
		}
	}

	public void giraL(){
		if(podeGirar()){
			giraEsquerda(-1);
			rotation.girarEsquerdaSentidoHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraL();
			}
		}
	}

	public void giraL_(){
		if(podeGirar()){
			giraEsquerda(1);
			rotation.girarEsquerdaSentidoAntiHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraL_();
			}
		}
	}

	public void giraU(){		
		if(podeGirar()){
			giraCima(-1);
			rotation.girarCimaSentidoHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraU();
			}
		}		
	}

	public void giraU_(){
		if(podeGirar()){
			giraCima(1);
			rotation.girarCimaSentidoAntiHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraU_();
			}
		}
	}

	public void giraD(){
		if(podeGirar()){
			giraBaixo(1);
			rotation.girarBaseSentidoHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraD();
			}
		}
	}

	public void giraD_(){
		if(podeGirar()){
			giraBaixo(-1);
			rotation.girarBaseSentidoAntiHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraD_();
			}
		}
	}

	public void giraB(){
		if(podeGirar()){
			giraTras(-1);
			rotation.girarAtrasSentidoHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraB();
			}
		}
	}

	public void giraB_(){
		if(podeGirar()){
			giraTras(1);
			rotation.girarAtrasSentidoAntiHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraB_();
			}
		}
	}

	public void giraF(){
		if(podeGirar()){
			giraFrente(1);
			rotation.girarFrenteSentidoHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraF();
			}
		}
	}

	public void giraF_(){
		if(podeGirar()){
			giraFrente(-1);
			rotation.girarFrenteSentidoAntiHorario(cuboMagico);
			
			for(CuboCompletoListener listener: listeners){
				listener.giraF_();
			}
		}
	}
	
	private boolean podeGirar(){
		
		if(!animado){
			
			animado = true;
			return animado;
			
		}else{
			
			return !animado;	
		}		
		
	}

	private Color convertColor(Cor cor){

		Map<Cor, Color> cores = new HashMap<Cor, Color>();

		cores.put(Cor.AMARELO, SVGColor.YELLOW);
		cores.put(Cor.AZUL, SVGColor.BLUE);
		cores.put(Cor.BRANCO, SVGColor.WHITE);
		cores.put(Cor.LARANJA, SVGColor.ORANGE);
		cores.put(Cor.VERDE, SVGColor.GREEN);
		cores.put(Cor.VERMELHO, SVGColor.RED);

		return cores.get(cor);

	}

	@Override
	public void draw(GLAUX gl) {

		gl.glColor3f(0, 0, 0);

		gl.glScaled(SIZE, SIZE, SIZE);

		for(int i=0;i<6;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					adesivos[i][j][k].draw(gl);
				}
			}
		}
	}
	
	public void resolve(String rotacao){
		
		Method metodo;
		
		try {
			
			metodo = this.getClass().getMethod("gira"+rotacao, null);
			
			metodo.invoke(this, null);
			
			for(CuboCompletoListener listener: listeners){
				listener.removeLastRotation();
			}			
			
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
	
	public void addListener(CuboCompletoListener listener){
		listeners.add(listener);
	}

}
