package VektorenBibliothek;

/**
 * This Class generates an Normal3-Object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Normal3 {

	/**
	 * Value X of the normal
	 */
	final public double x;
	
	/**
	 * Value Y of the normal
	 */
	final public double y;
	
	/**
	 * Value Z of the normal
	 */
	final public double z;

	/**
	 * Constructor for Normal3 - Object.
	 * @param x - Attribute of Normal
	 * @param y - Attribute of Normal
	 * @param z - Attribute of Normal
	 */
	public Normal3(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Multiplication of given Normal3 with Scalar.
	 * @param c - Attribute of Normal
	 * @return new Normal3 - Object
	 */
	public Normal3 mul(final double c) {
		
		return new Normal3(this.x * c, this.y * c, this.z * c);
	}

	/**
	 * Addition of given Normal3 and another Normal3.
	 * @param n - Normal3 - Object
	 * @return new Normal3 - Object
	 */
	public Normal3 add(final Normal3 n) {
		if (n == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Normal3(this.x + n.x, this.y + n.y, this.z + n.z);
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
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Normal3 other = (Normal3) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Normal3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
