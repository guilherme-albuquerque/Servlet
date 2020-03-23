package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Para o teste implementar o banco de dados para assim poder rodar os testes.
     */

    public static Connection obtemConexao() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost/vendas?user=guilherme&password=12343");
    }

}
