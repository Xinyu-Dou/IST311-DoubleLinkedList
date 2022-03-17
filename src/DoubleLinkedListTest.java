import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @org.junit.jupiter.api.Test
    void append() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Chen",1);
        dl.append(a1);
    }


    @org.junit.jupiter.api.Test
    void insert() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Chen",1);
        dl.insert(0,a1);
        System.out.println(dl.toString());
    }

    @Test
    void delete() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        Album a1 = new Album(1,list,"Chen",1);
        dl.insert(0,a1);
        System.out.println(dl.getNumNode());
        dl.delete(2);
        System.out.println(dl.toString());
    }

    @Test
    void getIndex() {
        DoubleLinkedList dl = new DoubleLinkedList();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add("First Name");
        list.add("Second Name");
        list2.add("First Name");
        Album a1 = new Album(1,list,"Chen",1);
        Album a2 = new Album(1,list,"Dou",1);
        dl.append(a1);

        System.out.println(dl.getIndex(a2));
    }

}