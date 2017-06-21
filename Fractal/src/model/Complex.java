package model;

public class Complex {

	private double re;
	private double im;
	
	public Complex(double real, double imaginary){
		re=real;
		im=imaginary;
	} 
	
	public double abs(){
		return Math.hypot(re, im);
	}
	
	public Complex plus(Complex b){
		return new Complex(re+b.re, im+b.im);
	}
	
	public Complex times(Complex b){
		return new Complex(re*b.re-im*b.im,im*b.re+re*b.im);
	}
	
	public double re(){
		return re;
	} 
	
	public double im(){
		return im;
	}
	
	
}
