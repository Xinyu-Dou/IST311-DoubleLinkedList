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

    //insert at that point in the list (0 is the head, 1 is right after the head)
    public Node<T> insert(int position, Album data) {
        Node<T> node = new Node<T>(data);

        try {
            if (position > numNode || position < 0) {
                throw new IllegalArgumentException();
            }
            // add to the end of the list
            else if (position == numNode) {
                append(data);
            } else {
                // nothing in the list, start the list
                if (position == 0 && numNode == 0) {
                    this.head = node;
                    this.tail = node;
                }
                // add to the head of the list
                else if (position == 0) {
                    this.head.next = this.head;
                    this.head.next.prev = this.head;
                    this.head = node;
                }
                // add to the middle of the list
                else if (position < numNode) {
                    int count = 1;
                    Node<T> pre_node = this.head;
                    Node<T> after_node = this.head.next;
                    while (count < position) {
                        pre_node = after_node;
                        after_node = after_node.next;
                    }
                    pre_node.next = node;
                    pre_node.next.prev = pre_node;
                    pre_node.next.next = after_node;
                    pre_node.next.next.prev = node;
                }
                numNode++;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Location is out of the bounds of the list");
        }
        return node;
    }

}
