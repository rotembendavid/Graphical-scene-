package test;



import static org.junit.Assert.*;

//import java.util.ArrayList;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point3D;
//import Primitives.Ray;
import Primitives.Vector;
//import elements.Camera;
import geometries.Plane;

public class PlaneTest {

	@Test
	public void testGetNormal() {
		System.out.println("normalize");
		Vector a = new Vector(new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(0)));
		Vector a1 = new Vector(new Point3D(new Coordinate(-1),new Coordinate(1),new Coordinate(0)));
		Plane b= new Plane (new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(0)),a);
		Vector c=  b.getNormal(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1)));
        assertEquals(a1, c);
	}
	
	  @Test
	    public void testFindIntersections() {
	       System.out.println("FindIntersections");
	        /*int count=0;
	        Camera c=new Camera();
	        Plane inPlane=new Plane(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-5)),new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-1))));
	        ArrayList<Ray> rayList=new ArrayList<>();
	        ArrayList<ArrayList<Point3D>> list=new ArrayList<>();
	        for (int i = 1; i < 4; i++) {
	            for (int j = 1; j < 4; j++) {
	                rayList.add(c.constructRayThroughPixel(3, 3, i, j, 1, 10, 10));
	            }
	        }
	        for (Ray ray : rayList) {
	            ArrayList<Point3D> listOfPoints = new ArrayList<>(inPlane.FindIntersections(ray));
	            list.add(listOfPoints);
	        }
	        
	        for (ArrayList<Point3D> arrayList : list) {
	            count+=arrayList.size();
	        }
	        int result=count;
	        int expResult = 9;
	        
	        assertEquals(expResult, result);*/
	  }

}
