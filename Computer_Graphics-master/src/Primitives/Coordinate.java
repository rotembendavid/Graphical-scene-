//hila shamay & michal shalman
//Level 4
package Primitives;

//this class represent coordinate
public class Coordinate {
	private double coordinate;

	
	
	// ***************** Constructors ********************** // 
	public Coordinate() {//Default constructor
		coordinate=0;
	}

	public Coordinate(double coordinate1) {//constructor
		this.coordinate = coordinate1;
	}

	public Coordinate(Coordinate copy) {//copy constructor
		this.coordinate = copy.getCoordinate();
	}

	// ***************** Getters/Setters ********************** // 
	public double getCoordinate() {//get coordinate
		return coordinate;
	}

	public void setCoordinate(double coordinate1) {//set coordinate
		this.coordinate = coordinate1;
	}
	
	// ***************** Administration ********************** // 
	@Override
	public String toString() {//override to string
		return Double.toString(coordinate);
	}


	@Override
	public boolean equals(Object obj) {//override equals
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//get is unequal
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(coordinate) != Double.doubleToLongBits(other.coordinate))//the coordinate unequal 
			return false;
		return true;
	}
	
	
	// ***************** Operations ******************** // 

	public void add(Coordinate c) {//add coordinates
		this.coordinate += c.coordinate;
	}

	public void subtract(Coordinate c) {//sub coordinates
		this.coordinate -= c.coordinate;
	}
}
