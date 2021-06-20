package VektorenBibliothek;

/**
 * This Class generates an Point3-Object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Point3 {

	/**
	 *  Value X of the point
	 */
	final public double x;
	
	/**
	 * Value Y of the point
	 */
	final public double y;
	
	/**
	 * Value Z of the point
	 */
	final public double z;

	/**
	 * Constructor for Point3 - Object.
	 * @param x - Attribute of Point
	 * @param y - Attribute of Point
	 * @param z - Attribute of Point
	 */
	public Point3(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Subtraction of Point3 from given Point3.
	 * @param p - Point3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 sub(final Point3 p) {
		if (p == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Vector3(this.x - p.x, this.y - p.y, this.z - p.z);

	}

	/**
	 * Subtraction of Vector3 from given Point3.
	 * @param v - Vector3 - Object
	 * @return new Point3 - Object
	 */
	public Point3 sub(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Point3(this.x - v.x, this.y - v.y, this.z - v.z);

	}

	/**
	 * Addition of given Point3 with Vector3.
	 * @param v - Vector3 - Object
	 * @return new Point3 - Object
	 */
	public Point3 add(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Point3(this.x + v.x, this.y + v.y, this.z + v.z);

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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3 other = (Point3) obj;
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
		return "Point3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}