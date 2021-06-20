package Texture;

import Farben.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This Class represents the ImageTexture.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class ImageTexture implements Texture {
	/** path to texture */
	public static final String path = "Texturen/";

	/** color of texture */
	public final Color color;

	/** image for texture */
	public BufferedImage image;

	/**
	 * Constructor for ImageTexture
	 *
	 * @param color    - color
	 * @param pathTemp - String, path of image
	 */
	public ImageTexture(final Color color, final String pathTemp) {
		this.color = color;
		this.image = null;
		try {
			this.image = ImageIO.read(new File(path + pathTemp));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Skaling for texture from coordinates
	 */
	@Override
	public Color getColor(final double u, final double v) {
		final double coord1 = ImageTexture.toRelative(u);
		final double coord2 = ImageTexture.toRelative(v);
		final double x = (this.image.getWidth() - 1) * coord1;
		final double y = (this.image.getHeight() - 1) - ((image.getHeight() - 1) * coord2);
		return ImageTexture.positionToColor(this.image, (int) Math.round(x), (int) Math.round(y));
	}

	/**
	 * Gives relative coordinates for 2D
	 *
	 * @param d_var double
	 * @return relative coord
	 */
	public static double toRelative(final double d_var) {
		double d_out = d_var % 1.0;
		if (d_out < 0.0) {
			d_out = d_out + 1.0;
		}
		return d_out;
	}

	/**
	 * Color of Position in Image.
	 *
	 * @param image BufferedImage
	 * @param x     int coordinate for pixel in x
	 * @param y     int coordinate for pixel in x
	 * @return color
	 */
	public static Color positionToColor(final BufferedImage image, final int x, final int y) {
		final java.awt.Color c = new java.awt.Color(image.getRGB(x, y));
		return new Color(c);
	}

	/**
	 * Overriding hashcode for correct use within this class
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageTexture other = (ImageTexture) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "ImageTexture [color=" + color + ", image=" + image + "]";
	}
}
