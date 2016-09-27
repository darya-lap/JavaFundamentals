package Task_4_Serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MySerialize implements Serializable{
    List<Movie> movieList= new ArrayList<>();

    MySerialize(Movie... movies){
        for (Movie m: movies){
            movieList.add(m);
        }
    }

    public void outList(){
        for(Movie m: movieList){
            System.out.print("\n" + m.getMovieTitle() + "\n\nActors:\n" + m.getActors());
        }
    }

    public void addFilm(Movie m){
        movieList.add(m);
    }

    public void serializeObject(String films) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(films))){
            oos.reset();
            oos.writeObject(this);
            oos.flush();
            oos.close();
            this.outList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MySerialize recoverObject(String films){
        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(films))) {
            MySerialize ms = (MySerialize) oos.readObject();
            oos.close();
            return ms;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
