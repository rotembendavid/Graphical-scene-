//hila shamay & michal shalman
//Level4
package Primitives;

//this class represent Point2D
public class Point2D {
	protected Coordinate x;
	protected Coordinate y;
	
	// ***************** Getters/Setters ********************** // 
	
	public Coordinate getX() {//get x
		return x;
	}
	public void setX(Coordinate x) {//set x
		this.x = x;
	}
	public Coordinate getY() {//get y
		return y;
	}
	public void setY(Coordinate y) {//set y
		this.y = y;
	}
	
	// ***************** Constructors ********************** // 

	public Point2D() {// default constructor
        this.x = new Coordinate();
        this.y = new Coordinate();
    }

    public Point2D(Coordinate x1, Coordinate y1) {//constructor
        this.x = new Coordinate(x1);
        this.y = new Coordinate(y1);
    }

    public Point2D(Point2D copy) {//copy constructor
        this.x = new Coordinate(copy.x.getCoordinate());
        this.y = new Coordinate(copy.y.getCoordinate());
    }
	public Point2D(double x1, double y1) {
		// TODO Auto-generated constructor stub
		this.x = new Coordinate(x1);
        this.y = new Coordinate(y1);
	}
    
 // ***************** Administration ********************** // 
	

	@Override
	public boolean equals(Object obj) {//Override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	@Override
	public String toString() {//override to string
		return "(" + x + "," + y + ")";
	}
	
	// ***************** Operations ******************** // 

/*	public void add(Vector v) {
        x.add(v.getHead().getX());
        y.add(v.getHead().getY());
    }

    public void subtract(Vector v) {
        x.subtract(v.getHead().getX());
        y.subtract(v.getHead().getY());
    }
    */
}
