package Package;

public class Quadrado extends Forma{
	

	public Quadrado(Ponto2D[] pontos) {
		super(pontos);
		// TODO Auto-generated constructor stub
	}
	
	public double calculaArea() {
		Quadrado quad = new Quadrado(getPontos());
		
		if(quad.getPontos().length == 4) {
			Forma quadrado = Forma.geraForma(getPontos());
			Ponto2D[] pontos = quadrado.getPontos();
			double lado = pontos[0].calculaDistancia(pontos[1]);
			return Math.pow(lado, 2);
		}
		return 0;
	}
	
	public double calculaPerimetro() {
		Quadrado quad = new Quadrado(getPontos());
		
		if(quad.getPontos().length == 4) {
			Forma quadrado = Forma.geraForma(getPontos());
			Ponto2D[] pontos = quadrado.getPontos();
			double lado = pontos[0].calculaDistancia(pontos[1]);
			return lado * 4;
		}
		
		return 0;
	}
}
