package test;

import static org.junit.Assert.*;

//import java.util.ArrayList;

import org.junit.Test;

//import Primitives.Coordinate;
import Primitives.Point3D;
//import Primitives.Ray;
import Primitives.Vector;
//import elements.Camera;
import geometries.Triangle;


public class TriangleTest {
	 @Test
	public void testGetNormal() 
	{
		 System.out.println("GetNormal");
		Point3D p1= new Point3D (1,0,0);
		Point3D p2= new Point3D (0,1,0);
		Point3D p3= new Point3D (1,1,0);
		
		Triangle t1= new Triangle(p1,p2,p3);
		
		Vector v1= new Vector(t1.getNormal(p1));
		
		Vector v2= new Vector(new Point3D(0.0, -0.0, -1));
		
		v2.normalize();
		assertEquals(v2,v1);
	}

/*	@Test
	public void testFindIntersections() {
		System.out.println("FindIntersections");
		int count=0;
		Camera c=new Camera();
		Coordinate c1=new Coordinate(-1);
		Coordinate c2=new Coordinate(-1);
		Coordinate c3=new Coordinate(-2);

		Coordinate c4=new Coordinate(1);
		Coordinate c5=new Coordinate(-1);
		Coordinate c6=new Coordinate(-2);

		Coordinate c7=new Coordinate(0);
		Coordinate c8=new Coordinate(10);
		Coordinate c9=new Coordinate(-2);

		Triangle instance2=new Triangle(new Point3D(c1,c2,c3),new Point3D(c4,c5,c6),new Point3D(c7,c8,c9));
		ArrayList<Ray> rayList=new ArrayList<Ray>();
		ArrayList<ArrayList<Point3D>> list=new ArrayList<ArrayList<Point3D>>();
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
			}
		}
		for (Ray ray : rayList) {
			ArrayList<Point3D> listOfPoints = new ArrayList<Point3D>(instance2.FindIntersections(ray));
			list.add(listOfPoints);
		}

		for (ArrayList<Point3D> arrayList : list) {
			count+=arrayList.size();
		}
		int result=count;
		int expResult = 2;

		assertEquals(expResult, result);
	}*/


}
