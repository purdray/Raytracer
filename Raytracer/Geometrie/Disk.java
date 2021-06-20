package Geometrie;

import Material.Material;
import Strahl.Ray;
import Texture.TexCoord2;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;

/**
 * This Class represents a Disk or a Ring object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Disk extends Geometry {
    /** 
	 * center
	 */
	public final Point3 c;
	
	/** 
	 * radius
	 */
	public final double r;
	
	/** 
	 * normal
	 */
	public final Normal3 normal;

	/** 
	 * makes a ring
	 */
	public final double ring;

	/**
	 * Disk constructor
	 * @param c -  disk center
	 * @param r - disk radius
	 * @param material - Material for the disk
	 * @param ring - Factor for CircleCutOut, 0.0-1.0, 0:no Ring
	 */
	public Disk(final Material material,final Point3 c,final double r,final Normal3 normal, final double ring) {
		super(material);
		if (c == null || normal == null) {
			throw new IllegalArgumentException("Null not allowed! Please check your inputs!");
		}
		
		
		this.c = c;
		this.r = r;
		this.normal = normal;
		this.ring = ring;
	}


	/**
	 * Method to check if there's a hit between a ray and a disk
	 */
	@Override
	public Hit hit(final Ray ray) {
		if (ray == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}		 
		final Plane plane = new Plane(c, normal, material);
		final Hit hit = plane.hit(ray);
		if (hit != null) {
			if (hit.t <= 0) {
				
				return null;
			}

			final Point3 pTemp = ray.at(hit.t);
			if (c.sub(pTemp).magnitude < (r*r) && c.sub(pTemp).magnitude > r*r*ring) {
				
				return new Hit(hit.t, ray, this,hit.normal,new TexCoord2(pTemp.x, -pTemp.z));

			} else {
				return null;
			}
		}
		return null;

	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((normal == null) ? 0 : normal.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disk other = (Disk) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (normal == null) {
			if (other.normal != null)
				return false;
		} else if (!normal.equals(other.normal))
			return false;
		if (Double.doubleToLongBits(r) != Double
				.doubleToLongBits(other.r))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "Disk [center=" + c + ", radius=" + r + ", normal="
				+ normal + "]";
	}

}