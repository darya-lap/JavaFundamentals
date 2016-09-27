package Task_4_Serializable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable{
    String movieTitle;
    int yearOfRelease;
    String producerName;
    List<Actor> actors = new ArrayList<>();

    Movie(String title, int year, String producer){
        movieTitle = title;
        yearOfRelease = year;
        producerName = producer;
    }

    public String getMovieTitle(){
        return movieTitle;
    }

//    public int getYearOfRelease(){
//        return yearOfRelease;
//    }

   public String getActors(){
       StringBuilder s = new StringBuilder();
       for (Actor a:actors){
           s.append(a.getActorName() + ":\n");
           s.append(a.getActorMovies());
       }
       return  s.toString();
   }

    public void addActor(Actor a){
        actors.add(a);
    }
}
