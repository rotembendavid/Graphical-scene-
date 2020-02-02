package test;

import java.awt.Color;

import org.junit.Test;

import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RecursiveTest {

	
	@Test
	public void recursiveTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 500);
		Material m1=new Material();
		m1.set_nShininess(20);
		m1.set_Kt(0.5);
		sphere.set_material(m1);
		sphere.setEmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Point3D(0.0, 0.0, -1000), 250);
		Material m2=new Material();

		m2.set_nShininess(20);
		m2.set_Kt(0);
		sphere2.set_material(m2);
		sphere2.setEmission(new Color(100, 20, 20));
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3),  0.000001, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
		
	}
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(new Point3D(-550, -500, -1000), 300);
		Material m1=new Material();
		m1.set_nShininess(20);
		m1.set_Kt(0.5);
		sphere.set_material(m1);
		sphere.setEmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Point3D(-550, -500, -1000), 150);
		Material m2=new Material();
		m2.set_nShininess(20);
		m2.set_Kt(0);
		sphere2.set_material(m2);
		
		sphere2.setEmission(new Color(100, 20, 20));
		
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500));
		
		triangle.setEmission(new Color(20, 20, 20));
		triangle2.setEmission(new Color(20, 20, 20));
		Material m3=new Material();
		m3.set_Kr(1);
		triangle.set_material(m3);
		Material m4=new Material();
		m4.set_Kr(0.5);
		triangle2.set_material(m4);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
		
	}
	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(new Point3D(0, 0, -1000), 300);
		
		sphere.setEmission(new Color(0, 0, 100));
		Material m1=new Material();
		m1.set_nShininess(20);
		m1.set_Kt(0.5);
		sphere.set_material(m1);
		
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Point3D(0, 0, -1000), 150);
		
		sphere2.setEmission(new Color(100, 20, 20));
		
		Material m2=new Material();
		m2.set_nShininess(20);
		m2.set_Kt(0);
		sphere2.set_material(m2);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
				 						 new Point3D( -1000,  2000, -1500),
				 						 new Point3D(  700,  700, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
										  new Point3D( -1000,  2000, -1500),
										  new Point3D( -1000, -1000, -1500));
		
		triangle.setEmission(new Color(20, 20, 20));
		triangle2.setEmission(new Color(20, 20, 20));
		Material m3=new Material();
		m3.set_Kr(1);
		triangle.set_material(m3);
		Material m4=new Material();
		m4.set_Kr(0.5);
		triangle2.set_material(m4);
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToimage();
		
	}
	
}