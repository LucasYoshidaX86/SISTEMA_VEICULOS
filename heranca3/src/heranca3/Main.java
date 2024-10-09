package heranca3;

public class Main {

	public static void main(String[] args) {
//Instâncias criadas para diferentes tipos de veículos.
		
//Carro com todos os dados +  simulação insert para banco de dados.
        AutomovelDomestico v1 = new AutomovelDomestico("Gol", 2013, "Volkswagen", "Branco", 150000, 5, "ABS", "Não");
        	System.out.println("\n" + "Dados do veículo: " + "\n");
        		System.out.println(v1.exibicao());
        			System.out.println(v1.insert());
        	
        
//Moto com todos os dados + simulação insert para banco de dados.       
        Motocicleta v2 = new Motocicleta("MT-07", 2025, "Yamaha", "Preta", 20000, 689, 7);
        	System.out.println("\n" + "Dados do veículo: " + "\n");
        		System.out.println(v2.exibicao());
        			System.out.println(v2.insert());
        	
        	
//Caminhão com todos os dados + simulação de insert para banco de dados.        
        Caminhao v3 = new Caminhao("Volvo FMX", 2023, "Volvo", "Branca", 100000, 4, 58000);
        	System.out.println("\n" + "Dados do veículo: " + "\n");
        		System.out.println(v3.exibicao());
        			System.out.println(v3.insert());
        	
        	
//Bicicleta com todos os dados + simulação de insert para banco de dados.       
        Bicicleta v4 = new Bicicleta("Caloi FS Carbon", 2022, "Caloi", "Preta/vermelha", 0, "Carbono", 12, "Sim - RockShox");
        	System.out.println("\n" + "Dados do veículo: " + "\n");
        		System.out.println(v4.exibicao());
        			System.out.println(v4.insert());
        	
        	
//Skate com todos os dados + simulação de insert para banco de dados.        
        Skate v5 = new Skate("Obscure Hand", 2021, "Santa Cruz", "Azul/Roxo/Verde", 0,  "PU");
        	System.out.println("\n" + "Dados do veículo: " + "\n");
        		System.out.println(v5.exibicao());
        			System.out.println(v5.insert());
        	
        
            
	}

}
