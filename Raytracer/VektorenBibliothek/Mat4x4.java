package VektorenBibliothek;
/**
 * This Class generates an Matri4x4-Object.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Mat4x4 {

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
	 * fourth component in first row
	 */
	final public double m14;

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
	 * fourth component in second row
	 */
	final public double m24;

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
	 * fourth component in third row
	 */
	final public double m34;

	/**
	 * first component in fourth row
	 */
	final public double m41;

	/**
	 * second component in fourth row
	 */
	final public double m42;

	/**
	 * third component in fourth row
	 */
	final public double m43;
	
	/**
	 * fourth component in fourth row
	 */
	final public double m44;

	/**
	 * Constructor for 4x4Matrix 
	 * 
	 * @param m11 - double - first component in first row
	 * @param m21 - double - first component in second row
	 * @param m31 - double - first component in third row
	 * @param m41 - double - first component in fourth row
	 * 
	 * @param m12 - double - second component in first row
	 * @param m22 - double - second component in second row
	 * @param m32 - double - second component in third row
	 * @param m42 - double - second component in fourth row
	 * 
	 * @param m13 - double - third component in first row
	 * @param m23 - double - third component in second row
	 * @param m33 - double - third component in third row
	 * @param m43 - double - third component in fourth row
	 * 
	 * @param m14 - double - fourth component in first row
	 * @param m24 - double - fourth component in first row
	 * @param m34 - double - fourth component in first row
	 * @param m44 - double - fourth component in fourth row
	 * 
	 */

	public Mat4x4(final double m11, final double m12, final double m13, final double m14, final double m21,
			final double m22, final double m23, final double m24, final double m31, final double m32, final double m33,
			final double m34, final double m41, final double m42, final double m43, final double m44) {

		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m14 = m14;

		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m24 = m24;

		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		this.m34 = m34;

		this.m41 = m41;
		this.m42 = m42;
		this.m43 = m43;
		this.m44 = m44;

	}

	/**
	 * Multiplication Vector3 - Object with Matrix (Mat3x3)
	 * 
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
		final double w = 0;

		xN = this.m11 * v.x + this.m12 * v.y + this.m13 * v.z + this.m14 * w;
		yN = this.m21 * v.x + this.m22 * v.y + this.m23 * v.z + this.m24 * w;
		zN = this.m31 * v.x + this.m32 * v.y + this.m33 * v.z + this.m34 * w;

		return new Vector3(xN, yN, zN);
	}

	/**
	 * Multiplication Point3 - Object with Matrix (Mat3x3)
	 * 
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
		final double w = 1;

		xP = this.m11 * p.x + this.m12 * p.y + this.m13 * p.z + this.m14 * w;
		yP = this.m21 * p.x + this.m22 * p.y + this.m23 * p.z + this.m24 * w;
		zP = this.m31 * p.x + this.m32 * p.y + this.m33 * p.z + this.m34 * w;

		return new Point3(xP, yP, zP);
	}

	/**
	 * Multiplication of the given Matrix (4x4 Matrix) with another Matrix
	 * 
	 * @param m Mat4x4 - Object
	 * @return new Mat4x4 - Object
	 */
	public Mat4x4 mul(final Mat4x4 m) {
		if (m == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		final double mN11;
		final double mN12;
		final double mN13;
		final double mN14;

		final double mN21;
		final double mN22;
		final double mN23;
		final double mN24;

		final double mN31;
		final double mN32;
		final double mN33;
		final double mN34;

		final double mN41;
		final double mN42;
		final double mN43;
		final double mN44;

		// Calculating the new 4x4Matrix rows and collumns

		mN11 = this.m11 * m.m11 + this.m12 * m.m21 + this.m13 * m.m31 + this.m14 * m.m41;
		mN21 = this.m21 * m.m11 + this.m22 * m.m21 + this.m23 * m.m31 + this.m24 * m.m41;
		mN31 = this.m31 * m.m11 + this.m32 * m.m21 + this.m33 * m.m31 + this.m34 * m.m41;
		mN41 = this.m41 * m.m11 + this.m42 * m.m21 + this.m43 * m.m31 + this.m44 * m.m41;

		mN12 = this.m11 * m.m12 + this.m12 * m.m22 + this.m13 * m.m32 + this.m14 * m.m42;
		mN22 = this.m21 * m.m12 + this.m22 * m.m22 + this.m23 * m.m32 + this.m24 * m.m42;
		mN32 = this.m31 * m.m12 + this.m32 * m.m22 + this.m33 * m.m32 + this.m34 * m.m42;
		mN42 = this.m41 * m.m12 + this.m42 * m.m22 + this.m43 * m.m32 + this.m44 * m.m42;

		mN13 = this.m11 * m.m13 + this.m12 * m.m23 + this.m13 * m.m33 + this.m14 * m.m43;
		mN23 = this.m21 * m.m13 + this.m22 * m.m23 + this.m23 * m.m33 + this.m24 * m.m43;
		mN33 = this.m31 * m.m13 + this.m32 * m.m23 + this.m33 * m.m33 + this.m34 * m.m43;
		mN43 = this.m41 * m.m13 + this.m42 * m.m23 + this.m43 * m.m33 + this.m44 * m.m43;

		mN14 = this.m11 * m.m14 + this.m12 * m.m24 + this.m13 * m.m34 + this.m14 * m.m44;
		mN24 = this.m21 * m.m14 + this.m22 * m.m24 + this.m23 * m.m34 + this.m24 * m.m44;
		mN34 = this.m31 * m.m14 + this.m32 * m.m24 + this.m33 * m.m34 + this.m34 * m.m44;
		mN44 = this.m41 * m.m14 + this.m42 * m.m24 + this.m43 * m.m34 + this.m44 * m.m44;

		return new Mat4x4(mN11, mN12, mN13, mN14, mN21, mN22, mN23, mN24, mN31, mN32, mN33, mN34, mN41, mN42, mN43,
				mN44);
	}

	/**
	 * @return returns a transposed Matrix
	 */
	public Mat4x4 transposed() {
		return new Mat4x4(m11, m21, m31, m41, m12, m22, m32, m42, m13, m23, m33, m43, m14, m24, m34, m44);
	}
}