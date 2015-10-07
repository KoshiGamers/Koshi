package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Modelo.Celda;
import Modelo.Mapa;
import Modelo.Monstruo;
import Modelo.Objeto;
import Modelo.Obstaculo;
import Modelo.movimientoEspecial;

public class GestorMapas {

	public GestorMapas() {

	}

	public Mapa crearMapa(int nivel) throws IOException {
		Mapa mapa = new Mapa(nivel);
		mapa.setMovimientos(leerMovimientos(nivel));
		mapa.setObjetos(leerObjetos(nivel));
		String fileName = "mapas/mapa" + nivel + ".txt";
		FileReader file = new FileReader(fileName);

		// BufferedReader buffer = new BufferedReader(file);
		char s[] = {};
		int valor = 0;
		for (int i = 0; i < mapa.filas; i++) {
			for (int j = 0; j < mapa.columnas; j++) {
				valor = file.read();
				char aux = (char) valor;
				Celda c = new Celda(aux);
				mapa.mapaValores[i][j] = c;
			}
			valor = file.read();
			valor = file.read();
		}
		if (nivel == 0) {
			mapa.actualizarMapa(20203840);
			mapa.actualizarMapa(20203841);
		} else if (nivel == 2) {
			mapa.actualizarMapa(30112564);
			mapa.actualizarMapa(30112565);
			mapa.actualizarMapa(30112566);
			mapa.actualizarMapa(30112567);
		}
		file.close();
		return mapa;
	}

	public ArrayList<movimientoEspecial> leerMovimientos(int nivel) throws NumberFormatException, IOException {
		String fileName = "movimientos/movimiento_especial" + nivel + ".txt";
		FileReader file = new FileReader(fileName);
		BufferedReader br = new BufferedReader(file);
		String line;
		movimientoEspecial movimiento = null;
		ArrayList<movimientoEspecial> movimientos = new ArrayList<movimientoEspecial>();
		while ((line = br.readLine()) != null) {
			if (line.equals("Movimiento")) {
				line = br.readLine();
				int number = Integer.parseInt(line);
				String combinacion = br.readLine();
				movimiento = new movimientoEspecial(number, combinacion);
				line = br.readLine();
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					String prioridad = st.nextToken();
					movimiento.setPrioridad(prioridad);
				}
				line = br.readLine();
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					String pos = st.nextToken();
					StringTokenizer st2 = new StringTokenizer(pos, " ");
					while (st2.hasMoreTokens()) {
						String texto = st2.nextToken();
						StringTokenizer st3 = new StringTokenizer(texto, ",");
						int x, y;
						x = Integer.parseInt(st3.nextToken());
						y = Integer.parseInt(st3.nextToken());
						movimiento.setPosicion(y, x);
					}
				}

			}
			movimientos.add(movimiento);
			System.out.println(movimiento.toString());
		}
		file.close();
		return movimientos;
	}

	public ArrayList<Objeto> leerObjetos(int nivel) throws NumberFormatException, IOException {
		String fileName = "objetos/objeto" + nivel + ".txt";
		FileReader file = new FileReader(fileName);
		BufferedReader br = new BufferedReader(file);
		String line, name, desc;
		int valor, posX, posY, tipo, cod;
		char c;
		ArrayList<Objeto> objetos = new ArrayList<Objeto>();
		while ((name = br.readLine()) != null) {
			line = br.readLine();
			cod = Integer.parseInt(line);
			valor = br.read();
			c = (char) valor;
			br.readLine();
			line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			posX = Integer.parseInt(st.nextToken());
			posY = Integer.parseInt(st.nextToken());
			tipo = Integer.parseInt(st.nextToken());
			desc = br.readLine();
			if (tipo == 2) {
				Objeto monster = new Monstruo();
				monster.setNombre(name);
				monster.setEstado(0);
				monster.setPos(posX, posY);
				monster.setTipo(tipo);
				monster.setDescripcion(desc);
				monster.setCodigo(cod);
				monster.setCaracter(c);
				objetos.add(monster);
			} else {
				Objeto obstacle = new Obstaculo();
				obstacle.setNombre(name);
				obstacle.setEstado(0);
				obstacle.setPos(posX, posY);
				obstacle.setTipo(tipo);
				obstacle.setDescripcion(desc);
				obstacle.setCodigo(cod);
				obstacle.setCaracter(c);
				objetos.add(obstacle);
			}
		}
		file.close();
		return objetos;
	}
}