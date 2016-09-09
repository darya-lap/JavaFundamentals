package Task_6;

import java.util.Scanner;

/**
 * Класс представляет собой список заметок
 *
 */
public class Notebook {
    /**
     * @param SIZE - максимальное количество заметок
     * @param notes - массив заметок
     * @param numb - номер первой свободной позиции в списке заметок
     */
    final int SIZE = 100;
    private Note[] notes = new Note[SIZE];
    private static int numb = 0;

    /**
     * Метод выводит на экран все существующие заметки
     * @return true, если заметки были выведены на экран, false - если массив заметок пуст
     */
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

    /**
     * Метод добавляет новую заметку
     */
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

    /**
     * Метод удаляет заметку
     * @param i номер удаляемой заметки
     */
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

    /**
     * Метод изменяет текст заметки
     * @param i номер изменяемой заметки
     */
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

