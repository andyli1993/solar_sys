package module9;

import java.awt.Color;

public class comet extends datapoint {
	
	
	
	datapoint parent;

	public comet(String a, Color b, int c, int d, double e, double f, double g, int h,datapoint parent) {
		super(a, b, c, d, e, f, g, h);
		
		this.parent= parent;
		// TODO Auto-generated constructor stub
	}
	
	
	datapoint getparent(){
		
		return parent;
	}
	
	

}
