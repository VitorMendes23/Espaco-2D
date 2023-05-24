package Package;

public class Ponto2D {

	private double x;
	private double y;
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Ponto2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public Ponto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Ponto2D(Ponto2D ponto) {
		this.x = ponto.getX();
		this.y = ponto.getY();
	}
	
	public double calculaDistancia(Ponto2D ponto) {
		double distanciaX = ponto.x - this.x;
        double distanciaY = ponto.y - this.y;
        return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
	}

}
