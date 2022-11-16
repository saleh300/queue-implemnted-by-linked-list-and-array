package Queue;

public class LinkedStack<E> implements Stack<E>{

	SinglyLinkedList<E> list = new SinglyLinkedList<>() ;	
	public LinkedStack() {

	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E top() {
		return list.first() ;
	}

	@Override
	public E pop() {
		return list.removeFirst() ;
	}

	@Override
	public int size() {
		return list.size() ;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty() ;
	}

}
