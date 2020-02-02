package test;

import java.awt.Color;


import org.junit.Test;

import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class LightingTest {


	@Test 
	public void emmissionTest(){

		Scene scene = new Scene();
		Color c1=  new Color(255,0,0);
		Sphere s1=new Sphere(new Point3D(0.0, 0.0, -149), 50);
		s1.setEmission(c1);

		scene.addGeometry(s1);

		Triangle triangle = new Triangle(new Point3D( 100, 0, -149),
				new Point3D(  0, 100, -149),
				new Point3D( 100, 100, -149));
		Color c2=new Color(0,255,0);
		triangle.setEmission(c2);

		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -149),
				new Point3D(  0, -100, -149),
				new Point3D( 100,-100, -149));
		Color c3=new Color(0,0,255);
		triangle2.setEmission(c3);

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149),
				new Point3D(  0, 100, -149),
				new Point3D(-100, 100, -149));
		Color c4=new Color(255,255,0);
		triangle3.setEmission(c4);

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
				new Point3D(  0,  -100, -149),
				new Point3D(-100, -100, -149));
		Color c5=new Color(255,0,255);
		triangle4.setEmission(c5);

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Emmition test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToimage();
	}



	@Test
	///////////////////////////////////////////////////
	public void spotLightTest2(){
		/*		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Point3D(0.0, 0.0, -1000), 800);
		Color c=new Color(0, 0, 100);
		sphere.setEmission(c);
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005));*/


		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 500);
		Color c=new Color(0, 0, 100);
		sphere.setEmission(c);
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
				new Point3D(-225, -125, -260),
				new Point3D(-225, -225, -270));
		Color c1=new Color(0, 0, 100);
		triangle.setEmission(c1);

		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3),  0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();

	}


	@Test
	public void spotLightTest(){

		Scene scene = new Scene();
		scene.setScreenDistance(100);

		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 800);
		Color c=new Color(0, 0, 100);
		sphere.setEmission(c);
		Material m=new Material();
		m.set_nShininess(4);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				new Vector(2, 2, -3), 0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();

	}


	@Test
	public void pointLightTest(){

		Scene scene = new Scene();
		scene.setScreenDistance(100);

		Sphere sphere = new Sphere (new Point3D(0.0, 0.0, -1000), 800);
		Color c=new Color(0, 0, 100);
		sphere.setEmission(c);
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
	//	render.printGrid(50);
		imageWriter.writeToimage();


	}

	@Test
	public void spotLightTest3(){

		Scene scene = new Scene();

		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));
		Color c2=new Color(0,0,0);
		triangle.setEmission(c2);

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));
		Color c3=new Color(0,0,0);
		triangle2.setEmission(c3);

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();

	}

	@Test
	public void pointLightTest2(){

		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 800);
		Color c=new Color(0, 0, 100);
		sphere.setEmission(c);
		Material m=new Material();
		m.set_nShininess(21);
		sphere.set_material(m);

		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));
		Color c2=new Color(0,0,0);
		triangle.setEmission(c2);

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));
		Color c3=new Color(0,0,0);
		triangle2.setEmission(c3);

		scene.addGeometry(sphere);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();

	}


}