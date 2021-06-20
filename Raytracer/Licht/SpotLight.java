package Licht;

import Farben.Color;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;
import Welt.World;
import Geometrie.Hit;
import Strahl.Ray;

/**
 * This class represents a Spot light
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class SpotLight extends Light{
	
	/**
	 * Position of the light
	 */
	public final Point3 position;
	
	/**
	 * Direction of the light
	 */
	public final Vector3 direction;
	
	/**
	 * Angle of the spotLight
	 */
	public final double halfAngle;
	
	/**
	 * 
	 * @param color - Color object
	 * @param position - Position of the light
	 * @param direction - Direction of the light
	 * @param spotLightAngle - Angle of the spotLight
	 */
	public SpotLight(final Color color, final Point3 position, final Vector3 direction, final double halfAngle, final boolean castsShadows) {
		super(color, castsShadows);
		if (color == null || position == null || direction == null) {
			throw new IllegalArgumentException("The Point cannot be null!");
		}	
		this.position = position;
		this.direction = direction;
		this.halfAngle = halfAngle;
		
	}
	/**
	 * Method for testing the "Light-Hit"
	 * @param point - Point3-object
	 * @param world - World-object
	 * @return boolean
	 */
	@Override
	public boolean illuminates (final Point3 point, final World world) {
		if (point == null || world == null) {
			throw new IllegalArgumentException("The Point cannot be null!");
		}
		if (Math.sin(position.sub(point).normalized().x(direction).magnitude) <= halfAngle) {
			if(this.castsShadows == true) {						
				Hit hit = world.hit(new Ray(point, directionFrom(point)));
				if (hit != null) {
					double tTemp = (position.sub(point).magnitude)	/ (directionFrom(point).magnitude);
					if (hit.t < tTemp) {
						return false;
					} else {
						return true;
					}
				}
				if (hit == null) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Method for determining the direction of light
	 * @override point - Point3-object
	 * @return Vector3
	 */
	@Override
	public Vector3 directionFrom(final Point3 point) {
		if (point == null) {
			throw new IllegalArgumentException("Input is null!");
		}
		return direction.mul(-1);		
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		long temp;
		temp = Double.doubleToLongBits(halfAngle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SpotLight other = (SpotLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (Double.doubleToLongBits(halfAngle) != Double
				.doubleToLongBits(other.halfAngle))
			return false;
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
		return "SpotLight [position=" + position + ", direction=" + direction
				+ ", spotLightAngle=" + halfAngle + "]";
	}

}
