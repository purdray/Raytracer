package Transformieren;

import Strahl.Ray;
import VektorenBibliothek.Mat4x4;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;

/**
 * This Class transforms geometries
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Transform {
        
	/**
     * Mat4x4 object
     */
	public final Mat4x4 m;
        
	/**
	 * Inverse Matrix
	 */
	public final Mat4x4 i;
    
	/**
	 * Transform constructor
	 */
	public Transform() {
		m = new Mat4x4(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);  
		i = m;
	}
    
	/**
	 * Constructor overload, initilazing the matrix and inverse
	 * @param m - Matrix object
	 * @param i - Inverse object
	 */
	public Transform(final Mat4x4 m, final Mat4x4 i) {
		this.m = m;
		this.i = i;
	}
        
	/**
	 * This method appends a translation by the given Point and returns
	 * a new Transformed object
	 * @param p - Point3 - object
	 * @return a translated Transformation object
	 */
	public Transform translate(final Point3 p) {
		if (p == null ) {
			throw new NullPointerException("Null not allowed! Please check your inputs!");
		}
		final Transform transform = new Transform(
				new Mat4x4(1, 0, 0, p.x, 
						   0, 1, 0, p.y, 
						   0, 0, 1, p.z, 
						   0, 0, 0, 1), 
				new Mat4x4(1, 0, 0, -p.x,
						   0, 1, 0, -p.y, 
						   0, 0, 1, -p.z, 
						   0, 0, 0, 1));
		
		return new Transform(m.mul(transform.m), transform.i.mul(i));
        }
    
	/**
	 * This method appends a scaled transformation by the given Point for the axis
	 * to an existing transformation and returns a new transformation object.
	 * @param p - Point3 - object
	 * @return a transformed and scaled object
	 */  
	public Transform scale(final Point3 p) {      
		if (p == null ) {
			throw new NullPointerException("Null not allowed! Please check your inputs!");
		}
		final Transform transform = new Transform(
				new Mat4x4(p.x, 0.0, 0.0, 0.0,
						   0.0, p.y, 0.0, 0.0,
						   0.0, 0.0, p.z, 0.0,
						   0.0, 0.0, 0.0, 1.0),
				new Mat4x4(1.0/p.x, 0.0, 0.0, 0.0,
                           0.0, 1.0/p.y, 0.0, 0.0,
                           0.0, 0.0, 1.0/p.z, 0.0,
                           0.0, 0.0, 0.0, 1.0));	
    
		return new Transform(m.mul(transform.m), transform.i.mul(i));
        }
    
	/**
	 * This method appends a rotation around the x axis to the transformation
	 * and returns a new transformation object.
	 * @param a - The angle of the rotation in radiant.          
	 * @return a transformation object where the x axis has been rotated
	 */   
	public Transform rotateX(double a) {
		Transform transform = new Transform(
				new Mat4x4(1, 0, 0, 0,
						   0, Math.cos(a), -Math.sin(a), 0, 
						   0, Math.sin(a), Math.cos(a), 0,
						   0, 0, 0, 1), 
            		
				new Mat4x4(1, 0, 0, 0,
						   0, Math.cos(a), Math.sin(a), 0,
						   0, -Math.sin(a), Math.cos(a), 0,
						   0, 0, 0, 1));
    		
		return new Transform(m.mul(transform.m), transform.i.mul(i));
        }
    
	/**
	 * This method appends a rotation around the y axis to the transformation
	 * and returns a new transformation object.
	 * @param a - The angle of the rotation in radiant.          
	 * @return a transformation object where the y axis has been rotated
	 */ 
	public Transform rotateY(double a) {
		Transform transform = new Transform(
				new Mat4x4(Math.cos(a), 0.0, Math.sin(a), 0.0,
						   0.0, 1.0, 0.0, 0.0,
						   -Math.sin(a), 0.0, Math.cos(a), 0.0,
						   0.0, 0.0, 0.0, 1.0),
                 
				new Mat4x4(Math.cos(a), 0.0, -Math.sin(a), 0.0,
						   0.0, 1.0, 0.0, 0.0,
						   Math.sin(a), 0.0, Math.cos(a), 0.0,
						   0.0, 0.0, 0.0, 1.0));
            
		return new Transform(m.mul(transform.m), transform.i.mul(i));
        }
    
	/**
	 * This method appends a rotation around the z axis to the transformation
	 * and returns a new transformation object.
	 * @param a - The angle of the rotation in radiant.          
	 * @return a transformation object where the z axis has been rotated
	 */ 
	public Transform rotateZ(double a) {
		Transform transform = new Transform(
				new Mat4x4(Math.cos(a), -Math.sin(a), 0.0, 0.0,
                           Math.sin(a), Math.cos(a), 0.0, 0.0,
                           0.0, 0.0, 1.0, 0.0,
                           0.0, 0.0, 0.0, 1.0),
				new Mat4x4(Math.cos(a), Math.sin(a), 0.0, 0.0,
                           -Math.sin(a), Math.cos(a), 0.0, 0.0,
                           0.0, 0.0, 1.0, 0.0,
                           0.0, 0.0, 0.0, 1.0));
		
		return new Transform(m.mul(transform.m), transform.i.mul(i));
        }
    
	/**
	 * Transforming a Ray object
	 * @param ray - Ray object
	 * @return a transformed Ray
	 */
	public Ray mul(final Ray ray) {
		if (ray == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
		return new Ray(i.mul(ray.o), i.mul(ray.d));
	}
    
	/**
	 * Transforming a Normal back.
	 * @param n - Normal3 object
	 * @return a back transformed normal
	 */
	public Normal3 mul(Normal3 n) {
		if (n == null ) {
			throw new NullPointerException("Null not allowed! Please check your inputs!");
		}
		return i.transposed().mul(new Vector3(n.x, n.y, n.z)).normalized().asNormal();
	}
    
	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		return result;
	}
    
	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transform other = (Transform) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		return true;
	}
    
	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Transform [m=" + m + ", i=" + i + "]";
	}
	
}