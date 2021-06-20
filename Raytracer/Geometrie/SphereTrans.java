package Geometrie;

import java.util.ArrayList;

import Material.Material;
import Strahl.Ray;
import Transformieren.Transform;

import VektorenBibliothek.Point3;
/**
 * This Class represents a Sphere as a Node for usage of Transform - Operations.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class SphereTrans extends Geometry {
    /**
     * Sphere center
     */
    public Point3 c;

    /**
     * Sphere radius
     */
    public double r;

    /**
     * Sphere Node
     */
    public Node Node;

    /**
     * Sphere constructor
     * 
     * @param c     - Point3-Object for Sphere center
     * @param r     - double Sphere radius
     * @param material - Material for Sphere
     */
    public SphereTrans(final Point3 c, final double r, final Material material) {
        super(material);
        if (c == null || material == null) {
            throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
        }
        this.c = c;
        this.r = r;
        final ArrayList<Geometry> geos = new ArrayList<Geometry>();
		geos.add(new Sphere(new Point3(0,0,0),1,material));
        Node = new Node(new Transform().translate(c).scale(new Point3(r,r,r)), geos);

    }

	/** 
	 * Method to check if there's a hit between a ray and a sphere
	 */
    @Override
    public Hit hit(Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
        final Hit hitTemp = Node.hit(r);
        if (hitTemp != null){return hitTemp;}
   
		return null;	
		
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SphereTrans other = (SphereTrans) obj;
		if (c == null) {
			if (other.c != null) {
				return false;
			}
		} else if (!c.equals(other.c)) {
			return false;
		}
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r)) {
			return false;
		}
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
		return "SphereTrans [c=" + c + ", r=" + r + ", sphereNode=" + Node + "]";
	}
    
    
}