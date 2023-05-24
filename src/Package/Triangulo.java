package Package;

public class Triangulo extends Forma{
	
	public Triangulo(Ponto2D[] pontos) {
		super(pontos);
		// TODO Auto-generated constructor stub
	}
	
	public double calculaArea() {
		
		Triangulo tria = new Triangulo(getPontos());
		
		if(tria.getPontos().length == 3) {
			Forma triangulo = Forma.geraForma(getPontos());
			if(triangulo != null) {
				Ponto2D[] pontos = triangulo.getPontos();
				String tipoTriangulo = tria.tipoTriangulo();
				
				double distancia1 = pontos[0].calculaDistancia(pontos[1]);
				double distancia2 = pontos[0].calculaDistancia(pontos[2]);
				double distancia3 = pontos[1].calculaDistancia(pontos[2]);
				
				if(tipoTriangulo.equals("equilatero")) {
					double lado = pontos[0].calculaDistancia(pontos[1]);
					return (Math.pow(lado, 2) * Math.sqrt(3)) / 4;
					
				}else if(tipoTriangulo.equals("escaleno")){

				    double perimetro = (distancia1 + distancia2 + distancia3) / 2; // semi-perímetro
				    
				    return Math.sqrt(perimetro * (perimetro - distancia1) * (perimetro - distancia2) * (perimetro - distancia3)); // fórmula de Heron
				
				}else if(tipoTriangulo.equals("isosceles")) {
					double area = 0;
				    double base = 0;
				    double altura = 0;
					if((distancia1 == distancia2 && distancia1 != distancia3)) {
						base = distancia3 / 2;
						altura =  Math.sqrt(Math.pow(distancia1, 2) - Math.pow(base, 2));
						area = (base * altura) / 2;
					}else if((distancia1 == distancia3 && distancia1 != distancia2)) {
						base = distancia2 / 2;
						altura =  Math.sqrt(Math.pow(distancia1, 2) - Math.pow(base, 2));
						area = (base * altura) / 2;
					}else if((distancia3 == distancia2 && distancia1 != distancia3)) {
						base = distancia1 / 2;
						altura =  Math.sqrt(Math.pow(distancia3, 2) - Math.pow(base, 2));
						area = (base * altura) / 2;
					}
					return area;

				}
				
			}
		}
		return 0;	
		
	}
	
	public double calculaPerimetro() {

		
		Triangulo tria = new Triangulo(getPontos());
		
		if(tria.getPontos().length == 3) {
			Forma triangulo = Forma.geraForma(getPontos());
			if(triangulo != null) {
				Ponto2D[] pontos = triangulo.getPontos();
				String tipoTriangulo = tria.tipoTriangulo();
				
				double distancia1 = pontos[0].calculaDistancia(pontos[1]);
				double distancia2 = pontos[0].calculaDistancia(pontos[2]);
				double distancia3 = pontos[1].calculaDistancia(pontos[2]);
				
				if(tipoTriangulo.equals("equilatero")) {
					return 3 * distancia1;
					
				}else if(tipoTriangulo.equals("escaleno") || tipoTriangulo.equals("isosceles")){
					return distancia1 + distancia2 + distancia3;
				}
				
			}
		}
		return 0;	
		
		
	}
	public String tipoTriangulo() {
		
		Triangulo tria = new Triangulo(getPontos());
		
		if(tria.getPontos().length == 3) {
			Forma trangulo = Forma.geraForma(getPontos());
			Ponto2D[] pontos = trangulo.getPontos();
			
			double distancia1 = pontos[0].calculaDistancia(pontos[1]);
			double distancia2 = pontos[0].calculaDistancia(pontos[2]);
			double distancia3 = pontos[1].calculaDistancia(pontos[2]);
			
			if(distancia1 == distancia2 && distancia1 == distancia3 && distancia3 == distancia2  )
				return"equilatero";
			else if(distancia1 != distancia2 && distancia1 != distancia3 && distancia3 != distancia2)
				return"escaleno";
			else if((distancia1 == distancia2 && distancia1 != distancia3) || (distancia1 == distancia3 && distancia1 != distancia2) || (distancia3 == distancia2 && distancia1 != distancia3))
				return"isosceles";
		}

		return"não triangulo";

	}

}
