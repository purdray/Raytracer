package Licht;

import Farben.Color;
import Strahl.Ray;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;
import Welt.World;

/**
 * This class represents a PointLight
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class PointLight extends Light {

	/**
	 * Position of the light
	 */
	public Point3 position;

	/**
	 * Pointlight contructor
	 * @param color    - Color object
	 * @param position - Position of the light
	 */
	public PointLight(final Color color, final Point3 position, final boolean castsShadows) {
		super(color, castsShadows);
		if (color == null || position == null) {
			throw new IllegalArgumentException("Position is null!");
		}
		this.position = position;

	}

	/**
	 * Method for testing the "Light-Hit"
	 * @param point - Point3-object
	 * @param world - World-object
	 * @return boolean
	 */
	@Override
	public boolean illuminates(final Point3 point, final World world) {
		if (point == null || world == null) {
			throw new IllegalArgumentException("The Point cannot be null!");
		}
		
		if (world.hit(new Ray(point, directionFrom(point))) == null) {
			return true;
		}
		
		if(this.castsShadows == true) {
			Ray r = new Ray(point, directionFrom(point));
			double t1 = r.tOf(position);
			if (world.hit(r).t < t1) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Method for determining the direction of light
	 * @override point - Point3-object
	 * @return Vector3
	 */
	@Override
	public Vector3 directionFrom(final Point3 point) {
		if (point == null) {
			throw new IllegalArgumentException("Point is null!");
		}
		// normale zwischen point und position
		return position.sub(point).normalized();

	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		PointLight other = (PointLight) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "PointLight [position=" + position + "]";
	}
}
