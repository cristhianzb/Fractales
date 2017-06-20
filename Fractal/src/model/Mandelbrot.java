package model;

import javafx.scene.paint.Color;

public class Mandelbrot {
	private int xs,ys,x,y,iterations;
	private Color color,background;
	
	
	public Mandelbrot(int xs,int ys){
		this.xs=xs;
		this.ys=ys;
		color = Color.DARKGREY;
		background = Color.WHITE;
		iterations = 100;
	}
	
	public Color NewValues(int xs, int ys){
		Color ans = background;
		x = xs;
		y = ys;
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
