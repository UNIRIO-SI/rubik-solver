package view.application;

import org.jgl.GLAUX;

import controller.Timeline;
import view.component.LoadSlotPanel;
import view.component.SaveSlotPanel;
import view.component.ScramblePanel;
import view.component.TimeLinePanel;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.label.ImageLabel;

public abstract class CuboGUIApplication extends GLAUX{

	protected Timeline timeline;
	
	protected TimeLinePanel timelinePanel;
	
	protected ScramblePanel scramblePanel;
	
	protected SaveSlotPanel saveSlotPanel;
	
	protected LoadSlotPanel loadSlotPanel;

	protected Button buttonU;
	protected Button buttonU_;

	protected Button buttonD;
	protected Button buttonD_;

	protected Button buttonR;
	protected Button buttonR_;

	protected Button buttonL;
	protected Button buttonL_;

	protected Button buttonF;
	protected Button buttonF_;

	protected Button buttonB;
	protected Button buttonB_;

	protected Button buttonScramble;
	protected Button buttonSolve;
	
	protected Button buttonSave;
	protected Button buttonLoad;

	public CuboGUIApplication(int w, int h){
		super(w,h);
	}

	protected void carregaBotoes(){

		timeline = new Timeline();
		
		//Painel de Timeline
		timelinePanel = new TimeLinePanel(timeline, this.w, 90);
		add(timelinePanel);

		//Painel de Embaralhar
		scramblePanel = new ScramblePanel(w,h);
		scramblePanel.setVisible(false);
		add(scramblePanel);
		
		//Painel de Salvar
		saveSlotPanel = new SaveSlotPanel(w,h);
		saveSlotPanel.setVisible(false);
		add(saveSlotPanel);
		
		//Painel de Carregar
		loadSlotPanel = new LoadSlotPanel(w,h);
		loadSlotPanel.setVisible(false);
		add(loadSlotPanel);

		int altura = 530;

		buttonU = new Button(10+95*0, altura, 90, 90);
		buttonU.setLabel(new ImageLabel("u.png"));
		add(buttonU);

		buttonU_ = new Button(10+95*0, altura+95, 90, 90);
		buttonU_.setLabel(new ImageLabel("u_.png"));
		add(buttonU_);

		buttonD = new Button(10+95*1, altura+95, 90, 90);
		buttonD.setLabel(new ImageLabel("d.png"));
		add(buttonD);

		buttonD_ = new Button(10+95*1, altura, 90, 90);
		buttonD_.setLabel(new ImageLabel("d_.png"));
		add(buttonD_);

		buttonR = new Button(10+95*2, altura, 90, 90);
		buttonR.setLabel(new ImageLabel("l.png"));
		add(buttonR);

		buttonR_ = new Button(10+95*2, altura+95, 90, 90);
		buttonR_.setLabel(new ImageLabel("l_.png"));
		add(buttonR_);

		buttonL = new Button(10+95*3, altura, 90, 90);
		buttonL.setLabel(new ImageLabel("r.png"));
		add(buttonL);

		buttonL_ = new Button(10+95*3, altura+95, 90, 90);
		buttonL_.setLabel(new ImageLabel("r_.png"));
		add(buttonL_);

		buttonF = new Button(10+95*4, altura, 90, 90);
		buttonF.setLabel(new ImageLabel("f.png"));
		add(buttonF);

		buttonF_ = new Button(10+95*4, altura+95, 90, 90);
		buttonF_.setLabel(new ImageLabel("f_.png"));
		add(buttonF_);

		buttonB = new Button(10+95*5, altura, 90, 90);
		buttonB.setLabel(new ImageLabel("b.png"));
		add(buttonB);

		buttonB_ = new Button(10+95*5, altura+95, 90, 90);
		buttonB_.setLabel(new ImageLabel("b_.png"));
		add(buttonB_);

		buttonSolve = new Button(10+95*6, altura, 90, 90);
		buttonSolve.setLabel(new ImageLabel("solve.png"));
		add(buttonSolve);

		buttonScramble = new Button(10+95*6, altura+95, 90, 90);
		buttonScramble.setLabel(new ImageLabel("scramble.png"));
		add(buttonScramble);
		
		buttonSave = new Button(10+95*7, altura, 90, 90);
		buttonSave.setLabel(new ImageLabel("save.png"));
		add(buttonSave);

		buttonLoad = new Button(10+95*7, altura+95, 90, 90);
		buttonLoad.setLabel(new ImageLabel("load.png"));
		add(buttonLoad);

	}	

}