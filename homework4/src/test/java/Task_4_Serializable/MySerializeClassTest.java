package Task_4_Serializable;

import org.junit.Test;

public class MySerializeClassTest {
    MySerialize serialize;

    @Test
    public void AddActorsToFilmAndFilmsToActor(){
        Movie m1 = new Movie("Forrest Gump", 1994, "Robbert Zamekis");
        Movie m2 = new Movie("Introuchables", 2011, "Olivie Nakash");
        Movie m3 = new Movie("Inception", 2010, "Christofer Nolan");
        Movie m4 = new Movie("Shutter Island", 2009, "Martin Scorcese");
        Actor a11 = new Actor("Tom Hanks");
        Actor a12 = new Actor("Robin Wright");
        Actor a21 = new Actor("Fransua Cluse");
        Actor a22 = new Actor("Omar See");
        Actor a31 = new Actor("Leonardo DiCaprio");
        Actor a32 = new Actor("Jozef Gordon-Levitt");
        Actor a33 = new Actor("Tom Hardi");
        Actor a42 = new Actor("Mark Rufallo");
        m1.addActor(a11);
        m1.addActor(a12);
        a11.addMovie(m1);
        a12.addMovie(m1);
        m2.addActor(a21);
        m2.addActor(a22);
        a21.addMovie(m2);
        a22.addMovie(m2);
        m3.addActor(a31);
        m3.addActor(a32);
        m3.addActor(a33);
        a31.addMovie(m3);
        a32.addMovie(m3);
        a33.addMovie(m3);
        m4.addActor(a31);
        m4.addActor(a42);
        a31.addMovie(m4);
        a42.addMovie(m4);
        serialize = new MySerialize(m1,m2,m3,m4);

       // serialize.outList();
        serialize.serializeObject("films1.txt");

        serialize = serialize.recoverObject("films1.txt");

        Movie m5 = new Movie("Fight club", 1999, "David Fincher");
        Actor a51 = new Actor("Edward Norton");
        Actor a52 = new Actor("Bred Pitt");
        m5.addActor(a51);
        m5.addActor(a52);
        a51.addMovie(m5);
        a52.addMovie(m5);
        serialize.addFilm(m5);

       // serialize.outList();
        serialize.serializeObject("films2.txt");
    }
}
