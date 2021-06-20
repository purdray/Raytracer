package Welt;

import Farben.Color;
import Geometrie.Geometry;
import Geometrie.Hit;
import Strahl.Ray;
import java.util.ArrayList;
import Licht.Light;

/**
 * This Class represents the World.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */

public class World {

	/**
	 * Background Color of the Raytracer
	 */
	public Color backgroundColor;

	public Color color;
	/**
	 * List of the currently added geometry objects
	 */
	public ArrayList<Geometry> geometryList;

	public ArrayList<Light> lightList;

	/**
	 * Standardconstructor for worldclass.
	 * @param geometryList - ArrayList
	 * @param backgroundColor - Color
	 */
	public World(final ArrayList<Geometry> geometryList, final Color backgroundColor,
			final ArrayList<Light> lightList) {
		if (geometryList == null || backgroundColor == null ) {
			throw new NullPointerException("Null not allowed! Please check your inputs!");
		}
		this.geometryList = geometryList;
		this.backgroundColor = backgroundColor;
		this.lightList = lightList;
	}

	/**
	 * Hit - method for calculating the Hitpoint as an Hit-Object
	 * 
	 * @param r - given Ray for calculating
	 * @return a Hitpoint
	 */
	public Hit hit(final Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}

		/**
		 * Creates a list for all hits
		 */
		final ArrayList<Hit> hitList = new ArrayList<Hit>();

		/**
		 * Iteration through all geometry objects, adds a hit to the list if the hit
		 * doesn't equals null
		 */
		for (Geometry gL : geometryList) {
			if (gL.hit(r) != null) {
				hitList.add(gL.hit(r));
			}
		}

		/**
		 * Returns null if the hitList is empty
		 */
		if (hitList.isEmpty()) {
			return null;

		/**
		 * Iteration through the hitList, returns the smallest positive hit t
		 */
		} else {
			double tmin = Double.MAX_VALUE;
			Hit hitTemp = null;
			for (Hit hit : hitList) {
				if (hit.t < tmin && hit.t > 0.0000) {
					tmin = hit.t;
					if (tmin < 0.0001) {
						tmin = 0.0001;
					}
				}
				hitTemp = hit;
			}
			return hitTemp;
		}

	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backgroundColor == null) ? 0 : backgroundColor.hashCode());
		result = prime * result + ((geometryList == null) ? 0 : geometryList.hashCode());
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
		World other = (World) obj;
		if (backgroundColor == null) {
			if (other.backgroundColor != null)
				return false;
		} else if (!backgroundColor.equals(other.backgroundColor))
			return false;
		if (geometryList == null) {
			if (other.geometryList != null)
				return false;
		} else if (!geometryList.equals(other.geometryList))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "World [backgroundColor=" + backgroundColor + ", geometryList=" + geometryList + "]";
	}
}
