package VektorenBibliothek;

/**
 * This Class generates an Vector3-Object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Vector3 {
	
	/**
	 * Value X of the vector
	 */
	final public double x;
	
	/**
	 * Value Y of the vector
	 */
	final public double y;
	
	/**
	 * Value Z of the vector
	 */
	final public double z;
	
	/**
	 * Calculating the magnitude of the Vector
	 */
	final public double magnitude;

	/**
	 * Constructor for Vector3 - Object.
	 * @param x - double-attribute from Vector
	 * @param y - double-attribute from Vector
	 * @param z - double-attribute from Vector
	 */
	public Vector3(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.magnitude = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);

	}

	/**
	 * Addition of Vector3 and Vector3.
	 * @param v - Vector3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 add(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
	}

	/**
	 * Addition of Vector and Normalvector.
	 * @param n - Normal3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 add(final Normal3 n) {
		if (n == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Vector3(this.x + n.x, this.y + n.y, this.z + n.z);
	}

	/**
	 * Subtraction of Normal3 from given Vector3.
	 * @param n - Normal3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 sub(final Normal3 n) {
		if (n == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Vector3(this.x - n.x, this.y - n.y, this.z - n.z);
	}

	/**
	 * Multiplication of given Vector3 with Scalar.
	 * @param c - Scalar.
	 * @return new Vector3 - Object
	 */
	public Vector3 mul(final double c) {

		return new Vector3(this.x * c, this.y * c, this.z * c);
	}

	/**
	 * Dot - Product of given Scalar and another Vector3. 
	 * @param v - Vector3 - Object
	 * @return new Scalar
	 */
	public double dot(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return (this.x * v.x) + (this.y * v.y) + (this.z * v.z);
	}

	/**
	 * Dot - Product of given Scalar and another Normal3.
	 * @param n - Normal3 - Object
	 * @return new Scalar
	 */
	public double dot(final Normal3 n) {
		if (n == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return (this.x * n.x) + (this.y * n.y) + (this.z * n.z);

	}

	/**
	 * Normalizing Vector3.
	 * @return A normalized Vector3.
	 */
	public Vector3 normalized() {

		return new Vector3(this.x / this.magnitude, this.y / this.magnitude, this.z / this.magnitude);
	}

	/**
	 * "Setting" Vector3 as Normal3.
	 * @return new Normal3 - Object
	 */
	public Normal3 asNormal() {
		
		return new Normal3(this.x, this.y, this.z);
	}

	/**
	 * Reflexes a Vector3 over a Normal3.
	 * @param n - Normal3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 reflectedOn(final Normal3 n) {
		if (n == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Vector3(2 * this.dot(n) * n.x - this.x, 2 * this.dot(n) * n.y - this.y,
				2 * this.dot(n) * n.z - this.z);
	}

	/**
	 * Vectorproduct or Crossproduct of given Vector3 and another Vector3.
	 * @param v - Vector3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 x(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Vector3((this.y * v.z) - (this.z * v.y), (this.z * v.x) - (this.x * v.z),
				(this.x * v.y) - (this.y * v.x));
	
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(magnitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Vector3 other = (Vector3) obj;
		if (Double.doubleToLongBits(magnitude) != Double.doubleToLongBits(other.magnitude))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Vector3 [x=" + x + ", y=" + y + ", z=" + z + ", magnitude=" + magnitude + "]";
	}

}