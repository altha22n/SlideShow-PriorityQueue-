/**
 * 
 * @author Nada-Al-Thawr
 *
 */
public class Slide implements Comparable<Slide> {

	// global variables
	SlideShowController slideShow;
	String time;
	int timeIn;
	String text;

	// String time;
	// SlideShowController slideShow;
	public Slide() {
		// slideShow = new SlideShowController();
		// time = slideShow.slideTime.getText();
		//
		// timeIn = Integer.valueOf(time);
		// System.out.println(time);

		// String slideText = text;
		// int slideTime = time;

		// this.text = slideText;
		// this.time = slideTime;

	}
	/**
	 * constructor
	 * @param slideTime
	 * @param slideText
	 */
	public Slide(int slideTime, String slideText) {
		this.text = slideText;
		this.timeIn = slideTime;
	}
	/**
	 * getTime
	 * @return timeIn
	 */
	public int getTime() {

		return timeIn;
	}
	/**
	 * setTime
	 * @param inputTime
	 */
	public void setTime(int inputTime) {
		this.timeIn = inputTime;
	}
	/**
	 *  getSlideText
	 * @return text
	 */
	public String getSlideText() {
//		 SlideShowController slideShow = new SlideShowController();
//		 text = slideShow.slideText.getText();
		return text;
	}
	/**
	 * setText
	 * @param inputText
	 */
	public void setText(String inputText) {
		this.text = inputText;
	}
	/**
	 * compareTo
	 * return int 
	 */
	@Override
	public int compareTo(Slide slide) {

		if (slide.getTime() > 0) {
			return -1;
		} else {
			return 1;

		}
	}
}
