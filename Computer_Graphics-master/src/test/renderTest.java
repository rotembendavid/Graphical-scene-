package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import Primitives.Coordinate;
import geometries.Sphere;
import geometries.Triangle;
import Primitives.Point3D;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class renderTest {

	@Test
	public void basicRendering(){

		Scene scene = new Scene();
		Point3D p= new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -150));
		Sphere s=new Sphere(p, 50);
		s.setEmission(Color.white);
		scene.addGeometry(s);

		//scene.addGeometry(new Sphere( new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -150)),50));

		Triangle triangle = new Triangle(new Point3D(new Coordinate( 100),new Coordinate( 0),new Coordinate( -149)),
				new Point3D(  new Coordinate(0), new Coordinate(100),new Coordinate( -149)),
				new Point3D( new Coordinate(100), new Coordinate(100), new Coordinate(-149)));

		triangle.setEmission(Color.blue);

		Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100), new Coordinate(0),new Coordinate( -149)),
				new Point3D(new Coordinate(  0), new Coordinate(-100), new Coordinate(-149)),
				new Point3D( new Coordinate(100),new Coordinate(-100),new Coordinate( -149)));

		triangle2.setEmission(Color.red);
		Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0),new Coordinate( -149)),
				new Point3D( new Coordinate( 0), new Coordinate(100),new Coordinate( -149)),
				new Point3D(new Coordinate(-100), new Coordinate(100), new Coordinate(-149)));
		triangle3.setEmission(Color.green);
		Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0), new Coordinate(-149)),
				new Point3D( new Coordinate( 0),  new Coordinate(-100), new Coordinate(-149)),
				new Point3D(new Coordinate(-100), new Coordinate(-100), new Coordinate(-149)));

		triangle4.setEmission(Color.white);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.get_imageWriter().writeToimage();
		assertTrue(true);

	}

	@Test
	public void ilFlagTest(){

		Scene scene = new Scene();
		Triangle triangle = new Triangle(new Point3D(new Coordinate(100),new Coordinate(-100),new Coordinate( -149)),
				new Point3D(  new Coordinate(0), new Coordinate(100),new Coordinate( -149)),
				new Point3D( new Coordinate(-100), new Coordinate(-100), new Coordinate(-149)));
		triangle.setEmission(Color.blue);
		Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100), new Coordinate(50),new Coordinate( -149)),
				new Point3D(new Coordinate(  -100), new Coordinate(50), new Coordinate(-149)),
				new Point3D( new Coordinate(0),new Coordinate(-150),new Coordinate( -149)));
		triangle2.setEmission(Color.blue);

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		ImageWriter imageWriter = new ImageWriter("IsraelFlag Render test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.get_imageWriter().writeToimage();
		assertTrue(true);

	}

}
