/**
 * 
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class PriorityQueueBH<T> implements PriorityQueue<T> {

	// global variables
	public BinaryHeap pqHeap;
	public int heapSize;

	/**
	 * first constructor
	 * 
	 * @param heap
	 */
	public PriorityQueueBH(int heap) {
		pqHeap = new BinaryHeapA(heap);
	}

	/**
	 * second constructor
	 * 
	 * @param pqHeap
	 */
	public PriorityQueueBH(BinaryHeap pqHeap) {
		this.pqHeap = pqHeap;

	}

	@Override
	/**
	 * insert 
	 * @param value
	 */
	public void insert(Comparable value) {
		// add element
		pqHeap.addElement(value);
		// call increase value
		// increase_value(heapSize, value);

	}

	@Override
	/**
	 * maximum
	 * @return max
	 */
	public Comparable maximum() {
		Comparable max = pqHeap.getElement(1);
		return max;
	}

	@Override
	/**
	 * extract max
	 * @return max
	 */
	public Comparable extract_max() {
		//if heapSize is smaller than 1
		if (pqHeap.size() < 1) {
			//return null
			return null;
		}
		//get max which is what is in element 1 
		Comparable max = pqHeap.getElement(1);
		// get the heap size 
		int size = pqHeap.size();
		//put the last element in the first index
		((BinaryHeapA) pqHeap).setElement(1, pqHeap.getElement(size));
		// System.out.println(pqHeap.getElement(size));
		// System.out.println(pqHeap.size());

		// pqHeap.getElement(size);
		pqHeap.setSize(pqHeap.size() - 1);
		//
		// Comparable[] array = ((BinaryHeapA) pqHeap).getArray();
		// array[heapSize] = null;
		// heapSize = heapSize - 1;

		pqHeap.maxHeapify(1);
		// return max;

		return max;
	}

	@Override
	public void increase_value(int heapIndex, Comparable newValue) {

		// int arr = (int) pqHeap.getElement(heapIndex);
		// int arr2 = (int) pqHeap.getElement(heapIndex / 2);
		if (newValue.compareTo(pqHeap.getElement(heapIndex)) < 0) {
			return;
		}
		// arr = (int) newValue;
		//
		// while (heapIndex > 1 && arr2 < arr) {
		// pqHeap.swap(arr2, arr);
		// heapIndex = heapIndex / 2;
		//
		// }
		((BinaryHeapA) pqHeap).setElement(heapIndex, newValue);

	}

}
