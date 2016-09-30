package Task_6;

import java.util.Scanner;

/**
 * Класс для использования возможностей программы
 */
public class Start_Notebook {
    public static void main(String[] args) {
        Notebook book = new Notebook();
        System.out.println("Вас приветствует самый бесполезный блокнот в консольке!");
        int w = 1;
        Menu:
        while (w != 5){
            System.out.println("\n\nЧто я могу сделать для вас?");
            System.out.println("1. Показать список всех записей\n2. Добавить запись");
            System.out.println("3. Удалить запись\n4. Редактировать запись\n5. Выйти из чудо-программы");
            Scanner in = new Scanner(System.in);
            w = in.nextInt();
            switch (w) {
                case 1:
                    book.showAllNotes();
                    break;
                case 2:
                    book.addNote();
                    break;
                case 3:
                    if (book.showAllNotes()) {
                        System.out.print("Введите номер ненужной записи: ");
                        int h = in.nextInt();
                        book.deleteNote(h - 1);
                    }
                    break;
                case 4:
                    if (book.showAllNotes()){
                        System.out.print("Введите номер неправильной записи: ");
                        int h1 = in.nextInt();
                        book.changeNote(h1 - 1);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Некорректный ввод");
                    break;
            }
            //System.out.println("\nНажмите на любую букву или цефру для продолжения...");
            //in.next();
        }
    }
}
