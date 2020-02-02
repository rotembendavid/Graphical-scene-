//hila shamay && michal shalman
//Level 4
package Primitives;

//this class represent vector
public class Vector  {
	protected Point3D head;

	// ***************** Getters/Setters ********************** // 

	public Point3D getHead() {// get vector's head
		return new Point3D(head);
	}

	public void setHead(Point3D head) {//set vector's head
		this.head = new Point3D(head);
	}

	// ***************** Constructors ********************** // 

	public Vector() {//default constructor
		this.head = new Point3D();
	}

	public Vector(Point3D head1) {//constructor
		this.head = new Point3D(head1);
	}

	public Vector(Vector copy) {//copy constructor
		this.head = new Point3D(copy.head);
	}
	public Vector(Point3D point, Point3D po) {
		this.head = new Point3D(point);
		Vector temp=new Vector(po);
		this.head.subtract(temp);
		this.normalize();

	}

	// ***************** Administration ********************** // 

	public Vector(int i, int j, int k) {
		this.head = new Point3D(new Coordinate(i),new Coordinate(j),new Coordinate(k));
	}

	@Override
	public String toString() {//Override to string
		return head.toString();
	}

	@Override
	public boolean equals(Object obj) {//Override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}



	// ***************** Operations ******************** // 

	public void add(Vector v) {//add 2 vectors
		this.head.add(v);
	}

	public void subtract(Vector v) {//sub 2 vectors
		this.head.subtract(v);
	}

	public void scale(double scale) {//multiplication with scale the vector
		head.getX().setCoordinate(head.getX().getCoordinate() * scale);//multiplication x on scale
		head.getY().setCoordinate(head.getY().getCoordinate() * scale);//multiplication y on scale
		head.getZ().setCoordinate(head.getZ().getCoordinate() * scale);//multiplication z on scale
	}



	public double length() {// the length of vector
		//shoresh(x^2 + y^2 + z^2)
		return Math.sqrt(Math.pow(head.getX().getCoordinate(), 2) + Math.pow(head.getY().getCoordinate(), 2) + Math.pow(head.getZ().getCoordinate(), 2));
	}

	public void normalize() {// normalize the vector
		double length1 = this.length();//divide by vector's length
		if (length1 == 0) {
			return;//can't divide by 0
		}
		this.head.getX().setCoordinate(this.head.getX().getCoordinate() / length1);//divide x in length
		this.head.getY().setCoordinate(this.head.getY().getCoordinate() / length1);//divide x in length
		this.head.getZ().setCoordinate(this.head.getZ().getCoordinate() / length1);//divide x in length
	}

	public Vector crossProduct(Vector v) {//Vector product i,j,k
		double x1, y1, z1, x2, y2, z2, newX, newY, newZ;
		x1 = this.head.getX().getCoordinate();
		x2 = v.head.getX().getCoordinate();
		y1 = this.head.getY().getCoordinate();
		y2 = v.head.getY().getCoordinate();
		z1 = this.head.getZ().getCoordinate();
		z2 = v.head.getZ().getCoordinate();
		newX = y1 * z2 - z1 * y2;
		newY = -(x1 * z2 - z1 * x2);
		newZ = x1 * y2 - y1 * x2;
		Vector newVector = new Vector(new Point3D(new Coordinate(newX), new Coordinate(newY), new Coordinate(newZ)));
		return newVector;
	}
	public double dotProduct(Vector v) {//Sklar product
		//x1*x2 +y1*y2 + z1*z2
		return head.getX().getCoordinate() * v.head.getX().getCoordinate() + head.getY().getCoordinate() * v.head.getY().getCoordinate() + head.getZ().getCoordinate() * v.head.getZ().getCoordinate();
	}
}
