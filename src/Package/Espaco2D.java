package Package;

import java.util.ArrayList;

public class Espaco2D {
	
	private ArrayList<Forma> formas;

	public ArrayList<Forma> getFormas() {
		return formas;
	}

	public void setFormas(ArrayList<Forma> formas) {
		this.formas = formas;
	}

	public Espaco2D(ArrayList<Forma> formas) {
		this.formas = formas;
	}
	public Espaco2D() {
		this.formas = new ArrayList<Forma>();
	}
	
	public Forma criaForma(Ponto2D[] pontos) {
	    Forma forma = Forma.geraForma(pontos);		
		return forma;
		
	}
	public double calculaAreaTotal() {
		
		double areaTotal = 0;
		
		for(Forma forma : formas) {
			if(forma instanceof Triangulo)
				areaTotal = areaTotal + ((Triangulo)forma).calculaArea();
			else if(forma instanceof Circulo)
				areaTotal = areaTotal + ((Circulo)forma).calculaArea();
			else if(forma instanceof Quadrado)
				areaTotal = areaTotal + ((Quadrado)forma).calculaArea();
		}
			
		return areaTotal;
	}
	
	public double calculaPerimetroTotal() {
		
		double perimetrTotal = 0;
		
		for(Forma forma : formas) {
			if(forma instanceof Triangulo)
				perimetrTotal = perimetrTotal + ((Triangulo)forma).calculaPerimetro();
			else if(forma instanceof Circulo)
				perimetrTotal = perimetrTotal + ((Circulo)forma).calculaPerimetro();
			else if(forma instanceof Quadrado)
				perimetrTotal = perimetrTotal + ((Quadrado)forma).calculaPerimetro();
		}
			
		return perimetrTotal;
		
	}
	
	public boolean adicionaForma(Forma forma) {
		
		int tamanhoListaAntes = formas.size();
		
		if(forma != null)
		formas.add(forma);
		
		int tamanhoListaDepois = formas.size();
		
		if(tamanhoListaAntes == tamanhoListaDepois)
			return false;
		else
			return true;

	}
	
	public String mostraTipoTriangulos() {
		//percorrer o arraylist e se achar trinagulo vai mostrar o tipo
		String tipoTriangulos = null;
		for(Forma forma : formas) {
			if(forma instanceof Triangulo)
				tipoTriangulos = tipoTriangulos +" - " + ((Triangulo)forma).tipoTriangulo();
		}
		return tipoTriangulos;
	}
	

}
