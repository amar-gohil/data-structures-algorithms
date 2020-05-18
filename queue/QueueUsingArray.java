
package queue;

public class QueueUsingArray {

	static int first = -1;
	static int last = -1;
	static int[] queue = new int[5];

	static boolean isFull() {
		return last == queue.length - 1 ? true : false;
	}

	static void enqueue(int value) {
		if (isFull()) {
			System.out.println("Queue is Full");
			return;
		} else if (first == -1 && last == -1) {
			first++;
			last++;
			queue[last] = value;
		} else {
			last++;
			queue[last] = value;
		}
	}

	static void dequeue() {
		if (first == -1 && last == -1) {
			System.out.println("Queue is empty");
		} else if (first == last) {
			first = last = -1;
		} else {
			first++;
		}
	}

	static void display() {
		if (first != -1) {
			for (int i = first; i <= last; i++) {
				System.out.print(queue[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		dequeue();
		enqueue(5);
		enqueue(6);
		display();
	}
}
