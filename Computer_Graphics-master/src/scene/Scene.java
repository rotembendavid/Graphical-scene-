//hila shamay & michal shalman
//Level 4
package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;


public class Scene {
	//this class represent scene
	private String sceneName;//the name of scene
	private Color background;//color of background
	public List<Geometry> geometries;//geometries of scene
	public List<Light> lights;//light of scene
	private Camera camera;//camera
	private double screenDistance;//distance from the camera
	private AmbientLight ambientLight;//תאורה סביבתית

	// ***************** Getters/Setters ********************** // 


	public String getSceneName() {//get SceneName
		return new String(sceneName);
	}

	public void setSceneName(String sceneName) {//set SceneName
		this.sceneName = new String(sceneName);
	}

	public AmbientLight getAmbientLight() {//get Ambient Light
		return new AmbientLight(ambientLight);
	}

	public void setAmbientLight(AmbientLight ambientLight) {//set AmbientLight
		this.ambientLight = new AmbientLight(ambientLight);
	}

	public Color getBackground() {//get Background
		return new Color(background.getRGB());
	}

	public void setBackground(Color background) {//set Background
		this.background = new Color(background.getRGB());
	}


	public Camera getCamera() {//get Camera
		return new Camera(camera);
	}

	public void setCamera(Camera camera) {//set Camera
		this.camera = new Camera(camera);
	}

	public ArrayList<Geometry> getGeometries() {//get Geometries
		return (ArrayList<Geometry>) geometries;
	}

	public void setGeometries(List<Geometry> geometries) {//set Geometries
		this.geometries = geometries;
	}

	public double getScreenDistance() {//get ScreenDistance
		return screenDistance;
	}

	public void setScreenDistance(double screenDistance) {//set ScreenDistance
		this.screenDistance = screenDistance;
	}

	// ***************** Constructors ********************** // 
	public Scene(String sceneName, Color background,AmbientLight ambientLight, Camera camera, double screenDistance, ArrayList<Geometry> c , ArrayList<Light> d) //constructor
	{
		this.sceneName = new String(sceneName);
		this.background = new Color(background.getRGB());
		this.camera = new Camera(camera);
		this.screenDistance = screenDistance;
		this.ambientLight = new AmbientLight(ambientLight);
		this.geometries = new ArrayList<Geometry>();
		this.lights = new ArrayList<Light>();
		this.geometries.addAll(c);
		this.lights.addAll(d);

	}

	public Scene(Scene s1) //copy contractor
	{
		this.ambientLight = new AmbientLight(s1.ambientLight);
		this.sceneName = new String(s1.sceneName);
		this.background = new Color(s1.background.getRGB());
		this.camera = new Camera(s1.camera);
		this.screenDistance = s1.screenDistance;
		geometries = new ArrayList<Geometry>();
		lights = new ArrayList<Light>();

	}

	public Scene() {//Default contractor
		this.sceneName="The Scene";
		this.background=new Color(0, 0, 0);
		this.camera=new Camera();
		this.screenDistance=149;
		this.geometries=new ArrayList<Geometry>();
		this.lights = new ArrayList<Light>();
		this.ambientLight= new AmbientLight();

	}

	// ***************** Administration ********************** // 

	@Override
	public String toString() {
		return "Scene [sceneName=" + sceneName + ", background=" + background + ", geometries=" + geometries
				+ ", lights=" + lights + ", camera=" + camera + ", screenDistance=" + screenDistance + ", ambientLight="
				+ ambientLight + "]";
	}


	// ***************** Operations ******************** // 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (ambientLight == null) {
			if (other.ambientLight != null)
				return false;
		} else if (!ambientLight.equals(other.ambientLight))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (camera == null) {
			if (other.camera != null)
				return false;
		} else if (!camera.equals(other.camera))
			return false;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		if (lights == null) {
			if (other.lights != null)
				return false;
		} else if (!lights.equals(other.lights))
			return false;
		if (sceneName == null) {
			if (other.sceneName != null)
				return false;
		} else if (!sceneName.equals(other.sceneName))
			return false;
		if (Double.doubleToLongBits(screenDistance) != Double.doubleToLongBits(other.screenDistance))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 

	//adding the geometries to the list
	public void addGeometry(Geometry g)
	{
		this.geometries.add(g);
	}

	public Iterator<Geometry> getIteratorGeometries() {//return iterator of geometry list
		return geometries.iterator();
	}
	public Iterator<Light> getLightIterator() {//return iterator of light list
		return lights.iterator();
	}
	public void addLight(Light light) {//adding the light to the list
		lights.add(light);
	}

}
