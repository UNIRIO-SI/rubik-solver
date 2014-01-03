

import view.CuboApplication;
import br.com.etyllica.EtyllicaFrame;

public class CuboVisual extends EtyllicaFrame{

	public CuboVisual() {
		super(800, 768);
	}
	
	public static void main(String[] args){
		CuboVisual cuboVisual = new CuboVisual();
		cuboVisual.init();
	}

	@Override
	public void startGame() {
		
		setMainApplication(new CuboApplication(this.w, this.h));
		
	}
	
}
