package LibraryWorking;

import Pool.DAO.LibraryController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibraryController controller = new LibraryController();
        controller.deleteTable();
//        book.setYear(2016);
//        book.setAuthor("Shildt");
//        book.setName("Java 8");
//        controller.update(book);
    }
}
