package Geometrie;

import java.util.ArrayList;
import java.util.HashSet;

import Material.Material;
import Strahl.Ray;
import Transformieren.Transform;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;

/**
 * This Class represents a Box.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Box extends Geometry {
	/**
	 * The left bottom point of the box
	 */
	public final Point3 lBf;

	/**
	 * The right upper point of the box
	 */
	public final Point3 rUp;

	private final Node far;
	private final Node right;
	private final Node left;
	private final Node bottom;
	private final Node top;
	private final Node front;

	/**
	 * Instantiates a new axis aligned box.
	 *
	 * @param material - Material for the Box
	 * @param a - Point3 for left bottom point
	 * @param b - Point3 for right upper point
	 * @throws will be thrown if the given argument is null
	 */
	public Box(final Material material, final Point3 a, final Point3 b) {
		super(material);
		if (a == null || b == null) {
			throw new NullPointerException("Null not allowed! Please check your inputs!");
		}

		this.lBf = a;
		this.rUp = b;

		final ArrayList<Geometry> geos = new ArrayList<Geometry>();
		geos.add(new Plane(new Point3(0, 0, 0), new Normal3(0, 1, 0), material));
		left = new Node(new Transform().translate(this.lBf).rotateZ(Math.PI / 2), geos);
		bottom = new Node(new Transform().translate(this.lBf).rotateX(Math.PI), geos);
		far = new Node(new Transform().translate(this.lBf).rotateZ(Math.PI).rotateX(-Math.PI / 2), geos);
		right = new Node(new Transform().translate(this.rUp).rotateZ(-Math.PI / 2), geos);
		top = new Node(new Transform().translate(this.rUp), geos);
		front = new Node(new Transform().translate(this.rUp).rotateZ(Math.PI).rotateX(Math.PI / 2), geos);

	}

	/** 
	 * Method to check if there's a hit between a ray and a box
	 */
	@Override
	public Hit hit(final Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}

		final Hit[] xHits = new Hit[] { left.hit(r), right.hit(r) };
		final Hit[] yHits = new Hit[] { top.hit(r), bottom.hit(r) };
		final Hit[] zHits = new Hit[] { front.hit(r), far.hit(r) };

		final HashSet<Hit> hits = new HashSet<Hit>();

		for (int i = 0; i < 2; i++) {
			if (xHits[i] != null) {
				final Point3 p = r.at(xHits[i].t);
				if (p.y >= lBf.y && p.y <= rUp.y && p.z >= lBf.z && p.z <= rUp.z)
					hits.add(xHits[i]);
			}
		}

		for (int i = 0; i < 2; i++) {
			if (yHits[i] != null) {
				final Point3 p = r.at(yHits[i].t);
				if (p.x >= lBf.x && p.x <= rUp.x && p.z >= lBf.z && p.z <= rUp.z)
					hits.add(yHits[i]);
			}
		}

		for (int i = 0; i < 2; i++) {
			if (zHits[i] != null) {
				final Point3 p = r.at(zHits[i].t);
				if (p.x >= lBf.x && p.x <= rUp.x && p.y >= lBf.y && p.y <= rUp.y)
					hits.add(zHits[i]);
			}
		}

		double t = Double.MAX_VALUE;
		Hit hitTemp = null;

		for (final Hit hit : hits) {
			if (hit == null)
				continue;
			if (hit.t < t && t > 0 && hit.t > 0.0001) {
				t = hit.t;
				hitTemp = hit;
			}
		}
		return hitTemp;
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lBf == null) ? 0 : lBf.hashCode());
		result = prime * result + ((rUp == null) ? 0 : rUp.hashCode());
		return result;
	}

	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Box other = (Box) obj;
		if (lBf == null) {
			if (other.lBf != null)
				return false;
		} else if (!lBf.equals(other.lBf))
			return false;
		if (rUp == null) {
			if (other.rUp != null)
				return false;
		} else if (!rUp.equals(other.rUp))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "AxisAlignedBox [lbf=" + lBf + ", run=" + rUp + "]";
	}

}
