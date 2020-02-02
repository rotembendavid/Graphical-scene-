//hila shamay & michal shalman
//Level 4
package Primitives;

//this class represent ray
public class Ray {
	private Point3D pRay;//point of ray
    private Vector direction;

    
	// ***************** Getters/Setters ********************** // 

    public Point3D getPRay() {//get ray's point
        return new Point3D(pRay);
    }

    public void setPRay(Point3D pRay) {//set ray's point
        this.pRay = new Point3D(pRay);
    }

    public Vector getDirection() {//get direction
        return new Vector(direction);
    }

    public void setDirection(Vector direction) {//set direction
        this.direction = new Vector(direction);
    }
    
	// ***************** Constructors ********************** // 

    public Ray() {//default constructor
        this.pRay=new Point3D();
        this.direction=new Vector();
    }

    public Ray(Point3D pRay1, Vector direction) {//constructor
        this.pRay = new Point3D(pRay1);
        this.direction = new Vector(direction);
    }

    public Ray(Ray copy) {//copy constructor
        this.direction = new Vector(copy.direction);
        this.pRay = new Point3D(copy.pRay);
    }

	// ***************** Administration ********************** // 

    @Override
    public String toString() {//override to string
        return "point: " + pRay + " direction: " + direction;
    }


	@Override
	public boolean equals(Object obj) {//override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (pRay == null) {
			if (other.pRay != null)
				return false;
		} else if (!pRay.equals(other.pRay))
			return false;
		return true;
	}

   

}
