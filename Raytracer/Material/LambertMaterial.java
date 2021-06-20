package Material;

import Farben.Color;
import Geometrie.Hit;
import Welt.World;
import Licht.Light;
import VektorenBibliothek.Vector3;

/**
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class LambertMaterial extends Material {

	public Color color;

	/**
	 * LambertMaterial constructor
	 * @param color - Color
	 */
	public LambertMaterial(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("The Hit cannot be null!");
		}
		
		this.color = color;
		
	}
	
	/**
	 * Method for Color-Extraction of LambertMaterial
	 * @param hit - given Hit-object
	 * @param world - given World
	 * @return Color
	 */
    @Override
    public Farben.Color colorFor(final Hit hit, final World world) {
        if (hit == null || world == null) {      	
        	throw new IllegalArgumentException("The Hit cannot be null!");
		}

        Farben.Color colorTemp = this.color.mul(world.backgroundColor);

        for (Light light : world.lightList) {
            Farben.Color lightColor = light.color;        
			if (light.illuminates(hit.ray.at(hit.t),world)) {
				final Vector3 lightVector = light.directionFrom(hit.ray.at(hit.t)).normalized();
				final double max = Math.max(0.0, lightVector.dot(hit.normal));
				colorTemp = colorTemp.add(color.mul(lightColor).mul(max));
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
		LambertMaterial other = (LambertMaterial) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		return true;
	}

	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "LambertMaterial [color=" + color + "]";
	}
             
}