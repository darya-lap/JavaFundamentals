package Task_4_Serializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Actor implements Serializable{
    String actorName;
    List<Movie> movies = new ArrayList<>();

    Actor(String name){
        actorName = name;
    }

    public void addMovie(Movie m){
        movies.add(m);
    }

    public String getActorName(){
        return actorName;
    }

    public String getActorMovies(){
        StringBuilder s = new StringBuilder();
        for (Movie m: movies){
            s.append("\t" + m.getMovieTitle() + "\n");
        }
        return s.toString();
    }

}
