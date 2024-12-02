package heranca3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Subclasse de Veículos com criação de atributos específicos.
public class Bicicleta extends Veiculos{
	private String material;
    private int qtdMarchas;
    private String amortecedor;

//Constructor para inicialização dos atributos herdados e criados. 
    public Bicicleta(String modelo, int anoFabricacao, String montadora, String cor,int kilometragem, String material, int qtdMarchas, String amortecedor) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem); 
        this.material = material;
        this.qtdMarchas = qtdMarchas;
        this.amortecedor = amortecedor;
    }

//Métodos getters e setters para acessar e alterar atributos privados (encapsulamento). 
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQtdMarchas() {
        return qtdMarchas;
    }

    public void setQtdMarchas(int qtdMarchas) {
        this.qtdMarchas = qtdMarchas;
    }

    public String getAmortecedor() {
        return amortecedor;
    }

    public void setAmortecedor(String amortecedor) {
        this.amortecedor = amortecedor;
    }
 
//Informações formatadas quando puxadas ao main.
    public String exibicao() {
    	return
    			super.exibicao() +
    			"Material: " + this.material + "\n" +
    			"Quantidade de marchas: " + this.qtdMarchas + "\n" +
    			"Amortecedor: " + this.amortecedor + "\n";
    }
    
  //Insert para enviar e armazenar dados no SQL.  
    public void insert() throws SQLException {
        Connection conexao = ConexaoMySQL.conectar(); //Conecta ao banco de dados.

        if (conexao != null) { //Verifica se existe a conexão para dar prosseguimento ao código.
            try {
                //Comando para inserir dados dentro do banco de dados.
                String sqlVeiculo = "INSERT INTO Veiculos (modelo, anoFabricacao, montadora, cor, kilometragem) " +
                                     "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmtVeiculo = conexao.prepareStatement(sqlVeiculo, PreparedStatement.RETURN_GENERATED_KEYS);
                //Definindo valores aos parâmetros.
                stmtVeiculo.setString(1, getModelo());
                stmtVeiculo.setInt(2, getAnoFabricacao());
                stmtVeiculo.setString(3, getMontadora());
                stmtVeiculo.setString(4, getCor());
                stmtVeiculo.setInt(5, getKilometragem());
                stmtVeiculo.executeUpdate();

                // Recupera ID gerado do veiculo inserido.
                var rs = stmtVeiculo.getGeneratedKeys();
                int idVeiculo = 0;
                if (rs.next()) {
                    idVeiculo = rs.getInt(1);
                }

                //Comando para inserir dados dentro do banco de dados.
                String sqlBicicleta = "INSERT INTO Bicicleta (id, material, qtdMarchas, amortecedor) " +
                                      "VALUES (?, ?, ?, ?)";
                PreparedStatement stmtBicicleta = conexao.prepareStatement(sqlBicicleta);
                stmtBicicleta.setInt(1, idVeiculo);  
                stmtBicicleta.setString(2, material);
                stmtBicicleta.setInt(3, qtdMarchas);
                stmtBicicleta.setString(4, amortecedor);
                stmtBicicleta.executeUpdate();
                //Validação de sucesso do código.
                System.out.println("Veículo e Bicicleta inseridos com sucesso!");
                //Criando exceções caso aconteça algum erro.
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
