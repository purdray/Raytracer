package Raytracer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import Geometrie.Hit;
import Strahl.Ray;
import Welt.World;
import Kamera.Camera;

/**
 * This Class creates an (buffered) image from the given components.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class Draw {

	private final Camera camera;
	private final World world;
	public int breite;
	public int hoehe;
	public int start = 0;
	private final BufferedImage buffImg;
	private final Raytracer raytracer;

	/**
	 * Constructor for Draw-object
	 * 
	 * @param breite - int for Width of the Image
	 * @param hoehe  - int for Height of the Image
	 * @param world  - world with geometry
	 * @param camera - used camera-type
	 */
	public Draw(final int breite, final int hoehe, final World world, final Camera camera) {

		if (world == null || camera == null) {

			throw new IllegalArgumentException("Null not allowed! Please check your inputs!");
		}

		this.breite = breite;
		this.hoehe = hoehe;
		this.world = world;
		this.camera = camera;

		buffImg = drawPic(breite, hoehe, start);
		raytracer = new Raytracer(buffImg);
	}

	/**
	 * 
	 * @param breite - int for Width of the Image
	 * @param hoehe  - int for Height of the Image
	 * @param start  - int for Starting-point of the Image
	 * @return returns a buffered image, that gets added to the image object later
	 *         on.
	 */
	private BufferedImage drawPic(final int breite, final int hoehe, final int start) {

		this.start = start;

		final BufferedImage imageTemp = new BufferedImage(breite, hoehe, BufferedImage.TYPE_INT_ARGB);
		final WritableRaster raster = imageTemp.getRaster();
		final ColorModel model = imageTemp.getColorModel();

		Color black = Color.black;
		int bRGB = black.getRGB();
		final Object pixelSchwarz = model.getDataElements(bRGB, null);

		Ray rayTemp;
		Hit hitTemp;
		for (int i = start; i < breite; i++) { // x
			for (int j = start; j < hoehe; j++) { // y
				rayTemp = null;
				hitTemp = null;

				rayTemp = camera.rayFor(breite, hoehe, i, j);

				hitTemp = world.hit(rayTemp);

				/**
				 * Ray hits object from the world
				 */
				if (hitTemp != null) {

					int testFarbe = hitTemp.geo.material.colorFor(hitTemp, world).getFarbe();

					Object geoFarbe = model.getDataElements(testFarbe, null);

					raster.setDataElements(i, hoehe - j - 1, geoFarbe);
				}

				if (hitTemp == null) {

					raster.setDataElements(i, hoehe - j - 1, pixelSchwarz);
				}

			}
		}

		return imageTemp;
	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "Draw [camera=" + camera + ", world=" + world + ", breite=" + breite + ", hoehe=" + hoehe + ", start="
				+ start + ", buffImg=" + buffImg + ", raytracer=" + raytracer + "]";
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + breite;
		result = prime * result + ((buffImg == null) ? 0 : buffImg.hashCode());
		result = prime * result + ((camera == null) ? 0 : camera.hashCode());
		result = prime * result + hoehe;
		result = prime * result + ((raytracer == null) ? 0 : raytracer.hashCode());
		result = prime * result + start;
		result = prime * result + ((world == null) ? 0 : world.hashCode());
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
		Draw other = (Draw) obj;
		if (breite != other.breite) {
			return false;
		}
		if (buffImg == null) {
			if (other.buffImg != null) {
				return false;
			}
		} else if (!buffImg.equals(other.buffImg)) {
			return false;
		}
		if (camera == null) {
			if (other.camera != null) {
				return false;
			}
		} else if (!camera.equals(other.camera)) {
			return false;
		}
		if (hoehe != other.hoehe) {
			return false;
		}
		if (raytracer == null) {
			if (other.raytracer != null) {
				return false;
			}
		} else if (!raytracer.equals(other.raytracer)) {
			return false;
		}
		if (start != other.start) {
			return false;
		}
		if (world == null) {
			if (other.world != null) {
				return false;
			}
		} else if (!world.equals(other.world)) {
			return false;
		}
		return true;
	}
}
