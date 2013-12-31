package view.component;

import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.GUIComponent;
import br.com.etyllica.gui.Panel;
import br.com.etyllica.gui.label.TextLabel;
import br.com.etyllica.gui.spinner.IntegerSpinner;

public class LoadSlotPanel extends GUIComponent{

	private Button cancelButton;
	
	private Button confirmButton;
	
	private IntegerSpinner spinner;
	
	public LoadSlotPanel(int w, int h){
		super();
		
		//Create Panel
		int panelWidth = 400;
		int panelHeight = 200;
		
		Panel slotPanel = new Panel(w/2-panelWidth/2, h/3-panelHeight/2, panelWidth, panelHeight);
		
		//Create Title
		TextLabel title = new TextLabel(slotPanel.getX()+200,slotPanel.getY()+30,"Você deseja carregar qual slot?");
		
		slotPanel.add(title);
		
		add(slotPanel);
		
		//Create Spinner
		spinner = new IntegerSpinner(slotPanel.getX()+120, slotPanel.getY()+60, 200, 60);
		spinner.setValue(1);
		spinner.setMinValue(1);
		spinner.setMaxValue(5);
		
		add(spinner);
		
		//Create Buttons
		int offsetX = 20;
		
		int buttonY = slotPanel.getY()+slotPanel.getH()-60;
		int buttonW = 120;
		int buttonH = 50;
		
		cancelButton = new Button(slotPanel.getX()+offsetX, buttonY, buttonW, buttonH);
		cancelButton.setLabel(new TextLabel("Cancelar"));
		
		add(cancelButton);
		
		confirmButton = new Button(slotPanel.getX()+slotPanel.getW()-(buttonW+offsetX), buttonY, buttonW, buttonH);
		confirmButton.setLabel(new TextLabel(slotPanel.getX(), slotPanel.getY(), "Confirmar"));
		
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
