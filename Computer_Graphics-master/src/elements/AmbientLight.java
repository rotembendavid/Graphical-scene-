package elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;
//this func extend light
public class AmbientLight extends Light {//תאורה סביבתית

	final private double _ka= 0.1;//גורם הרחקה

	// ***************** Constructors ********************** // 

	public AmbientLight(){//Default Constructor
		color=new Color(255,255,255);//Default-white
	}
	public AmbientLight(AmbientLight aLight)// copy Constructor
	{
		color=new Color(aLight.color.getRGB());
	}
	public AmbientLight(int r, int g, int b)//Constructor
	{
		color=new Color(r,g,b);   
	}
	// ***************** Getters/Setters ********************** //
	public double get_ka() {//get _ka
		return _ka;
	}
	
	// ***************** Administration ********************** // 
	@Override
	public String toString() {
		return "_ka=" + _ka;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}
	@Override
	public Color getIntensity(Point3D P) {//Calculate the color of light
		int r=color.getRed();
		int g=color.getGreen();
		int b=color.getBlue();
		//mult' with גורם ההרחקה
		r*=_ka;
		g*=_ka;
		b*=_ka;
		if (r <0) {
			r = 0;
		}
		if (g <0) {
			g = 0;
		}
		if (b <0) {
			b = 0;
		}
		if(r>255){
			r=255;
		}
		if(g>255){
			g =255;
		}
		if(b>255){
			b=255;
		}
		return new Color(r,g,b);
	}
	@Override
	public Vector getL(Point3D point)//return vector from light source to point
	{
		return new Vector(0,0,0);//Default, does'nt need in ambient
	}



}
