//hila shamay & michal shalman
//Level 4
package Primitives;

//this class represent Point3D
public class Point3D extends Point2D{
	private Coordinate z;

	// ***************** Getters/Setters ********************** // 

	public Coordinate getZ() {// get z
		return z;
	}

	public void setZ(Coordinate z) {//set z
		this.z = z;
	}

	// ***************** Constructors ********************** // 

	public Point3D() {//default contractor
		this.z=new Coordinate();
	}

	public Point3D(Coordinate x1, Coordinate y1, Coordinate z1) {//contractor
		super(x1, y1);
		this.z = new Coordinate(z1);
	}

	public Point3D(Point3D copy) {//copy contractor
		super(copy);
		this.z = new Coordinate(copy.z);
	}
	public Point3D(double x1, double y1, int z1) {
		// TODO Auto-generated constructor stub
		super(x1, y1);
		this.z = new Coordinate(z1);
	}

	// ***************** Administration ********************** // 

	

	@Override
	public String toString() {//override to string
		return "("+ x +"," +y + "," + z + ")";
	}

	@Override
	public boolean equals(Object obj) {// override equals
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}

	// ***************** Operations ******************** // 


	public void add(Vector v) {// add coordinate to vector
		getX().add(v.getHead().getX());//add x to x
		getY().add(v.getHead().getY());//add y to y
		z.add(v.getHead().z);//add z to z
	}

	public void subtract(Vector v) {//sub coordinate from vector
		getX().subtract(v.getHead().getX());//sub x from x
		getY().subtract(v.getHead().getY());//sub y from y
		z.subtract(v.getHead().z);   //sub z from z
	}
	public double distance(Point3D point) //get the distance between 2 3d point
	//shoresh((x1-x2)^2+(y1-y2)^2+(z1-z2)^2)
	{
		return Math.sqrt(Math.pow((this.getX().getCoordinate()-point.getX().getCoordinate()), 2)+Math.pow(this.getY().getCoordinate()-point.getY().getCoordinate(), 2)+Math.pow(this.getZ().getCoordinate()-point.getZ().getCoordinate(), 2));
	}


}
