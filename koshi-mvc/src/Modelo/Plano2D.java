package Modelo;

public class Plano2D {
	/*Cree esta clase dado a que a veces es necesario
	 * modificar dos parámetros en una misma llamada
	 * a la función, como sería en c++ pasarlos por referencia,
	 * pero en Java no existe parámetros por referencia, por tanto
	 * cree Plano2D que en verdad es un contenedor que permite
	 * que varíes X y y en un mismo llamado
	 */
	private int ejeX;
	private int ejeY;
	
	public Plano2D(int ejeY,int ejeX){
		this.ejeX=ejeX;
		this.ejeY=ejeY;
	}
	public Plano2D(Plano2D copy){
		this.ejeX=copy.ejeX;
		this.ejeY=copy.ejeY;
	}
	public void setX(int x){
		this.ejeX=x;
	}
	public void setY(int y){
		this.ejeY=y;
	}
	public int getX(){
		return this.ejeX;
	}
	public int getY(){
		return this.ejeY;
	}
	public String toString(){
		return this.ejeX + " " + this.ejeY;
	}
}