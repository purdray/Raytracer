package Geometrie;

import java.util.ArrayList;

import Material.Material;
import Strahl.Ray;
import Transformieren.Transform;
import VektorenBibliothek.Point3;

/**
 * This Class represents a Triangle as a Node for usage of Transform - Operations.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class TriangleTrans extends Geometry {

	public Node Node;

	/**
	 * Sphere constructor
	 * 
	 * @param a - Point3 - point a of triangle
	 * @param b - Point3 - point b of triangle
	 * @param c - Point3 - point c of triangle
	 * @param material - Material for the triangle
	 */
	public TriangleTrans(final Material material, final Point3 a, final Point3 b, final Point3 c) {
		super(material);
		if (c == null || a == null || b == null) {
			throw new IllegalArgumentException("Input is null!");
		}

		final ArrayList<Geometry> geos = new ArrayList<Geometry>();
		geos.add(new Triangle(material, a, b, c));
		Node = new Node(new Transform().scale(new Point3(2,2,2)), geos);
	}

	/**
	 * Method to check if there's a hit between a ray and a triangle
	 */
	@Override
	public Hit hit(Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
		final Hit hitTemp = Node.hit(r);
		if (hitTemp != null) {
			return hitTemp;
		}

		return null;

	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Node == null) ? 0 : Node.hashCode());
		return result;
	}

	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TriangleTrans other = (TriangleTrans) obj;
		if (Node == null) {
			if (other.Node != null) {
				return false;
			}
		} else if (!Node.equals(other.Node)) {
			return false;
		}
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "TriangleTrans [Node=" + Node + "]";
	}

}