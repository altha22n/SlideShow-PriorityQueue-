import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by peter on 2/18/16.
 *
 * This is an example of using an ActionListener in conjunction with a timer.
 * You may find this useful in implementing your slideshow.
 *
 */
public class TimerDemo {
	protected int time;
	protected Timer timer;
	protected ActionListener timerListener;

	//PriorityQueueBH slideShowPQ = new PriorityQueueBH();
	BinaryHeap<Slide> mySlide = new BinaryHeapA(10);
	PriorityQueueBH<Slide> slideShowPQ = new PriorityQueueBH(mySlide);
	Slide slide = new Slide();
	//SlideShowController slideS = new SlideShowController();
	public TimerDemo() {
		time = 0;

		timerListener = new ActionListener() 
		{
		
			@Override
			public void actionPerformed(ActionEvent e) {
				time += 1;
				 //Slide nextSlide = (Slide) slideShowPQ.maximum();
				if (time <= 10) {
				Slide nextSlide = (Slide) slideShowPQ.maximum();

					System.out.print(slideShowPQ.pqHeap.toString());
					// if the time is the same time of the next
					if (slide.getTime() == nextSlide.getTime()) {
						//.slideLabel.setText(nextSlide.getSlideText());
						slideShowPQ.extract_max();
					}
//					//create a method getTime that gets the time
//				//if(time==nextSlide.getTime()){
//				//slideShowPQ.extract_max();
//					Slide nextSlide = (Slide) slideShowPQ.maximum();
					
					System.out.println("listener time: " + time);
				} else {
					System.out.println("listener complete");
					timer.stop();
				}
			}
		};
	}

	public void startTimer() {
		// slideshowListener is called every 1000 milliseconds (1 second)
		timer = new Timer(1000, timerListener);
		System.out.print("listener starting...");
		timer.start();
	}

	public static void main(String[] args) {
		System.out.println("welcome to the timer demo\n");
		TimerDemo t = new TimerDemo();
		t.startTimer();
		System.out.println("listener started.");
	}
}