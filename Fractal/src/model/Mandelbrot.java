package model;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Mandelbrot {
	private int iterations;
	private Color color,background;
	
	
	public Mandelbrot(){		
		color = Color.DARKGREY;
		background = Color.WHITE;
		iterations = 100;
	}
	
	public ArrayList<Object[]> getPixels(int x0,int xf,int y0,int yf){
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		for(int i = x0; i <= xf;i++){
			for(int j = y0; j <= yf;j++){
				Object[] e = new Object[3];
				e[0]=i;
				e[1]=j;
				e[2]=getColor(i, j);
				list.add(e);
			}
		}
		return list;
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
