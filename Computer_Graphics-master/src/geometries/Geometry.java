//hila shamay && michal shalman
//Level 4
package geometries;

import java.awt.Color;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Primitives.Ray;
import java.util.List;


//this is abstract class represent the Properties of geometry
public abstract class Geometry {
	private Material _material = new Material();//the metiral of geometry
	private Color emission = new Color(0, 0, 0);//color of geometry

	// ***************** Getters/Setters ********************** // 
	public Color getEmission() {//get color
		return new Color(emission.getRGB());
	}


	public void setEmission(Color color1) {//set color
		this.emission = new Color(color1.getRGB());
	}
	

	public Material get_material() {
		return _material;
	}


	public void set_material(Material _material) {
		this._material = _material;
	}


	// ***************** Constructors ********************** //
	public Geometry() {//default constructor
	}


	public abstract Vector getNormal(Point3D p);//Abstract func to get normal to the geometry
	public abstract List<Point3D> FindIntersections(Ray ray);//Abstract func to find intersections with the geometry


}
