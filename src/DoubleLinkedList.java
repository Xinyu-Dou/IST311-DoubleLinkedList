import javax.swing.plaf.metal.MetalButtonUI;
import java.util.ArrayList;
import java.util.Objects;

public class DoubleLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int numNode = 0;

    public DoubleLinkedList() {

    }

    // Adding a node after the last node of the list
    public Node<T> append(Album data) {
        Node<T> node = new Node<T>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            this.tail.next.prev = this.tail;
        }
        this.tail = node;
        this.tail.next = null;
        numNode += 1;
        return node;
    }

}
