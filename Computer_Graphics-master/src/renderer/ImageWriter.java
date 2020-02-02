package renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

	private int _imageWidth;//the width of image
	private int _imageHeight;//the height of image

	private int _Ny, _Nx;//num of pixel on x,y

	final String PROJECT_PATH = System.getProperty("user.dir");//the place to save the picture

	private BufferedImage _image;

	private String _imageName;//name of image

	// ***************** Constructors ********************** // 

	public ImageWriter(String imageName, int width, int height, int Ny, int Nx){//constructor

		_Nx = Nx;
		_Ny = Ny;

		_imageWidth = width;
		_imageHeight = height;

		_imageName = imageName;

		_image = new BufferedImage(
				_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
	}

	public ImageWriter (ImageWriter imageWriter){//copy constructor
		_Nx = imageWriter._Nx;
		_Ny = imageWriter._Ny;

		_imageWidth = imageWriter.getWidth();
		_imageHeight = imageWriter.getHeight();

		_imageName = imageWriter._imageName;

		_image = new BufferedImage(
				_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
	}

	// ***************** Getters/Setters ********************** //

	public int getWidth()  { return _imageWidth;  }//get Width
	public int getHeight() { return _imageHeight; }//getHeight

	public int getNy() { return _Ny; }//get Ny
	public int getNx() { return _Nx; }//get Nx

	public void setNy(int _Ny) { this._Ny = _Ny; }//set Ny
	public void setNx(int _Nx) { this._Nx = _Nx; }//set Nx

	// ***************** Operations ******************** // 

	public void writeToimage(){//make set all the values

		File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");//make new file

		try {
			ImageIO.write(_image, "jpg", ouFile);
		} catch (IOException e) {//if fail
			e.printStackTrace();
		}
	}

	public void writePixel(int xIndex, int yIndex, int r, int g, int b){//color all the pixel he get

		int rgb = new Color(r, g, b).getRGB();
		_image.setRGB(xIndex, yIndex, rgb);

	}

	public void writePixel(int xIndex, int yIndex, int[] rgbArray){//get array of color and coloring all the pixel like the array

		int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
		_image.setRGB(xIndex, yIndex, rgb);

	}

	public void writePixel(int xIndex, int yIndex, Color color){//color all the pixel he get


		_image.setRGB(xIndex, yIndex, color.getRGB());

	}

}
