package elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;
//תאורה ממקור אור נקודתי
public class PointLight extends Light{

	double area;

	protected Point3D _position;//נקודת מרכז האור
	protected double _kc, _kl, _kq;//גורמי הנחתה

	// ***************** Constructors ********************** //  
	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {//Constructor
		this.color = new Color(color.getRGB());
		this._position = new Point3D(position);
		this._kc = kc;
		this._kl = kl;
		this._kq = kq;
	

	}
	// ***************** Getters/Setters ********************** //

	public Point3D get_position() {//get _position
		return _position;
	}

	public void set_position(Point3D _position) {//set _position
		this._position = _position;
	}

	public double get_kc() {//get _kc
		return _kc;
	}

	public void set_kc(double _kc) {//set _kc
		this._kc = _kc;
	}

	public double get_kl() {//get _kl
		return _kl;
	}

	public void set_kl(double _kl) {//set _kl
		this._kl = _kl;
	}

	public double get_kq() {//get _kq
		return _kq;
	}

	public void set_kq(double _kq) {//set _kq
		this._kq = _kq;
	}
	
	// ***************** Administration ********************** // 


	@Override
	public String toString() {
		return "position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}

	@Override
	public Color getIntensity(Point3D point) {//Calculate the color of light
		double distance = point.distance(_position);
		double k= _kc + _kl * distance + _kq * distance * distance;//Calculate the part of color by distance and more...
		if(k<1) 
			k=1;
		
		int r = (int) (color.getRed() / k);
		int g = (int) (color.getGreen() / k);
		int b = (int) (color.getBlue() / k);
		//check right of r,g,b
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
	public Vector getL(Point3D point) {//return vector from light source to point
		Point3D point2=new Point3D(point);
		Vector temp=new Vector(_position);
		point2.subtract(temp);//from light to position
		Vector v=new Vector(point2);
		v.normalize();//normal the vector
		return v;
	}


}
