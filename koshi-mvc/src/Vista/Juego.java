package Vista;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Controlador.GestorMapas;
import Controlador.InterpreteComandos;
import Modelo.Mapa;
import Modelo.Personaje;

public class Juego {

	private Mapa mapaActual;
	private static final int numNiveles = 3;
	// Ventana v = new Ventana();

	public void jugar() throws IOException {
		/* Variables: */
		int nuevoJuego = 1;
		Personaje personaje1 = new Personaje();
		Personaje personaje2 = new Personaje();

		while (nuevoJuego == 1) {
			int start;
			GestorMapas gestor = new GestorMapas();
			Renderizador ren = new Renderizador();
			ArrayList<Mapa> mapas = new ArrayList<Mapa>();
			for (int i = 0; i < numNiveles; i++) {
				mapas.add(new Mapa(gestor.crearMapa(i)));
			}
			// newGame=showStarScreen()
			nuevoJuego = MenuInicial();
			/*
			 * En esta función se mostrara una pequeña intro del juego en donde
			 * el jugador podrá saltarlo presionando enter, posteriormente
			 * aparecera 2 opciones una si desea un nuevo juego y otra si desea
			 * salir
			 */

			if (nuevoJuego == 3) {// QUIT
				// showEndScreenLoser();
				MostrarPantallaRendicion();
				/* mostrara la pantalla de rendición */
				continue;
			} else if (nuevoJuego == 2) {// cargar juego guardado

				// cargarJuego(personaje1,personaje2);
				// CARGAR PERSONAJE 1
				FileReader file2;
				try {
					file2 = new FileReader("guardado/personaje1.txt");
					XStream xstream = new XStream(new DomDriver());
					personaje1 = (Personaje) xstream.fromXML(file2);
					try {
						file2.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// CARGAR PERSONAJE 2
				FileReader file3;
				try {
					file3 = new FileReader("guardado/personaje2.txt");
					XStream xstream = new XStream(new DomDriver());
					personaje2 = (Personaje) xstream.fromXML(file3);
					try {
						file3.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// CARGAR MAPACTUAL
				FileReader file;
				try {
					file = new FileReader("guardado/mapa.txt");
					XStream xstream = new XStream(new DomDriver());
					mapaActual = (Mapa) xstream.fromXML(file);
					try {
						file.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				start = mapaActual.getNivel();
			} else {// nuevo juego
				String name1 = escogerNombre(1);
				String name2 = escogerNombre(2);
				personaje1 = new Personaje(name1, true, 10, 0);
				// personaje1.setPos(10,0);
				personaje2 = new Personaje(name2, false, 2, 0);
				// personaje2.setPos(2,0);
				start = 0;
				mapaActual = new Mapa(mapas.get(start));
			}

			// showHistoryScreen1();

			Ventana v = new Ventana();

			InterpreteComandos IC = new InterpreteComandos();
			while (start != mapas.size()) {
				int d = 0;
				// MostrarPantallaHistoria(start);
				ren.DibujaV(mapaActual, personaje1, personaje2, v);

				// ACA LEER EL SIGUIENTE MOVIMIENTO
				System.out.print("Ingrese el siguiente movimiento + Tecla Intro: ");
				BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				d = buffer.read();
				char c = (char) d;

				int suceso = IC.Movimiento(personaje1, personaje2, this.mapaActual, c, v); // devuelve
																							// 1
																							// si
																							// se
																							// movio,
																							// 0
																							// si
																							// no
				// el valor de retorno de la fx de Mov es suceso(1 valido) y 2
				// murio.

				if (suceso == 1) {
					int accionEspecial = IC.ValidarAccionEspecial(personaje1, personaje2, this.mapaActual);
					if (accionEspecial != 0) {
						ren.dibujaComandoEspecial(
								this.mapaActual.obtenerMovimiento(this.mapaActual.getAccion()).getCombinacion());
						System.out.println("Ingrese la secuencia solicitada: ");
						BufferedReader buffer2 = new BufferedReader(new InputStreamReader(System.in));
						String s2 = buffer2.readLine();
						IC.realizaAccionEspecial(personaje1, personaje2, this.mapaActual, accionEspecial, s2, v);
					}
					continue; // solo movimiento
				} else if (suceso == 2) { // no se paso el nivel(murio)
					// mostrarPantallaGameOver
					MostrarGameOver();
					break;
				} else if (suceso == 3) {// se avanzó al siguiente nivel
					start++;
					if (start >= mapas.size())
						continue;
					mapaActual = new Mapa(mapas.get(start));
					// actualizarPosicionPersonajes
					personaje1.setPos(10, 0);
					personaje2.setPos(2, 0);

					GuardarNivel(personaje1, personaje2);

				}
			}
			if (start >= mapas.size()) {
				nuevoJuego = 4; // se gano el juego
				// mostrarPantallaVictoria
				MostrarPantallaVictoria();
			}
		}
		// Mostrar PantallaSalir
		MostrarPantallaSalir();
	}

	public boolean escogerMultijugador() {
		System.out.println("Un Jugador (O)");
		System.out.println("MultiJugador(M)");
		int c = 0;
		try {
			c = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (c != 0) {
			char d = (char) c;
			if (d == 'o' || d == 'O')
				return true;
			else
				return false;
		}
		return false;
	}

	public static boolean escogerJugador() {
		System.out.println("Escoger a koshi (K)");
		System.out.println("Escoger a mono  (M)");
		int c = 0;
		try {
			c = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (c != 0) {
			char d = (char) c;
			if (d == 'k' || d == 'K')
				return true;
			else
				return false;
		}
		return false;
	}

	public static String escogerNombre(int i) throws IOException {
		if (i == 1)
			System.out.println("Escoja el nombre de su 1er personaje");
		if (i == 2)
			System.out.println("Escoja el nombre de su 2do personaje");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		String s = buffer.readLine();
		return s;

	}

	public void MostrarPantallaHistoria(int nivel) throws IOException {
		String fileName = "historias/historia" + nivel + ".txt";
		FileReader file = new FileReader(fileName);

		int valor = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 67; j++) {
				valor = file.read();
				char aux = (char) valor;
				System.out.print(aux);
			}
		}
		System.out.println("");
		file.close();
	}

	public int MenuInicial() throws IOException {
		// String fileName = "historias/inicial.txt";
		// FileReader file = new FileReader(fileName);
		//
		// int valor = 0;
		// for (int i = 0; i < 30; i++) {
		// for (int j = 0; j < 67; j++) {
		// valor = file.read();
		// char aux = (char) valor;
		// System.out.print(aux);
		// }
		// }
		// System.out.println("");
		// file.close();
		int d = 0;
		// System.out.print("Ingrese el siguiente movimiento + Tecla Intro: ");
		Menu m = new Menu();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Para cargar juego presione L");
		System.out.println("Para crear juego nuevo presione N");
		System.out.println("Para Salir juego presione cualquier tecla");

		d = buffer.read();
		m.dispose();
		if ((char) d == 'n' || (char) d == 'N')
			return 1;
		else if ((char) d == 'L' || (char) d == 'l')
			return 2;
		else
			return 3;
	}

	public void MostrarPantallaRendicion() throws IOException {
		String fileName = "historias/rendicion.txt";
		FileReader file = new FileReader(fileName);

		int valor = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 64; j++) {
				valor = file.read();
				char aux = (char) valor;
				System.out.print(aux);
			}
		}
		System.out.println("");
		file.close();
	}

	public void MostrarGameOver() throws IOException {
		String fileName = "historias/gameover.txt";
		FileReader file = new FileReader(fileName);

		int valor = 0;
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 37; j++) {
				valor = file.read();
				char aux = (char) valor;
				System.out.print(aux);
			}
		}
		System.out.println("");
		file.close();
	}

	public void MostrarPantallaVictoria() throws IOException {
		String fileName = "historias/victoria.txt";
		FileReader file = new FileReader(fileName);

		int valor = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 50; j++) {
				valor = file.read();
				char aux = (char) valor;
				System.out.print(aux);
			}
		}
		System.out.println("");
		file.close();
	}

	public void MostrarPantallaSalir() throws IOException {
		String fileName = "historias/salir.txt";
		FileReader file = new FileReader(fileName);

		int valor = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 68; j++) {
				valor = file.read();
				char aux = (char) valor;
				System.out.print(aux);
			}
		}
		System.out.println("");
		file.close();
	}

	public void GuardarNivel(Personaje p1, Personaje p2) throws IOException {
		System.out.println("Desea guardar el juego Y | N?");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		int d = buffer.read();
		if ((char) d == 'y' || (char) d == 'Y') {
			FileWriter fw;
			try {
				XStream xs = new XStream();
				// 1. Escribir el archivoFileWriter
				fw = new FileWriter("guardado/personaje1.txt");
				fw.write(xs.toXML(p1));
				fw.close();
				fw = new FileWriter("guardado/personaje2.txt");
				fw.write(xs.toXML(p2));
				fw.close();
				fw = new FileWriter("guardado/mapa.txt");
				fw.write(xs.toXML(this.mapaActual));
				fw.close();
				System.out.println("Juego guardado");
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}

	public boolean cargarJuego(Personaje p1, Personaje p2) {

		return false;
	}

}