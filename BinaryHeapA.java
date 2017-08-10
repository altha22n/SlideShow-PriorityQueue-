/**
 * 
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T> {
	// array to hold the heap
	private Comparable[] internalArray;
	// keep track of the heap size (different from the capacity)
	public int heapSize;

	/**
	 * first constructor
	 * 
	 * @param heap
	 */
	public BinaryHeapA(int heap) {
		// initialize heapSize to 0
		heapSize = 0;
		// create new array
		internalArray = new Comparable[heap];
	}

	/**
	 * second constructor
	 * 
	 * @param stringArray
	 */
	public BinaryHeapA(Comparable[] stringArray) {
		// set the array
		this.internalArray = stringArray;
		// set the heapSize as the array length
		heapSize = internalArray.length;
		// call buildMaxHeap
		buildMaxHeap();
	}

	/**
	 * getElement returns the internal array element -1 index
	 */
	public Comparable<T> getElement(int element) {
		return internalArray[element - 1];
	}

	/**
	 * addElement
	 */
	public void addElement(Comparable<T> element) {
		// if there's no space and the size is equal to the length of the array
		if (heapSize == internalArray.length) {
			// return
			return;
		} else {
			// else increase heapseize
			heapSize++;
			// and add the element
			internalArray[heapSize - 1] = element;
		}

	}

	/**
	 * return the index of the left child of i
	 */
	public int leftChild(int i) {

		return (2 * i);
	}

	/**
	 * return the index of the right child of i
	 */
	public int rightChild(int i) {

		return (2 * i) + 1;
	}

	/**
	 * return the index of the parent of i
	 */
	public int parent(int i) {

		return (int) Math.floor(i / 2);
	}

	/**
	 * capacity returns int of the capacity
	 */
	public int capacity() {
		// heapSize is the array length -1
		heapSize = internalArray.length - 1;
		// return the heapSize
		return heapSize;
	}

	/**
	 * size
	 */
	public int size() {

		return heapSize;
	}

	/**
	 * set size
	 */
	public void setSize(int i) {
		heapSize = i;
	}

	/**
	 * swap between two int params
	 */
	public void swap(int i, int j) {
		// create a temp comparable
		Comparable<T> temp = internalArray[i - 1];
		// swap
		internalArray[i - 1] = internalArray[j - 1];
		internalArray[j - 1] = temp;

	}

	/**
	 * buildMaxHeap calls maxHeapify
	 */
	public void buildMaxHeap() {
		// loop through the size/2 and decrement till 0
		for (int i = (int) Math.floor(heapSize / 2); i > 0; i--) {
			// System.out.println( "Here in BuildmaxHeap for loop");
			// call maxHeapify
			maxHeapify(i);
		}
	}

	/**
	 * maxHeapify recursively calls itself as it goes the parent and the
	 * children of the heap
	 */
	public void maxHeapify(int i) {
		// get the left and right children index
		int left = leftChild(i);
		int right = rightChild(i);
		int largestNum = 0;
		// if left is smaller than or equal to size()
		// and element in left is bigger than element of i
		System.out.println("get element: "+getElement(i));
		if (left <= size()
				&& (getElement(left).
						compareTo((T) getElement(i)) > 0)) {
			// largest num is left
			largestNum = left;
		} else {
			// else largest num is i
			largestNum = i;
		}
		// if right is smaller than or equalt to size
		// and right element compared largest num element are biggeer than 0
		if (right <= size()
				&& (getElement(right).compareTo((T) getElement(largestNum)) > 0)) {
			// largest num is right
			largestNum = right;
		}
		// if largestNum isn't equal to i
		if (largestNum != i) {
			// swap between i and largest num
			swap(i, largestNum);
			// call it recursive on largestNum
			maxHeapify(largestNum);
		}

	}

	/**
	 * getArray
	 * 
	 * @return internalArray
	 */
	public Comparable[] getArray() {
		return internalArray;
	}
	public void setElement( int index, Comparable element){
		internalArray[index-1] = element;
		
	}

	/**
	 * isEmpty
	 */
	public boolean isEmpty() {
		if (internalArray != null) {
			return true;
		} else {

			return false;
		}
	}

}
