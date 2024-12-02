package heranca3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Subclasse de Veículos com criação de atributos específicos. 
public class Caminhao extends Veiculos {
	private int qtdEixos;
    private double pesoBruto;

//Constructor para inicialização de atributos puxados e criados.
    public Caminhao(String modelo, int anoFabricacao, String montadora, String cor, int kilometragem,
                    int qtdEixos, double pesoBruto) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);
        this.qtdEixos = qtdEixos;
        this.pesoBruto = pesoBruto;
    }

//Métodos getters e setters para acessar e alterar atributos privados (encapsulamento).
    public int getQtdEixos() {
        return qtdEixos;
    }

    public void setQtdEixos(int qtdEixos) {
        this.qtdEixos = qtdEixos;
    }

    public double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

//Informações formatadas para exibição quando puxadas ao main.
    public String exibicao() {
    	return
    			super.exibicao() +
    			"Quantidade de eixos: " + this.qtdEixos + "\n" +
    			"Peso bruto: " + this.pesoBruto + "\n";
    			
    }
    
//Insert para enviar e armazenar dados no SQL. 
    public void insert() throws SQLException {
        Connection conexao = ConexaoMySQL.conectar(); //Conecta ao banco de dados.

        if (conexao != null) { //Verifica se existe a conexão para dar prosseguimento ao código.
            try {	
                //Comando para inserir dados dentro do banco de dados.
                String sqlVeiculo = "INSERT INTO Veiculos (modelo, anoFabricacao, montadora, cor, kilometragem) " +
                                     "VALUES (?, ?, ?, ?, ?)";
                //Criando objeto com consulta SQL, gerando automaticamente chaves ID, que são recuperadas depois.
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
                String sqlCaminhao = "INSERT INTO Caminhao (id, qtdEixos, pesoBruto) " +
                                      "VALUES (?, ?, ?)";
                PreparedStatement stmtCaminhao = conexao.prepareStatement(sqlCaminhao);
                stmtCaminhao.setInt(1, idVeiculo);  
                stmtCaminhao.setInt(2, qtdEixos);
                stmtCaminhao.setDouble(3, pesoBruto);
                stmtCaminhao.executeUpdate();
                //Validação de sucesso do código.
                System.out.println("Veículo e Caminhão inseridos com sucesso!");
                //Criando exceções caso o código apresente algum erro.
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
