package Geometrie;

import Material.Material;
import Strahl.Ray;

/**
 * This Class represents a Geometry object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public abstract class Geometry {

	/**
	 * Material object
	 */
	public Material material;

	/**
	 * Geometry Construcot
	 * 
	 * @param material- Material object
	 */
	public Geometry(final Material material) {
		if (material == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		this.material = material;

	}

	/**
	 * @param r - Ray object
	 * @return Returns in a hit in the ray
	 */
	public abstract Hit hit(final Ray r);

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
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
		Geometry other = (Geometry) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Geometry [material=" + material + "]";
	}

}
