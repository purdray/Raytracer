package Geometrie;

import Material.Material;
import Strahl.Ray;
import Texture.TexCoord2;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Normal3;

/**
 * This Class represents a Sphere.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Sphere extends Geometry {
	
	/**
	 * Sphere center
	 */
	public Point3 c;
	
	/**
	 * Sphere radius
	 */
	public double r;

	/**
	 * Sphere constructor
	 * @param c -  Sphere center
	 * @param r - Sphere radius
	 * @param color - Sphere color
	 */
	public Sphere(final Point3 c, final double r, final Material material) {
		super(material);
		if (c == null || material == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}	
		this.c = c;
		this.r = r;
		
	}
	

	/** 
	 * Method to check if there's a hit between a ray and a sphere
	 */
	@Override
	public Hit hit(final Ray ray) {
		if (ray == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		
		}

		double a = ray.d.dot(ray.d);
		double b = ray.d.dot((ray.o.sub(c)).mul(2));		
        double c1  = (ray.o.sub(c).dot(ray.o.sub(c)))-this.r*this.r;
		
        /**
		 * Numerator (Positive)
		 */
        double tnp = (b*-1 + Math.sqrt(b*b-4*a*c1));
        
        /**
		 * Numerator (Negative)
		 */
        double tnn = (b*-1 - Math.sqrt(b*b-4*a*c1));	
        double td = 2*a;
		
		/**
		 * Checks if Numerator is not divided by 0.
		 * Returns a new Hit if the Numerator is not
		 * devided by 0, returns null otherwise. 
		 */
        if(td != 0.0) {
        	double tp = tnp / td;
			double tn = tnn / td;
			
			if (tp > 0.0001 || tn > 0.0001) {
				if(tp < tn) {
					final Normal3 normal1 = ray.at(tp).sub(this.c).normalized().asNormal();
					return new Hit(tp, ray, this,normal1,pointToTex(ray.at(tp)));
				}
        	
				else if(tn < tp) {
					final Normal3 normal2 = ray.at(tn).sub(this.c).normalized().asNormal();
					return new Hit(tn, ray, this,normal2,pointToTex(ray.at(tn)));
				}
			}
        }
		return null;	
		
	}
	

	/**
	 * Polarcoordinates for textures
	 * @param point - given point for center of texture
	 * @return TextCoord
	 */
	private TexCoord2 pointToTex(final Point3 point){
		if (point == null) {
			throw new IllegalArgumentException("The Point cannot be null!");
		}
		
		double teta = Math.acos(point.y);
		double phi   = Math.atan2(point.x, point.z);
		
		return  new TexCoord2(phi/(Math.PI*2), -teta/Math.PI);
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Sphere other = (Sphere) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "Sphere [c=" + c + ", r=" + r + "]";
	}

}
