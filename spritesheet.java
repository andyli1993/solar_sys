package module9;

import java.awt.image.BufferedImage;

public class spritesheet {

	
	public BufferedImage sheet;

	public spritesheet(BufferedImage sheet) {
		this.sheet= sheet;
	}
	public BufferedImage crop(int x, int y,int w, int h){
		return sheet.getSubimage(x, y, w, h); 
		}
	
}
