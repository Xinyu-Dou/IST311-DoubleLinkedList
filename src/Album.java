import java.util.ArrayList;

public class Album{
    private int ID;
    private ArrayList<String> artistName;
    private String title;
    private int numSongs;

    public Album(int id, ArrayList<String> name, String title, int num){
        this.ID = id;
        this.artistName = name;
        this.title = title;
        this.numSongs = num;
    }

}
