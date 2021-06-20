package Geometrie;

import java.util.ArrayList;

import Material.Material;
import Strahl.Ray;
import Transformieren.Transform;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;
import Geometrie.Node;
import Welt.World;
/**
 * This Class represents a Sphere.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class SphereKresie extends Geometry {
    /*
     * Sphere center
     */
    public Point3 c;

    /*
     * Sphere radius
     */
    public double r;

    /*
     * Sphere NodeList
     */
    private ArrayList<Node> nodeList;

    /**
     * Sphere constructor
     * 
     * @param c     - Sphere center
     * @param r     - Sphere radius
     * @param material - Sphere material
     */
    public SphereKresie(final Point3 c, final double r, final Material material) {
        super(material);
        if (c == null || material == null) {
            throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
        }
        nodeList = new ArrayList<Node>();
        
        this.c = c;
        this.r = r;
        final ArrayList<Geometry> geos = new ArrayList<Geometry>();
        geos.add(new Disk(material, new Point3(0,0,0),r,new Normal3(0,-1,0),0));
        double degree = Math.PI/180.0;
        Node nodeTemp = null;

        for(int i=1;i<180;i++){
            nodeTemp = new Node(new Transform().rotateZ((degree*i)), geos);
            if (nodeTemp != null){nodeList.add(nodeTemp);}
        }
        //sphereNode2 = new Node(new Transform().translate(this.c).rotateX(Math.PI), geos);

    }

	/** 
	 * Method to check if there's a hit between a ray and a sphere
	 */
    @Override
    public Hit hit(Ray r) {
        if (r == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}

		/*
		 * Creates a list for all hits
		 */
		final ArrayList<Hit> hitList = new ArrayList<Hit>();
        
        for (Node nL : nodeList) {
			if (nL.hit(r) != null) {
				hitList.add(nL.hit(r));
			}
		}

		/*
		 * Returns null if the hitList is empty
		 */
		if (hitList.isEmpty()) {
			return null;

			/*
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
    
}