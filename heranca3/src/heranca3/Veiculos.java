package heranca3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Superclasse com atributos em comum.
public class Veiculos {
   
    private String modelo;
    private int anoFabricacao;
    private String montadora;
    private String cor;
    private int kilometragem;

// Constructor para inicialização dos atributos criados.
    public Veiculos(String modelo, int anoFabricacao, String montadora, String cor, int kilometragem) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.montadora = montadora;
        this.cor = cor;
        this.kilometragem = kilometragem;
    }

// Métodos getters e setters para acessar e alterar atributos privados. 
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem; 
    }
    
//Exibição formatada quando puxadas ao main.
    public String exibicao() {
    	return
    			"Modelo: " + this.modelo + "\n" +
    			"Ano de fabricação: " + this.anoFabricacao + "\n" +
    			"Montadora: " + this.montadora + "\n" +
    			"Cor: " + this.cor + "\n" +
    			"Kilometragem: " + this.kilometragem + "\n";
    }
    
//Insert para enviar e armazenar dados no SQL. 
    public void insert() throws SQLException {
        Connection conexao = ConexaoMySQL.conectar(); //Conecta ao banco de dados.

        if (conexao != null) { //Verifica se existe a conexão para dar prosseguimento ao código.
            try {
                //Comando para inserir dados dentro do banco de dados.
                String sql = "INSERT INTO Veiculos (modelo, anoFabricacao, montadora, cor, kilometragem) " +
                             "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql); //Cria um objeto com a consulta SQL.
                //Definindo valores aos parâmetros.
                stmt.setString(1, getModelo());
                stmt.setInt(2, getAnoFabricacao());
                stmt.setString(3, getMontadora());
                stmt.setString(4, getCor());
                stmt.setInt(5, getKilometragem());
                stmt.executeUpdate();
                //Validação do processo de insert dentro do banco de dados.
                System.out.println("Veículo inserido com sucesso na tabela Veiculos!");
                //Tratando exceções caso aconteça algum erro durante a execução do código.
            } catch (SQLException e) {
                e.printStackTrace();
                //Fecha conexão com o banco de dados.
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
