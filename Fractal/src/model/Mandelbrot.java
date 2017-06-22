package model;

import java.util.ArrayList;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Mandelbrot {
	private int iterations;
	private Color color,background;
	
	private double xc,yc,size;
	private int n,m;
	
	public Mandelbrot(){		
		color = Color.DARKGREY;
		background = Color.WHITE;
		iterations = 255;
		xc = -0.5;
		yc = 0;
		size = 2;
		
	}
	
	public void draw(WritableImage image){
		n = (int)image.getWidth(); 
		m = (int)image.getHeight(); 
		PixelWriter pw = image.getPixelWriter();
		Color c;
		for(int i = 0; i < n;i++){
			for(int j = 0; j < m;j++){
				double x0 = xc - size/2 + size*i/n;
                double y0 = yc - size/2 + size*j/m;
				Complex z0 = new Complex(x0,y0);
				if(iterations(z0)<iterations)
					c = background;
				else
					c = color;
				pw.setColor(i,j, c);
			}
		}
	}
	
	
	private int iterations(Complex z0){
		int ans=0;
		Complex z = new Complex(z0.re(), z0.im());
		while(z.abs()<=2.0 && ans<iterations){
			z = z.times(z).plus(z0);
			ans++;
		}
		return ans;
	}
	
	
	private Color getColor(int xs, int ys){
		Color ans = background;
		int x = xs;
		int y = ys;
		int r = 0;
		int i = 0;
		while(r > 10000 || i==iterations){
			x = x*x-y*y-xs;
			y = 2*x*y-ys;
			r = (int) Math.sqrt(x*x+y*y);
			i++;
		}
		if(r>10000){
			ans = color;
		}
		return ans;
	}
	
}
