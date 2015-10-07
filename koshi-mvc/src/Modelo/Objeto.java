package Modelo;

public interface Objeto {
	public String obtenNombre();

	public Plano2D obtenPosicion();

	public int obtenEstado();

	public int obtenTipo();

	public int obtenCodigo();

	public String obtenDescripcion();

	public char obtenCaracter();

	public void setNombre(String nombre);

	public void setPos(int x, int y);

	public void setTipo(int tipo);

	public void setDescripcion(String descripcion);

	public void setEstado(int est);

	public void setCaracter(char c);

	public void setCodigo(int cod);
}
