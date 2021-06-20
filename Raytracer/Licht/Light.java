package Licht;

import Farben.Color;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;
import Welt.World;

/**
 * Abstract light class
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public abstract class Light {
	
	/**
	 * Color object
	 */
	public final Farben.Color color;
	
	/**
	 * Determines if a shadow should be casted or not
	 */
	public final boolean castsShadows;
	
	/**
	 * Light constructor
	 * @param color - Color object
	 * @param castsShadows - Determines if a shadow should be casted or not
	 */
	public Light(final Color color, final boolean castsShadows) {
		if (color == null) {
			throw new IllegalArgumentException("Input is null!");
		}
		this.color = color.mul(255);
		this.castsShadows = castsShadows;
	}
	
	/**
	 * abstract method of illuminates
	 * @param point - Position of the light
	 * @param world - World object
	 * @return returns a illuminated light
	 */
	public abstract boolean illuminates(final Point3 point, final World world);
		
	
	/**
	 * abstract method of directionFrom
	 * @param point - Position of the light
	 * @return returns the source of light
	 */
	public abstract Vector3 directionFrom(final Point3 point);

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Light other = (Light) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;		
		return true;
	}
	
	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "Light [color=" + color + "]";
	}
}
