package Controlador;

import java.io.IOException;

import Modelo.Mapa;
import Modelo.Personaje;
import Modelo.Plano2D;
import Modelo.movimientoEspecial;
import Vista.Renderizador;
import Vista.Ventana;

public class InterpreteComandos {
	// Juego juego = new Juego();

	public int Movimiento(Personaje p1, Personaje p2, Mapa mapaActual, char c, Ventana v) throws IOException {

		int retorno = 0;
		Renderizador ren = new Renderizador();

		if (p1.getVidaActual() <= 0)
			return 2;
		if (p1.getX() == 15 && p2.getX() == 15)
			return 3;

		Plano2D plano1 = new Plano2D(p1.getPos()); // System.out.println(plano1.getX()+"
													// "+plano1.getY());
		Plano2D plano2 = new Plano2D(p2.getPos());// System.out.println(plano2.getX()+"
													// "+plano2.getY());

		Plano2D plano1Aux = new Plano2D(plano1); // la pos donde se podria mover
		Plano2D plano2Aux = new Plano2D(plano2);

		int eleccion = InterpretarComando(plano1Aux, plano2Aux, c); // planos
																	// auxiliares
																	// modificados
																	// devuelve
																	// q pasara
		// Valido si es una posicion valida : primero Limites
		if (plano1Aux.getX() < 0 || plano1Aux.getX() >= mapaActual.columnas || plano1Aux.getY() < 0
				|| plano1Aux.getY() >= mapaActual.filas || plano2Aux.getX() < 0
				|| plano2Aux.getX() >= mapaActual.columnas || plano2Aux.getY() < 0
				|| plano2Aux.getY() >= mapaActual.filas)
			return retorno;

		if (eleccion == 1
				&& p1.getEstado() != 1) /* solo movimiento de personaje1 */ {
			// char
			// carac=mapaActual.mapaValores[plano1Aux.getY()][plano1Aux.getX()].getTipo();
			int tipo = mapaActual.mapaValores[plano1Aux.getY()][plano1Aux.getX()].tipoCelda();

			switch (tipo) {
			case 1:
				retorno = 1; // por tanto se actualiza su posicion
				p1.setPos(plano1Aux.getY(), plano1Aux.getX());
				break;
			case 2:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 3:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 4:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 5:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 6:
				// enemigo, Hacer algo extra
				// ..............................................
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 7:
				retorno = 1; // por tanto se actualiza su posicion Y ACTIVA ALGO
								// ...............................
				p1.setPos(plano1Aux.getY(), plano1Aux.getX());
				p1.setEstado(1);
				if (mapaActual.getNivel() == 1) {
					mapaActual.actualizarMapa(20110216);
					mapaActual.actualizarMapa(20110006);
					mapaActual.actualizarMapa(20112080);
					mapaActual.actualizarMapa(20110450);
				} else if (mapaActual.getNivel() == 2) {
					mapaActual.actualizarMapa(20111055);
					mapaActual.actualizarMapa(20111099);
					mapaActual.actualizarMapa(20112555);
					mapaActual.actualizarMapa(20111371);
				}
				break;
			case 8:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 9:
				retorno = 1;
				p1.setPos(plano1Aux.getY(), plano1Aux.getX());
				break;
			case 10:
				retorno = 1;
				break;
			case 11:
				retorno = 1;
				p1.setPos(plano1Aux.getY(), plano1Aux.getX());
				break;
			}
		}
		if (eleccion == 2
				&& p2.getEstado() != 1) /* solo movimiento de personaje2 */ {

			int tipo = mapaActual.mapaValores[plano2Aux.getY()][plano2Aux.getX()].tipoCelda();
			switch (tipo) {
			case 1:
				retorno = 1; // por tanto se actualiza su posicion
				break;
			case 2:
				retorno = 1; // por tanto se actualiza su posicion
				p2.setPos(plano2Aux.getY(), plano2Aux.getX());
				break;
			case 3:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 4:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 5:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 6:
				// enemigo, Hacer algo extra
				// ..............................................
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 7:
				retorno = 1; // por tanto se actualiza su posicion Y ACTIVA ALGO
								// ...............................
				p2.setPos(plano2Aux.getY(), plano2Aux.getX());
				p2.setEstado(1);
				if (mapaActual.getNivel() == 2) {
					mapaActual.actualizarMapa(20105726);
					mapaActual.actualizarMapa(20111493);
					mapaActual.actualizarMapa(20110871);
					mapaActual.actualizarMapa(20097029);
				}
				break;
			case 8:
				retorno = 1; // por tanto no se actualiza su posicion
				break;
			case 9:
				retorno = 1;
				p2.setPos(plano2Aux.getY(), plano2Aux.getX());
				break;
			case 10:
				retorno = 1;
				break;
			case 11:
				retorno = 1;
				p2.setPos(plano2Aux.getY(), plano2Aux.getX());
				break;
			}
		}
		ren.DibujaV(mapaActual, p1, p2, v);

		return retorno; // retorno significa que sucedió al mover el personaje
	}

	public int InterpretarComando(Plano2D plano1Aux, Plano2D plano2Aux, char c) throws IOException {

		// En cada comando revisar si es valido el movimiento, revisando si el
		// mapa lo permite
		// O si los limites lo permiten
		int condicion = 0;

		switch (c) { // en este caso X e Y son los ejes y no fila y columna?
		case 'w': // arriba
			plano1Aux.setY(plano1Aux.getY() - 1);
			condicion = 1; // solo movimiento personaje1
			break;
		case 'a': // izquierda
			plano1Aux.setX(plano1Aux.getX() - 1);
			condicion = 1;// solo movimiento
			break;
		case 's':// abajo
			plano1Aux.setY(plano1Aux.getY() + 1);
			condicion = 1;// solo movimiento
			break;
		case 'd': // derecha
			plano1Aux.setX(plano1Aux.getX() + 1);
			condicion = 1;// solo movimiento
			break;
		case 'i':// arriba
			plano2Aux.setY(plano2Aux.getY() - 1);
			condicion = 2;// solo movimiento personaje2
			break;
		case 'j': // abajo
			plano2Aux.setX(plano2Aux.getX() - 1);
			condicion = 2;// solo movimiento
			break;
		case 'k': // izquierda
			plano2Aux.setY(plano2Aux.getY() + 1);
			condicion = 2;
			break;
		case 'l': // derecha
			plano2Aux.setX(plano2Aux.getX() + 1);
			condicion = 2;// solo movimiento
			break;
		case 'e':
			// accionEspecial();
			break;
		case 'o':
			// accionEspecial();
			break;
		}
		return condicion;
	}

	public void realizaAccionEspecial(Personaje p1, Personaje p2, Mapa mapaActual, int accionEspecial, String s,
			Ventana v) throws IOException {
		// ACA acciones especiales
		Renderizador ren = new Renderizador();
		int index = mapaActual.getAccion();
		movimientoEspecial movimiento = mapaActual.obtenerMovimiento(index);
		if (movimiento != null) {
			boolean condicion = accionEsp(p1, p2, movimiento.getCombinacion().toLowerCase(), s);
			if (condicion) {
				for (int i = 0; i < movimiento.longitud(); i++) {
					if (mapaActual.getNivel() == 1 && movimiento.getTipo() == 1 && i == 2 && index == 0) {
						p1.setPos(9, 6);
						p1.setEstado(0);
						eliminarEnemigos(mapaActual.getNivel(), index, mapaActual);
					} else if (mapaActual.getNivel() == 2 && movimiento.getTipo() == 1 && index == 0 && i == 3) {
						p1.setPos(7, 5);
						p1.setEstado(0);
						eliminarEnemigos(mapaActual.getNivel(), index, mapaActual);
						System.in.read();
						System.in.read();

					} else if (mapaActual.getNivel() == 2 && movimiento.getTipo() == 1 && index == 1 && i == 2) {
						p2.setPos(4, 13);
						p2.setEstado(0);
						eliminarEnemigos(mapaActual.getNivel(), index, mapaActual);
						ren.DibujaV(mapaActual, p1, p2, v);
						System.in.read();
						System.in.read();
					}

					realizarMovimiento(mapaActual.getNivel(), p1, p2, movimiento, i);
					ren.DibujaV(mapaActual, p1, p2, v);
					System.in.read();
					System.in.read();
				}

				mapaActual.setAccion(index + 1);
			}
		}

	}

	private void eliminarEnemigos(int nivel, int index, Mapa mapaActual) {
		if (nivel == 1 && index == 0) {
			mapaActual.actualizarMapa(20110216);
			mapaActual.actualizarMapa(20110006);
			mapaActual.actualizarMapa(20112080);
			mapaActual.actualizarMapa(20110450);
		} else if (nivel == 2 && index == 0) {
			mapaActual.actualizarMapa(20111055);
			mapaActual.actualizarMapa(20111099);
			mapaActual.actualizarMapa(20112555);
			mapaActual.actualizarMapa(20111371);
		} else if (nivel == 2 && index == 1) {
			mapaActual.actualizarMapa(20105726);
			mapaActual.actualizarMapa(20111493);
			mapaActual.actualizarMapa(20110871);
			mapaActual.actualizarMapa(20097029);
		}
	}

	private boolean accionEsp(Personaje koshi, Personaje mono, String combinacion, String s) {
		if (s.toLowerCase().contentEquals(combinacion))
			return true;
		else {
			koshi.disminuirVida();
			mono.disminuirVida();
			return false;
		}
	}

	private void realizarMovimiento(int nivel, Personaje p1, Personaje p2, movimientoEspecial movimiento, int mov) {
		String prioridad = movimiento.getPrioridad(mov);
		if (prioridad.length() == 2) {
			Plano2D pos1 = movimiento.getPosicion(movimiento.getIndex());
			movimiento.setIndex(movimiento.getIndex() + 1);
			Plano2D pos2 = movimiento.getPosicion(movimiento.getIndex());
			movimiento.setIndex(movimiento.getIndex() + 1);
			int y1 = p1.getY() + pos1.getY(), x1 = p1.getX() + pos1.getX();
			int y2 = p2.getY() + pos2.getY(), x2 = p2.getX() + pos2.getX();
			p1.setPos(y1, x1);
			p2.setPos(y2, x2);
		} else {
			Plano2D pos = movimiento.getPosicion(movimiento.getIndex());
			movimiento.setIndex(movimiento.getIndex() + 1);
			char mueve = prioridad.charAt(0);
			if (mueve == 'k' || mueve == 'K') {
				int y = p1.getY() + pos.getY(), x = p1.getX() + pos.getX();
				p1.setPos(y, x);
			} else {
				int y = p2.getY() + pos.getY(), x = p2.getX() + pos.getX();
				p2.setPos(y, x);
			}
		}
	}

	public int ValidarAccionEspecial(Personaje p1, Personaje p2, Mapa mapaActual) {
		Plano2D posP1 = new Plano2D(p1.getPos());
		Plano2D posP2 = new Plano2D(p2.getPos());
		int tipo = mapaActual.mapaValores[posP1.getY()][posP1.getX()].tipoCelda();
		int tipo2 = mapaActual.mapaValores[posP2.getY()][posP2.getX()].tipoCelda();
		if (tipo == 11 && p2.getEstado() == 1)
			return 2;
		else if (tipo2 == 11 && p1.getEstado() == 1)
			return 1;
		else if (tipo == 9 && tipo2 == 9)
			return 3;
		else
			return 0;
	}

	public boolean accionEsp(Personaje koshi, Personaje mono, String str, int nivel, int acc) {
		// Nota: si hubiesen varias acciones especiales en un mismo nivel,
		// validarlos por posicion
		switch (nivel) {
		case 0:
			switch (acc) {
			// case 1:
			// case 2:
			case 3:
				if (str.contentEquals("IWUOQE") || str.contentEquals("iwuoqe"))
					return true;
			}
		case 1:
			switch (acc) {
			case 1:
				if (str.contentEquals("UOKL") || str.contentEquals("uokl"))
					return true;
				// case 2:
			case 3:
				if (str.contentEquals("KWQEUO") || str.contentEquals("kwqeuo"))
					return true;
			}
		case 2:
			switch (acc) {
			case 1:
				if (str.contentEquals("KLIUOJ") || str.contentEquals("kliuoj"))
					return true;
			case 2:
				if (str.contentEquals("WQEWW") || str.contentEquals("wqeww"))
					return true;
				// case 3:
			}
		}
		koshi.disminuirVida();
		mono.disminuirVida();
		return false;

	}

}
