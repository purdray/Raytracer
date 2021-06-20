package Material;


import Geometrie.Hit;
import Welt.World;
/**
 * Superclass of Material
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public abstract class Material {

	/**
	 * Abstract-Class for Color-extraction of Material-Classes
	 * @param hit - Hit object
	 * @param world - World object
	 * @return color
	 */
    public abstract Farben.Color colorFor(final Hit hit, final World world);
	
    

}
