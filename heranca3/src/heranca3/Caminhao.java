package heranca3;

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
    
//Simulação do método Insert para enviar e armazenar dados no SQL. (Simulação por conta de não criar banco de dados).
    public String insert() {
        return "INSERT INTO Caminhao (modelo, anoFabricacao, montadora, cor, kilometragem, qtdEixos, pesoBruto) " +
        			"VALUES ("+ getModelo() +", "+ getAnoFabricacao() +", "+ getMontadora() +", "+ getCor() +", "+ getKilometragem() +", "+ qtdEixos +", "+ pesoBruto +");";
    }
}
