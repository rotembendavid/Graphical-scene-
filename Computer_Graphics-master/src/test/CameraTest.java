package test;

//import elements.Camera;
//import Primitives.Coordinate;
//import Primitives.Point3D;
//import Primitives.Ray;
//import Primitives.Vector;
//import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTest {

	@Test
    public void testConstructRayThroughPixel() {
        System.out.println("constructRayThroughPixel");
     /*   int Nx = 3;
        int Ny = 3;
        double i = 2;
        double j = 2;
        double screenDistance = 1;
        double screenWidth = 9;
        double screenHeight = 9;
        Point3D P0=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
        Vector vUp=new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0)));
        Vector vTo=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)));
        Camera instance = new Camera(P0, vUp, vTo);
        Ray expResult = new Ray(P0, vTo);
        Ray result = instance.constructRayThroughPixel(Nx, Ny, i, j, screenDistance, screenWidth, screenHeight,2);
        assertEquals(expResult.toString(), result.toString());  */      
    }   

}
