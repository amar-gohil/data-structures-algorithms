package queue;

public class DequeUsingCircularArray {

	static int size = 5;
	static int[] deque = new int[size];
	static int f = -1;
	static int l = -1;

	static void enqueueFront(int value) {
		if ((f == 0 && l == size - 1) || f == (l + 1)) {
			System.out.println("queue is full");
		} else if (f == -1 && l == -1) {
			f = l = 0;
			deque[f] = value;
		} else if (f == 0) {
			f = size - 1;
			deque[f] = value;
		} else {
			f--;
			deque[f] = value;
		}
	}

	static void enqueueRear(int value) {
		if ((f == 0 && l == size - 1) || f == (l + 1)) {
			System.out.println("queue is full");
		} else if (f == -1 && l == -1) {
			f = l = 0;
			deque[l] = value;
		} else if (l == size - 1) {
			l = 0;
			deque[l] = value;
		} else {
			l++;
			deque[l] = value;
		}
	}

	static void dequeueFront() {
		if (f == -1 && l == -1) {
			System.out.println("Queue is empty");
		} else if (f == l) {
			deque[f] = 0;
			f = l = -1;
		} else if (f == size - 1) {
			deque[f] = 0;
			f = 0;
		} else {
			deque[f] = 0;
			f++;
		}
	}

	static void dequeueRear() {
		if (f == -1 && l == -1) {
			System.out.println("Queue is empty");
		} else if (f == l) {
			deque[l] = 0;
			f = l = -1;
		} else if (l == 0) {
			deque[l] = 0;
			l = size - 1;
		} else {
			deque[l] = 0;
			l--;
		}
	}

	static void display() {
		if (f != -1 && l != -1) {
			int temp = f;
			while (temp != l) {
				System.out.print(deque[temp] + " ");
				temp = (temp + 1) % size;
			}
			System.out.println(deque[temp]);
		}
	}

	public static void main(String[] args) {
		enqueueFront(2);
		enqueueFront(5);
		enqueueRear(-1);
		enqueueRear(0);
		enqueueFront(7);
		enqueueFront(4);
		display();

	}
}
