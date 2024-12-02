package heranca3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Subclasse de veiculos com atributos específicos.
public class AutomovelDomestico extends Veiculos{
	private int maxPassageiros;
    private String tipoFreio;
    private String airbag;

//Constructor para inicialização dos atributos criados e puxados da superclasse.
    public AutomovelDomestico(String modelo, int anoFabricacao, String montadora, String cor, int kilometragem, int maxPassageiros, String tipoFreio, String airbag) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);
        this.maxPassageiros = maxPassageiros;
        this.tipoFreio = tipoFreio;
        this.airbag = airbag;
    }

//Métodos getters e setters para acessar e alterar atrivutos privados (encapsulamento).
    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }
    
//Informações formatadas para exibição quando puxadas ao main.
    public String exibicao() {
    	return
    			super.exibicao() +
    			"Quantidade máxima de passageiros: " + this.maxPassageiros + "\n" +
    			"Tipo de freio: " + this.tipoFreio + "\n" +
    			"Airbag: " + this.airbag + "\n";
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
                String sqlAuto = "INSERT INTO AutomovelDomestico (id, maxPassageiros, tipoFreio, airbag) " +
                                 "VALUES (?, ?, ?, ?)";
                PreparedStatement stmtAuto = conexao.prepareStatement(sqlAuto);
                stmtAuto.setInt(1, idVeiculo);  
                stmtAuto.setInt(2, maxPassageiros);
                stmtAuto.setString(3, tipoFreio);
                stmtAuto.setString(4, airbag);
                stmtAuto.executeUpdate();
                //Validação de sucesso do código.
                System.out.println("Veículo e Automóvel Doméstico inseridos com sucesso!");
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
