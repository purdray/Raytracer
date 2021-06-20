package Geometrie;

import Strahl.Ray;
import Texture.TexCoord2;
import VektorenBibliothek.Normal3;

/**
 * This Class represents a Hit.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Hit {
	
	/**
	 * t represents where the ray gets hit
	 */
	public double t;
	
	/**
	 * Ray object
	 */
	public Ray ray;
	
	/**
	 * The geometry which gets hit 
	 */
	public Geometry geo;
	
	/**
	 * Normal for t 
	 */
	public Normal3 normal;

	/**
	 * TexCoord2 
	 */
	public TexCoord2 texCoord;


	/**
	 * Hit - method for calculating the Hitpoint as an Hit-Object
	 * @param r - given Ray for calculating
	 * @return Returns a Hitpoint
	 */
	public Hit(final double t, final Ray ray, final Geometry geo, final Normal3 normal, final TexCoord2 texCoord) {
		if (ray == null || geo == null || normal == null || texCoord == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		this.t = t;
		this.ray = ray;
		this.geo = geo;
		this.normal = normal;
		this.texCoord = texCoord;
		
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geo == null) ? 0 : geo.hashCode());
		result = prime * result + ((ray == null) ? 0 : ray.hashCode());
		long temp;
		temp = Double.doubleToLongBits(t);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Hit other = (Hit) obj;
		if (geo == null) {
			if (other.geo != null)
				return false;
		} else if (!geo.equals(other.geo))
			return false;
		if (ray == null) {
			if (other.ray != null)
				return false;
		} else if (!ray.equals(other.ray))
			return false;
		if (Double.doubleToLongBits(t) != Double.doubleToLongBits(other.t))
			return false;
		return true;
	}
	
	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Hit [t=" + t + ", ray=" + ray + ", geo=" + geo + ", normal=" + normal + "]";
	}

}
