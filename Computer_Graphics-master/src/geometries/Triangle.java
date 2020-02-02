//hila shamay && michal shalman
//Level 4
package geometries;

import Primitives.Point3D;
import Primitives.Vector;
import java.util.List;

//import Geometries.FlatGeometry;
import Primitives.Ray;
import java.util.ArrayList;

//this class represent triangle
public class Triangle  extends Geometry  implements FlatGeometry{
	private Point3D p1;
	private Point3D p2;
	private Point3D p3;

	// ***************** Getters/Setters ********************** // 

	public Point3D getP1() { //get p1
		return new Point3D(p1);
	}

	public void setP1(Point3D p1) {//set p1
		this.p1 = new Point3D(p1);
	}
	public Point3D getP2() {//get p2
		return new Point3D(p2);
	}
	public void setP2(Point3D p2) {//set p2
		this.p1 = new Point3D(p2);
	}
	public Point3D getP3() {//get p3
		return new Point3D(p3);
	}
	public void setP3(Point3D p3) {//set p3
		this.p1 = new Point3D(p3);
	}

	// ***************** Constructors ********************** //
	public Triangle() {//default constructor
		p1 = new Point3D();
		p2 = new Point3D();
		p3 = new Point3D();
	}

	public Triangle(Point3D p1, Point3D p2, Point3D p3) {//constructor
		this.p1 = new Point3D(p1);
		this.p2 = new Point3D(p2);
		this.p3 = new Point3D(p3);
	}

	public Triangle(Triangle copy) {// copy constructor
		this.p1 = new Point3D(copy.p1);
		this.p2 = new Point3D(copy.p2);
		this.p3 = new Point3D(copy.p3);
	}

	// ***************** Administration ********************** // 

	@Override
	public boolean equals(Object obj) {//override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		return true;
	}

	@Override
	public String toString() {//Override to string
		return "p1:"+p1.toString()+" "+"p2:"+p2.toString()+" "+"p3:"+p3.toString();
	}

	@Override
	public Vector getNormal(Point3D p) {// func return the normal vector
		//Same for every point
		Vector v1 = new Vector(p1);
		v1.subtract(new Vector(p2));//SUBSTRUCT point p1 from vector v1

		Vector v2 = new Vector(p3);
		v2.subtract(new Vector(p2));//SUBSTRUCT point 2 from vector v2

		Vector normal = new Vector(v2.crossProduct(v1));//to get the normal we need to do cross product with v1 and v2
		normal.normalize();//normal the vector
		return normal;
	}

	public Vector triangleNormal(Point3D p1, Point3D p2, Point3D cameraPoo) {
		Vector temp=new Vector(cameraPoo);
		p1.subtract(temp);
		p2.subtract(temp);
		Vector vp1 = new Vector(p1);
		Vector vp2 = new Vector(p2);
		vp1 = vp1.crossProduct(vp2);
		vp1.normalize();
		return vp1;
	}

	@Override
	public List<Point3D> FindIntersections(Ray ray) {//func to find intersections with the triangle

		//V1=T1-P0
		//V2=T2-P0
		//N1=(V2xV1)/|V2xV1|
		//THEN
		//if sign((P-P0)*N1)==sign(P-P0)*N2)==sign(P-P0)*N3)->return True;
		Vector planeNormal = new Vector(this.getNormal(p1));
		Plane planeOfTriangle = new Plane(p3, planeNormal);
		ArrayList<Point3D> list2 = new ArrayList<>(planeOfTriangle.FindIntersections(ray));
		if (list2.isEmpty()) {
			return list2;
		}
		Point3D planeIntersectionPoint = list2.get(0);
		Vector normal1 = new Vector(triangleNormal(new Point3D(p1), new Point3D(p2), new Point3D(ray.getPRay())));
		Vector normal2 = new Vector(triangleNormal(new Point3D(p2), new Point3D(p3), new Point3D(ray.getPRay())));
		Vector normal3 = new Vector(triangleNormal(new Point3D(p3), new Point3D(p1), new Point3D(ray.getPRay())));

		Point3D testPoint = new Point3D(ray.getPRay());
		Vector temp=new Vector(planeIntersectionPoint);
		testPoint.subtract(temp);
		Vector testVector = new Vector(testPoint);

		double dotProduct1 = testVector.dotProduct(normal1);
		double dotProduct2 = testVector.dotProduct(normal2);
		double dotProduct3 = testVector.dotProduct(normal3);

		if ((dotProduct1 > 0 && dotProduct2 > 0 && dotProduct3 > 0) || (dotProduct1 < 0 && dotProduct2 < 0 && dotProduct3 < 0)) {
			return list2;          
		} else {
			list2.clear();
			return list2;
		}
	}




}
