import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class PriorityQueueBHTest {
	protected Integer[] array;
	protected BinaryHeap bh;
	protected PriorityQueue pq;

	protected BinaryHeap emptyBH;
	protected PriorityQueue emptyPQ;

	@Before
	public void init() {
		emptyBH = new BinaryHeapA(10);
		emptyPQ = new PriorityQueueBH(emptyBH);

		array = new Integer[] { 2, 1, 3, 10, 15, 8 };
		bh = new BinaryHeapA(array);
		pq = new PriorityQueueBH(bh);

	}

	@Test
	public void testConstructor() {
		assertNotNull(pq);
		assertNotNull(emptyPQ);

	}

	@Test
	public void maximumTest() {
		// System.out.println("excuse me? "+ pq.maximum().toString());
		assertEquals("test maximum", 15, pq.maximum());

	}

	/**
	 * knows how to get max but doesn't delete the max
	 */
	@Test
	public void extractMaxTest() {
		// System.out.println("comon " + pq.extract_max());
		// System.out.println(pq.extract_max());
		assertEquals("test maximum", 15, pq.extract_max());
		assertEquals("test maximum", 10, pq.extract_max());
		assertEquals("test maximum", 8, pq.extract_max());
		assertEquals("test maximum", 3, pq.extract_max());
	}

	@Test
	public void increaseValueTest() {
		pq.increase_value(1, 27);
		assertEquals("test increase value", 27, pq.extract_max());
		pq.increase_value(1, 99);
		assertEquals("test increase value", 99, pq.extract_max());
	}

	@Test
	public void insertTest() {
		emptyPQ.insert(72);
		assertEquals(72, emptyPQ.extract_max());
	}

}
