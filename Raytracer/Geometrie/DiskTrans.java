package Geometrie;

import java.util.ArrayList;

import Material.Material;
import Strahl.Ray;
import Transformieren.Transform;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;

/**
 * This Class represents a Disk as a Node for usage of Transform - Operations.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class DiskTrans extends Geometry{


    public Node Node;

    /**
	 * Disk constructor
	 * @param c -  Disk center
	 * @param r - Disk radius
	 * @param material - Material for the Disk
	 * @param ring - Factor for CircleCutOut, 0.0-1.0, 0:no Ring
	 */
	public DiskTrans(final Material material, final Point3 c, final double r, final Normal3 normal, final double ring) {
		super(material);
		if (c == null || normal == null) {
			throw new IllegalArgumentException("Null not allowed! Please check your inputs!");
        }
        
        final ArrayList<Geometry> geos = new ArrayList<Geometry>();
		geos.add(new Disk(material, c, r,normal,ring));
		Node = new Node(new Transform(), geos);
    }
    
	/** 
	 * Method to check if there's a hit between a ray and a Disk
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
		DiskTrans other = (DiskTrans) obj;
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
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "DiskTrans [Node=" + Node + "]";
	}
    
}