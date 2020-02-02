package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



//import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import elements.Light;
import geometries.Geometry;
import scene.Scene;


public class Render {

	private static int RECURSION_LEVEL = 5;//recurse of the refraction
	public Scene _scene;//scene
	public ImageWriter _imageWriter;
	//***********Constructors*********************

	public Render(int width, int height, int Ny, int Nx) //constructor
	{
		this._scene=new Scene();
		this._imageWriter=new ImageWriter("myImage", width, height, Ny, Nx);
	}

	public Render()//default constructor 
	{
		this._scene=new Scene();
		this._imageWriter=new ImageWriter("myImage", 50,50, 25, 25);
	}

	public Render(Scene s,String name,int width, int height, int Ny, int Nx ) //constructor
	{
		this._scene=s;
		this._imageWriter=new ImageWriter(name,width, height, Ny, Nx);
	}


	public Render(ImageWriter imageWriter, Scene scene) {//constructor
		this.set_imageWriter(imageWriter);
		this.set_scene(scene);
	}
	//***********Getters and Setters*******************

	public Scene get_scene() {//get _scene
		return _scene;
	}


	public void set_scene(Scene _scene) {//set _scene
		this._scene = _scene;
	}


	public ImageWriter get_imageWriter() {//get _imageWriter
		return _imageWriter;
	}


	public void set_imageWriter(ImageWriter _imageWriter) {//set _imageWriter
		this._imageWriter = _imageWriter;
	}
	//************Administration*****************

	@Override
	public String toString() {
		return "_scene=" + _scene + ", _imageWriter=" + _imageWriter;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (_imageWriter == null) {
			if (other._imageWriter != null)
				return false;
		} else if (!_imageWriter.equals(other._imageWriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}
	//**********Operations************************************

	public void writeToimage(){	//to allow the renderer to execute the writeToimage function


		_imageWriter.writeToimage();
	}

	public void printGrid(int interval) {	//the func print grid on the image
		for (int i = 50; i < 451; i += interval) {
			for (int j = 0; j < 500; j += 1) {
				_imageWriter.writePixel(i, j, Color.WHITE);
			}
		}
		for (int i = 50; i < 451; i += interval) {
			for (int j = 0; j < 500; j += 1) {
				_imageWriter.writePixel(j, i, Color.WHITE);
			}
		}
	}
	//to sum all the lights with :phong model.
	//the point parameter is for the point itself to find the color 
	//the inRay parameter is for know the ray that enter to the point
	//the level parameter is for not calculate forever - to stop our recorsia.

	private Color calcColor(Geometry geometry, Point3D point, Ray ray)
	{
		return calcColor(geometry, point, ray, 0);
	}

	private Color calcColor(Geometry geometry,Point3D point, Ray inRay, int level)
	{
		if (level == RECURSION_LEVEL) //stop the recurse
			return new Color(0, 0, 0);

		Color ambiantLight = new Color(_scene.getAmbientLight().getIntensity(point).getRGB());//תתאורה סביבתית של הסצנה
		Color emissionLight = new Color(geometry.getEmission().getRGB());//the color of geometry
		Iterator<Light> lights = _scene.getLightIterator();//all the lights of the scene

		int difuseR = 0, difuseG = 0, difuseB = 0, spcularR = 0, specularG = 0, specularB = 0;
		while (lights.hasNext()) {
			Light light = lights.next();
			boolean shadow = occluded(light, point, geometry);
			if (!shadow ) { 
				Color d=new Color(0);
				d = new Color(calcDifuseComp(geometry.get_material().get_Kd(), geometry.getNormal(point), light.getL(point), light.getIntensity(point)).getRGB());
				difuseR += d.getRed();

				difuseG += d.getGreen();

				difuseB += d.getBlue();

				Color s=new Color(0);
				s = new Color(calcSpecularComp(geometry.get_material().get_Ks(), new Vector( _scene.getCamera().getP0(),point), geometry.getNormal(point), light.getL(point),geometry.get_material().get_nShininess(), light.getIntensity(point)).getRGB());
				spcularR += s.getRed();

				specularG += s.getGreen();

				specularB += s.getBlue();

			}
		}
		double kr = geometry.get_material().get_Kr();//kr = mirror reflection 
		Color reflectedLight= new Color(0,0,0);
		if (kr != 0)
		{
			Color reflectedColor = new Color(0,0,0);
			Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
			Map<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);
			for(Entry<Geometry,Point3D> e: reflectedEntry.entrySet())
				reflectedColor = calcColor(e.getKey(), e.getValue(), reflectedRay,level+1);
			reflectedLight = new Color ((int)(kr * reflectedColor.getRed()),(int)(kr * reflectedColor.getGreen()),(int)(kr * reflectedColor.getBlue()));


		}
		double kt = geometry.get_material().get_Kt();//kt= water refraction
		Color refractedLight = new Color(0,0,0);
		if (kt != 0)
		{
			Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
			Map<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
			Color refractedColor = new Color(0,0,0);
			for(Entry<Geometry,Point3D> e: refractedEntry.entrySet())
				refractedColor = calcColor(e.getKey(),e.getValue(), refractedRay ,level+1);		
			refractedLight = new Color ((int)(kt * refractedColor.getRed()),(int)(kt * refractedColor.getGreen()),(int)(kt * refractedColor.getBlue()));
		}
		int finalR, finalG, finalB;


		finalR = ambiantLight.getRed() + emissionLight.getRed() + difuseR + spcularR+ reflectedLight.getRed() +refractedLight .getRed();
		finalG = ambiantLight.getGreen() + emissionLight.getGreen() + difuseG + specularG +reflectedLight.getGreen() + refractedLight .getGreen();
		finalB = ambiantLight.getBlue() + emissionLight.getBlue() + difuseB + specularB +reflectedLight.getBlue() + refractedLight .getBlue();
		if (finalR <0) {
			finalR = finalR*0;
		}
		if (finalG <0) {
			finalG = finalG*0;
		}
		if (finalB <0) {
			finalB = finalB*0;
		}
		if (finalR > 255) {
			finalR = 255;
		}
		if (finalG > 255) {
			finalG = 255;
		}
		if (finalB > 255) {
			finalB = 255;
		}


		Color IO = new Color(finalR, finalG, finalB);
		return IO;
	}

	//this func gets all the "meeting points" of a certain array with all the geometries and checks what is the closest point to the viewplane
	//meaning thats the point that the  between her and P0 (the camera) is the smallest 
	//the func find the closest point from the intersections points
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoint) {
		double distance = Double.MAX_VALUE;
		Point3D po = _scene.getCamera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry:
			intersectionPoint.entrySet()) {
			for (Point3D point : entry.getValue()) {
				if (po.distance(point) < distance) {
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = po.distance(point);
				}
			}
		}
		return minDistancePoint;
	}
	private Map<Geometry,Point3D> findClosestIntersection(Ray reflectedRay)
	{
		Map<Geometry, List<Point3D>> intersections = getSceneRayIntersections(reflectedRay);
		Map<Geometry,Point3D> closestPoint = getClosestPoint(intersections);
		return closestPoint;
	}

	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
		Iterator<Geometry> geometries = _scene.getIteratorGeometries();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<>();

		while (geometries.hasNext()) {
			Geometry geometry = geometries.next();          
			List<Point3D> geometryIntersectionPoints = new ArrayList<>(geometry.FindIntersections(ray));
			if (!geometryIntersectionPoints.isEmpty()) {
				intersectionPoints.put(geometry, geometryIntersectionPoints);
			}
		}
		return intersectionPoints;
	}

	public void renderImage()
	{
		double sumRed=0;
		double sumGreen=0;
		double sumBlue=0;
		int height=_imageWriter.getNy();
		int width=_imageWriter.getNx();
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				sumRed=0;
				sumGreen=0;
				sumBlue=0;
				for(int k=0;k<5;k++)
				{ 
					Ray ray = _scene.getCamera().constructRayThroughPixel
							(_imageWriter.getNx(), _imageWriter.getNy(), j, i,
									_scene.getScreenDistance(), _imageWriter.getWidth(),
									_imageWriter.getHeight(),k);
					Map<Geometry,List<Point3D>> intersectionPoints =getSceneRayIntersections(ray);
					if (intersectionPoints.isEmpty())

					{sumRed+=_scene.getBackground().getRed();
					sumGreen+=_scene.getBackground().getGreen();
					sumBlue+=_scene.getBackground().getBlue();
					}
					else//add the color in the closest point in the intersection points list.
					{
						Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
						for(Entry<Geometry, Point3D> entry: closestPoint.entrySet())
						{
							Color sumColor=calcColor(entry.getKey(),entry.getValue(),ray);
							sumRed+=sumColor.getRed();
							sumGreen+=sumColor.getGreen();
							sumBlue+=sumColor.getBlue();
						}
					}
				}
				sumRed/=5;//average of the colors of 5 rays
				sumGreen/=5;//average of the colors of 5 rays
				sumBlue/=5;//average of the colors of 5 rays
				Color sumColor=addColor(new Color((int)sumRed,(int)sumGreen,(int)sumBlue),new Color(0,0,0));//average of the multi-rays
				_imageWriter.writePixel(j, i, sumColor);

			}
		}

	}
	private Color addColor(Color color1,Color color2)

	{
		int red=color1.getRed()+color2.getRed();
		if(red>255)
			red=255;
		int green=color1.getGreen()+color2.getGreen();
		if(green>255)
			green=255;
		int blue=color1.getBlue()+color2.getBlue();
		if(blue>255)
			blue=255;
		return new Color(red,green,blue);
	}


	private Color calcDifuseComp(double kd, Vector normal, Vector lightToPoint, Color lightIntensity) {
		normal.normalize();
		lightToPoint.normalize();


		double difuseFactor = kd *Math.abs( normal.dotProduct(lightToPoint));
		difuseFactor = Math.abs(difuseFactor);
		int r = (int) (lightIntensity.getRed() * difuseFactor);
		int g = (int) (lightIntensity.getGreen() * difuseFactor);
		int b = (int) (lightIntensity.getBlue() * difuseFactor);
		if (r < 0) {
			r =0;
		}
		if (r > 255) {
			r = 255;
		}
		if (g < 0) {
			g =0;
		}
		if (g > 255) {
			g = 255;
		}
		if (b < 0) {
			b = 0;
		}
		if (b > 255) {
			b = 255;
		}
		return new Color(r, g, b);
	}

	private Color calcSpecularComp(double ks, Vector cameraToPoint, Vector normalOfPoint, Vector lightToPoint, double nShininess, Color intensity) {
		lightToPoint.normalize();
		normalOfPoint.normalize();
		cameraToPoint.normalize();
		double scale =2 * normalOfPoint.dotProduct(lightToPoint);
		//if(scale<0)
		//scale=0;
		Vector temp = new Vector(normalOfPoint);
		temp.scale(scale);
		Vector R = new Vector(lightToPoint);
		R.subtract(temp);
		R.normalize();
		int r,g,b;
		if(cameraToPoint.dotProduct(R)>0) {
			double factor = Math.pow(cameraToPoint.dotProduct(R), nShininess);
			r = (int) (factor * (intensity.getRed()*ks));
			g = (int) (factor * (intensity.getGreen()*ks));
			b = (int) (factor * (intensity.getBlue()*ks));
		}
		else
		{
			r=0;
			b=0;
			g=0;
		}

		if (r < 0) {
			r = r*(-1);
		}
		if (r > 255) {
			r = 255;
		}
		if (g < 0) {
			g =g*(-1);
		}
		if (g > 255) {
			g = 255;
		}
		if (b < 0) {
			b = b*(-1);
		}
		if (b > 255) {
			b = 255;
		}

		return new Color(r, g, b);
	}

	private boolean occluded(Light light, Point3D point, Geometry geometry) {
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);

		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(0.1);

		geometryPoint.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, List<Point3D>> intersectionPoints =
				getSceneRayIntersections(lightRay);

		// Flat geometry cannot self intersect
		if (geometry instanceof geometries.FlatGeometry){
			intersectionPoints.remove(geometry);
		}
		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
		{
			if (entry.getKey().get_material().get_Kt() == 0)
				return true;
		}

		return false;
	}

	private Ray constructReflectedRay (Vector N, Point3D point, Ray inRay)
	{

		Vector l = new Vector(inRay.getDirection());
		l.normalize();
		N.scale(-2*l.dotProduct(N));
		l.add(N);
		Vector R = new Vector(l);
		R.normalize();
		point.add(N);

		Ray reflectedRay = new Ray (point, R);

		return reflectedRay;
	}



	private Ray constructRefractedRay (Vector normal, Point3D point,Ray inRay)
	{
		Vector newVector = new Vector(inRay.getDirection());
		normal.scale(-1);
		point.add(normal);
		return new Ray(point,newVector);

		//newVector.scale(0.0000000000000000000000000002);
		//  inRay.setPRay(point);
		//  newVector.normalize();
		//inRay.getPRay().add(newVector);
		//return new Ray(inRay);
	}
}

