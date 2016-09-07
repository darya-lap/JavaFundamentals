package Task_6;

/**
 * Created by Дарья on 27.08.2016.
 */
public class Note {
    private int numberOfNote;
    private String note;

    public void createNote(String str, int numb){
        note = str;
        numberOfNote = numb;
    }


    public void changeNoteText(String str){
        note = str;
    }

    public String getNote(){
        return this.note;
    }
}
