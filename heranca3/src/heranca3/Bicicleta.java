package heranca3;

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
    
  //Simulação do método Insert para enviar e armazenar dados no SQL. (Simulação por conta de não criar banco de dados).   
    public String insert() {
        return "INSERT INTO Bicicleta (modelo, anoFabricacao, marca, cor, kilometragem, material, qtdMarchas, amortecedor) " +
        		 "VALUES ("+ getModelo() +", "+ getAnoFabricacao() +", "+ getMontadora() +", "+ getCor() +"," +getKilometragem()+ ", "+ material +", "+ qtdMarchas +", "+ amortecedor +");";
    }
}
