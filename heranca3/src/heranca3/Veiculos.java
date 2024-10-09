package heranca3;

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
    
//Simulação do método Insert para enviar e armazenar dados no SQL. (Simulação por conta de não criar banco de dados).
    public String insert() {
        return "INSERT INTO veiculos (modelo, anoFabricacao, montadora, cor, kilometragem)" +
        		 " VALUES ("+ modelo +" , " + anoFabricacao + ", " + montadora + ", " + cor + ", " + kilometragem + ");";
    }
}
