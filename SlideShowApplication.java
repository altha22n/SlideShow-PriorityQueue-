import javax.swing.JFrame;
/**
 * 
 * @author Nada-Al-Thawr
 *
 */
public class SlideShowApplication {

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//create an instance of SlideShowController to add to the frame
		SlideShowController show = new SlideShowController();
		// creates a new JFrame
		JFrame myFrame = new JFrame("Slide Show!");
		//add to the frame
		myFrame.add(show);
		// sets the size
		myFrame.setSize(700, 700);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set it to be visible
		myFrame.setVisible(true);
		
	}
}
