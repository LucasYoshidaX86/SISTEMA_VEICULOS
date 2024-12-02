package heranca3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Subclasse de Veiculos com criação de atributos específicos.
public class Skate extends Veiculos{
	private String tipoRodas;

//Constructor para inicialização de atributos herdados e criados.
    public Skate(String modelo, int anoFabricacao, String marca, String cor, int kilometragem, String tipoRodas) {
        super(modelo, anoFabricacao, marca, cor, kilometragem); // Usa marca como "montadora" na superclasse
        this.tipoRodas = tipoRodas;
    }

 //Métodos getters e setters para acessar e alterar atributos privados (encapsulamento).
    public String getTipoRodas() {
        return tipoRodas;
    }

    public void setTipoRodas(String tipoRodas) {
        this.tipoRodas = tipoRodas;
    }
  
//Informações formatadas para exibição quando puxadas ao main.
    public String exibicao() {
    	return
    			super.exibicao() +
    			"Tipo de rodas: " + this.tipoRodas + "\n";
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

                // Comando para inserir dados dentro do banco de dados.
                String sqlSkate = "INSERT INTO Skate (id, tipoRodas) " +
                                  "VALUES (?, ?)";
                PreparedStatement stmtSkate = conexao.prepareStatement(sqlSkate); 
                stmtSkate.setInt(1, idVeiculo);  
                stmtSkate.setString(2, tipoRodas);
                stmtSkate.executeUpdate();
                //Validação de sucesso do código.
                System.out.println("Veículo e Skate inseridos com sucesso!");
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
