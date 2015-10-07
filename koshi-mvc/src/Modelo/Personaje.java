package Modelo;

public class Personaje {
	
	
	//Atributes
	int maxVida;
	int vidaActual;
	int estado;
	private Plano2D pos;
	String nombre;
	
	
	public Personaje(){
	}
	

	
	public Personaje(String nombre,boolean koshi,int posY,int posX){
		this.nombre=nombre;
		this.maxVida = 5;
		this.vidaActual = 5;
		this.estado = 0;
		this.pos=new Plano2D(posY,posX);
	}
	
	
	//Setters n Getters
	public int getMaxVida() {
		return maxVida;
	}
	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}
	public int getVidaActual() {
		return vidaActual;
	}
	public void setVidaActual(int vidaActual) {
		if (vidaActual <= this.maxVida && vidaActual >= 0)
			this.vidaActual = vidaActual;
	}
	public int getX() {
		return pos.getX();
	}

	public int getY() {
		return pos.getY();
	}

	public Plano2D getPos() {
		return pos;
	}
	public void setPos(int y,int x){
		this.pos.setX(x);
		this.pos.setY(y);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void mover(int x,int y){
	    this.setPos(x, y);
	}
	
	public void cambiaEstado(){
		if (this.estado == 0) this.estado = 1;
		else this.estado = 0;
	}

	public void disminuirVida(){
		int nVida = this.vidaActual -1;
		this.setVidaActual(nVida);
	}
	
	public Plano2D obtenPos(){
		return this.pos;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}


}