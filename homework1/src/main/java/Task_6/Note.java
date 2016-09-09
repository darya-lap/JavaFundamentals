package Task_6;

/**
 *Класс Note представляет собой заметку
 */
public class Note {
    /**
     * @param numberOfNote номер заметки
     * @param note текст заметки
     */
    private int numberOfNote;
    private String note;

    /**
     *Метод создает заметку
     * @param str текст создаваемой заметки
     * @param numb номер создаваемой заметки
     */
    public void createNote(String str, int numb){
        note = str;
        numberOfNote = numb;
    }

    /**
     * Метод изменяет текст в заметке
     * @param str текст замены
     */
    public void changeNoteText(String str){
        note = str;
    }

    /**
     *
     * @return возвращает заметку
     */
    public String getNote(){
        return this.note;
    }
}
