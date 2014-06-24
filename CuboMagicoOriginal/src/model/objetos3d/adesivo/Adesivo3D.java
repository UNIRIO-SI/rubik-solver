package model.objetos3d.adesivo;

import java.awt.Color;

import org.jgl.GLAUX;

import br.com.abby.GLDrawable;
import br.com.abby.linear.Point3D;

public abstract class Adesivo3D extends Point3D implements GLDrawable {

	protected float angleX = 0;
	
	protected float angleY = 0;
	
	protected float angleZ = 0;
	
	public Adesivo3D(double x, double y, double z) {
		super(x,y,z);
	}

	protected void setColor(GLAUX gl, Color color){
		gl.glColor3i(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	protected void rotate(GLAUX gl){
		
		gl.glTranslated(+1.6, +1.6, +0.6);
		
		gl.glRotated(angleX, 1, 0, 0);
		
		gl.glRotated(angleY, 0, 1, 0);
		
		gl.glRotated(angleZ, 0, 0, 1);
				
		gl.glTranslated(-1.6, -1.6, -0.6);
		
	}

	public float getAngleX() {
		return angleX;
	}

	public void setAngleX(float angleX) {
		this.angleX = angleX;
	}

	public float getAngleY() {
		return angleY;
	}

	public void setAngleY(float angleY) {
		this.angleY = angleY;
	}
	
	public float getAngleZ() {
		return angleZ;
	}

	public void setAngleZ(float angleZ) {
		this.angleZ = angleZ;
	}

}
