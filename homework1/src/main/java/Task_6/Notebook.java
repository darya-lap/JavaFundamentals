package Task_6;

import java.util.Scanner;

/**
 * Created by Дарья on 27.08.2016.
 */
public class Notebook {
    final int SIZE = 3;
    private Note[] notes = new Note[SIZE];
    private static int numb = 0;
    public boolean showAllNotes(){
        if (numb == 0){
            System.out.println("У вас нет ни одной заметки!");
            return false;
        }
        else {
            int i = 0;
            while (i < SIZE) {
                if (notes[i] != null) {
                    System.out.println((i + 1) + ". " + notes[i].getNote());
                }
                else break;
                i++;
            }
            return true;
        }
    }

    public void addNote(){
        int i = 0;
        try{
            while (notes[i] != null) i++;
            Scanner in = new Scanner(System.in);
            System.out.println("Введите содержание заметки: ");
            String str = in.nextLine();
            notes[i] = new Note();
            notes[i].createNote(str, numb);
            numb++;
        }
        catch (Exception e){
            System.out.println("У вас закончилось место. Чтобы внести новую заметку, удалите одну из старых :(");
        }
    }

    public void deleteNote(int i){
        if (notes[i] == null) System.out.println("У вас нет такой записи!");
        else {
            while (i < SIZE - 1){
                if (notes[i] != null) {
                    notes[i] = notes[i + 1];
                    i++;
                }
                else{
                    break;
                }
            }
            if (notes[i+1] != null) notes[i+1] = null;
            numb--;
        }
    }

    public void changeNote(int i){
        if (notes[i] == null) System.out.println("У вас нет такой записи!");
        else{
            Scanner in = new Scanner(System.in);
            System.out.println("Введите измененный текст заметки: ");
            String str = in.nextLine();
            notes[i].changeNoteText(str);
        }
    }

}

