package Pool.DAO;

import Pool.ConnectionPool.ConnectionPool;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<E, K> {
    private Connection connection;
    private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool(10);

    public AbstractController() throws SQLException {
        connection = connectionPool.getConnection();
    }

    public abstract List<E> getAll();
    public abstract boolean update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);
    public abstract boolean deleteTable();

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() {
        connectionPool.returnConnection(connection);
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

