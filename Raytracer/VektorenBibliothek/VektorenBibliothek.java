package VektorenBibliothek;

/**
 * VektorenBibliothek is used as the main-controller for this programm.
 * 
 * @author Mike 
 * @author Marian 
 * @author Daniel 
 */
public class VektorenBibliothek {

	/**
	 * Mainclass for creating objects and calling arithmetic operations (methods).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Test 1
		 */
		final Normal3 test_1a = new Normal3(1, 2, 3);
		System.out.println("Test 1:");
		final Normal3 test_1b = test_1a.mul(0.5);
		System.out.printf("%f %f %f", test_1b.x, test_1b.y, test_1b.z);
		System.out.print("\n\n");

		/*
		 * Test 2
		 */
		final Normal3 test_2a = new Normal3(1, 2, 3);
		final Normal3 test_2b = new Normal3(3, 2, 1);
		System.out.println("Test 2:");
		final Normal3 test_2add = test_2a.add(test_2b);
		System.out.printf("%f %f %f", test_2add.x, test_2add.y, test_2add.z);
		System.out.print("\n\n");

		/*
		 * Test 3
		 */
		System.out.println("Test 3:");
		final Normal3 test_3na = new Normal3(1, 0, 0);
		final Normal3 test_3nb = new Normal3(0, 1, 0);
		final Vector3 test_3va = new Vector3(1, 0, 0);
		final Vector3 test_3vb = new Vector3(0, 1, 0);

		final double test_3s1 = test_3na.dot(test_3va);
		final double test_3s2 = test_3na.dot(test_3vb);
		final double test_3s3 = test_3va.dot(test_3na);
		final double test_3s4 = test_3va.dot(test_3nb);
		final double test_3s5 = test_3va.dot(test_3va);
		final double test_3s6 = test_3va.dot(test_3vb);

		System.out.printf("%f", test_3s1);
		System.out.println();
		System.out.printf("%f", test_3s2);
		System.out.println();
		System.out.printf("%f", test_3s3);
		System.out.println();
		System.out.printf("%f", test_3s4);
		System.out.println();
		System.out.printf("%f", test_3s5);
		System.out.println();
		System.out.printf("%f", test_3s6);
		System.out.print("\n\n");

		/*
		 * Test 4
		 */
		System.out.println("Test 4:");
		final Point3 test_4a = new Point3(1, 1, 1);
		final Point3 test_4b = new Point3(2, 2, 0);
		final Vector3 test_4c = test_4a.sub(test_4b);
		System.out.printf("%f %f %f", test_4c.x, test_4c.y, test_4c.z);
		System.out.print("\n\n");

		/*
		 * Test 5
		 */
		System.out.println("Test 5:");
		final Point3 test_5a = new Point3(1, 1, 1);
		final Vector3 test_5b = new Vector3(4, 3, 2);
		final Point3 test_5c = test_5a.sub(test_5b);
		System.out.printf("%f %f %f", test_5c.x, test_5c.y, test_5c.z);
		System.out.print("\n\n");

		/*
		 * Test 6
		 */
		System.out.println("Test 6:");
		final Point3 test_6a = new Point3(1, 1, 1);
		final Vector3 test_6b = new Vector3(4, 3, 2);
		final Point3 test_6c = test_6a.add(test_6b);
		System.out.printf("%f %f %f", test_6c.x, test_6c.y, test_6c.z);
		System.out.print("\n\n");

		/*
		 * Test 7
		 */
		System.out.println("Test 7:");
		final Vector3 test_7a = new Vector3(1, 1, 1);
		final double test_7b = test_7a.magnitude;
		System.out.printf("%f", test_7b);
		System.out.print("\n\n");

		/*
		 * Test 8
		 */
		System.out.println("Test 8:");
		final Vector3 test_8a = new Vector3(3, 5, 4);
		final Vector3 test_8b = new Vector3(2, 2, 1);
		final Vector3 test_8add = test_8a.add(test_8b);
		final Vector3 test_8sub = test_8a.add(test_8b);
		final Vector3 test_8mul = test_8a.add(test_8b);
		System.out.printf("%f %f %f", test_8add.x, test_8add.y, test_8add.z);
		System.out.println("");
		System.out.printf("%f %f %f", test_8sub.x, test_8sub.y, test_8sub.z);
		System.out.println("");
		System.out.printf("%f %f %f", test_8mul.x, test_8mul.y, test_8mul.z);
		System.out.println("");
		System.out.print("\n\n");

		/*
		 * Test 9
		 */
		System.out.println("Test 9:");
		final Vector3 test_9a = new Vector3(-0.707, 0.707, 0);
		final Normal3 test_9b = new Normal3(0, 1, 0);
		final Vector3 test_9c = test_9a.reflectedOn(test_9b);
		System.out.printf("%f %f %f", test_9c.x, test_9c.y, test_9c.z);
		System.out.print("\n\n");

		/*
		 * Test 10
		 */
		System.out.println("Test 10:");
		final Vector3 test_10a = new Vector3(0.707, 0.707, 0);
		final Normal3 test_10b = new Normal3(1, 0, 0);
		final Vector3 test_10c = test_10a.reflectedOn(test_10b);
		System.out.printf("%f %f %f", test_10c.x, test_10c.y, test_10c.z);
		System.out.print("\n\n");

		/*
		 * Test 11
		 */
		System.out.println("Test 11:");
		final Mat3x3 test_11m = new Mat3x3(1, 0, 0, 0, 1, 0, 0, 0, 1);
		final Vector3 test_11v = new Vector3(3, 2, 1);
		final Point3 test_11p = new Point3(3, 2, 1);

		final Vector3 test_11vm = test_11m.mul(test_11v);
		System.out.printf("%f %f %f", test_11vm.x, test_11vm.y, test_11vm.z);
		System.out.println();
		final Point3 test_11pm = test_11m.mul(test_11p);
		System.out.printf("%f %f %f", test_11pm.x, test_11pm.y, test_11pm.z);
		System.out.print("\n\n");

		/*
		 * Test 12
		 */
		System.out.println("Test 12:");
		final Mat3x3 test_12a = new Mat3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
		final Mat3x3 test_12b = new Mat3x3(1, 0, 0, 0, 1, 0, 0, 0, 1);
		final Mat3x3 test_12c = test_12a.mul(test_12b);
		System.out.printf("%f %f %f %f %f %f %f %f %f", test_12c.m11, test_12c.m12, test_12c.m13, test_12c.m21,
				test_12c.m22, test_12c.m23, test_12c.m31, test_12c.m32, test_12c.m33);
		System.out.print("\n\n");

		/*
		 * Test 13
		 */
		System.out.println("Test 13:");
		final Mat3x3 test_13a = new Mat3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
		final Mat3x3 test_13b = new Mat3x3(0, 0, 1, 0, 1, 0, 1, 0, 0);
		final Mat3x3 test_13c = test_13a.mul(test_13b);
		System.out.printf("%f %f %f %f %f %f %f %f %f", test_13c.m11, test_13c.m12, test_13c.m13, test_13c.m21,
				test_13c.m22, test_13c.m23, test_13c.m31, test_13c.m32, test_13c.m33);
		System.out.print("\n\n");

		/*
		 * Test 14
		 */
		System.out.println("Test 14:");
		final Mat3x3 test_14m = new Mat3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
		final Vector3 test_14v = new Vector3(8, 8, 8);
		final Mat3x3 test_14c1 = test_14m.changeCol1(test_14v);
		final Mat3x3 test_14c2 = test_14m.changeCol2(test_14v);
		final Mat3x3 test_14c3 = test_14m.changeCol3(test_14v);
		System.out.printf("%f %f %f %f %f %f %f %f %f", test_14c1.m11, test_14c1.m12, test_14c1.m13, test_14c1.m21,
				test_14c1.m22, test_14c1.m23, test_14c1.m31, test_14c1.m32, test_14c1.m33);
		System.out.println("");
		System.out.printf("%f %f %f %f %f %f %f %f %f", test_14c2.m11, test_14c2.m12, test_14c2.m13, test_14c2.m21,
				test_14c2.m22, test_14c2.m23, test_14c2.m31, test_14c2.m32, test_14c2.m33);
		System.out.println("");
		System.out.printf("%f %f %f %f %f %f %f %f %f", test_14c3.m11, test_14c3.m12, test_14c3.m13, test_14c3.m21,
				test_14c3.m22, test_14c3.m23, test_14c3.m31, test_14c3.m32, test_14c3.m33);
		System.out.print("\n\n");
		
	}

}
