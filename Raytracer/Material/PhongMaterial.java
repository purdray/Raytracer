package Material;

import Farben.Color;
import Geometrie.Hit;
import Licht.Light;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;
import Welt.World;

/**
 * This Class creates a Phong Material
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class PhongMaterial extends Material {
	public final Farben.Color diffuse;
	public final Farben.Color specular;
	public final int exponent;

	/**
	 * Constructor for Phongmaterial
	 * @param diffuse  - Color
	 * @param specular - Color
	 * @param exponent - int
	 */
	public PhongMaterial(final Color diffuse, final Color specular, final int exponent) {
		if (diffuse == null || specular == null) {
			throw new IllegalArgumentException("The Hit cannot be null!");
		}

		this.diffuse = diffuse;
		this.specular = specular;
		this.exponent = exponent;
	}

	/**
	 * Method for Color-Extraction of LambertMaterial
	 * @param hit - given Hit-object
	 * @param world - given World
	 * @return color
	 */
	@Override
	public Color colorFor(final Hit hit, final World world) {
		if (hit == null || world == null) {
			throw new IllegalArgumentException("The Hit cannot be null!");
		}

		final Normal3 normal = hit.normal;
		final Point3 point = hit.ray.at(hit.t);
		Farben.Color colorTemp = world.backgroundColor.mul(diffuse);
		final Vector3 e = (hit.ray.d.mul(-1)).normalized();
		Farben.Color lightColor =new Color(0,0,0);

		for (Light light : world.lightList) {
			if (light.illuminates(hit.ray.at(hit.t),world)) {

				final Vector3 lightVector = light.directionFrom(point).normalized();
				final Vector3 reflectedVector = lightVector.reflectedOn(normal);

				final double maxL = Math.max(0.0, lightVector.dot(normal));
				final double maxR = Math.pow(
						Math.max(0.0, reflectedVector.dot(e)), exponent);

				lightColor = lightColor
						.add(light.color.mul(diffuse).mul(maxL)).add(
								light.color.mul(specular).mul(maxR));

				colorTemp = colorTemp.add(lightColor);
			}
		}
		
		return colorTemp;
	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diffuse == null) ? 0 : diffuse.hashCode());
		result = prime * result + exponent;
		result = prime * result + ((specular == null) ? 0 : specular.hashCode());
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
		PhongMaterial other = (PhongMaterial) obj;
		if (diffuse == null) {
			if (other.diffuse != null) {
				return false;
			}
		} else if (!diffuse.equals(other.diffuse)) {
			return false;
		}
		if (exponent != other.exponent) {
			return false;
		}
		if (specular == null) {
			if (other.specular != null) {
				return false;
			}
		} else if (!specular.equals(other.specular)) {
			return false;
		}
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "PhongMaterial [diffuse=" + diffuse + ", specular=" + specular + ", exponent=" + exponent + "]";
	}
}
