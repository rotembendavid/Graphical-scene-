package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Vector;
import Primitives.Point3D;
import Primitives.Coordinate;


public class VectorTest {

	@Test
    public void testAdd() {
        System.out.println("add");
        Vector a = new Vector(new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1)));
        Vector b = new Vector(new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(5)));
        b.add(a);
         Vector c = new Vector(new Point3D(new Coordinate(3),new Coordinate(4),new Coordinate(6)));
        assertEquals(b.toString(),c.toString());
	}
	
	@Test
	 public void testSubtract() {
        System.out.println("subtract");
        Vector a = new Vector(new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1)));
        Vector b = new Vector(new Point3D(new Coordinate(3),new Coordinate(8),new Coordinate(5)));
        b.subtract(a);
        Vector c = new Vector(new Point3D(new Coordinate(2),new Coordinate(7),new Coordinate(4)));
        assertEquals(b.toString(),c.toString());
       
    }

	  @Test
	    public void testScaling() {
	        System.out.println("scaling");
	        double scale = 2;
	        Vector a = new Vector(new Point3D(new Coordinate(1),new Coordinate(3),new Coordinate(5)));
	        a.scale(scale);
	        Vector b = new Vector(new Point3D(new Coordinate(2),new Coordinate(6),new Coordinate(10)));
	        assertEquals(a.toString(),b.toString());
	  }
	  
	  @Test
	    public void testDorProduct() {
	        System.out.println("dotrroduct");
	        Vector a = new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0)));
	        Vector b = new Vector(new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0)));
	        double expResult = 0;
	        double result = b.dotProduct(a);
	        assertEquals(expResult, result, 0.0);
	       
	    }
	  @Test
	    public void testLengh() {
	        System.out.println("length");
	        Vector a = new Vector(new Point3D(new Coordinate(-2),new Coordinate(-2),new Coordinate(-2)));
	        double expResult = Math.sqrt(12);
	        double result = a.length();
	        assertEquals(expResult, result, 0.0);
	      
	    }
	  @Test
	    public void testNormalize() {
	        System.out.println("normalize");
	        Vector a = new Vector(new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1)));
	        a.normalize();
	        Vector b = new Vector(new Point3D(new Coordinate(1/Math.sqrt(3)),new Coordinate(1/Math.sqrt(3)),new Coordinate(1/Math.sqrt(3))));
	        assertEquals(a.toString(),b.toString());
	       
	    }
	  
	  @Test
	    public void testCrossProduct() {        
	        System.out.println("crossProduct");
	        Vector a = new Vector(new Point3D(new Coordinate(1),new Coordinate(1),new Coordinate(1)));
	        Vector b = new Vector(new Point3D(new Coordinate(4),new Coordinate(2),new Coordinate(2)));
	        Vector c = new Vector(new Point3D(new Coordinate(0.0),new Coordinate(-2.0),new Coordinate(2.0)));
	        Vector result = b.crossProduct(a);
	        assertEquals(result.toString(),c.toString());
	  }

}
