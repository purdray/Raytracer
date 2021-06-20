package Material;

import Farben.Color;
import Geometrie.Hit;
import Licht.Light;
import Texture.Texture;
import Welt.World;

/**
 * This Class creates a Single Color Material
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class SingleColorMaterial extends Material {

	/**
	 * Color object
	 */
	public final Color color;

	/**
	 * texture
	 */
	public final Texture texture;

	/**
	 * Constructor for SingleColorMaterial
	 * @param color - Color object
	 */
	public SingleColorMaterial(final Color color) {
		if (color == null) {
			throw new IllegalArgumentException("Input null");
		}
		this.color = color;
		
		this.color.r = this.color.r*255;
		this.color.g = this.color.g*255;
		this.color.b = this.color.b*255;
		
		this.texture = null;
	}
	/**
	 * Constructor for SingleColorMaterial
	 * @param texture - Texture
	 */
	public SingleColorMaterial(final Texture texture) {
		if (texture == null){
			throw new IllegalArgumentException("Input null");}
		this.texture = texture;
		this.color=null;
	}

	/**
	 * Method to assign a color
	 * @param hit   - Hit-Object
	 * @param world - World-Object
	 * @return color
	 */
	public Color colorFor(final Hit hit, final World world) {
		if (hit == null || world == null) {
			throw new IllegalArgumentException("Input is null");
		}
		if(this.texture != null) {
			Color cTemp = this.texture.getColor(hit.texCoord.u, hit.texCoord.v);
			/*
			cTemp.r = cTemp.r*255;
			cTemp.g = cTemp.g*255;
			cTemp.b = cTemp.b*255;
			*/

			for (Light light : world.lightList) {
//				Farben.Color lightColor = light.color;        
				if (light.illuminates(hit.ray.at(hit.t),world)) {
					
					return cTemp;
				}
			}
			return cTemp.mul(world.backgroundColor);

		}

		return this.color;

	}

	/**
	 * Overriding hachCode for correct use within this class
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleColorMaterial other = (SingleColorMaterial) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
	
	/**
	 * Overriding toString for correct use within this class
	 */
	@Override
	public String toString() {
		return "SingleColorMaterial [color=" + color + "]";
	}

}
