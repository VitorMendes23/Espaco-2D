package Package;

public class Circulo extends Forma{
	
	public Circulo(Ponto2D[] pontos) {
		super(pontos);
		// TODO Auto-generated constructor stub
	}
	
	public double calculaArea() {
		
		Circulo circ = new Circulo(getPontos());
		
		if(circ.getPontos().length == 2) {
			Forma circulo = Forma.geraForma(getPontos());
			Ponto2D[] pontos = circulo.getPontos();
			double raio = pontos[0].calculaDistancia(pontos[1]);
			return Math.PI * Math.pow(raio, 2);
		}
		return 0;		
	}
	
	public double calculaPerimetro() {
		Circulo circ = new Circulo(getPontos());
		
		if(circ.getPontos().length == 2) {
			Forma circulo = Forma.geraForma(getPontos());
			Ponto2D[] pontos = circulo.getPontos();
			double raio = pontos[0].calculaDistancia(pontos[1]);
			return Math.PI * raio * 2;
		}
		return 0;		
		
	}

}
