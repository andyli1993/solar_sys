package module9;



import java.awt.image.BufferedImage;

public class assets {

	private static final int width=32,height=32;

	public static BufferedImage player,dirt,grass,stone,tree;

	public static  void init() {
		spritesheet sheet=new spritesheet(ImageLoader.loadImage("/textures/sheet.png"));
		player=sheet.crop(0,0,width,height);
		dirt=sheet.crop(width,0,width,height);
		grass=sheet.crop(width*2,0,width,height);
		stone=sheet.crop(width*3,0,width,height);
		tree=sheet.crop(0,width,width,height);	
	}
}	