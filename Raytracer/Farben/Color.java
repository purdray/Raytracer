package Farben;

/**
 * This Class represents a Color.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */

public class Color {
	
	/**
	 * red value, the value is either 0 or 1
	 */
	public double r;
	
	/**
	 * green value, the value is either 0 or 1
	 */
	public double g;
	
	/**
	 * blue value, the value is either 0 or 1
	 */
	public double b;
	
	/**
	 * Sets the Color values to either 0 (Not displaying color)
	 * or 1 (displaying color)
	 * @param r - Red color value
	 * @param g - Green color value
	 * @param b - Blue color value
	 */
	public Color(final double r, final double g, final double b) {

		/**
		 * Sets the r value to either 0 or 1
		 */
		if(r > 1.0) {
			this.r = 1.0;
		}
		else if(r < 0)  {
			this.r = 0.0;
		}
		
		/**
		 * Sets the g value to either 0 or 1
		 */
		if(g > 1.0) {
			this.g = 1.0;
		}
		else if(g < 0){
			this.g = 0.0;
		}
		
		/**
		 * Sets the b value to either 0 or 1
		 */
		if(b > 1.0) {
			this.b = 1.0;
		}
		else if(b < 0){
			this.b = 0.0;
		}	
		this.r = r;

		this.g = g;

		this.b = b;
	}

	/**
	 * Converts java.awt.color Objects
	 * @param color
	 */
	public Color(java.awt.Color color) {
        this.r = color.getRed();
        this.g = color.getGreen();
        this.b = color.getBlue();
    }
	
	/**
	 * Method to returns the given color
	 */
	public int getFarbe() {
		int red;
		int green;
		int blue;
	
		red = (int)this.r;
		green = (int)this.g;
		blue = (int)this.b;

        red = (red << 16) & 0x00FF0000;
       	green = (green << 8) & 0x0000FF00;
		blue = (blue << 0) & 0x000000FF;
			
		return 0xFF000000 | red | green | blue;
    }


	/**
	 * Method to add colors
	 * @param c - Color object
	 * @return Addition of Color and Color
	 */
	public Color add(final Color c) {
		if (c == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}

		return new Color(this.r + c.r, this.g + c.g, this.b + c.b);

	}

	/**
	 * Method to substract colors
	 * @param c - Color object
	 * @return Substraction of Color and Color
	 */
	public Color sub(final Color c) {
		if (c == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}

		return new Color(this.r - c.r, this.g - c.g, this.b - c.b);
	}

	/**
	 * Method to multiply colors
	 * @param c - Color value
	 * @return Multiplication of Color and Color
	 */
	public Color mul(final Color c) {
		if (c == null) {
			throw new NullPointerException("Attribute Null not allowed. Please check you inputs.");
		}
		
		Color colorTemp = new Color(this.r * c.r, this.g * c.g, this.b * c.b);
		//if(colorTemp.r>1 || colorTemp.g >1 || colorTemp.b >1){throw new NullPointerException();}
		return colorTemp;
	}

	/**
	 * Method to multiply colors with another double
	 * @param c - double value
	 * @return Multiplication of Color and double
	 */
	public Color mul(final double v) {	
			
		return new Color(this.r * v, this.g * v, this.b * v);
		
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(g);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Overriding equals for correct use within this class.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Color other = (Color) obj;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(g) != Double.doubleToLongBits(other.g))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
	
}
