//hila shamay && michal shalman
//Level 4
package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.util.ArrayList;
import java.util.List;

//import Geometries.FlatGeometry;

//this class represent plane
public class Plane extends Geometry  implements FlatGeometry {
	private Point3D pPlane;// point on plane
	private Vector plumb;//plumb to plane
	
	// ***************** Getters/Setters ********************** // 

	public Point3D getpPlane() {//get plane's point
		return new Point3D(pPlane);
	}
	public void setpPlane(Point3D pPlane) {//set plane's point
		this.pPlane = new Point3D(pPlane);
	}
	public Vector getPlumb() {//get plumb
		return new Vector(plumb);
	}
	public void setplumb(Vector p) {//set plumb
		this.plumb = new Vector(p);
	}
	// ***************** Constructors ********************** //
	public Plane() {//default constructor
		pPlane = new Point3D();
		plumb = new Vector();
	}

	public Plane(Point3D p, Vector plumb1) {//constructor
		this.pPlane = new Point3D(p);
		this.plumb = new Vector(plumb1);
	}

	public Plane(Plane copy) {// copy constructor

		this.pPlane = new Point3D(copy.pPlane);
		this.plumb = new Vector(copy.plumb);
	}
	
	// ***************** Administration ********************** // 

	@Override
	public String toString() {//override to string
		return "Plane point=" + pPlane + ", plumb vector=" + plumb ;
	}

	@Override
	public boolean equals(Object obj) {// override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (plumb == null) {
			if (other.plumb != null)
				return false;
		} else if (!plumb.equals(other.plumb))
			return false;
		if (pPlane == null) {
			if (other.pPlane != null)
				return false;
		} else if (!pPlane.equals(other.pPlane))
			return false;
		return true;
	}
	@Override
	public Vector getNormal(Point3D p) {// func return the normal
		/*Vector normal = new Vector(plumb);
		normal.normalize();// normalize the vector
		return normal;*/
		Vector v= new Vector(p);//new vector to point p
		Vector v2= v.crossProduct(this.plumb);
		return v2;
	}
	
    @Override
   
    public List<Point3D> FindIntersections(Ray ray) {//func to find intersections with the plane
    //N*(P0+tV-Q0)=0
    	//t=-N*(P0-Q0)/(N*V)
    	//P=P0+tV
    	//N*(P0+tV-Q0)=0
    	ArrayList<Point3D> list = new ArrayList<Point3D>();//make array of point3d
        Vector v = new Vector(ray.getPRay());//new vector from the point of the ray
        Vector direction=new Vector(ray.getDirection());//direction vector
        v.subtract(new Vector(pPlane));//subtract vector to plane from the ray vector
        double f = plumb.dotProduct(direction);//dot product
        if (f != 0) {
            double t = -(plumb.dotProduct(v) / f);
            if (t > 0) {
                direction.scale(t);
                Point3D p = new Point3D(ray.getPRay());
                p.add(direction);
                list.add(p);//add point to list
            }
        }
        return list;
    }





}
