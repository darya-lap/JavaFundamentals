package Pool.DAO;

import Pool.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class LibraryController extends AbstractController<Book, Integer> {
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM myDBtest.library";
    private static final String ADD_NEW_BOOK = "insert into mydbtest.library (author,name,year) values ('";
    private static final String UPDATE = "update mydbtest.library set ";
    private static final String GET_BY = "select * from mydbtest.library where ";
    private static final String DELETE_BOOK = "delete from myDBtest.library ";
    private static final String DELETE_TABLE = "drop table mydbtest.library ";


    public LibraryController() throws SQLException {
        super();
    }

    @Override
    public List<Book> getAll() {
        return resultOfExecuteQuery(SELECT_ALL_BOOKS);
    }

    @Override
    public boolean update(Book book) {
        StringBuilder sql = new StringBuilder(UPDATE);
        sql.append("name = '");
        sql.append(book.getName());
        sql.append("', author = '");
        sql.append(book.getAuthor());
        sql.append("', year = ");
        sql.append(book.getYear());
        sql.append(" where id = ");
        sql.append(book.getId());
        return resultOfExecute(sql.toString());
    }


    @Override
    public Book getEntityById(Integer id) {
        StringBuilder getBy = new StringBuilder(GET_BY);
        getBy.append("id = " + id);
        return resultOfExecuteQuery(getBy.toString()).get(0);
    }

    public List<Book> getBooksByName(String name){
        StringBuilder getBy = new StringBuilder(GET_BY);
        getBy.append("name = '" + name + "'");
        return resultOfExecuteQuery(getBy.toString());
    }

    public List<Book> getBooksByAuthor(String author){
        StringBuilder getBy = new StringBuilder(GET_BY);
        getBy.append("author = '" + author + "'");
        return resultOfExecuteQuery(getBy.toString());
    }

    public List<Book> getBooksByNameAndAuthor(String name, String author){
        StringBuilder getBy = new StringBuilder(GET_BY);
        getBy.append("name = '" + name + "'and author = '" + author + "'");
        return resultOfExecuteQuery(getBy.toString());
    }

    public List<Book> getBooksByYear(Integer year){
        StringBuilder getBy = new StringBuilder(GET_BY);
        getBy.append("year = " + year);
        return resultOfExecuteQuery(getBy.toString());
    }

    @Override
    public boolean delete(Integer id) {
        StringBuilder sql = new StringBuilder(DELETE_BOOK);
        sql.append("where id = " + id);
        return resultOfExecute(sql.toString());
    }

    @Override
    public boolean create(Book entity) {
        StringBuilder sql = new StringBuilder(ADD_NEW_BOOK);
        sql.append(entity.getAuthor());
        sql.append("', '" );
        sql.append(entity.getName());
        sql.append("', ");
        sql.append(entity.getYear());
        sql.append(");");
        return resultOfExecute(sql.toString());
    }

    @Override
    public boolean deleteTable() {
        return resultOfExecute(DELETE_TABLE);
    }

    private boolean resultOfExecute(String sql){
        PreparedStatement ps = getPrepareStatement(sql);
        try {
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Book> resultOfExecuteQuery(String sql){
        List<Book> lst = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setAuthor(rs.getString(2));
                book.setName(rs.getString(3));
                book.setYear(rs.getInt(4));
                lst.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement((com.mysql.jdbc.PreparedStatement) ps);
        }
        return lst;
    }
}
