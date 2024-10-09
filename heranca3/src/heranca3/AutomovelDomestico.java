package heranca3;

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
    
//Simulação do método Insert para enviar e armazenar dados no SQL. (Simulação por conta de não criar banco de dados).
    public String insert() {
        return "INSERT INTO Automovel_Domestico (modelo, anoFabricacao, montadora, cor, kilometragem, qtdPassageiros, tipoFreio, airbag) " +
        		 "VALUES ("+ getModelo() +" , "+ getAnoFabricacao() +" , "+ getMontadora() +" , "+ getCor() +" , "+ getKilometragem() +" , "+ maxPassageiros + " , "+ tipoFreio +" , "+ airbag +");";
    }
}
