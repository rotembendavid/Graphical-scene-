package elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;
//תאורה עם כיוון
public class DirectionalLight extends Light{
	private Vector direction;//כיוון האור   
	// ***************** Constructors ********************** //  
	public DirectionalLight(Color color, Vector direction)//Constructor
	{
		this.color=new Color(color.getRGB());
		this.direction=new Vector(direction);
	}     
	// ***************** Getters/Setters ********************** // 
	public Vector getDirection() {//get Direction
		return direction;
	}
	public void setDirection(Vector direction) {//set Direction
		this.direction =  new Vector(direction);
	}
	// ***************** Administration ********************** // 
	@Override
	public String toString() {
		return "direction=" + direction;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}
	@Override
	public Color getIntensity(Point3D point){//Calculate the color of light
		return new Color(color.getRGB());}

	@Override
	public Vector getL(Point3D point){//return vector from light source to point
		return new Vector(direction);}



}
