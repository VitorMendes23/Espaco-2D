package Package;

public abstract class Forma {
	
	private Ponto2D[] pontos;
	private double area;
	private double perimetro;
	
	public abstract double calculaArea(); 
	
	public abstract double calculaPerimetro();
	
	public Forma() {
		pontos = null;
		area = 0;
		perimetro = 0;
	}

	public Forma(Ponto2D[] pontos) {
		this.pontos = pontos;
		area = 0;
		perimetro = 0;
	}

	public Ponto2D[] getPontos() {
		return pontos;
	}

	public void setPontos(Ponto2D[] pontos) {
		this.pontos = pontos;
	}
	
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public static Forma geraForma(Ponto2D[] pontos) {
		
		int tamanho = pontos.length; 
		
		Forma forma = null;
		
		switch (tamanho) {
		case 2: {
			if(formaCirculo(pontos)) 
				forma = new Circulo(pontos);
            break;
		}
		case 3: {
			if(formaTriangulo(pontos))
				forma = new Triangulo(pontos);
			break;
		}
		case 4: {
			if(formaQuadrado(pontos))
				forma = new Quadrado(pontos);
			break;
		}
		default:{
			forma = null;
			break;
		}		
	}		
		return forma;
	}
	//pode ter esse metodo que verifica se vai formar um trisangulo
	private static boolean formaTriangulo(Ponto2D[] pontos) {
		
		double distancia1 = pontos[0].calculaDistancia(pontos[1]);
		double distancia2 = pontos[0].calculaDistancia(pontos[2]);
		double distancia3 = pontos[1].calculaDistancia(pontos[2]);
		
		if(distancia1 + distancia2 > distancia3 && distancia1 + distancia3 > distancia2 && (distancia3 + distancia2 > distancia1))
			return true;
		else
			return false;
		
	}
	private static boolean formaCirculo(Ponto2D[] pontos) {
		
		double raio = pontos[0].calculaDistancia(pontos[1]);
		
		if(raio > 0)
			return true;
		else
			return false;		
	}
	private static boolean formaQuadrado(Ponto2D[] pontos) {
		
	    // Verifica se todos os lados têm o mesmo comprimento.
		double distncia12 = pontos[0].calculaDistancia(pontos[1]);
		double distncia23 = pontos[1].calculaDistancia(pontos[2]);
		double distncia34 = pontos[2].calculaDistancia(pontos[3]);
		double distncia41 = pontos[3].calculaDistancia(pontos[1]);
		
		   if (distncia12 != distncia23 || distncia23 != distncia34 || distncia34 != distncia41) {
		        return false;
		    }
		// Verifica se todas as diagonais têm o mesmo comprimento.
		double distancia13 = pontos[0].calculaDistancia(pontos[2]);
		double distancia24 = pontos[1].calculaDistancia(pontos[3]);
		   if (distancia13 != distancia24) {
		        return false;
		    }
		// Verifica se os ângulos são todos iguais a 90 graus (usando o produto escalar).
		double produto12_23 = (pontos[1].getX() - pontos[0].getX()) * (pontos[2].getX() - pontos[1].getX()) + (pontos[1].getY() - pontos[0].getY()) * (pontos[2].getY() - pontos[1].getY());
		double produto23_34 = (pontos[2].getX() - pontos[1].getX()) * (pontos[3].getX() - pontos[2].getX()) + (pontos[2].getY() - pontos[1].getY()) * (pontos[3].getY() - pontos[2].getY());
		double produto34_41 = (pontos[3].getX() - pontos[2].getX()) * (pontos[0].getX() - pontos[3].getX()) + (pontos[3].getY() - pontos[2].getY()) * (pontos[0].getY() - pontos[3].getY());
		double produto41_12 = (pontos[0].getX() - pontos[3].getX()) * (pontos[1].getX() - pontos[0].getX()) + (pontos[0].getY() - pontos[3].getY()) * (pontos[1].getY() - pontos[0].getY());
		    if (produto12_23 != 0 || produto23_34 != 0 || produto34_41 != 0 || produto41_12 != 0) {
		        return false;
		    }
		// Verifica se a diagonal tem o comprimento correto.
		double diagonal = pontos[0].calculaDistancia(pontos[2]);
		double diagonalCorreta = Math.sqrt(2) * distncia12;
		    if (diagonal != diagonalCorreta) {
		        return false;
		    }
		// Se todas as condições forem satisfeitas, os pontos formam um quadrado.
		return true;
	}

}
