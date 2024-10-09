package heranca3;

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
    
//Simulação do método Insert para enviar e armazenar dados no SQL. (Simulação por conta de não criar banco de dados).   
    public String insert() {
        return "INSERT INTO Skate (modelo, anoFabricacao, marca, cor, kilometragem, tipoRodas) " +
        		 "VALUES ("+ getModelo() +", "+ getAnoFabricacao() +", "+ getMontadora() +", "+ getCor() +", "+ getKilometragem()+", "+ tipoRodas +");";
    }
}
