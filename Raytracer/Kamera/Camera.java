package Kamera;

import Strahl.Ray;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;

/**
 * This Class represents a Camera.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public abstract class Camera {
	
	/**
	 * Eye position
	 */
	public Point3 e;
	
	/**
	 * Gaze direction (Blickrichtung)
	 */
	public Vector3 g;
	
	/**
	 * Up-Vektor
	 */
	public Vector3 t;
	
	/**
	 *  Points to the right from the camera perspective 
	 */
	public Vector3 u;
	
	/**
	 * Points up from the camera perspective 
	 */
	public Vector3 v;
	
	/**
	 * Points to the back from the camera perspective
	 */
	public Vector3 w;
	
	/**
	 * Camera constructor
	 * @param e - Eye position
	 * @param g - Gaze direction
	 * @param t - UpVector
	 */
	public Camera(final Point3 e, final Vector3 g, final Vector3 t) {
		if (e == null || g == null || t == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}	
		
		this.e = e;
		this.g = g;
		this.t = t;				
		this.w = g.normalized().mul(-1);
		this.u = t.x(w).normalized();
		this.v = w.x(u);
		
	}
	
	/**
	 * @param w - w represents the width of the image
	 * @param h - h represents the height of the image
	 * @param x - x represents the x coordinate
	 * @param y - y represents the y coordinate
	 * @return returns the ray for a pixel.
	 */
	public abstract Ray rayFor(final int width, final int height, final int x, final int y);

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((g == null) ? 0 : g.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		return result;
	}

	/**
	 * Overriding equals for correct use within this class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (g == null) {
			if (other.g != null)
				return false;
		} else if (!g.equals(other.g))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if (w == null) {
			if (other.w != null)
				return false;
		} else if (!w.equals(other.w))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "Camera [e=" + e + ", g=" + g + ", t=" + t + ", u=" + u + ", v=" + v + ", w=" + w + "]";
	}

}
