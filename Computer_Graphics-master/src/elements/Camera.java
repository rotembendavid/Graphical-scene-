//hila shamay && michal shalman
//Level 4
package elements;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;
import Primitives.Ray;

//this class represent camera
public class Camera {
	private Point3D P0;
	private Vector vUp;
	private Vector vTo;
	private Vector vRight;
	
	// ***************** Getters/Setters ********************** //

	  public Point3D getP0() {//get P0
	        return new Point3D(P0);
	    }

	    public void setP0(Point3D P0) {//set P0
	        this.P0 = new Point3D(P0);
	    }

	    public Vector getvUp() {//get v Up
	        return new Vector(vUp);
	    }

	    public void setvUp(Vector vUp) {//set vUp
	        this.vUp = new Vector(vUp);
	    }

	    public Vector getvTo() {//get vTo
	        return new Vector(vTo);
	    }

	    public void setvTo(Vector vTo) {//set vTo
	        this.vTo = new Vector(vTo);
	    }

	    public Vector getvRight() {//get vRight
	        return new Vector(vRight);
	    }

	    public void setvRight(Vector vRight) {//set v Right
	        this.vRight = new Vector(vRight);
	    }
	    
		// ***************** Constructors ********************** // 

	    public Camera() {//default constructor
	        this.P0 = new Point3D();
	        this.vUp = new Vector(new Point3D(new Coordinate(),new Coordinate(1),new Coordinate()));
	        this.vTo = new Vector(new Point3D(new Coordinate(),new Coordinate(),new Coordinate(-1)));
	        this.vRight = new Vector(new Point3D(new Coordinate(1),new Coordinate(),new Coordinate()));
	    }

	    public Camera(Point3D P0, Vector vUp, Vector vTo) {//constructor
	        this.P0 = new Point3D(P0);
	        this.vUp = new Vector(vUp);
	        this.vTo = new Vector(vTo);
	        this.vRight = new Vector(vUp.crossProduct(vTo));
	    }
	    public Camera(Camera copy) {//copy constructor
	        this.P0 = new Point3D(copy.P0);
	        this.vUp = new Vector(copy.vUp);
	        this.vTo = new Vector(copy.vTo);
	        this.vRight = new Vector(vUp.crossProduct(vTo));
	    }
	    
		// ***************** Administration ********************** // 

	    @Override
	    public String toString() {//Override to string
	        return "camera origin: " + P0 + " up Vector: " + vUp + " right vector: " + vRight + " fowards vector: " + vTo;
	    }

		@Override
		public boolean equals(Object obj) {//Override equals
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Camera other = (Camera) obj;
			if (P0 == null) {
				if (other.P0 != null)
					return false;
			} else if (!P0.equals(other.P0))
				return false;
			if (vRight == null) {
				if (other.vRight != null)
					return false;
			} else if (!vRight.equals(other.vRight))
				return false;
			if (vTo == null) {
				if (other.vTo != null)
					return false;
			} else if (!vTo.equals(other.vTo))
				return false;
			if (vUp == null) {
				if (other.vUp != null)
					return false;
			} else if (!vUp.equals(other.vUp))
				return false;
			return true;
		}
		
		// ***************** Operations ******************** // 

		
		//this func according the math of the course's book
	    public Ray constructRayThroughPixel(int Nx, int Ny, double i, double j, double screenDistance, double screenWidth, double screenHeight,int flag) {
	        //Nx- number of pixels from right to left
	    	//Ny-number of pixels from up to down
	    	//i- the index of pixel in the line
	    	//j- the index of pixel in column
	    	
	    	//P=Pc+[[(X-(Nx/2)*Rx+(Rx/2)]*Vright-[(Y-(Ny/2)*Ry+(Ry/2)]*Vup]
	    	
	    	
	    	int jumpX=1,jumpY=1;//this condition add for the improvement the color in sides-it help to create 5 rays from each pixel
	    	if(flag==0)//up-left of the pixel
	    	{
	    		jumpX=0;
	    	    jumpY=0;
	    	}
	    	if(flag==1)//up-right of the pixel
	    	{
	    		jumpX=2;
	    		jumpY=0;
	    	}
	    	if(flag==2)//middle of the pixel
	    	{
	    		jumpX=1;
	    		jumpY=1;
	    	}
	    	if(flag==3)//down-left of the pixel
	    	{
	    		jumpX=1;
	    		jumpY=2;
	    	}
	    	if(flag==4)//down-right of the pixel
	    	{
	    		jumpX=2;
	    		jumpY=2;
	    	}
	    	Point3D pc= new Point3D(P0);
	    	Vector v2= new Vector(vTo);
	    	v2.normalize();
	    	v2.scale(screenDistance);
	    	pc.add(v2);//pc is the center of the view plane
	    	double Rx=screenWidth/Nx;//width of 1 pixel
	    	double Ry=screenHeight/Ny;//height of 1 pixel
	    	double tmp1=(i-(Nx/2.0))*Rx+(Rx/2)*jumpX;//part of the formula
	    	double tmp2=(j-(Ny/2.0))*Ry+(Ry/2)*jumpY;//part of the formula
	    	Vector right=new Vector (vRight);
	    	Vector up=new Vector (vUp);
	    	right.scale(tmp1);
	    	up.scale(tmp2);
	    	pc.add(right);
	    	pc.subtract(up);
	    	Vector p=new Vector(new Point3D(pc));
	    	p.normalize();//normalize the direction vector of the ray
	    	return(new Ray(P0,p));//return the ray
	    	
	       
	    }
	    
}
