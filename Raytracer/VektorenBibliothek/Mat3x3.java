package VektorenBibliothek;

/**
 * This Class generates an Matri3x3-Object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Mat3x3 {
	
	/**
	 * first component in first row
	 */
	final public double m11;
	
	/**
	 * second component in first row
	 */
	final public double m12;
	
	/**
	 * third component in first row
	 */
	final public double m13;
	
	/**
	 * first component in second row
	 */
	final public double m21;
	
	/**
	 * second component in second row
	 */
	final public double m22;
	
	/**
	 * third component in second row
	 */
	final public double m23;
	
	/**
	 * first component in third row
	 */
	final public double m31;
	
	/**
	 * second component in third row
	 */
	final public double m32;
		
	/**
	 * third component in third row 
	 */
	final public double m33;
	/**
	 * calculating determinant
	 */
	final public double determinant;

	/**
	 * Constructor for 3x3Mat - Object
	 * @param m11         - double - first component in first row
	 * @param m12         - double - second component in first row
	 * @param m13         - double - third component in first row
	 * @param m21         - double - first component in second row
	 * @param m22         - double - second component in second row
	 * @param m23         - double - third component in second row
	 * @param m31         - double - first component in third row
	 * @param m32         - double - second component in third row
	 * @param m33         - double - third component in third row
	 * @param determinant - calculating determinant
	 */
	public Mat3x3(final double m11, final double m12, final double m13, final double m21, final double m22,
			final double m23, final double m31, final double m32, final double m33) {

		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;

		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;

		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		
		this.determinant = ((m11 * m22 * m33) + (m12 * m23 * m31) + (m13 * m21 * m32))
				- ((m31 * m22 * m13) + (m32 * m23 * m11) + (m33 * m21 * m12));
	}

	/**
	 * Multiplication of the given Matrix (3x3Mat) with another Matrix
	 * @param m Mat3x3 - Object
	 * @return new Mat3x3 - Object
	 */
	public Mat3x3 mul(final Mat3x3 m) {
		if (m == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		final double mN11;
		final double mN12;
		final double mN13;
		final double mN21;
		final double mN22;
		final double mN23;
		final double mN31;
		final double mN32;
		final double mN33;

		/*
		 * first column with first row
		 */
		mN11 = this.m11 * m.m11 + this.m12 * m.m21 + this.m13 * m.m31;
		/*
		 * second column with first row
		 */
		mN21 = this.m21 * m.m11 + this.m22 * m.m21 + this.m23 * m.m31;
		/*
		 * third column with first row
		 */
		mN31 = this.m31 * m.m11 + this.m32 * m.m21 + this.m33 * m.m31;
		/*
		 * first column with second row
		 */
		mN12 = this.m11 * m.m12 + this.m12 * m.m22 + this.m13 * m.m32;
		/*
		 * second column with second row
		 */
		mN22 = this.m21 * m.m12 + this.m22 * m.m22 + this.m23 * m.m32;
		/*
		 * third column with second row
		 */
		mN32 = this.m31 * m.m12 + this.m32 * m.m22 + this.m33 * m.m32;
		/*
		 * first colum with third row
		 */
		mN13 = this.m11 * m.m13 + this.m12 * m.m23 + this.m13 * m.m33;
		/*
		 * second colum with third row
		 */
		mN23 = this.m21 * m.m13 + this.m22 * m.m23 + this.m23 * m.m33;
		/*
		 * third colum with third row
		 */
		mN33 = this.m31 * m.m13 + this.m32 * m.m23 + this.m33 * m.m33;

		return new Mat3x3(mN11, mN12, mN13, mN21, mN22, mN23, mN31, mN32, mN33);
	}

	/**
	 * Multiplication Vector3 - Object with Matrix (Mat3x3)
	 * @param v Vector3 - Object
	 * @return new Vector3 - Object
	 */
	public Vector3 mul(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}

		final double xN;
		final double yN;
		final double zN;

		xN = this.m11 * v.x + this.m12 * v.y + this.m13 * v.z;
		yN = this.m21 * v.x + this.m22 * v.y + this.m23 * v.z;
		zN = this.m31 * v.x + this.m32 * v.y + this.m33 * v.z;

		return new Vector3(xN, yN, zN);
	}

	/**
	 * Multiplication Point3 - Object with Matrix (Mat3x3)
	 * @param p Point3 - Object
	 * @return new Point3 - Object
	 */
	public Point3 mul(final Point3 p) {
		if (p == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}

		final double xP;
		final double yP;
		final double zP;

		xP = this.m11 * p.x + this.m12 * p.y + this.m13 * p.z;
		yP = this.m21 * p.x + this.m22 * p.y + this.m23 * p.z;
		zP = this.m31 * p.x + this.m32 * p.y + this.m33 * p.z;

		return new Point3(xP, yP, zP);
	}

	/**
	 * Changing the first column of given Matrix (Mat3x3) with Vector3 Attributes.
	 * @param Vector3 - Object
	 * @return new Mat3x3 - Object
	 */
	public Mat3x3 changeCol1(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Mat3x3(v.x, this.m12, this.m13, v.y, this.m22, this.m23, v.z, this.m32, this.m33);
	}

	/**
	 * Changing the second column of given Matrix (Mat3x3) with Vector3 Attributes. 
	 * @param Vector3 - Object
	 * @return new Mat3x3 - Object
	 */
	public Mat3x3 changeCol2(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Mat3x3(this.m11, v.x, this.m13, this.m21, v.y, this.m23, this.m31, v.z, this.m33);
	}

	/**
	 * Changing the third column of given Matrix (Mat3x3) with Vector3 Attributes.
	 * @param Vector3 - Object
	 * @return new Mat3x3 - Object
	 */
	public Mat3x3 changeCol3(final Vector3 v) {
		if (v == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		return new Mat3x3(this.m11, this.m12, v.x, this.m21, this.m22, v.y, this.m31, this.m32, v.z);
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(determinant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m11);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m12);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m13);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m21);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m22);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m23);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m31);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m32);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m33);
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
		Mat3x3 other = (Mat3x3) obj;
		if (Double.doubleToLongBits(determinant) != Double.doubleToLongBits(other.determinant)) {
			return false;
		}
		if (Double.doubleToLongBits(m11) != Double.doubleToLongBits(other.m11)) {
			return false;
		}
		if (Double.doubleToLongBits(m12) != Double.doubleToLongBits(other.m12)) {
			return false;
		}
		if (Double.doubleToLongBits(m13) != Double.doubleToLongBits(other.m13)) {
			return false;
		}
		if (Double.doubleToLongBits(m21) != Double.doubleToLongBits(other.m21)) {
			return false;
		}
		if (Double.doubleToLongBits(m22) != Double.doubleToLongBits(other.m22)) {
			return false;
		}
		if (Double.doubleToLongBits(m23) != Double.doubleToLongBits(other.m23)) {
			return false;
		}
		if (Double.doubleToLongBits(m31) != Double.doubleToLongBits(other.m31)) {
			return false;
		}
		if (Double.doubleToLongBits(m32) != Double.doubleToLongBits(other.m32)) {
			return false;
		}
		if (Double.doubleToLongBits(m33) != Double.doubleToLongBits(other.m33)) {
			return false;
		}
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Mat3x3 [m11=" + m11 + ", m12=" + m12 + ", m13=" + m13 + ", m21=" + m21 + ", m22=" + m22 + ", m23=" + m23
				+ ", m31=" + m31 + ", m32=" + m32 + ", m33=" + m33 + ", determinant=" + determinant + "]";
	}

}
