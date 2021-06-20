package Texture;

import Farben.Color;

/**
 * This Class represents the SingleColorTexture.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class SingleColorTexture implements Texture {

	/** Color */
	public final Color color;

	/**
	 * Constructor Texture
	 * 
	 * @param c Color
	 */
	public SingleColorTexture(final Color c) {
		this.color = c;
	}

	/**
	 * Getter for color
	 */
	@Override
	public Color getColor(double u, double v) {

		return this.color;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "SingleColorTexture [color=" + color + "]";
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		SingleColorTexture other = (SingleColorTexture) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		return true;
	}
}