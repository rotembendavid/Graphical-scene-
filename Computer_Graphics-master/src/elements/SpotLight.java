package elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;
//this class extend point light
public class SpotLight extends PointLight {
	private Vector _direction;//direction of light
	// ***************** Constructor ********************** // 
	public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq) {
		super(color, position, kc, kl, kq);
		this._direction = new Vector(direction);
		_direction.normalize();
	}
	// ***************** Getters/Setters ********************** //
	public Vector get_direction() {//get _direction
		return _direction;
	}
	public void set_direction(Vector _direction) {//set _direction
		this._direction = _direction;
	}
	// ***************** Administration ********************** // 
	@Override
	public String toString() {
		String r= super.toString();
		r+="direction=" + _direction;
		return r;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	@Override
	public Color getIntensity(Point3D point) {//Calculate the color of light
		Point3D po = new Point3D(point);
		Vector temp=new Vector(_position);
		po.subtract(temp);
		Vector D = new Vector(po);
		D.normalize();
		_direction.normalize();
		double distance = point.distance(_position);
		double dotP = D.dotProduct(_direction);
		dotP = Math.abs(dotP);
		double  k=_kc + _kl * distance + _kq * distance * distance;
		if(k<1)
			k=1;
		int r = (int) ((color.getRed() * dotP) /k);
		int g = (int) ((color.getGreen() * dotP) / k);
		int b = (int) ((color.getBlue() * dotP) / k);
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


}
