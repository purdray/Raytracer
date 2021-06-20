  package Kamera;

import Strahl.Ray;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;

/**
 * This Class represents a Orthographic-Camera.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class OrthographicCamera extends Camera {
	
	/**
	 * Scaling factor
	 */
	public double s;

	/**
	 * @param e - Eye position
	 * @param g - Gaze direction (Blickrichtung)
	 * @param t - Up-Vektor
	 * @param s - Scaling factor
	 */
	public OrthographicCamera(final Point3 e, final Vector3 g, final Vector3 t, final double s) {
		super(e, g, t);
		if (e == null || g == null || t == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}	
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	/**
	 * Generate a ray for a given pixel-coordinate
	 * @param w - picture width
	 * @param h - picture height
	 * @param x - pixel-coordinate x
	 * @param y - pixel-coordinate y
	 * @return a new Ray
	 */
	public Ray rayFor(final int w, final int h, final int x, final int y) {	
		final double wNeu = (double)w;
		final double hNeu = (double)h;
		final double xNeu = (double)x;
		final double yNeu = (double)y;
		final double a = wNeu/hNeu;
		final Vector3 d = super.w.mul(-1);	
        final Point3 o = e.add(u.mul(a*(s*((xNeu-((wNeu-1)/2))/(wNeu-1))))).add(v.mul(s*((yNeu-((hNeu-1)/2))/(hNeu-1))));
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
		temp = Double.doubleToLongBits(s);
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
		OrthographicCamera other = (OrthographicCamera) obj;
		if (Double.doubleToLongBits(s) != Double.doubleToLongBits(other.s))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "OrthographicCamera [s=" + s + "]";
	}
	
}
