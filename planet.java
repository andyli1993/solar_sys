package module9;

import java.awt.Color;

public class planet extends datapoint{
	
	
	datapoint parent;

	public planet(String a, Color b, int c, int d, double e, double f, double g, int h,datapoint parent) {
		super(a, b, c, d, e, f, g, h);
		// TODO Auto-generated constructor stub
	}
	
	public datapoint getparent(){

		
		return parent;
	
	

	}
}
