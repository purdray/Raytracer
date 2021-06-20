package Raytracer;

import java.util.ArrayList;

import Farben.Color;
import Geometrie.Box;
import Geometrie.BoxTrans;
import Geometrie.Disk;
import Geometrie.Geometry;
import Geometrie.Plane;
import Geometrie.Sphere;
import Geometrie.SphereTrans;
import Geometrie.Triangle;
import Kamera.OrthographicCamera;
import Kamera.PerspectiveCamera;
import Licht.DirectionalLight;
import Licht.Light;
import Licht.PointLight;
import Texture.ImageTexture;
import Texture.InterpolatedImageTexture;
import VektorenBibliothek.Normal3;
import VektorenBibliothek.Point3;
import VektorenBibliothek.Vector3;
import Welt.World;

/**
 * This Class creates the inputs for raytracing. geometry, camera, light and
 * texture.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class GeoController {

	private int modus = 0;

	/**
	 * 
	 * @param modus int for scene selection 0 is default 1 for an old scene 2 for
	 *              Art 3 for the latest scene with perspective camera
	 *              --------------dreick entfernen 4 for the latest scene with
	 *              orthographic camera 5 for the latest scene
	 *              ----------------------------------- Sinnlos?
	 */
	public GeoController(int modus) {

		final Normal3 a = new Normal3(0, 1, 0);
		final Point3 n = new Point3(0, 0, 0);
		final Farben.Color color = new Farben.Color(0.8, 0.8, 0.8);
		final Farben.Color color2 = new Farben.Color(0.54, 0.27, 0.07);
		final Material.LambertMaterial diffuse = new Material.LambertMaterial(color);
		final Material.LambertMaterial diffuse2 = new Material.LambertMaterial(color2);
		final Material.LambertMaterial diffuse3 = new Material.LambertMaterial(new Color(0.7, 0.7, 0.7));
		final Material.LambertMaterial diffuse4 = new Material.LambertMaterial(new Color(0.85, 0.65, 0.125));
		final Material.LambertMaterial diffuse5 = new Material.LambertMaterial(new Color(0.9, 0.75, 0.2));
		final Material.LambertMaterial diffuse6 = new Material.LambertMaterial(new Color(1.0, 0.65, 0.65));

		final Point3 p = new Point3(15, 15, 2);
		final Farben.Color pointColor = new Farben.Color(1.0, 1.0, 1.0);
		final PointLight pointLight = new PointLight(pointColor, p, true);
//		final DirectionalLight dirLight = new DirectionalLight(pointColor, new Vector3(-1, -1, -1), true);

		final Material.SingleColorMaterial materialSingle = new Material.SingleColorMaterial(
				new Farben.Color(0.1, 0.1, 0.2));
		final Material.SingleColorMaterial materialSingle2 = new Material.SingleColorMaterial(new Color(1.0, 1.0, 0.0));
//		final Material.SingleColorMaterial textureTest1 = new Material.SingleColorMaterial(
//				new ImageTexture(new Color(1, 1, 1), "erdeNacht.jpg"));
		final Material.SingleColorMaterial textureTest2 = new Material.SingleColorMaterial(
				new ImageTexture(new Color(1, 1, 1), "Steinboden_002.jpg"));
		final Material.SingleColorMaterial textureTest3 = new Material.SingleColorMaterial(
				new ImageTexture(new Color(0.9, 0.9, 0.9), "dreieck_001.jpg"));
		final Material.SingleColorMaterial textureTest4 = new Material.SingleColorMaterial(
				new InterpolatedImageTexture(new Color(1, 1, 1), "erdeNacht.jpg"));
		final Material.SingleColorMaterial textureTest5 = new Material.SingleColorMaterial(
				new InterpolatedImageTexture(new Color(1, 1, 1), "sauron_001.jpg"));

//		final Material.PhongMaterial pMaterial = new Material.PhongMaterial(new Farben.Color(0.86,0.08,0.23), new Farben.Color(0.2,0.9,0) , 16);		

		final Material.PhongMaterial pMaterial = new Material.PhongMaterial(new Farben.Color(0.86, 0.08, 0.23),
				new Farben.Color(0.2, 0.9, 0), 32);

		final Point3 e = new Point3(20, 20, 20);
		final Vector3 g = new Vector3(-1, -1, -1);
		final Vector3 t = new Vector3(0, 1, 0);
		final double angle = (Math.PI / 4);
		final PerspectiveCamera cam = new PerspectiveCamera(e, g, t, angle);

		final double skaling = 25;
		final OrthographicCamera oCam = new OrthographicCamera(e, g, t, skaling);

		/*
		 * Way to goal Inputs and modus
		 */
		if (modus == 1) {

			final Point3 punktC = new Point3(6, 6.5, 4);
			final double r = 1;
			final SphereTrans kugelC = new SphereTrans(punktC, r, textureTest4);
			// final Point3 punktC1 = new Point3(6, 8.5, 4);
			// final SphereTrans kugelC1 = new SphereTrans(punktC1, r,textureTest4);

			final Plane ebene = new Plane(n, a, textureTest3);

			// final Triangle dreieck1= new Triangle(textureTest3,new Point3(7,6.95,4),new
			// Point3(7.05,7.4,3.95), new Point3(6.95,7.3,4.05));
			final Triangle dreieck1 = new Triangle(materialSingle2, new Point3(7, 10, 2), new Point3(7, 7, -2),
					new Point3(7, 13, 0));

//			final Box wuerfel1 = new Box(pMaterial, new Point3(-1.5, 0.5, 0.5), new Point3(-0.5, 1.5, 1.5));

			final Box tb1 = new Box(textureTest2, new Point3(2, 0, 0), new Point3(3, 5, 1));
			final Box tb2 = new Box(textureTest2, new Point3(6, 0, 0), new Point3(7, 5, 1));
			final Box tb3 = new Box(textureTest2, new Point3(2, 0, 5), new Point3(3, 5, 6));
			final Box tb4 = new Box(textureTest2, new Point3(6, 0, 5), new Point3(7, 5, 6));
			final Box tp = new Box(textureTest2, new Point3(2, 5, 0), new Point3(7, 6, 6));
			final BoxTrans bT = new BoxTrans(materialSingle2, new Point3(2, 6, 5), new Point3(3, 7, 6));

			bT.Node.transform = bT.Node.transform.rotateZ(Math.PI * 0.2).rotateY(Math.PI * 0.2);
			final Disk plate = new Disk(diffuse5, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.0);
			final Disk innerPlate = new Disk(diffuse3, new Point3(3, 6.1, 2), 0.8, new Normal3(0, 1, 0), 0.0);
			final Disk outerRing = new Disk(diffuse4, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.9);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();
			geoList.add(ebene);
			// geoList.add(wuerfel1);

			geoList.add(tb1);
			geoList.add(tb2);
			geoList.add(tb3);
			geoList.add(tb4);
			geoList.add(tp);
			geoList.add(kugelC);
			geoList.add(dreieck1);
			geoList.add(plate);
			geoList.add(innerPlate);
			geoList.add(outerRing);
			geoList.add(bT);

			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);

		}

		/*
		 * Stillleben Plate, table and Earth Inputs and modus
		 */
		if (modus == 2) {

			final Point3 punktC = new Point3(6, 6.5, 4);
			final double r = 1;
			final SphereTrans kugelC = new SphereTrans(punktC, r, textureTest4);
			// final Point3 punktC1 = new Point3(6, 8.5, 4);
			// final SphereTrans kugelC1 = new SphereTrans(punktC1, r,textureTest4);

			final Plane ebene = new Plane(n, a, textureTest3);

			// final Triangle dreieck1= new Triangle(textureTest3,new Point3(7,6.95,4),new
			// Point3(7.05,7.4,3.95), new Point3(6.95,7.3,4.05));
//			final Triangle dreieck1= new Triangle(materialSingle2,new Point3(7,10,2),new Point3(7,7,-2), new Point3(7,13,0));

//			final Box wuerfel1 = new Box(pMaterial,new Point3(-1.5,0.5,0.5), new Point3(-0.5,1.5,1.5));

			final Box tb1 = new Box(textureTest2, new Point3(2, 0, 0), new Point3(3, 5, 1));
			final Box tb2 = new Box(textureTest2, new Point3(6, 0, 0), new Point3(7, 5, 1));
			final Box tb3 = new Box(textureTest2, new Point3(2, 0, 5), new Point3(3, 5, 6));
			final Box tb4 = new Box(textureTest2, new Point3(6, 0, 5), new Point3(7, 5, 6));
			final Box tp = new Box(textureTest2, new Point3(2, 5, 0), new Point3(7, 6, 6));
//			final BoxTrans bT = new BoxTrans(materialSingle2,new Point3(2,6,5), new Point3(3,7,6));

			final Disk plate = new Disk(diffuse5, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.0);
			final Disk innerPlate = new Disk(diffuse3, new Point3(3, 6.1, 2), 0.8, new Normal3(0, 1, 0), 0.0);
			final Disk outerRing = new Disk(diffuse4, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.9);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();
			geoList.add(ebene);
			// geoList.add(wuerfel1);

			geoList.add(tb1);
			geoList.add(tb2);
			geoList.add(tb3);
			geoList.add(tb4);
			geoList.add(tp);
			geoList.add(kugelC);
//			geoList.add(dreieck1);
			geoList.add(plate);
			geoList.add(innerPlate);
			geoList.add(outerRing);
//			geoList.add(bT);

			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);

		}

		/*
		 * Standard-Modus with Perpective camera Inputs and modus
		 */
		if (modus == 5) {

			final Point3 punktC = new Point3(6, 6.5, 4);
			final double r = 1;
			final SphereTrans kugelC = new SphereTrans(punktC, r, textureTest4);
			// final Point3 punktC1 = new Point3(6, 8.5, 4);
			// final SphereTrans kugelC1 = new SphereTrans(punktC1, r,textureTest4);

			final Plane ebene = new Plane(n, a, textureTest3);

			// final Triangle dreieck1= new Triangle(textureTest3,new Point3(7,6.95,4),new
			// Point3(7.05,7.4,3.95), new Point3(6.95,7.3,4.05));
			final Triangle dreieck1 = new Triangle(materialSingle2, new Point3(7, 10, 2), new Point3(7, 7, -2),
					new Point3(7, 13, 0));

			/*
			 * tiefe*hoehe*breite(erster Punkt gibt start zweiter punkt gibt
			 * ende...Kantenlenge ist der Abstand zwischen beiden)
			 */
//			final Box wuerfel1 = new Box(pMaterial, new Point3(-1.5, 0.5, 0.5), new Point3(-0.5, 1.5, 1.5));

			final Box tb1 = new Box(textureTest2, new Point3(2, 0, 0), new Point3(3, 5, 1));
			final Box tb2 = new Box(textureTest2, new Point3(6, 0, 0), new Point3(7, 5, 1));
			final Box tb3 = new Box(textureTest2, new Point3(2, 0, 5), new Point3(3, 5, 6));
			final Box tb4 = new Box(textureTest2, new Point3(6, 0, 5), new Point3(7, 5, 6));
			final Box tp = new Box(textureTest2, new Point3(2, 5, 0), new Point3(7, 6, 6));
			final BoxTrans bT = new BoxTrans(materialSingle2, new Point3(2, 6, 5), new Point3(3, 7, 6));

			bT.Node.transform = bT.Node.transform.rotateZ(Math.PI * 0.2).rotateY(Math.PI * 0.2);
			final Disk plate = new Disk(diffuse5, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.0);
			final Disk innerPlate = new Disk(diffuse3, new Point3(3, 6.1, 2), 0.8, new Normal3(0, 1, 0), 0.0);
			final Disk outerRing = new Disk(diffuse4, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.9);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();
			geoList.add(ebene);
			// geoList.add(wuerfel1);

			geoList.add(tb1);
			geoList.add(tb2);
			geoList.add(tb3);
			geoList.add(tb4);
			geoList.add(tp);
			geoList.add(kugelC);
			geoList.add(dreieck1);
			geoList.add(plate);
			geoList.add(innerPlate);
			geoList.add(outerRing);
			geoList.add(bT);

			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);

		}

		if (modus == 6) {

			final double r1 = 7;
			final Point3 punktC1 = new Point3(6, 5, 6);
			final SphereTrans kugelC1 = new SphereTrans(punktC1, r1, textureTest4);

			/*
			 * ------> so kommt man von aussen an die transform Klasse heran um hier noch
			 * veraenderung am objekt zu ermoeglichen Kugel wurde hier nach der init noch
			 * veraendert...geht nur bei den Geometrien mit trans im Namen
			 * 
			 * weitere veraenderung hier mit "." anhaengen (.translate() bspw )
			 */
			kugelC1.Node.transform = kugelC1.Node.transform.rotateY(-Math.PI / 1.3).rotateX(Math.PI / 5);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();

			geoList.add(kugelC1);

			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);
		}

		if (modus == 7) {

			final double r1 = 7;
			final Point3 punktC1 = new Point3(6, 5, 6);
			final SphereTrans kugelC1 = new SphereTrans(punktC1, r1, textureTest5);

			/*
			 * ------> so kommt man von aussen an die transform Klasse heran um hier noch
			 * veraenderung am objekt zu ermoeglichen Kugel wurde hier nach der init noch
			 * veraendert...geht nur bei den Geometrien mit trans im Namen
			 * 
			 * weitere veraenderung hier mit "." anhaengen (.translate() bspw )
			 */
			kugelC1.Node.transform = kugelC1.Node.transform.rotateY(-Math.PI / 1.3).rotateX(Math.PI / 5);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();

			geoList.add(kugelC1);

			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);
		}

		/*
		 * Standard-Modus with orthographic camera Inputs and modus
		 */
		if (modus == 4) {

			final Point3 punktC = new Point3(6, 6.5, 4);
			final double r = 1;
			final double r1 = 7;
			final SphereTrans kugelC = new SphereTrans(punktC, r, pMaterial);
			final Point3 punktC1 = new Point3(0, 7, 0);
			final SphereTrans kugelC1 = new SphereTrans(punktC1, r1, textureTest4);

			/*
			 * ------> so kommt man von aussen an die transform Klasse heran um hier noch
			 * veraenderung am objekt zu ermoeglichen Kugel wurde hier nach der init noch
			 * veraendert...geht nur bei den Geometrien mit trans im Namen
			 * 
			 * weitere veraenderung hier mit "." anhaengen (.translate() bspw )
			 */
			kugelC1.Node.transform = kugelC1.Node.transform.rotateY(-Math.PI / 1.3);

			final Plane ebene = new Plane(n, a, textureTest3);

			// final Triangle dreieck1= new Triangle(textureTest3,new Point3(7,6.95,4),new
			// Point3(7.05,7.4,3.95), new Point3(6.95,7.3,4.05));

			final Triangle dreieck1 = new Triangle(materialSingle2, new Point3(7, 10, 2), new Point3(7, 7, -2),
					new Point3(7, 13, 0));

			/*
			 * tiefe*hoehe*breite(erster Punkt gibt start zweiter punkt gibt
			 * ende...Kantenlenge ist der Abstand zwischen beiden)
			 */
			// final Box wuerfel1 = new Box(pMaterial, new Point3(-1.5, 0.5, 0.5), new
			// Point3(-0.5, 1.5, 1.5));

			final Box tb1 = new Box(textureTest2, new Point3(2, 0, 0), new Point3(3, 5, 1));
			final Box tb2 = new Box(textureTest2, new Point3(6, 0, 0), new Point3(7, 5, 1));
			final Box tb3 = new Box(textureTest2, new Point3(2, 0, 5), new Point3(3, 5, 6));
			final Box tb4 = new Box(textureTest2, new Point3(6, 0, 5), new Point3(7, 5, 6));
			final Box tp = new Box(textureTest2, new Point3(2, 5, 0), new Point3(7, 6, 6));
			final BoxTrans bT = new BoxTrans(textureTest4, new Point3(2, 6, 5), new Point3(3, 7, 6));

			bT.Node.transform = bT.Node.transform.rotateZ(Math.PI * 0.2).rotateY(Math.PI * 0.2);
			final Disk plate = new Disk(diffuse5, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.0);
			final Disk innerPlate = new Disk(diffuse3, new Point3(3, 6.1, 2), 0.8, new Normal3(0, 1, 0), 0.0);
			final Disk outerRing = new Disk(diffuse4, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.9);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();
			geoList.add(ebene);
			// geoList.add(wuerfel1);

			geoList.add(tb1);
			geoList.add(tb2);
			geoList.add(tb3);
			geoList.add(tb4);
			geoList.add(tp);
			geoList.add(kugelC);
			geoList.add(dreieck1);
			geoList.add(plate);
			geoList.add(innerPlate);
			geoList.add(outerRing);
			geoList.add(bT);
			// die folgende Kugel zeigt die drehung aus dem raytest
			// geoList.add(kugelC1);
			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, oCam);

		}

		/**
		 * Standard-Modus Inputs and modus for "Beginn"
		 */
		if (modus == 0) {

			final Plane ebene = new Plane(n, a, diffuse);

			final Point3 punktC = new Point3(7, 6.5, 4);
			final double r = 0.5;
			final Sphere kugelC = new Sphere(punktC, r, pMaterial);

			final Triangle dreieck1 = new Triangle(materialSingle, new Point3(7, 6.95, 4), new Point3(7.05, 7.4, 3.95),
					new Point3(6.95, 7.3, 4.05));
			// final Box wuerfel1 = new Box(materialSingle2,new Point3(-1.5,0.5,0.5), new
			// Point3(-0.5,1.5,1.5));

			final Box tb1 = new Box(diffuse2, new Point3(2, 0, 0), new Point3(3, 5, 1));
			final Box tb2 = new Box(diffuse2, new Point3(6, 0, 0), new Point3(7, 5, 1));
			final Box tb3 = new Box(diffuse2, new Point3(2, 0, 5), new Point3(3, 5, 6));
			final Box tb4 = new Box(diffuse2, new Point3(6, 0, 5), new Point3(7, 5, 6));
			final Box tp = new Box(diffuse2, new Point3(2, 5, 0), new Point3(7, 6, 6));
			final BoxTrans bT = new BoxTrans(diffuse6, new Point3(2, 6, 5), new Point3(3, 7, 6));

			bT.Node.transform = bT.Node.transform.rotateZ(Math.PI * 0.2).rotateY(Math.PI * 0.2);
			final Disk plate = new Disk(diffuse, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.0);
			final Disk innerPlate = new Disk(diffuse3, new Point3(3, 6.1, 2), 0.8, new Normal3(0, 1, 0), 0.0);
			final Disk outerRing = new Disk(diffuse4, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.9);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();
			geoList.add(ebene);
			// geoList.add(wuerfel1);
			geoList.add(tb1);
			geoList.add(tb2);
			geoList.add(tb3);
			geoList.add(tb4);
			geoList.add(tp);
			geoList.add(kugelC);
			geoList.add(dreieck1);
			geoList.add(plate);
			geoList.add(innerPlate);
			geoList.add(outerRing);
			geoList.add(bT);

			final Farben.Color ambilight = new Farben.Color(0.1, 0.1, 0.1);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);

		}
		/**
		 * Inputs and modus for "Volle Texturen"
		 */
		if (modus == 3) {

			final Point3 punktC = new Point3(6, 6.5, 4);
			final double r = 1;
			final double r1 = 7;
			final SphereTrans kugelC = new SphereTrans(punktC, r, pMaterial);
			final Point3 punktC1 = new Point3(0, 7, 0);
			final SphereTrans kugelC1 = new SphereTrans(punktC1, r1, textureTest4);

			/*
			 * ------> so kommt man von aussen an die transform Klasse heran um hier noch
			 * veraenderung am objekt zu ermoeglichen Kugel wurde hier nach der init noch
			 * veraendert...geht nur bei den Geometrien mit trans im Namen
			 * 
			 * weitere veraenderung hier mit "." anhaengen (.translate() bspw )
			 */
			kugelC1.Node.transform = kugelC1.Node.transform.rotateY(-Math.PI / 1.3);

			final Plane ebene = new Plane(n, a, textureTest3);

			// final Triangle dreieck1= new Triangle(textureTest3,new Point3(7,6.95,4),new
			// Point3(7.05,7.4,3.95), new Point3(6.95,7.3,4.05));
			final Triangle dreieck1 = new Triangle(materialSingle2, new Point3(7, 10, 2), new Point3(7, 7, -2),
					new Point3(7, 13, 0));

			/*
			 * tiefe*hoehe*breite(erster Punkt gibt start zweiter punkt gibt
			 * ende...Kantenlenge ist der Abstand zwischen beiden)
			 */
			// final Box wuerfel1 = new Box(pMaterial, new Point3(-1.5, 0.5, 0.5), new
			// Point3(-0.5, 1.5, 1.5));

			final Box tb1 = new Box(textureTest2, new Point3(2, 0, 0), new Point3(3, 5, 1));
			final Box tb2 = new Box(textureTest2, new Point3(6, 0, 0), new Point3(7, 5, 1));
			final Box tb3 = new Box(textureTest2, new Point3(2, 0, 5), new Point3(3, 5, 6));
			final Box tb4 = new Box(textureTest2, new Point3(6, 0, 5), new Point3(7, 5, 6));
			final Box tp = new Box(textureTest2, new Point3(2, 5, 0), new Point3(7, 6, 6));
			final BoxTrans bT = new BoxTrans(textureTest4, new Point3(2, 6, 5), new Point3(3, 7, 6));

			bT.Node.transform = bT.Node.transform.rotateZ(Math.PI * 0.2).rotateY(Math.PI * 0.2);
			final Disk plate = new Disk(diffuse5, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.0);
			final Disk innerPlate = new Disk(diffuse3, new Point3(3, 6.1, 2), 0.8, new Normal3(0, 1, 0), 0.0);
			final Disk outerRing = new Disk(diffuse4, new Point3(3, 6.1, 2), 1.0, new Normal3(0, 1, 0), 0.9);

			final ArrayList<Light> lightList = new ArrayList<Light>();
			lightList.add(pointLight);
			final ArrayList<Geometry> geoList = new ArrayList<Geometry>();
			geoList.add(ebene);
			// geoList.add(wuerfel1);

			geoList.add(tb1);
			geoList.add(tb2);
			geoList.add(tb3);
			geoList.add(tb4);
			geoList.add(tp);
			geoList.add(kugelC);
			geoList.add(dreieck1);
			geoList.add(plate);
			geoList.add(innerPlate);
			geoList.add(outerRing);
			geoList.add(bT);

			/*
			 * die folgende Kugel zeigt die drehung aus dem raytest geoList.add(kugelC1);
			 */
			final Farben.Color ambilight = new Farben.Color(0.3, 0.3, 0.3);

			final World welt = new World(geoList, ambilight, lightList);

			new Draw(1000, 800, welt, cam);
		}

	}

	/**
	 * Overriding toString for correct use within this class.
	 */
	@Override
	public String toString() {
		return "GeoController [modus=" + modus + "]";
	}

	/**
	 * Overriding hashCode for correct use within this class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + modus;
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
		GeoController other = (GeoController) obj;
		if (modus != other.modus) {
			return false;
		}
		return true;
	}
}
