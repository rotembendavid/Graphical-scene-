//hila shamay && michal shalman
//Level 4
package geometries;
//this is abstract class represent the Properties of  radial geometry
abstract public class RadialGeometry extends Geometry{

    protected double radius;// Radius
 // ***************** Getters/Setters ********************** // 
    public double getRadius() {// get radius
        return radius;
    }

    public void setRadius(double radius) {//set radius
        this.radius = radius;
    }
 // ***************** Constructors ********************** //
    public RadialGeometry() {//default constructor
    }

    public RadialGeometry(double radius) {//constructor
        this.radius = radius;
    }

}