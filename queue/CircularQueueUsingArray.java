package queue;

public class CircularQueueUsingArray {

	static int first = -1;
	static int last = -1;
	static int[] queue = new int[5];
	static int size = 5;

	static void enqueue(int value) {
		if ((last + 1) % size == first) {
			System.out.println("Queue is full");
		} else if (first == -1 && last == -1) {
			first = last = 0;
			queue[last] = value;
		} else {
			last = (last + 1) % size;
			queue[last] = value;
		}
	}

	static void dequeue() {
		if (first == -1 && last == -1) {
			System.out.println("Queue id empty");
		} else if (first == last) {
			first = last = -1;
		} else {
			first = (first + 1) % size;
		}
	}

	static void display() {
		if (first != -1) {
			int temp = first;
			while (temp != last) {
				System.out.print(queue[temp] + " ");
				temp = (temp + 1) % size;
			}
			System.out.print(queue[temp]);
		}
	}

	static void peek() {
		if (first != -1) {
			System.out.println(queue[first]);
		}
	}

	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		dequeue();
		enqueue(6);
		display();

	}
}
