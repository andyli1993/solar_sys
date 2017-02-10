package module9;

 
import java.awt.Color;

public class datapoint { 
   //initialise initial parameters
	private String name="";
	private Color color;
	private double angle=0;
	private double yearratio=0;
	double distancefromsun =0;
	private int x=0;
	private int y=0;
	private int radius=0;
	//class constructor contains the name of the planet/sun, the color it will be painted onto the screen, x position, y position, angle between the initial radius line and current radius line with respect to the sun
	//  distance from the sun, and the objects radius,the ratio of the time takes for the planet to complete 1 revolution compare to an earth year
	public datapoint(String a,  Color b, int c, int d, double e, double f,double g, int h) {		
		name = a;		
		color = b;
		x = c;
		y = d;
		angle = e;
		yearratio = f;
		distancefromsun =g;
		radius = h;		
	}
	//get the color of the planet(chosen by me)/sun that will be painted onto the screen
	public Color getcolor() {
		return color;
	}
	//set the angle between the initial radius line and current radius line with respect to the sun
	public void setangle(double a) {
		this.angle = a;
	}
	//get the planet/sun name
	public String getname() {
		return name;
	}
	//get the ratio of the time takes for the planet to complete 1 revolution compare to an earth year
	public double getyearratio(){
		return yearratio;
	}
	//get the distance from the sun
	public double getdistancefromsun(){
		return distancefromsun;
	}
	//get the angle between the initial radius line and current radius line with respect to the sun
	public double getangle() {
		return angle;
	}
	//set x position coordiantes
	public void setx(int bb) {
		this.x = bb;
	}
	//set y position coordiantes
	public void sety(int aa) {
		this.y = aa;
	}
	//get the x position coordiantes
	public int getx() {
		return x;
	}
	//get the y position coordiantes
	public int gety() {
		return y;
	}
	//get the radius of the planet/sun
	public int getradius() {
		return radius;
	}
}

	

	
	
