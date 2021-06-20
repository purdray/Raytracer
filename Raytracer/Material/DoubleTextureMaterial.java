package Material;

import Farben.Color;
import Licht.Light;
import Texture.Texture;
import Welt.World;
import Geometrie.Hit;
/**
 * This Class represents a DoubleTextureMaterial.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class DoubleTextureMaterial extends Material {
  
    public final Texture textureA;
    

    public final Texture textureB;
    
    /**
	 * Constructor
	 * @param textureA - Light_Texture
     * @param textureB - Shadow_Texture
	 */
	public DoubleTextureMaterial(final Texture textureA, final Texture textureB) {
		if (textureA == null || textureB == null){
            throw new IllegalArgumentException("Input null");}
            
        this.textureA = textureA;
        this.textureB = textureB;
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
            Color cTempA = this.textureA.getColor(hit.texCoord.u, hit.texCoord.v);
            Color cTempB = this.textureB.getColor(hit.texCoord.u, hit.texCoord.v);
			/*
			cTemp.r = cTemp.r*255;
			cTemp.g = cTemp.g*255;
			cTemp.b = cTemp.b*255;
			*/

			for (Light light : world.lightList) {       
				if (light.illuminates(hit.ray.at(hit.t),world)) {
					
					return this.textureA.getColor(hit.texCoord.u, hit.texCoord.v);
                }
                else{
                    return this.textureB.getColor(hit.texCoord.u, hit.texCoord.v);
                }
			}
			return this.textureB.getColor(hit.texCoord.u, hit.texCoord.v);

	}

	/**
	 * Overriding hashCode for correct use within this class
	 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((textureA == null) ? 0 : textureA.hashCode());
        result = prime * result + ((textureB == null) ? 0 : textureB.hashCode());
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
        DoubleTextureMaterial other = (DoubleTextureMaterial) obj;
        if (textureA == null) {
            if (other.textureA != null)
                return false;
        } else if (!textureA.equals(other.textureA))
            return false;
        if (textureB == null) {
            if (other.textureB != null)
                return false;
        } else if (!textureB.equals(other.textureB))
            return false;
        return true;
    }

	/**
	 * Overriding toString for correct use within this class
	 */
    @Override
    public String toString() {
        return "DoubleTexture [textureA=" + textureA + ", textureB=" + textureB + "]";
    }
}