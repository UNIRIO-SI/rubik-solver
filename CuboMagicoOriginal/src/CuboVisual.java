

import view.CuboApplication;
import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;

public class CuboVisual extends EtyllicaFrame {

	public CuboVisual() {
		super(800, 768);
	}
	
	public static void main(String[] args){
		CuboVisual cuboVisual = new CuboVisual();
		cuboVisual.init();
	}

	@Override
	public Application startApplication() {

		return new CuboApplication(this.w, this.h);
	}
	
}
