package Package;

import java.util.ArrayList;
import java.util.Scanner;


public class Teste {

	public static void main(String[] args) {
		
		Espaco2D espaco2d = new Espaco2D();

		Scanner scanner = new Scanner(System.in);
		boolean continuarPrograma = true;
		
		System.out.print("Bem-vindo ao sistema de geometria\n");
		System.out.print("Pressione <enter> para continuar ou digite 'sair' para sair do sistema.\n\n");
		
	    String resosta = scanner.nextLine();
	    
	    if(resosta.equals("sair")) {
        	scanner.close();
        	System.out.println("Programa encerrando...");
        	System.exit(0); 
	    }


		while (continuarPrograma) {

			System.out.printf("Digite a opção desejada:\n\n");
		    System.out.printf("Criar forma [1]\n");
		    System.out.printf("Calcular área total [2]\n");
		    System.out.printf("Calcular perímetro total  [3]\n");
		    System.out.printf("Mostrar tipos de triangulos do programa [4]\n");

		    int numero = scanner.nextInt();

		    if (numero < 1 || numero > 4) {
		        while (numero < 1 || numero > 4) {
		            System.out.printf("Digite uma opção válida:\n\n");
		            numero = scanner.nextInt();
		        }
		    }

		    switch (numero) {
		        case 1: {
		        	
					System.out.printf("É possível criar 3 tipos de formas:\n"
							+ "- Quadrado (4 pontos)\n"
							+ "- Triangulo (3 pontos)\n"
							+ "- Circulo (2 pontos)\n"
							+ "Você deve digitar 2 coordenadas para cada ponto, atente-se ao número de coordenadas e pontos\n"
							+ "Quantos pontos você vai utilizar? \n");
					int pont = scanner.nextInt();
					
					ArrayList<Ponto2D> pontos = new ArrayList<Ponto2D>(); 

					
					for(int i = 1; i <= pont; i++) {
						
						System.out.printf("Digite a coordenada x do ponto:\n");
						double x = scanner.nextDouble();
				        scanner.nextLine(); // Limpa o buffer
				        
						System.out.printf("Digite a coordenada y do ponto:\n");
						double y = scanner.nextDouble();
				        scanner.nextLine(); // Limpa o buffer

						Ponto2D ponto = new Ponto2D(x ,y);
						pontos.add(ponto);

					}
					Ponto2D[] vetPontos = (Ponto2D[]) pontos.toArray(new Ponto2D[0]);
					
					Forma forma = espaco2d.criaForma(vetPontos);
					
					Boolean adicionou = espaco2d.adicionaForma(forma);

					if(adicionou)
					System.out.printf("Forma adicionada! \n");
					else
					System.out.printf("Forma não adicionada! Você inseriu dados que não compõem uma forma \n");



		            break;
		        }
		        case 2: {
		        	
		        	double areaTotal = espaco2d.calculaAreaTotal();
		        	
		            System.out.printf("A soma das areas totais do espaço 2D do programa é: "+ areaTotal + "\n");
		            
		            break;
		         }
		        case 3: { 
		            
		        	double perimetroTotal = espaco2d.calculaPerimetroTotal();
		        	
		            System.out.printf("A soma dos perimetros totais do espaço 2D do programa é: "+ perimetroTotal + "\n");
		        	
					break;	
		        }
		        case 4: {
		        	
		        	String tiposTriangulo = espaco2d.mostraTipoTriangulos();
		        	
		            System.out.printf("Os triangulos presente no espaço 2D do programa é: "+ tiposTriangulo + "\n");
		        	
		        	break;
		        }
		        default:
		            break;
		    }

		    System.out.printf("Deseja continuar o programa? Sim[1] Não[0]\n");

		    
		    int opcao = scanner.nextInt();

		    
		    while (opcao != 0 && opcao != 1) {
		        System.out.printf("Digite uma opção válida: 1 para Sim ou 0 para Não\n");
		        opcao = scanner.nextInt();
		        scanner.nextLine(); // Consumir o caractere '\n'

		    }

		    if (opcao == 0) {
				continuarPrograma = false;
				scanner.close();
				System.out.println("Programa encerrando...");
				System.out.println("Obrigada por utilizar o sistema!");
				System.exit(0); 

		    }

			
		}
	}
	

}
