package Texture;

import Farben.Color;
/**
 * This Class represents an Interface for texture.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public interface Texture {
    /**
	 * Getter for Color
	 *
	 * @param u double u
	 * @param v double v
	 * @return color
	 */
	public Farben.Color getColor(final double u, final double v);
}