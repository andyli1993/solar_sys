package module9;

import java.awt.Color;

public class comet extends datapoint {
	
	
	
	planet parent;

	public comet(String a, Color b, int c, int d, double e, double f, double g, int h,planet parent) {
		super(a, b, c, d, e, f, g, h);
		
		this.parent= parent;
		// TODO Auto-generated constructor stub
	}
	
	
	public planet getparent(){
		
		return parent;
	}
	

	

}
