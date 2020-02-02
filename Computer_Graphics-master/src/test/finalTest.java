package test;

//import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Primitives.Material;
//import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
//import elements.AmbientLight;
import elements.SpotLight;
//import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class finalTest {

	@Test
	public void test1() {
		/*Scene scene = new Scene();
		scene.setScreenDistance(200);

		AmbientLight a= new  AmbientLight();
		a.color= new Color(255,255,255);
		scene.setAmbientLight(a);
		scene.setBackground(new Color(255,255,255));

		Sphere s1=new Sphere(new Point3D(0.0, -30, -149), 30);
		Color c1=  Color.gray;
		s1.setEmission(c1);
		Material m1=new Material();
		//m1.set_Kr(1);
		m1.set_nShininess(20);
		s1.set_material(m1);
		scene.addGeometry(s1);

		//Plane p1= new Plane(new Point3D(0,0,0),new Vector(21,30,-45));
		//Color c2=  Color.gray;
		//p1.setEmission(c2);
		//Material m2=new Material();
		//m2.set_Kr(1);
		//m2.set_nShininess(20);
		//p1.set_material(m2);
		//scene.addGeometry(p1);

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


		ImageWriter imageWriter = new ImageWriter("final Test", 500, 500, 500, 500);


		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();*/

		Scene scene = new Scene();
		scene.setScreenDistance(150);

		Triangle triangle = new Triangle(new Point3D(-125, -225, -260)
				,new Point3D(-225, -125, -260),new Point3D(-225, -225, -270));


		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 600);
		sphere.get_material().set_nShininess(20);
		sphere.setEmission(new Color(0, 0, 255));
		sphere.get_material().set_Kt(1);
		scene.addGeometry(sphere);

		Sphere sphere2 = new Sphere(new Point3D(0.0, 0.0, -1000), 100);
		sphere2.get_material().set_nShininess(1000);
		sphere2.setEmission(new Color(0, 0, 0));
		sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere2);

		Sphere sphere3 = new Sphere(new Point3D(0.0, 0.0, -1000), 300);
		sphere3.get_material().set_nShininess(20);
		sphere3.setEmission(new Color(225, 20, 20));
		sphere3.get_material().set_Kt(0.5);
		scene.addGeometry(sphere3);

		triangle.get_material().set_nShininess(20);
		triangle.setEmission(new Color(102, 0, 102));
		triangle.get_material().set_Kt(0);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("final test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}
	@Test
	public void test() {



		Scene scene = new Scene();
		scene.setScreenDistance(150);

		

		//head
		Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 300);
		sphere.get_material().set_nShininess(20);
		sphere.setEmission(new Color(0, 0, 255));
		//sphere.get_material().set_Kt(1);
		scene.addGeometry(sphere);

		//body
		Sphere sphere2 = new Sphere(new Point3D(0.0, -600, -1000), 300);
		sphere2.get_material().set_nShininess(20);
		sphere2.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere2);

		//arms
		//left arm

		Sphere sphere316 = new Sphere(new Point3D(290, -480, -1000), 90);
		sphere316.get_material().set_nShininess(20);
		sphere316.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere316);

		Sphere sphere315 = new Sphere(new Point3D(310, -510, -1000), 90);
		sphere315.get_material().set_nShininess(20);
		sphere315.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere315);

		Sphere sphere314 = new Sphere(new Point3D(330, -540, -1000), 90);
		sphere314.get_material().set_nShininess(20);
		sphere314.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere314);

		Sphere sphere313 = new Sphere(new Point3D(340, -570, -1000), 90);
		sphere313.get_material().set_nShininess(20);
		sphere313.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere313);

		Sphere sphere3 = new Sphere(new Point3D(350, -600, -1000), 90);
		sphere3.get_material().set_nShininess(20);
		sphere3.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere3);

		Sphere sphere31 = new Sphere(new Point3D(370, -650, -1000), 70);
		sphere31.get_material().set_nShininess(20);
		sphere31.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere31);

		Sphere sphere32 = new Sphere(new Point3D(390, -650, -1000), 70);
		sphere32.get_material().set_nShininess(20);
		sphere32.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere32);

		Sphere sphere33 = new Sphere(new Point3D(400, -650, -1000), 70);
		sphere33.get_material().set_nShininess(20);
		sphere33.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere33);

		Sphere sphere34 = new Sphere(new Point3D(410, -660, -1000), 70);
		sphere34.get_material().set_nShininess(20);
		sphere34.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere34);

		Sphere sphere35 = new Sphere(new Point3D(430, -640, -1000), 70);
		sphere35.get_material().set_nShininess(20);
		sphere35.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere35);

		Sphere sphere36 = new Sphere(new Point3D(450, -610, -1000), 70);
		sphere36.get_material().set_nShininess(20);
		sphere36.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere36);

		Sphere sphere37 = new Sphere(new Point3D(470, -590, -1000), 70);
		sphere37.get_material().set_nShininess(20);
		sphere37.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere37);

		Sphere sphere38 = new Sphere(new Point3D(490, -570, -1000), 70);
		sphere38.get_material().set_nShininess(20);
		sphere38.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere38);

		Sphere sphere39 = new Sphere(new Point3D(510, -550, -1000), 70);
		sphere39.get_material().set_nShininess(20);
		sphere39.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere39);

		Sphere sphere310 = new Sphere(new Point3D(530, -530, -1000), 70);
		sphere310.get_material().set_nShininess(20);
		sphere310.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere310);

		Sphere sphere311 = new Sphere(new Point3D(550, -510, -1000), 70);
		sphere311.get_material().set_nShininess(20);
		sphere311.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere311);

		//right arm
		Sphere sphere413 = new Sphere(new Point3D(-290, -460, -1000), 90);
		sphere413.get_material().set_nShininess(20);
		sphere413.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere413);

		Sphere sphere412 = new Sphere(new Point3D(-310, -490, -1000), 90);
		sphere412.get_material().set_nShininess(20);
		sphere412.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere412);

		Sphere sphere411 = new Sphere(new Point3D(-330, -520, -1000), 90);
		sphere411.get_material().set_nShininess(20);
		sphere411.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere411);



		Sphere sphere4 = new Sphere(new Point3D(-350, -550, -1000), 90);
		sphere4.get_material().set_nShininess(20);
		sphere4.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere4);

		Sphere sphere41 = new Sphere(new Point3D(-370, -580, -1000), 70);
		sphere41.get_material().set_nShininess(20);
		sphere41.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere41);

		Sphere sphere42 = new Sphere(new Point3D(-400, -600, -1000), 70);
		sphere42.get_material().set_nShininess(20);
		sphere42.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere42);

		Sphere sphere43 = new Sphere(new Point3D(-400, -620, -1000), 70);
		sphere43.get_material().set_nShininess(20);
		sphere43.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere43);

		Sphere sphere44 = new Sphere(new Point3D(-400, -650, -1000), 70);
		sphere44.get_material().set_nShininess(20);
		sphere44.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere44);

		Sphere sphere45 = new Sphere(new Point3D(-400, -670, -1000), 70);
		sphere45.get_material().set_nShininess(20);
		sphere45.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere45);

		Sphere sphere46 = new Sphere(new Point3D(-400, -700, -1000), 70);
		sphere46.get_material().set_nShininess(20);
		sphere46.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere46);

		Sphere sphere47 = new Sphere(new Point3D(-400, -730, -1000), 70);
		sphere47.get_material().set_nShininess(20);
		sphere47.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere47);

		Sphere sphere48 = new Sphere(new Point3D(-400, -760, -1000), 70);
		sphere48.get_material().set_nShininess(20);
		sphere48.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere48);

		Sphere sphere49 = new Sphere(new Point3D(-400, -790, -1000), 70);
		sphere49.get_material().set_nShininess(20);
		sphere49.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere49);

		Sphere sphere410 = new Sphere(new Point3D(-400, -820, -1000), 70);
		sphere410.get_material().set_nShininess(20);
		sphere410.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere410);

		//legs

		//right leg 


		Sphere sphere5 = new Sphere(new Point3D(-160, -1100, -1000), 80);
		sphere5.get_material().set_nShininess(20);
		sphere5.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere5);

		Sphere sphere51 = new Sphere(new Point3D(-160, -1090, -1000), 80);
		sphere51.get_material().set_nShininess(20);
		sphere51.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere51);

		Sphere sphere52 = new Sphere(new Point3D(-160, -1080, -1000), 80);
		sphere52.get_material().set_nShininess(20);
		sphere52.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere52);

		Sphere sphere53 = new Sphere(new Point3D(-160, -1070, -1000), 80);
		sphere53.get_material().set_nShininess(20);
		sphere53.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere53);

		Sphere sphere54 = new Sphere(new Point3D(-160, -1040, -1000), 80);
		sphere54.get_material().set_nShininess(20);
		sphere54.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere54);

		Sphere sphere55 = new Sphere(new Point3D(-160, -1010, -1000), 80);
		sphere55.get_material().set_nShininess(20);
		sphere55.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere55);

		Sphere sphere56 = new Sphere(new Point3D(-160, -980, -1000), 80);
		sphere56.get_material().set_nShininess(20);
		sphere56.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere56);

		Sphere sphere57 = new Sphere(new Point3D(-160, -1150, -1000), 80);
		sphere57.get_material().set_nShininess(20);
		sphere57.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere57);

		Sphere sphere58 = new Sphere(new Point3D(-160, -1190, -1000), 80);
		sphere58.get_material().set_nShininess(20);
		sphere58.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere58);


		//left leg

		Sphere sphere6 = new Sphere(new Point3D(160, -1100, -1000), 80);
		sphere6.get_material().set_nShininess(20);
		sphere6.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere6);

		Sphere sphere61 = new Sphere(new Point3D(160, -1090, -1000), 80);
		sphere61.get_material().set_nShininess(20);
		sphere61.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere61);

		Sphere sphere62 = new Sphere(new Point3D(160, -1080, -1000), 80);
		sphere62.get_material().set_nShininess(20);
		sphere62.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere62);

		Sphere sphere63 = new Sphere(new Point3D(160, -1070, -1000), 80);
		sphere63.get_material().set_nShininess(20);
		sphere63.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere63);

		Sphere sphere64 = new Sphere(new Point3D(160, -1040, -1000), 80);
		sphere64.get_material().set_nShininess(20);
		sphere64.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere64);

		Sphere sphere65 = new Sphere(new Point3D(160, -1010, -1000), 80);
		sphere65.get_material().set_nShininess(20);
		sphere65.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere65);

		Sphere sphere66 = new Sphere(new Point3D(160, -980, -1000), 80);
		sphere66.get_material().set_nShininess(20);
		sphere66.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere66);

		Sphere sphere67 = new Sphere(new Point3D(160, -1150, -1000), 80);
		sphere67.get_material().set_nShininess(20);
		sphere67.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere67);

		Sphere sphere68 = new Sphere(new Point3D(160, -1190, -1000), 80);
		sphere68.get_material().set_nShininess(20);
		sphere68.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere68);

		Sphere sphere69 = new Sphere(new Point3D(160, -950, -1000), 80);
		sphere69.get_material().set_nShininess(20);
		sphere69.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere69);
		
		Sphere sphere610 = new Sphere(new Point3D(160, -920, -1000), 80);
		sphere610.get_material().set_nShininess(20);
		sphere610.setEmission(new Color(0, 0, 255));
		//sphere2.get_material().set_Kt(0);
		scene.addGeometry(sphere610);



		Triangle triangle1 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000));
		Color c2=new Color(0,0,0);
		triangle1.setEmission(c2);

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000));
		Color c3=new Color(0,0,0);
		triangle2.setEmission(c3);

		Triangle triangle3 = new Triangle(new Point3D(  500, -1000,1000),
				new Point3D( 750,  2000, -2000),
				new Point3D( 750, -1000, -2000));


		triangle3.setEmission(new Color(20, 20, 20));
		Material m3=new Material();
		m3.set_Kr(1);
		triangle3.set_material(m3);

		scene.addGeometry(sphere);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);

		scene.addLight(new SpotLight(new Color(100, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("final test2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToimage();
	}



}


