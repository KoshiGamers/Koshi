package Modelo;

public class Obstaculo implements Objeto {
	private String nombre;
	private Plano2D pos = new Plano2D(0, 0);
	private int tipo;
	private String descripcion;
	private int estado;
	private char caracter;
	private int codigo;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPos(int x, int y) {
		this.pos.setX(x);
		this.pos.setY(y);
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Plano2D obtenPosicion() {
		return this.pos;
	}

	public String obtenNombre() {
		return this.nombre;
	}

	public int obtenTipo() {
		return this.tipo;
	}

	public String obtenDescripcion() {
		return this.descripcion;
	}

	public int obtenEstado() {
		return this.estado;
	}

	public char obtenCaracter() {
		return this.caracter;
	}

	public int obtenCodigo() {
		return this.codigo;
	}

	public Obstaculo() {
	}

	public Obstaculo(Obstaculo orig) {
		this.descripcion = orig.descripcion;
		this.nombre = orig.nombre;
		this.pos = new Plano2D(orig.pos.getX(), orig.pos.getY());
		this.tipo = orig.tipo;
		this.estado = orig.estado;
		this.caracter = orig.caracter;
		this.codigo = orig.codigo;
	}
}
