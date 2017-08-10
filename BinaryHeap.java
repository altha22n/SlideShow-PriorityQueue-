/**
 * BinaryHeap interface
 */
public interface BinaryHeap<T extends Comparable<T>> {

	public Comparable<T> getElement(int element);

	public void addElement(Comparable<T> element);

	public int leftChild(int left);

	public int rightChild(int right);

	public int parent(int i);

	public int capacity();

	public int size();

	public void setSize(int i);

	public void swap(int i, int j);

	public void buildMaxHeap();

	public void maxHeapify(int i);

	public boolean isEmpty();

}