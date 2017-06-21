package model;

import java.util.ArrayList;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Mandelbrot {
	private int iterations;
	private Color color,background;
	
	private double xc,yc,size;
	private int n,max;
	
	public Mandelbrot(){		
		color = Color.DARKGREY;
		background = Color.WHITE;
		iterations = 100;
		xc = -0.5;
		yc = 0;
		size = 2;
		max = 255;
	}
	
	public void draw(int x0,int xf,int y0,int yf,WritableImage image){
		n = (int)image.getWidth(); 
		PixelWriter pw = image.getPixelWriter();
		Color c;
		for(int i = 0; i <= n;i++){
			for(int j = 0; j <= n;j++){
				c = getColor(i,j);
				pw.setColor(width/2+i,height/2+j, c);
				//c = Color.BLUE;
				//pw.setColor(i, j, c);
			}
		}
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
