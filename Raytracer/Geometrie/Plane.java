package Geometrie;

import Material.Material;
import Strahl.Ray;
import Texture.TexCoord2;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;

/**
 * This Class represents a Plane.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Plane extends Geometry {

	/**
	 * Known point
	 */
	public final Point3 a;

	/**
	 * Direction alignment
	 */
	public final Normal3 n;
	
	/**
	 * Creates a Plane object for the raytracer
	 * @param a - Known point
	 * @param n - Direction alignment
	 * @param color - Color of the plane
	 */
	public Plane(final Point3 a, final Normal3 n, final Material material) {
		super(material);
		if (a == null || n == null || material == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		this.a = a;
		this.n = n;
	}
	
	/** 
	 * Method to check if there's a hit between a ray and a plane
	 */
	@Override
	public Hit hit(final Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
		double divisor = r.d.dot(n);

		if (divisor != 0.0) {
			double t = ((a.sub(r.o).dot(n)) / divisor);
			if (t<0.0001) {return null;}
			Point3 pTemp = r.at(t);
			return new Hit(t, r, this, n,new TexCoord2(pTemp.x, -pTemp.z));
		}
		return null;

	}
	
	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((n == null) ? 0 : n.hashCode());
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
		Plane other = (Plane) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (n == null) {
			if (other.n != null)
				return false;
		} else if (!n.equals(other.n))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "Plane [a=" + a + ", n=" + n + "]";
	}	

}
