public interface PriorityQueue<T> {

	public void insert(Comparable value);

	public Comparable maximum();

	public Comparable extract_max();

	public void increase_value(int heapIndex, Comparable newValue);
}
