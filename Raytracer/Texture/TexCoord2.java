package Texture;

/**
 * This Class represents the Texture-Coordinates.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class TexCoord2 {
	/** u */
	public double u;

	/** v */
	public double v;

	/**
	 * Constructor for TextCoord2
	 * 
	 * @param u u
	 * @param v v
	 */
	public TexCoord2(final double u, final double v) {

		this.u = u;
		this.v = v;

	}

	/**
	 * Addition
	 *
	 * @param t - TexCoord2
	 * @return TexCoord2
	 */
	public TexCoord2 add(final TexCoord2 t) {
		return new TexCoord2(u + t.u, v + t.v);
	}

	/**
	 * Multiplication
	 *
	 * @param a - double Factor
	 * @return TexCoord2
	 */
	public TexCoord2 mul(final double a) {
		return new TexCoord2(u * a, v * a);
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "TexCoord2 [u=" + u + ", v=" + v + "]";
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(u);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Overriding equals for correct use within this class
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
		TexCoord2 other = (TexCoord2) obj;
		if (Double.doubleToLongBits(u) != Double.doubleToLongBits(other.u)) {
			return false;
		}
		if (Double.doubleToLongBits(v) != Double.doubleToLongBits(other.v)) {
			return false;
		}
		return true;
	}
}