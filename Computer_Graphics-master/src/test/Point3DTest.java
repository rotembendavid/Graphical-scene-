package test;


import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

public class Point3DTest {

	 @Test
	    public void testAdd() {
	        System.out.println("add");
	        Point3D a = new Point3D(new Coordinate(-2),new Coordinate(-3),new Coordinate(-4));
	        Point3D b = new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4));
	        Point3D c=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
	        Vector v=new Vector(a);
	        b.add(v);
	        assertEquals(b.toString(), c.toString());
	    }
	 @Test
	    public void testSubtract() {
	        System.out.println("subtract");
	        Point3D a = new Point3D(new Coordinate(-2),new Coordinate(-3),new Coordinate(-4));
	        Point3D b = new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4));
	        Point3D c=new Point3D(new Coordinate(4),new Coordinate(6),new Coordinate(8));
	        Vector v=new Vector(a);
	        b.subtract(v);
	        assertEquals(b.toString(), c.toString());
	       

	    }


}
