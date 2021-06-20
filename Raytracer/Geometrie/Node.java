package Geometrie;

import java.util.ArrayList;

import Farben.Color;
import Material.SingleColorMaterial;
import Strahl.Ray;
import Transformieren.Transform;

/**
 * This Class represents a Node.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Node extends Geometry {

	/** 
	 * Transform object
	 */
	public Transform transform;

	/** 
	 * List of geometries
	 */
	public ArrayList<Geometry> geometries;

	/**
	 * Node constructor
	 * @param transform - Transform object
	 * @param geometries - List or geometries
	 */
	public Node(final Transform transform, final ArrayList<Geometry> geometries) {
		super(new SingleColorMaterial(new Color(0, 0, 0)));
		this.transform = transform;
		this.geometries = geometries;
	}
	
	/**
	 * Method to check if there's a hit between
	 * a Transformed Ray and a geometry
	 */
	@Override
	public Hit hit(final Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
		Ray transformedRay = transform.mul(r);
		double t = Double.MAX_VALUE;
		Hit lowHit = null;

		for (Geometry geometry : geometries) {
			Hit hit = geometry.hit(transformedRay);
			if (hit == null) {
				continue;
			}			
			if (hit.t < t && hit.t > 0.0001) {
				t = hit.t;
				lowHit = hit;
			}
		}

		if (lowHit == null) {
			return null;
		}
			
		else {
			return new Hit(lowHit.t, r, lowHit.geo, transform.mul(lowHit.normal),lowHit.texCoord);
		}
			
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((geometries == null) ? 0 : geometries.hashCode());
		result = prime * result + ((transform == null) ? 0 : transform.hashCode());
		return result;
	}


	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		if (transform == null) {
			if (other.transform != null)
				return false;
		} else if (!transform.equals(other.transform))
			return false;
		return true;
	}
	

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Node [transform=" + transform + ", geometries=" + geometries + "]";
	}

}