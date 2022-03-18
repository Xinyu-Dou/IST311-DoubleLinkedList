import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @org.junit.jupiter.api.Test
    void append() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        list2.add("He");
        Album a1 = new Album(1,list,"Chen",1);
        Album a2 = new Album(1,list,"We",1);
        //append when the list is empty
        dl.append(a1);
        assertEquals(a1,dl.append(a1).data);
        //append when the list is not empty
        dl.append(a2);
    }


    @org.junit.jupiter.api.Test
    void insert() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Dreamland",1);
        Album a2 = new Album(1,list,"We",3);
        Album a3 = new Album(1,list,"Sleepwalk",6);
        Album a4 = new Album(1,list,"Manic",7);
        //insert when the list is empty
        assertEquals(a1,dl.insert(0,a1).data);
        System.out.println(dl.toString());
        //insert at head
        assertEquals(a2,dl.insert(0,a2).data);
        System.out.println(dl.toString());
        //insert at tail
        assertEquals(a3,dl.insert(2,a3).data);
        System.out.println(dl.toString());
        //insert at middle
        assertEquals(a4,dl.insert(1,a4).data);
        System.out.println(dl.toString());
        //when the insert position is out of bounce
        dl.insert(5,a1);
    }

    @Test
    void delete() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Dreamland",1);
        Album a2 = new Album(1,list,"We",3);
        Album a3 = new Album(1,list,"Sleepwalk",6);
        Album a4 = new Album(1,list,"Manic",7);
        //delete when the list only contains one node
        dl.append(a1);
        assertEquals(a1,dl.delete(0).data);
        //delete head
        dl.append(a1);
        dl.append(a2);
        dl.append(a3);
        dl.append(a4);
        assertEquals(a1,dl.delete(0).data);
        //delete tail
        assertEquals(a4,dl.delete(2).data);
        //delete middle
        dl.append(a4);
        assertEquals(a3,dl.delete(1).data);
        //when the insert position is out of bounce
        dl.delete(5);
    }

    @Test
    void getIndex() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Dreamland",1);
        Album a2 = new Album(1,list,"We",3);
        Album a3 = new Album(1,list,"Sleepwalk",6);
        Album a4 = new Album(1,list,"Manic",7);
        dl.append(a1);
        dl.append(a2);
        dl.append(a3);
        assertEquals(0,dl.getIndex(a1));
        //when the node is not in the list
        assertEquals(-1,dl.getIndex(a4));
    }

    @Test
    void shuffle() {
        DoubleLinkedList dl = new DoubleLinkedList();
        DoubleLinkedList dl2 = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Dreamland",1);
        Album a2 = new Album(1,list,"We",3);
        Album a3 = new Album(1,list,"Sleepwalk",6);
        Album a4 = new Album(1,list,"Manic",7);
        //when the number of node is odd
        dl.append(a1);
        dl.append(a2);
        dl.append(a3);
        assertEquals(a2,dl.shuffle().data);
        //when the number of node is even
        dl.append(a1);
        dl.append(a2);
        dl.append(a3);
        dl.append(a4);
        assertEquals(a2,dl.shuffle().data);
    }

    @Test
    void partition() {
        DoubleLinkedList dl = new DoubleLinkedList();
        DoubleLinkedList dl2 = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Dreamland",1);
        Album a2 = new Album(1,list,"We",3);
        Album a3 = new Album(1,list,"Sleepwalk",6);
        Album a4 = new Album(1,list,"Manic",7);
        dl.append(a1);
        dl.append(a2);
        dl.append(a3);
        dl.append(a4);
        dl2.append(a2);
        dl2.append(a3);
        dl2.append(a4);
        Node<Album> n1 = new Node<Album>(a2);
        assertEquals(dl2.toString(),dl.partition(n1).toString());
    }
}