package model.objetos3d.adesivo;

import org.jgl.GL;
import org.jgl.GLAUX;

public class AdesivoFrente extends Adesivo3D{

	public AdesivoFrente(double x, double y, double z) {
		super(x,y,z);
	}

	@Override
	public void draw(GLAUX gl) {
		
		setColor(gl, color);
		
		gl.glPushMatrix();
		
		rotate(gl);
		
		gl.glBegin(GL.GL_QUADS);
		
		gl.glVertex3d(x+0.0, y+0.0, 0.0+z);
		gl.glVertex3d(x+1.0, y+0.0, 0.0+z);
		gl.glVertex3d(x+1.0, y+1.0, 0.0+z);
		gl.glVertex3d(x+0.0, y+1.0, 0.0+z);
		
		gl.glEnd();
		
		gl.glPopMatrix();
		
	}
		
}
