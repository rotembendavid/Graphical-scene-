//hila shamay && michal shalman
//Level 4
package geometries;

import Primitives.Point3D;
import Primitives.Vector;
import java.util.List;
import Primitives.Ray;
import java.util.ArrayList;

//this class represent sphere
public class Sphere extends RadialGeometry{
	private Point3D center;//center of sphere
	// ***************** Getters/Setters ********************** // 
	public Point3D getCenter() {// get center
		return new Point3D(center);
	}

	public void setCenter(Point3D center) {//set center
		this.center = new Point3D(center);
	}
	// ***************** Constructors ********************** //
	public Sphere() {//default constructor
		this.center=new Point3D();
	}
	public Sphere(Point3D center, double radius) {//constructor
		super(radius);
		this.center = new Point3D(center);
	}
	public Sphere(Sphere copy) {//copy constructor
		this.radius=copy.radius;
		this.center = new Point3D(copy.getCenter());
	}
	
	// ***************** Administration ********************** // 

	@Override
	public String toString() {//override to string
		return "radious: "+radius+" center: "+center;
	}



	@Override
	public boolean equals(Object obj) {//override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		return true;
	}


	@Override
	public Vector getNormal(Point3D p) {// return the normal vector 
		Vector po=new Vector(new Point3D(p));//NEW VECTOR WITH THE POINT TO NORMAL
		Vector temp=new Vector(center);//new vector by the center
		
		po.subtract(temp);//substract vector by center from vector to point
		Vector v=new Vector(po);     
		v.normalize();//normal the vector
		return new Vector(v);
		
		//head minus tell - the center is the head

	}

	   @Override
	    public List<Point3D> FindIntersections(Ray ray) {//func to find intersections with the sphere
	       //Ray:P=P0+tV
		   //Sphere/:|P-O|-r^2=0
		   //th=(r^2-d^2)^0.5
		   //t1=tm-tn
		   //t2=tm+tn
		   //P1=P0+t1V
		   //P2=P0+t2V
		   ArrayList<Point3D> list =new ArrayList<Point3D>();
	        Vector L=new Vector(center);
	        L.subtract(new Vector(ray.getPRay()));
	        double tm=L.dotProduct(ray.getDirection());
	        double d=Math.sqrt(L.dotProduct(L)-tm*tm);
	        if(d>radius)return list;
	        double th=Math.sqrt(radius*radius-d*d);
	        double t1=tm-th;
	        double t2=tm+th; 
	        Vector V=new Vector(ray.getDirection());
	        if(t1>=0){
	        Point3D p1=new Point3D(ray.getPRay());       
	        V.scale(t1);
	        p1.add(V);
	        list.add(p1);}
	        if(t2>=0){
	        Point3D p2=new Point3D(ray.getPRay());
	        V=new Vector(ray.getDirection());
	        V.scale(t2);
	        p2.add(V);  
	        list.add(p2);}
	        return list;
	    }

}
