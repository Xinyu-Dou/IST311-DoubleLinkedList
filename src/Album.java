import java.util.ArrayList;

public class Album implements Comparable<Album>{
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

    public int getID(){
        return ID;
    }

    public void setID(int id){
        this.ID = id;
    }

    public ArrayList<String> getName(){
        return artistName;
    }

    public void setName(ArrayList<String> name){
        this.artistName = name;
    }

    public String getTitle(){
        return title;
    }

    public void setID(String title){
        this.title = title;
    }

    public int getNumSong(){
        return numSongs;
    }

    public void setNumSong(int num){
        this.numSongs = num;
    }

    @Override
    public int compareTo(Album o) {
        if(this.numSongs > o.numSongs){
            return 1;
        }
        else if (this.numSongs == o.numSongs){
            return 2;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return title;
    }

}
