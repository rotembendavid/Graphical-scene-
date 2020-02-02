package elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public abstract class Light {//all types of light extend this class
	public Color color;
	// ***************** Constructors ********************** // 
    public Light() {//Default Constructor
       
    }

    public Light(Color color) {//Constructor
        this.color = new Color(color.getRGB());
    }

// ***************** Getters/Setters ********************** // 
    public abstract Color getIntensity(Point3D point);//Calculate the color of light 
    public abstract Vector getL(Point3D point);//return vector from light source to point


}
