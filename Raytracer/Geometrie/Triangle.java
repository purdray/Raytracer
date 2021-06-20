package Geometrie;

import VektorenBibliothek.*;
import Material.*;
import Strahl.Ray;
import Texture.TexCoord2;

/**
 * This Class represents a Triangle.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Triangle extends Geometry {

	/**
	 * Point a of the triangle
	 */
	public final Point3 a;

	/**
	 * Point b of the triangle
	 */
	public final Point3 b;

	/**
	 * Point c of the triangle
	 */
	public final Point3 c;

	public final Normal3 normal;
	public final Normal3 an;
	public final Normal3 bn;
	public final Normal3 cn;

	/**
	 * Creates a Triangle with 3 Points
	 * 
	 * @param material - Material for the triangle
	 * @param a        - Point a of the triangle
	 * @param b        - Point b of the triangle
	 * @param c        - Point c of the triangle
	 */
	public Triangle(final Material material, final Point3 a, final Point3 b, final Point3 c) {
		super(material);
		if (a == null || b == null || c == null) {
			throw new IllegalArgumentException("The Point a of the Triangle cannot be null!");
		}

		this.a = a;
		this.b = b;
		this.c = c;

		Point3 schwerpunkt = new Point3((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3, (a.z + b.z + c.z) / 3);
		this.an = schwerpunkt.sub(a).asNormal();
		this.bn = schwerpunkt.sub(b).asNormal();
		this.cn = schwerpunkt.sub(c).asNormal();

		normal = b.sub(a).x(c.sub(a)).normalized().asNormal();

	}

	/**
	 * Method to check if there's a hit between a Ray and a triangle
	 */
	@Override
	public Hit hit(final Ray r) {
		if (r == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
		final TexCoord2 texA = pointToTex(a);
		final TexCoord2 texB = pointToTex(b);
		final TexCoord2 texC = pointToTex(c);

		final Mat3x3 matA = new Mat3x3(a.x - b.x, a.x - c.x, r.d.x, a.y - b.y, a.y - c.y, r.d.y, a.z - b.z, a.z - c.z,
				r.d.z);

		final Vector3 vec = a.sub(r.o);
		final double beta = matA.changeCol1(vec).determinant / matA.determinant;
		final double gamma = matA.changeCol2(vec).determinant / matA.determinant;
		final double t = matA.changeCol3(vec).determinant / matA.determinant;

		if (beta < 0 || gamma < 0 || (beta + gamma) > 1 || t < 0.0001) {
			return null;
		} else {
			final double alpha = 1.0 - beta - gamma;
			final Normal3 n = an.mul(alpha).add(bn.mul(beta)).add(cn.mul(gamma));
			final TexCoord2 texCoord = texA.mul(alpha).add(texB).mul(beta).add(texC).mul(gamma);
			return new Hit(t, r, this, n, texCoord);
		}

	}


	/**
	 * Coordinates for textures 2D
	 * @param point - given point for center of texture
	 * @return TextCoord
	 */
	private TexCoord2 pointToTex(final Point3 point){
		if (point == null) {
			throw new IllegalArgumentException("The Ray cannot be null!");
		}
		
		double pU = point.x - point.z;
		double pV   = point.y - point.z;
		
		return  new TexCoord2(pU, pV);
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
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
		Triangle other = (Triangle) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

}
