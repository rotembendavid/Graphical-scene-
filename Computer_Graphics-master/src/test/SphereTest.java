package test;

import static org.junit.Assert.*;

//import java.util.ArrayList;

import org.junit.Test;
import Primitives.Coordinate;
import Primitives.Point3D;
//import Primitives.Ray;
import Primitives.Vector;
//import elements.Camera;
import geometries.Sphere;


public class SphereTest {


	@Test
	public void testGetNormal() {
		System.out.println("getnormal");
		Point3D p1=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
		Point3D p2=new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0));
		Point3D p3=new Point3D(new Coordinate(-1),new Coordinate(0),new Coordinate(0));
		Sphere sp= new Sphere(p1,1);
		Vector v= sp.getNormal(p2);
		assertEquals(v,new Vector(p3));
	}
	/*@Test
	public void testFindIntersections() {
		System.out.println("FindIntersections");
		int count=0;
		Camera c=new Camera();
		Sphere instance = new Sphere(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-3.0)),1.0);
		ArrayList<Ray> rayList=new ArrayList<Ray>();
		ArrayList<ArrayList<Point3D>> list=new ArrayList<ArrayList<Point3D>>();
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
			}
		}
		for (Ray ray : rayList) {
			ArrayList<Point3D> listOfPoints = new ArrayList<Point3D>(instance.FindIntersections(ray));
			list.add(listOfPoints);
		}

		for (ArrayList<Point3D> arrayList : list) {
			count+=arrayList.size();
		}
		int result=count;
		int expResult = 2;

		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}


	@Test
	public void testFindIntersections2() {
		System.out.println("FindIntersections");
		int count=0;
		Camera c=new Camera();
		Sphere instance = new Sphere(new Point3D(new Coordinate(),new Coordinate(),new Coordinate()),5.0);
		ArrayList<Ray> rayList=new ArrayList<Ray>();
		ArrayList<ArrayList<Point3D>> list=new ArrayList<ArrayList<Point3D>>();
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 2, 2));
			}
		}
		for (Ray ray : rayList) {
			ArrayList<Point3D> listOfPoints = new ArrayList<Point3D>(instance.FindIntersections(ray));
			list.add(listOfPoints);
		}

		for (ArrayList<Point3D> arrayList : list) {
			count+=arrayList.size();
		}
		int result=count;
		int expResult = 9;

		assertEquals(expResult, result);
	}*/

}
