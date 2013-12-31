package view.component;

import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.Panel;
import br.com.etyllica.gui.View;
import br.com.etyllica.gui.label.TextLabel;
import br.com.etyllica.gui.spinner.IntegerSpinner;

public class ScramblePanel extends View{

	private Button cancelButton;
	
	private Button confirmButton;
	
	private IntegerSpinner spinner;
	
	public ScramblePanel(int w, int h){
		super();
		
		//Create Panel
		int panelWidth = 400;
		int panelHeight = 200;
		
		Panel scramblePanel = new Panel(w/2-panelWidth/2, h/3-panelHeight/2, panelWidth, panelHeight);
		
		//Create Title
		TextLabel title = new TextLabel(scramblePanel.getX()+200,scramblePanel.getY()+30,"Você deseja embaralhar com quantos passos?");
		
		scramblePanel.add(title);
		
		add(scramblePanel);
		
		//Create Spinner
		spinner = new IntegerSpinner(scramblePanel.getX()+120, scramblePanel.getY()+60, 200, 60);
		spinner.setMaxValue(100);
		
		add(spinner);
		
		//Create Buttons
		int offsetX = 20;
		
		int buttonY = scramblePanel.getY()+scramblePanel.getH()-60;
		int buttonW = 120;
		int buttonH = 50;
		
		cancelButton = new Button(scramblePanel.getX()+offsetX, buttonY, buttonW, buttonH);
		cancelButton.setLabel(new TextLabel("Cancelar"));
		
		add(cancelButton);
		
		confirmButton = new Button(scramblePanel.getX()+scramblePanel.getW()-(buttonW+offsetX), buttonY, buttonW, buttonH);
		confirmButton.setLabel(new TextLabel(scramblePanel.getX(), scramblePanel.getY(), "Confirmar"));
		
		add(confirmButton);
		
	}
	
	
	@Override
	public void update(GUIEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	public Button getCancelButton() {
		return cancelButton;
	}


	public Button getConfirmButton() {
		return confirmButton;
	}


	public IntegerSpinner getSpinner() {
		return spinner;
	}
	
}
