package module9;


	import javax.imageio.ImageIO;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.WindowConstants;
	import java.awt.Graphics;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;


public class simple_paint {

 

	    public void simplezz() throws IOException {
	        JFrame frame = buildFrame();

	        final BufferedImage image = ImageIO.read(new File("C:\\Users\\user\\workspace\\selflearning\\src\\small[4036].jpg"));

	        JPanel pane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(image, 100, 100, null);
	            }
	        };


	        frame.add(pane);
	    }

//
	    static JFrame buildFrame() {
	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.setSize(1000, 1000);
	        frame.setVisible(true);
	        return frame;
	    }


	}