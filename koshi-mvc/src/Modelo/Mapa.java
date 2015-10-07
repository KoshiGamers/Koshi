package Modelo;

import java.util.ArrayList;

public class Mapa {
	public static final int filas = 11;
	public static final int columnas = 16;
	private int nivel;
	private int accion;
	public Celda[][] mapaValores = new Celda[filas][columnas];
	private ArrayList<movimientoEspecial> movimientos;
	private ArrayList<Objeto> objetos = new ArrayList<Objeto>();

	public Mapa(int nivel) {
		this.nivel = nivel;
		this.setAccion(0);
	}

	public Mapa(Mapa mapa) {
		this.nivel = mapa.nivel;
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				this.mapaValores[i][j] = mapa.mapaValores[i][j];
			}
		}
		this.objetos = mapa.objetos;
		this.movimientos = mapa.movimientos;
		this.setAccion(mapa.getAccion());
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Celda[][] getMapa() {
		return mapaValores;
	}

	public void setMapa(Celda[][] mapa) {
		this.mapaValores = mapa;
	}

	public void imprimirMapa(Celda[][] mapa) {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(mapa[i][j]);
			}
			System.out.println();
		}
	}

	public boolean movValido(Personaje per, int x, int y) {
		if (x > 0 && (x < this.filas) && y > 0 && (y < this.columnas)) {
			if (this.mapaValores[x][y].getTipo() == 'S' || this.mapaValores[x][y].getTipo() == 'S')
				return true;
		}
		return true;
	}

	public void agregaObjeto(Objeto obj) {
		this.objetos.add(obj);
	}

	public Objeto obtenerObjeto(int index) {
		if (index < this.objetos.size()) {
			return objetos.get(index);
		} else
			return null;
	}

	public void setMovimientos(ArrayList<movimientoEspecial> movimientos) {
		this.movimientos = movimientos;
	}

	public int getAccion() {
		return accion;
	}

	public void setAccion(int accion) {
		this.accion = accion;
	}

	public movimientoEspecial obtenerMovimiento(int index) {
		if (index < this.movimientos.size()) {
			return movimientos.get(index);
		} else
			return null;
	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}

	public void agregaObjAMapa(Objeto obj) {
		if (obj.obtenEstado() == 1) {
			Plano2D pos = obj.obtenPosicion();
			int x = pos.getX();
			int y = pos.getY();

		}
	}

	public int buscaObjeto(int cod) {
		int i;
		for (i = 0; i < this.objetos.size(); i++) {
			if (cod == this.objetos.get(i).obtenCodigo())
				return i;
		}
		return -1;
	}

	public void actualizarMapa(int cod) {
		int index = this.buscaObjeto(cod);
		if (this.objetos.get(index).obtenEstado() == 0) {
			this.objetos.get(index).setEstado(1);
			char car = this.objetos.get(index).obtenCaracter();
			Plano2D pos = this.objetos.get(index).obtenPosicion();
			this.mapaValores[pos.getX()][pos.getY()].setTipo(car);
		} else {

			this.objetos.get(index).setEstado(0);
			char car = this.objetos.get(index).obtenCaracter();
			Plano2D pos = this.objetos.get(index).obtenPosicion();
			if (car == 'E' || car == 'J')
				this.mapaValores[pos.getX()][pos.getY()].setTipo('S');
			else
				this.mapaValores[pos.getX()][pos.getY()].setTipo('N');
		}
	}
}
