import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @Test
    void compareTo() {
        ArrayList<String> list = new ArrayList<>();
        Album a1 = new Album(1,list,"Chen",1);
        Album a2 = new Album(1,list,"Chen",2);
        System.out.println(a1.compareTo(a2));
    }
}