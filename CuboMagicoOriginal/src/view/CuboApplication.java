package view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import model.Resolucao;
import model.cubos.CuboMagico;
import model.cubos.CuboMagico3x3x3;
import model.objetos3d.CuboCompleto;
import model.rotations.Rotations;
import model.rotations.RotationsImpl;
import view.application.CuboGUIApplication;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;

import com.j256.ormlite.dao.Dao;

import controller.Embaralhador;
import database.BancoDeDados;

public class CuboApplication extends CuboGUIApplication {

	private BancoDeDados bd;

	private Embaralhador embaralhador;

	private CuboMagico cuboMagico;

	private CuboCompleto cubo;

	private int angleX = 0;

	private int angleY = 0;

	private Rotations rotacao = new RotationsImpl();

	public CuboApplication(int w, int h) {
		super(w, h);
	}

	@Override
	public void draw(Graphic g) {

		glClearColor(0.9f, 0.9f, 1.0f, 0.0f);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-1.0f, 1.0f, -1.0f, 1.0f, -10.0f, 10.0f);

		glPushMatrix();
		glTranslated(0.1,0.5,0);
		glRotated(angleX, 1, 0, 0);
		glRotated(angleY, 0, 1, 0);

		cubo.draw(this);
		glPopMatrix();

		glFlush(g);

	}

	@Override
	public void load() {

		loading = 30;

		loadingPhrase = "Carregando o Cubo";
		inicializaCubo();

		loading = 60;
		loadingPhrase = "Configurando a Cena";
		glEnable(GL_DEPTH_TEST);

		loading = 70;
		loadingPhrase = "Carregando a Interface";
		carregaBotoes();

		defineAcoesBotoes();

		buttonSolve.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "resolve"));

		buttonSave.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "mostraPainelSalvar"));
		saveSlotPanel.getCancelButton().addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "escondePainelSalvar"));
		saveSlotPanel.getConfirmButton().addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "salva"));

		buttonLoad.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "mostraPainelCarregar"));
		loadSlotPanel.getCancelButton().addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "escondePainelCarregar"));
		loadSlotPanel.getConfirmButton().addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "carrega"));

		buttonScramble.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "mostraPainel"));

		scramblePanel.getCancelButton().addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "escondePainel"));

		scramblePanel.getConfirmButton().addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "embaralha"));

		cubo.addListener(timelinePanel);

		loadingPhrase = "Carregando o Embaralhador";
		loading = 80;		
		embaralhador = new Embaralhador(timelinePanel);

		loadingPhrase = "Carregando Banco de Dados";
		loading = 90;
		bd = new BancoDeDados();

		updateAtFixedRate(1);

		loading = 100;

	}

	@Override
	public void timeUpdate(long now){

		cubo.anima();

	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {

		int mouseY = event.getY();

		int mouseX = event.getX();				

		angleX = 135+((mouseY*90)/h);

		angleY = 260-((mouseX*200)/w);

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		return null;
	}

	public void mostraPainelSalvar(){
		saveSlotPanel.setVisible(true);
	}

	public void escondePainelSalvar(){
		saveSlotPanel.setVisible(false);
	}

	public void mostraPainelCarregar(){
		loadSlotPanel.setVisible(true);
	}

	public void escondePainelCarregar(){
		loadSlotPanel.setVisible(false);
	}

	public void mostraPainel(){
		scramblePanel.setVisible(true);
	}

	public void escondePainel(){
		scramblePanel.setVisible(false);
	}

	public void resolve(){

		//Trava para resolução
		if(!cubo.isAnimado()&&timeline.getRotations().size()>0){

			String solveRotation = timeline.getInvertedRotation(timeline.getLastRotation());

			cubo.resolve(solveRotation);

		}

	}

	public void embaralha(){

		int passos = scramblePanel.getSpinner().getValue();

		embaralhador.embaralha(cuboMagico, passos);

		cubo.coloreCubo();

		escondePainel();
	}

	public void salva(){

		try {

			Dao<Resolucao, Integer> dao = bd.getResolucaoDao();

			Resolucao res = dao.queryForId(saveSlotPanel.getSpinner().getValue());

			res.setPassos(timeline.getRotations());

			dao.update(res);

			timeline.toString();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		escondePainelSalvar();

	}

	private void inicializaCubo(){

		cuboMagico = new CuboMagico3x3x3();

		cubo = new CuboCompleto((CuboMagico3x3x3)cuboMagico);

	}

	public void carrega(){

		escondePainelCarregar();

		inicializaCubo();

		cubo.addListener(timelinePanel);

		timelinePanel.clearRotations();

		defineAcoesBotoes();

		Dao<Resolucao, Integer> dao = bd.getResolucaoDao();

		try {

			Resolucao res = dao.queryForId(loadSlotPanel.getSpinner().getValue());

			if(!res.getPassos().isEmpty()){

				String[] rotations = res.getPassos().split("\\s");

				for(String rotation: rotations){

					Method metodo = embaralhador.getMetodo(rotation);

					try {
						metodo.invoke(rotacao, cuboMagico);
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

					timelinePanel.addRotation(rotation);

				}

				cubo.coloreCubo();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void defineAcoesBotoes(){

		buttonU.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraU"));
		buttonU_.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraU_"));

		buttonD.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraD_"));
		buttonD_.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraD"));

		buttonL.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraL_"));
		buttonL_.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraL"));

		buttonR.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraR"));
		buttonR_.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraR_"));

		//OpenGL usa orientação anti-horária para rotação  
		buttonF.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraF_"));
		buttonF_.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraF"));

		buttonB.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraB"));
		buttonB_.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(cubo, "giraB_"));

	}

}