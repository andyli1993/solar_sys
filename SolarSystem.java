package module9;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <h1> solar System</h1>
 * Creates an animated solar system using java applet. Rotation speed along with the size of each planet have been slightly adjusted and calculated using data from {@link http://www.enchantedlearning.com/subjects/astronomy/planets/}
 * in order to fit the frame and allow the smallest planet to be still visible on screen.
 * 
 * <p>
 * <b>Note:</b> This method always returns immediately, whether or not the 
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives 
 * that draw the image will incrementally paint on the screen. 
 *
 * @author  gongzhu Li
 * @version 2.0
 * @since   2015-03-31
 */


public class SolarSystem extends JPanel implements ActionListener {
	// instantiate an arraylist of planets that will be painted
	ArrayList<datapoint> planets = new ArrayList<datapoint >();
	// create the sun ( sun is taken because it has no orbit and will be treated separately)
	datapoint sun =new datapoint("sun",Color.red,0,0,0,0,0,25);// the suns size is shrinked because it is too big to fit 
	//initialise time variable and buttons.
	double time = 0;
	/**
	 * The {@link double} instance representing time
	 */
	private JButton exitButton;
	private JButton Learnmore;
	// Create JPanel containing animation panel and buttons. 

	//set frame size solar system 2
	static SolarSystem thesolarsystem = new SolarSystem();
	private Timer animationTimer; // timer controlling frame rate
	public int jk =5;
	
	
	/**create and display JFrame containing a GUI
	 * @param args Unused.
	 * @return Nothing.	
	 */
	private static  SolarSystem createAndDisplayGui() {
		//title
		JFrame frame = new JFrame("our Solar System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(thesolarsystem); // Add panel to frame
		frame.pack(); // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
		return thesolarsystem;
	}

	
	
	
	
	
	   /**
	   * This is the main method which makes use of addNum method.
	   * @param args Unused.
	   * @return Nothing.	
	   */
	
	public static void main(String[] args) {


		/**
		 *  invoke a thread to and update new star position after each call
		 * @param args Unused.
		 * @return Nothing.	
		 */

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				

				thesolarsystem = createAndDisplayGui();
				//the relavant data are found from this website: http://www.enchantedlearning.com/subjects/astronomy/planets/				
				//instantiate first five planet
				datapoint Mercury = new datapoint("Mercury", Color.BLUE,0,0,0,87.96/365.26,0.39*100, 8*4878/12756);
				datapoint Venus = new datapoint("Venus", Color.ORANGE,0,0,0,224.68 /365.26,0.72*100,  8*12104/12756);
				datapoint Earth = new datapoint("Earth",   Color.GREEN,0,0,0,365.26/365.26,1*100,8 );
				datapoint Mars = new datapoint("Mars", Color.BLACK,0,0,0,686.98/365.26,1.524*100 , 8* 6787/12756);
				datapoint Jupiter = new datapoint("Jupiter", Color.DARK_GRAY,0,0,0,11.8625, 5.203*100, 1*142796/12756);	//size is shrinked because it is too big to be drawn 
				datapoint comet1 = new comet("comet1", Color.DARK_GRAY,0,0,0,11.8625, 5.203*10, 1*2796/756,Mars);
				//adding these planets into the display
				thesolarsystem.planets.add(Mercury);
				thesolarsystem.planets.add(Venus);
				thesolarsystem.planets.add(Earth);
				thesolarsystem.planets.add(Mars);
				thesolarsystem.planets.add(Jupiter);
				thesolarsystem.planets.add(comet1);
			}
		}
				);

		int delay =1;	//delay in ms between steps

		// This is called by the animation Timer object
		// at regular intervals to rotate the shape and
		// update the display.	  
		ActionListener tick = new ActionListener() {
			/**
			 * repaint after time ticked
			 * @param evt  ActionEvent
			 * @return Nothing
			 */
			public void actionPerformed(ActionEvent evt) {;
			//repaint after each run
			thesolarsystem.rotateplanet();
			thesolarsystem.time+=delay;		
			thesolarsystem.repaint();			
			}
		};
		//instantiate timer 
		Timer animationTimer = new Timer(delay, tick);
		//Start animation
		animationTimer.start();

	}

	
	
	/**
	 * set window size and buttons feature
	 */
	public SolarSystem(){

		//set window size 
		setPreferredSize(new Dimension(2000,2000));
		//name the two buttons exitButton as Exit and Learnmore as Learnmore.
		exitButton = new JButton("Exit");
		Learnmore= new JButton("Learnmore");
		//add the two buttons to actionlistener
		exitButton.addActionListener(this);
		Learnmore.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		//add the two buttons to the buttonpanel
		buttonPanel.add(exitButton);
		buttonPanel.add(Learnmore);
		add(buttonPanel);
	}		
	//calculate position for each planet.
	public void rotateplanet() {
		for(datapoint de : planets) {
			//angle are calculated using the fomula: angle+2*pi/(10000*year ratio)
			double angle = de.getangle() + ( 2 * Math.PI / (10000 * de.getyearratio()));
			//setx: top left x coordinate of the orbit are calulated using (centre point- radius/2+distance from the sun /2 *sin(angle)
			de.setx((int)(450-de.getradius()/2+ ((de.getdistancefromsun()/2)*Math.sin(angle))));
			//sety: top left y coordinate of the orbit are calulated using (centre point- radius/2+distance from the sun /2 *cos(angle)
			de.sety((int)(450-de.getradius()/2+ ((de.getdistancefromsun()/2)*Math.cos(angle))));
			de.setangle(angle);
		}
	}
	//paint planets through	paintUniverse(g) and the sun.
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		try {
			final BufferedImage image = ImageIO.read(new File("C:\\Users\\user\\workspace\\selflearning\\src\\small[4036].jpg"));
			 g.drawImage(image, 100, 100, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// draw&paint the planets
		int i=0;
		for(datapoint qw : planets) {
			//get planets' color
			g.setColor(qw.getcolor());
			//get the top left corner's co-ordinate of each planet(centre coordinate - distance from the sun/2).
			int topleftx= (int)(450-qw.getdistancefromsun()/2);
			int toplefty= (int)( 450-qw.getdistancefromsun()/2);		
			//450 mid point (top left x, top left y, radius, radius)
			g.drawOval(topleftx,toplefty, (int)qw.getdistancefromsun(), (int)qw.getdistancefromsun());				
			Font f = new Font("TimesRoman", Font.PLAIN,25);
			g.setFont(f);
			//draw name
			g.drawString(qw.getname(), qw.getx()+5, qw.gety()+5);
			//fill planets with color 
			g.fillOval(qw.getx(), qw.gety(), qw.getradius(), qw.getradius());
		}
		
		
		
		

		//draw the elapsed simulated time
		g.drawString("elapsed simulated time "+time/10000+" earth year", 1,988);
		//set sun 
		//set x and y of sun
		sun.setx(450);
		sun.sety(450);	
		g.setColor(Color.RED);
		g.fillOval(437, 437, sun.getradius(), sun.getradius());		//top left corner =sun450-25/2 =437
		//draw suns name
		Font f = new Font("TimesRoman", Font.PLAIN,15);
		g.setFont(f);
		g.setColor(Color.white);	
		g.drawString("sun", 440, 453);
	}

	// Respond to button clicks 
	public void actionPerformed(ActionEvent e) {
		// exit when click the exitButton
		if (e.getSource()==exitButton) {System.exit(0);
		}
		else if (e.getSource()==Learnmore){
			//open the relavant web browser when click the Learnmore button
			try {
				java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.enchantedlearning.com/subjects/astronomy/planets/"));
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}










