package view.component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.objetos3d.CuboCompletoListener;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.gui.Panel;
import br.com.etyllica.gui.View;
import br.com.etyllica.gui.label.ImageLabel;
import controller.Timeline;

public class TimeLinePanel extends View implements CuboCompletoListener{
		
	private List<ImageLabel> buttons;
	
	private Panel panel;
		
	private int utilWidth = 0;
	
	private int buttonSize = 90;
	
	private int cursorX = 0;
	
	private Map<String, String> rotationImage;
	
	private Timeline timeline;
	
	public TimeLinePanel(Timeline timeline, int w, int h){
		super(w,h);
		
		this.timeline = timeline;
				
		buttons = new ArrayList<ImageLabel>();
				
		rotationImage = new HashMap<String, String>();
		
		rotationImage.put("D", "d.png");
		rotationImage.put("D_", "d_.png");
		
		rotationImage.put("U", "u.png");
		rotationImage.put("U_", "u_.png");
		
		rotationImage.put("L", "l.png");
		rotationImage.put("L_", "l_.png");
		
		rotationImage.put("R", "r.png");
		rotationImage.put("R_", "r_.png");
		
		rotationImage.put("F", "f.png");
		rotationImage.put("F_", "f_.png");
		
		rotationImage.put("B", "b.png");
		rotationImage.put("B_", "b_.png");
				
		//Create Panel
		panel = new Panel(0,20,w,h);
				
	}
	
	public void removeLastRotation(){
		
		//Remove a rotação invertida criada apenas para gerar a animação
		removeLastImage();
		
		//Remove a verdadeira última rotação
		removeLastImage();
		
		resetButtons();
		
	}
		
	private void removeLastImage(){
		
		timeline.removeLastRotation();
		
		buttons.remove(buttons.get(buttons.size()-1));
				
	}
	
	public void clearRotations(){
		
		timeline.getRotations().clear();
		
		buttons.clear();
		
		resetButtons();
		
	}
	
	public void resetButtons(){

		utilWidth = buttons.size()*buttonSize;
		
		int offset = 0;
		
		if(utilWidth>panel.getW()){
			offset = panel.getW()-utilWidth;
		}
		
		int offsetX = 0;
		
		for(int i = 0;i<buttons.size();i++){
			
			offsetX = offset+buttonSize*i;
			
			buttons.get(i).setX(offsetX);
			buttons.get(i).setY(panel.getY());
		}
				
		cursorX = buttonSize/2+offsetX;
		
	}
	
	public void addRotation(String rotation){
		
		timeline.addRotation(rotation);
		
		buttons.add(new ImageLabel(rotationImage.get(rotation)));
				
		resetButtons();
	}
	
	@Override
	public void giraU() {
		addRotation("U");
	}
	
	@Override
	public void giraU_() {
		addRotation("U_");
	}

	@Override
	public void giraD() {
		addRotation("D");		
	}
	
	@Override
	public void giraD_() {
		addRotation("D_");		
	}
	
	@Override
	public void giraB() {
		addRotation("B");		
	}
	
	@Override
	public void giraB_() {
		addRotation("B_");		
	}

	@Override
	public void giraR() {
		addRotation("R");		
	}
	
	@Override
	public void giraR_() {
		addRotation("R_");		
	}

	@Override
	public void giraL() {
		addRotation("L");
	}
	
	@Override
	public void giraL_() {
		addRotation("L_");
	}

	@Override
	public void giraF() {
		addRotation("F");
	}
	
	@Override
	public void giraF_() {
		addRotation("F_");
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
	public GUIEvent updateMouse(PointerEvent event) {
				
		return null;
	}
		
	@Override
	public void draw(Graphic g){

		g.setAlpha(100);
		
		panel.draw(g);
		
		drawRotations(g);
		
		drawCursor(g);
				
	}
	
	private void drawRotations(Graphic g){

		for(ImageLabel image: buttons){
			image.draw(g);
		}
		
	}
	
	private void drawCursor(Graphic g){
		
		g.setAlpha(80);
		
		g.setColor(Color.BLACK);
		g.fillCircle(cursorX, 100, 8);
		
		g.setColor(Color.WHITE);
		g.fillCircle(cursorX, 100, 5);
		
	}
	
}
