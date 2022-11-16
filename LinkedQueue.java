package Queue ;

public class LinkedQueue<T> {

    private QNode<T> front;    // Reference to front queue node
    private QNode<T> last;     // Reference to last queue node
    private int size;		            // Number of elements in queue

    /**
     * Constructors
     */
    public LinkedQueue() {
        front = last = null;
        size = 0;
    }

    /**
     * @return Queue size
     */
    public int length() {
        return size;
    }
    
    /**
     * Clear
     */
    public void clear() {
        front = last = null;
        size = 0;
    }
    public boolean isEmpty() {
    	return size == 0 ;
    }

    /**
     * Put element on last
     */
    public void enqueue(T data) {
        QNode <T> temp = new QNode <T>(data, null);
        if (size == 0) {
            front = last = temp;
        } else {
            last = last.next = temp;
        }
        size++;
    }


    /**
     * Remove and return element from front
     */
    public T dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        T data = front.data;  // Store dequeued value
        front = front.next;  // Advance front
        if (front == null) {
            last = front; // Last Object
        }
        size--;
        return data;                      // Return Object
    }

    /**
     * @return Front data
     */
    public T frontValue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }
}
