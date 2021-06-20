package Licht;

import Farben.Color;
import Strahl.Ray;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;
import Welt.World;

/**
 * This class creates a Directional Light
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class DirectionalLight extends Light {
	
	/**
	 * Vector direction
	 */
	public Vector3 direction;
	
	/**
	 * @param color - Color object
	 * @param direction - Vector direction
	 */
	public DirectionalLight(final Color color, final Vector3 direction, final boolean castsShadows) {
		super(color, castsShadows);
		if (direction == null || color == null) {
			throw new IllegalArgumentException("Input is null!");
		}
		
		this.direction = direction;
	}
	
	/**
	 * Method for testing the "Light-Hit"
	 * @param point - Pointobject
	 * @param world - Porldobject
	 * @return boolean
	 */
	@Override
	public boolean illuminates(final Point3 point, final World world) {		
		if(point == null || world == null) {
			throw new IllegalArgumentException ("Input is null!"); 
		}
		
		if(this.castsShadows == true) {
			if (world.hit(new Ray (point, directionFrom(point))) == null) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * Method for determining the direction of light
	 * @override point - Point3 - object
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
	 * Overriding equals for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
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
		DirectionalLight other = (DirectionalLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}
	
	/**
	 * Overriding equals for correct use within this class
	 */
	@Override
	public String toString() {
		return "DirectionalLight [direction=" + direction + "]";
	}

}
