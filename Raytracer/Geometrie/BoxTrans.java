package Geometrie;

import java.util.ArrayList;

import Material.Material;
import Strahl.Ray;
import Transformieren.Transform;
import VektorenBibliothek.Point3;

/**
 * This Class represents a Box as a Node for usage of Transform - Operations.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class BoxTrans extends Geometry {

	public Node Node;

	/**
	 * Instantiates a new axis aligned box.
	 *
	 * @param material - Material for the Box
	 * @param a        - Point3 for left bottom point
	 * @param b        - Point3 for right upper point
	 * @throws will be thrown if the given argument is null
	 */
	public BoxTrans(final Material material, final Point3 a, final Point3 b) {
		super(material);
		if (a == null || b == null) {
			throw new NullPointerException("Null not allowed! Please check your inputs!");
		}

		final ArrayList<Geometry> geos = new ArrayList<Geometry>();
		geos.add(new Box(material, a, b));
		Node = new Node(new Transform(), geos);

	}

	/**
	 * Method to check if there's a hit between a ray and a box
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
		BoxTrans other = (BoxTrans) obj;
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
		return "BoxTrans [boxNode=" + Node + "]";
	}

}