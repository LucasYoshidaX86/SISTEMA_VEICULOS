package heranca3;

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
	    
//Simulação do método Insert para enviar e armazenar dados no SQL. (Simulação por conta de não criar banco de dados).
	    public String insert() {
	        return "INSERT INTO Motocicleta (modelo, anoFabricacao, montadora, cor, kilometragem, cilindradas, torque)" +
	        		 " VALUES ("+ getModelo() + ", " + getAnoFabricacao() + ", " + getMontadora() + ", " + getCor() + ", " + getKilometragem() + ", " + cilindradas + ", " + torque + ");";
	    }
}
