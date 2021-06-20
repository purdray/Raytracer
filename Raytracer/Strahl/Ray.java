package Strahl;

import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;

/**
 * This Class represents a Ray.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */

public class Ray {
	
	/**
	 * Origin of the ray
	 */
	public Point3 o;
	
	/**
	 * Direction of the ray
	 */
	public Vector3 d;
	
	/**
	 * @param o	- Point3 - Origin of the ray
	 * @param d - Vector3 - Direction of the ray, which gets normalized in the Ray constructor
	 */
	public Ray(final Point3 o, final Vector3 d) {
		if (o == null || d == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		this.o = o;
		this.d = d.normalized();	
	}
	
	/**
	 * @param t - double - Distance to the origin o
	 * @return Point3
	 */
	public Point3 at(final double t)  {
		final Point3 pointTemp= o.add(d.mul(t));
		return 	pointTemp;		
	}
	
	/**
	 * @param p - Point3 of the Ray
	 * @return double - the distance of the Point3
	 */
	public double tOf(final Point3 p) {
		if (p == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return p.sub(o).magnitude / d.magnitude;
		
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((o == null) ? 0 : o.hashCode());
		return result;
	}

	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (o == null) {
			if (other.o != null)
				return false;
		} else if (!o.equals(other.o))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Ray [o=" + o + ", d=" + d + "]";
	}
	
}
