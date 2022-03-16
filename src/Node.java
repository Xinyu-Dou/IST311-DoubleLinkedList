public class Node<T>{
    Album data;
    Node<T> next;
    Node<T> prev;

    public Node(Album data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
