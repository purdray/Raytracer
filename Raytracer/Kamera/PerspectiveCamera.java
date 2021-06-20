package Kamera;

import Strahl.Ray;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;

/**
 * This Class represents a Perspective-Camera.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class PerspectiveCamera extends Camera {
	
	/**
	 * Opening angle of the Camera (Radians/Bogenmaß)
	 */
	public double angle; 

	/**
	 * @param e - Eye position
	 * @param g - Gaze direction (Blickrichtung)
	 * @param t - Up-Vector
	 * @param angle - Opening angle of the Camera
	 */
	public PerspectiveCamera(final Point3 e, final Vector3 g, final Vector3 t, final double angle) {
		super(e, g, t);
		if (e == null || g == null || t == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		// TODO Auto-generated constructor stub
		this.angle = angle;
	}

	/**
	 * Generate a ray for a given pixel-coordinate
	 * @param w - picture width
	 * @param h - picture height
	 * @param x - pixel-coordinate x
	 * @param y - pixel-coordinate y
	 * @return a new Ray
	 */
	@Override
	public Ray rayFor(final int w, final int h, final int x, final int y) {
		final Vector3 r = this.w.mul(-1).mul( (h/2) / (Math.tan(angle/2) ) ).add(u.mul(x-( (w-1) /2) )).add(v.mul(y-( (h-1) /2) ));
		final Vector3 d = r.normalized();
		final Point3 o = super.e;
		
		return new Ray(o,d);
		
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(angle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Overriding equals for correct use within this class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerspectiveCamera other = (PerspectiveCamera) obj;
		if (Double.doubleToLongBits(angle) != Double.doubleToLongBits(other.angle))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "PerspectiveCamera [angle=" + angle + "]";
	}
	
}
