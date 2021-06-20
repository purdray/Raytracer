package Texture;

import Farben.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This Class represents the InterPolatedImageTexture.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class InterpolatedImageTexture implements Texture {

	/**
	 * path to texture
	 */
	public static final String path2 = "Texturen/";

	/** color */
	public final Color color;

	/** image */
	public BufferedImage image;

	/**
	 * Constructor for InterPolatedTexture
	 * 
	 * @param color    - color
	 * @param pathTemp - String, path of image
	 */
	public InterpolatedImageTexture(final Color color, final String pathTemp) {
		this.color = color;
		this.image = null;
		try {
			this.image = ImageIO.read(new File(path2 + pathTemp));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Color mapping for image sharpness
	 */
	@Override
	public Color getColor(final double u, final double v) {

		final double uR = ImageTexture.toRelative(u);
		final double vR = ImageTexture.toRelative(v);

		final double x = (this.image.getWidth() - 1) * uR;
		final double y = (this.image.getHeight() - 1) - ((image.getHeight() - 1) * vR);

		final double xInter = x - Math.floor(x);
		final double yInter = y - Math.floor(y);

		final Color colorA = ImageTexture.positionToColor(this.image, (int) Math.floor(x), (int) Math.floor(y));
		final Color colorB = ImageTexture.positionToColor(this.image, (int) Math.ceil(x), (int) Math.floor(y));
		final Color colorC = ImageTexture.positionToColor(this.image, (int) Math.floor(x), (int) Math.ceil(y));
		final Color colorD = ImageTexture.positionToColor(this.image, (int) Math.ceil(x), (int) Math.ceil(y));

		final Color colorAB = colorA.mul(1.0 - xInter).add(colorB.mul(xInter));
		final Color colorCD = colorC.mul(1.0 - xInter).add(colorD.mul(xInter));

		return colorAB.mul(1.0 - yInter).add(colorCD.mul(yInter));
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "InterpolatedImageTexture [color=" + color + ", image=" + image + "]";
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		InterpolatedImageTexture other = (InterpolatedImageTexture) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (image == null) {
			if (other.image != null) {
				return false;
			}
		} else if (!image.equals(other.image)) {
			return false;
		}
		return true;
	}
}