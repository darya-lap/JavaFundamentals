package Pool.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;



public class ConnectionPool {

    private Vector<Connection> availableConns = new Vector<>();
    private Vector<Connection> usedConns = new Vector<>();

    public ConnectionPool(int initConnCnt) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < initConnCnt; i++) {
            availableConns.addElement(createConnection());
        }
    }

    public static ConnectionPool getConnectionPool(int k) {
        return new ConnectionPool(k);
    }

    public Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/myDBtest?" +
                    "user=darya&password=darya");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized Connection getConnection() throws SQLException {
        Connection newConn;
        if (availableConns.size() == 0) {
            newConn = createConnection();
        } else {
            newConn = availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void returnConnection(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
                //закрываем соединение
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new NullPointerException("Connection not in the using");
            }
        }
    }

    //возвращает количество используемых соединений
    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}
