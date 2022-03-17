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
        //return the appended node
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
                    numNode++;
                }
                // add node to the head of the list
                else if (position == 0 && numNode != 0) {
                    this.head.prev = node;
                    node.next = this.head;
                    this.head = node;
                    numNode++;
                }
                // add to the middle of the list
                else if (position < numNode && numNode != 0) {
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
                    numNode++;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Location is out of the bounds of the list");
        }
        //return the inserted node
        return node;
    }

    public int getNumNode(){
        return numNode;
    }

    //delete the item at that location (delete 0 deletes the head)
    public Node<T> delete(int position) {
        Node<T> deleted = new Node<T>(null);
        try {
            if (position >= numNode || position < 0) {
                throw new IllegalArgumentException();
            }
            //delete last node
            else if (numNode == 1 && position == 0) {
                deleted = this.head;
                this.head = null;
                this.tail = null;
            }
            //delete head
            else if (numNode > 1 && position == 0) {
                deleted = this.head;
                this.head = this.head.next;
                this.head.prev = null;
            }
            //delete tail
            else if (numNode > 1 && position == numNode - 1) {
                deleted = this.tail;
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            //delete middle
            else {
                int count = 0;
                Node<T> pointer = this.head;
                while (count < position - 1) {
                    pointer = this.head;
                    pointer = pointer.next;
                    count++;
                }
                deleted = pointer.next;
                pointer.next = pointer.next.next;
                pointer.next.prev = pointer;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Location is out of the bounds of the list");
        }
        numNode--;
        //return the deleted node
        return deleted;
    }

    //return the first index of the  item
    public int getIndex(Album data){
        Node<T> pointer = this.head;
        int count = 0;
        while(pointer != null){
            if(pointer.data.getID() == data.getID() &&
                    pointer.data.getTitle().equals(data.getTitle()) &&
                    pointer.data.getNumSong() == data.getNumSong() &&
                    pointer.data.getName().equals(data.getName())){
                return count;
            }else{
                pointer = pointer.next;
                count++;
            }
        }
        //return -1 if it isn't in the list
        return -1;
    }

    //shuffle the doublelinked list
    public Node<T> shuffle(){
        //before shuffle the list, divide the original list into half by odd and even index
        DoubleLinkedList oddList = new DoubleLinkedList();
        DoubleLinkedList evenList = new DoubleLinkedList();
        Node<T> pointer = new Node<T>(null);
        pointer = this.head;
        int count = 0;
        while(pointer != null){
            if(count%2 == 0){
                evenList.append(pointer.data);
            }
            else{
                oddList.append(pointer.data);
            }
            pointer = pointer.next;
        }
        Node<T> pointer1 = new Node<T>(null);
        Node<T> pointer2 = new Node<T>(null);
        pointer1 = oddList.head;
        pointer2 = evenList.head;
        DoubleLinkedList result = new DoubleLinkedList();
        while(pointer2 != null){
            result.append(pointer1.data);
            result.append(pointer2.data);
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        if(pointer1 != null){
            result.append(pointer1.data);
        }
        //Return the head of a shuffled list
        return result.head;
    }

    public DoubleLinkedList<Album> partition(Node<T> data){
        DoubleLinkedList<Album> newList = new DoubleLinkedList<Album>();
        Node<T> pointer = new Node<T>(null);
        pointer = this.head;
        while(pointer != null){
            if(pointer.data.compareTo(data.data) == 1){
                newList.append(pointer.data);
            }
            else{
                continue;
            }
            pointer = pointer.next;
        }
        return newList;
    }

    @Override
    public String toString(){
        Node<T> toPrint = this.head;

        StringBuilder stringBuilder = new StringBuilder();

        while(toPrint != null){
            stringBuilder.append(toPrint.data);
            stringBuilder.append("->");
            toPrint = toPrint.next;
        }

        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }



}
