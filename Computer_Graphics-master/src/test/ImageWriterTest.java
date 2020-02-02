package test;

import static org.junit.Assert.*;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void test1() 
	{
		ImageWriter image= new ImageWriter("test1",500,500,500,500);
		printGrid(image,50);
		for(int i=251;i<300;i++)
			for(int j=251;j<300;j++)
				image.writePixel(i, j, 255,0,0);
		image.writeToimage();
		assertTrue(true);
	}
	
	@Test
	public void test2() 
	{
		ImageWriter image= new ImageWriter("test2",500,500,500,500);
		printGrid(image,50);
		for(int i=151;i<200;i++)
			for(int j=151;j<i;j++)
				image.writePixel(i, j, 255,0,0);
		image.writeToimage();
		assertTrue(true);
	}
	
	@Test
	public void test3() 
	{
		ImageWriter image= new ImageWriter("test3",500,500,500,500);
		printGrid(image,50);
		for(int i=251;i<300;i++)
			for(int j=200;j<i;j++)
				image.writePixel(i, j, 255,0,0);
		image.writeToimage();
		assertTrue(true);
	}
	
	public void printGrid(ImageWriter image, int interval)
	{
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
				if(i%interval==0|| j%interval==0)
					image.writePixel(i, j, 255,255,255);
				else
					image.writePixel(i, j, 0,0,0);
	}

}
