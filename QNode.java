package Queue ;


public class QNode <E>{
    
    public E data;
    public QNode<E> next;


    public QNode(E data, QNode<E> next) {
        this.data = data;
        this.next = next;
    }

   
}