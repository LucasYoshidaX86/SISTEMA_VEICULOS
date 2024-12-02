package heranca3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Subclasse de veículos com atributos específicos. 
public class Motocicleta extends Veiculos {
	 private int cilindradas;
	    private int torque;

//Constructor para inicialização dos atributos puxados e criados.
	    public Motocicleta(String modelo, int anoFabricacao, String montadora, String cor, int kilometragem, int cilindradas, int torque) {
	        super(modelo, anoFabricacao, montadora, cor, kilometragem);
	        this.cilindradas = cilindradas;
	        this.torque = torque;
	    }

//Métodos getters e setters para acessar e alterar atributos privados (encapsulamento).
	    public int getCilindradas() {
	        return cilindradas;
	    }

	    public void setCilindradas(int cilindradas) {
	        this.cilindradas = cilindradas;
	    }

	    public int getTorque() {
	        return torque;
	    }

	    public void setTorque(int torque) {
	        this.torque = torque;
	    }
	    
//Informações formatadas para exibição quando puxadas ao main.	    
	    public String exibicao() {
	    	return
	    			super.exibicao() +
	    			"Cilindradas: " + this.cilindradas + "\n" +
	    			"Torque: " + this.torque + "\n";
	    }
	    
//Insert para enviar e armazenar dados no SQL. 
	    public void insert() throws SQLException {
	        Connection conexao = ConexaoMySQL.conectar(); //Conecta ao banco de dados.

	        if (conexao != null) { //Verifica se existe a conexão para dar prosseguimento ao código.
	            try {
	                //Comando para inserir dados dentro do banco de dados.
	                String sqlVeiculo = "INSERT INTO Veiculos (modelo, anoFabricacao, montadora, cor, kilometragem) " +
	                                     "VALUES (?, ?, ?, ?, ?)";
	                //Criando objeto com consulta SQL, gerando automaticamente chaves ID, que serão recuperadas depois.
	                PreparedStatement stmtVeiculo = conexao.prepareStatement(sqlVeiculo, PreparedStatement.RETURN_GENERATED_KEYS);
	                //Definindo valores aos parâmetros.
	                stmtVeiculo.setString(1, getModelo());
	                stmtVeiculo.setInt(2, getAnoFabricacao());
	                stmtVeiculo.setString(3, getMontadora());
	                stmtVeiculo.setString(4, getCor());
	                stmtVeiculo.setInt(5, getKilometragem());
	                stmtVeiculo.executeUpdate();

	                //Recupera o ID gerado do veiculo inserido.
	                var rs = stmtVeiculo.getGeneratedKeys();
	                int idVeiculo = 0;
	                if (rs.next()) {
	                    idVeiculo = rs.getInt(1);
	                }

	                //Comando para inserir dados dentro do banco de dados.
	                String sqlMotocicleta = "INSERT INTO Motocicleta (id, cilindradas, torque) " +
	                                        "VALUES (?, ?, ?)";
	                PreparedStatement stmtMotocicleta = conexao.prepareStatement(sqlMotocicleta);
	                stmtMotocicleta.setInt(1, idVeiculo);  
	                stmtMotocicleta.setInt(2, cilindradas);
	                stmtMotocicleta.setInt(3, torque);
	                stmtMotocicleta.executeUpdate();
	                //Validação de sucesso do código.
	                System.out.println("Motocicleta inseridos com sucesso!");
	                //Criando exceções caso apresente algum erro.
	            } catch (SQLException e) {
	                e.printStackTrace();
	                //Fechando conexão com o banco de dados.
	            } finally {
	                try {
	                    conexao.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
