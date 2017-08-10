import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 * 
 * @author Nada-Al-Thawr
 *
 */
public class SlideShowController extends JPanel implements ActionListener {
	// global variables
	JButton addButton;
	JButton startButton;
	JPanel mainPanel;
	JPanel topPanel;
	JPanel centerPanel;
	JPanel bottomPanel;
	JTextField slideText;
	JTextField slideTime;
	static JLabel slideLabel;
	BinaryHeapA<Slide> mySlide = new BinaryHeapA(10);
	PriorityQueueBH<Slide> slideShow = new PriorityQueueBH(mySlide);
	Slide slide;
	int time;
	Timer timer;
	ActionListener timerListener;
	TimerDemo timerDemo = new TimerDemo();

	/**
	 * constructor
	 */
	public SlideShowController() {
		// calls super
		super(new BorderLayout());

		// call create display
		createDisplay();
		TimerDemo();
	}

	/**
	 * creates the display of the application
	 */
	private void createDisplay() {
		// create the panels
		// mainPanel = new JPanel(new GridLayout(2, 1));
		mainPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new GridLayout(1, 3));
		bottomPanel = new JPanel(new GridLayout(1, 2));
		centerPanel = new JPanel();

		// text fields for inserting text and time
		slideText = new JTextField("Slide Text Here..");
		slideTime = new JTextField("Slide Time (1-10..");

		// label
		slideLabel = new JLabel("SlideShow Appears Here!");
		// slideLabel.setPreferredSize(new Dimension(100,100));

		// create borders for the slide JLabel and change the color and font
		// got this from exploring different API's with borders and JComponents
		Border slideBorder = BorderFactory
				.createEmptyBorder(150, 150, 150, 150);
		Border colorBorder = BorderFactory.createLineBorder(Color.BLACK);
		Border compoundBorder = BorderFactory.createCompoundBorder(colorBorder,
				slideBorder);
		slideLabel.setPreferredSize(new Dimension(550, 550));
		// slideLabel.setFont(new Font("Calibri",Font.BOLD,16));
		slideLabel.setFont(new Font("LucidaSans", Font.ITALIC, 18));
		slideLabel.setBorder(compoundBorder);
		slideLabel.setBackground(Color.CYAN);
		slideLabel.setOpaque(true);

		// buttons
		addButton = new JButton("Add Slide!");
		startButton = new JButton("Start Show!");
		// add actionListener
		addButton.addActionListener(this);
		startButton.addActionListener(this);

		// add to the panels
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		topPanel.add(slideText);
		topPanel.add(slideTime);
		topPanel.add(addButton);
		centerPanel.add(slideLabel);
		bottomPanel.add(startButton);

		// add the panel
		add(mainPanel);

	}

	/**
	 * addSlide method, adds text and time inserted to the show
	 */
	public void addSlide() {
		// if text or time field have text
		if (slideText.getText().equals("") || slideTime.getText().equals("")) {
			// return
			return;
		}
		// get text inserted
		String textT = slideText.getText();
		// get time inserted
		String timeT = slideTime.getText();
		// parse time into int
		int timeI = Integer.parseInt(timeT);

		// create the new slide and pass in the new time and text
		slide = new Slide(timeI, textT);
		// insert the slide to the slide show
		slideShow.insert(slide);

		int i = 1;
		while (slideShow.pqHeap.getElement(i) != null) {
			System.out.println("text is : "
					+ ((Slide) slideShow.pqHeap.getElement(i)).getSlideText());
			// System.out.println(
			// "time is : "+((Slide) slideShow.pqHeap.getElement(i))
			// .getTime());
			i++;
		}

	}

	/**
	 * TimerDemo
	 */
	public void TimerDemo() {
		// initialize time as 0
		time = 0;

		timerListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// increment time by 1
				time += 1;
				// if time is less than or equal to 10
				if (time <= 10) {
					// create nextSlide
					Slide nextSlide = (Slide) slideShow.maximum();
					// testing print statements
					System.out.print(slideShow.pqHeap.toString());
					// if the time is the same time of the next
					if (slide.getTime() == nextSlide.getTime()) {
						// get text from next slide and set it on slide label
						slideLabel.setText(nextSlide.getSlideText());
						// extract max
						slideShow.extract_max();
					}

					System.out.println("listener time: " + time);
				} else {
					System.out.println("listener complete");
					// else stop
					timer.stop();
				}
			}
		};
	}

	public void startTimer() {
		// slideshowListener is called every 1000 milliseconds (1 second)
		timer = new Timer(1000, timerListener);
		System.out.print("listener starting...");
		// start
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if add button is clicked
		if (e.getSource() == addButton) {
			// call addSlide
			addSlide();
			// reset the text fields
			slideText.setText("");
			slideTime.setText("");

		}
		// if start button is clicked
		if (e.getSource() == startButton) {
			startTimer();

		}

	}
	
	/**
	 * I commented out this other method I was initially trying with the time but didn't work
	 * 
	 */
//	/**
//	 * startShowTime method Starts the show
//	 */
//	public void startShowTime() {
//		// initialize time as 0
//		time = 0;
//		// create a new timer with 10 seconds
//		timer = new Timer(1000, timerListener);
//		//timerListener = new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
//				System.out.print("listener starting...");
//				// start timer
//				timer.start();
//				System.out.println("slide: ");
//				System.out
//						.println("max is"
//								+ Arrays.toString(((BinaryHeapA<Slide>) slideShow.pqHeap)
//										.getArray()));
//				// increment time
//				time += 1;
//				// if time is less than or equal 10
//				if (time <= 10) {
//					// next slide will be the maximum of the slide show
//					Slide nextSlide = (Slide) slideShow.maximum();
//
//					System.out.print(slideShow.pqHeap.toString());
//					// if the time is the same time of the next
//					if (slide.getTime() == nextSlide.getTime()) {
//						// set the text to the label
//						slideLabel.setText(nextSlide.getSlideText());
//						// call extract max
//						slideShow.extract_max();
//					}
//
//				} else {
//					timer.stop();
//				}
//			}
//		//};
//
////	}

}
