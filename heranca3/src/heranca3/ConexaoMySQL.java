package heranca3;

//Importando bibliotecas.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Criação da classe responsável por conectar o código ao banco de dados MySQL.
public class ConexaoMySQL {
	private static final String URL = "jdbc:mysql://localhost:3306/veiculosdb"; 
    private static final String USUARIO = "root"; 
    private static final String SENHA = ""; 

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
