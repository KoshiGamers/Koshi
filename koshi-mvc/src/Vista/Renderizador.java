package Vista;

import Modelo.Mapa;
import Modelo.Personaje;

public class Renderizador {

	// Atributes
	private int A;
	private int B;

	// Methods
	public Renderizador() {
		this.A = 5;
		this.B = 5;
	}

	public Renderizador(Renderizador orig) {
		this.A = orig.A;
		this.B = orig.B;
	}

	public void imprimir() {

	}

	/* Hacer lo mismo que la anterior función pero pasando el mapa */
	public void DibujaP(Mapa mat, Personaje per1, Personaje per2) { // parametro
																	// ventana
		// Ventana v = new Ventana();
		int p1x = per1.getPos().getX();
		int p1y = per1.getPos().getY();
		int p2x = per2.getPos().getX();
		int p2y = per2.getPos().getY();
		int finFil = mat.filas;
		int finCol = mat.columnas;
		char p1 = 'A';
		char p2 = 'B';
		dibujaCabecera(per1, per2);
		dibujaSalud(per1);
		// int iniFil = p1x - this.B;
		// int iniCol = p1y - this.A;
		// int finFil = p1x + this.B;
		// int finCol = p1y + this.A;
		// if ((p1x - this.B) < 0) iniFil = 0;
		// if ((p1x + this.B) > limFil) finFil = limFil;
		// if ((p1y - this.A) < 0) iniCol = 0;
		// if ((p1y + this.A) > limCol) finCol = limCol;

		for (int i = 0; i < finFil; i++) {
			for (int j = 0; j < finCol; j++) {
				System.out.print(" ");
				if (i == p1y && j == p1x)
					System.out.print(p1);
				else if (i == p2y && j == p2x)
					System.out.print(p2);
				else
					System.out.print(mat.mapaValores[i][j].getTipo());
			}
			System.out.println("");
		}
		System.out.println("");

	}

	// public void Dibuja(Personaje heroe,int limFil,int limCol,Mapa map){
	// }

	// Setters & Getters
	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public void dibujaCabecera(Personaje per1, Personaje per2) {
		System.out.println("");
		// System.out.println("");
		for (int i = 0; i < 60; i++)
			System.out.print("-");
		System.out.println("");
		System.out.println("\tA es:" + per1.getNombre() + "\tMovimiento: W A S D");
		System.out.println("");
		System.out.println("\tB es:" + per2.getNombre() + "\tMovimiento: I J K L");
		for (int i = 0; i < 60; i++)
			System.out.print("-");
		// System.out.println("");System.out.println("");
	}

	public void dibujaSalud(Personaje per1) {
		System.out.println("");
		for (int i = 0; i < 32; i++)
			System.out.print("_");
		System.out.println("");
		System.out.print("\n" + "\tSALUD : " + per1.getVidaActual());
		System.out.print("\n");
		for (int i = 0; i < 32; i++)
			System.out.print("_");

	}

	public void dibujaComandoEspecial(String combinacion) {
		for (int i = 0; i < 60; i++)
			System.out.print("-");
		System.out.println(" ");
		System.out.println("\nEl comando especial es: " + combinacion);
		for (int i = 0; i < 60; i++)
			System.out.print("-");
		System.out.println("");
	}

	public void dibujaComandoEspecial(int nivel, int acc) {// tipo: duo=d,3
															// especial=e,1y2
		// System.out.println("");System.out.println("");
		for (int i = 0; i < 60; i++)
			System.out.print("-");
		System.out.println(" ");

		switch (nivel) {
		case 0:
			switch (acc) {
			// case 1:
			// case 2:
			case 3:
				System.out.println("\tEl comando especial es: iwuoqe");
				return;
			}
		case 1:
			switch (acc) {
			case 1:
				System.out.println("\tEl comando especial es: uokl");
				return;
			// case 2:
			case 3:
				System.out.println("\tEl comando especial es: kwqeuo");
				return;
			}
		case 2:
			switch (acc) {
			case 1:
				System.out.println("\tEl comando especial es: kliuoj");
				return;
			case 2:
				System.out.println("\tEl comando especial es: wqeww");
				return;
			// case 3:
			}
		}

		for (int i = 0; i < 60; i++)
			System.out.print("-");
		System.out.println("");
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------------------
	// NUEVOS METODOS GRAFICOS

	public void DibujaV(Mapa mat, Personaje per1, Personaje per2, Ventana v) { // parametro

		;
		;// ventana
		int p1x = per1.getPos().getX();
		int p1y = per1.getPos().getY();
		int p2x = per2.getPos().getX();
		int p2y = per2.getPos().getY();
		int finFil = mat.filas;
		int finCol = mat.columnas;
		char p1 = 'A';
		char p2 = 'B';

		// JLabel lblTest = new JLabel("TEST");
		// lblTest.setIcon(new ImageIcon("imagenes\\GIF-MONO-DERECHA.gif"));
		// lblTest.setBounds(p2x * 64, p2y * 64 + 64, 64, 64);
		//
		// JLabel lblTest2 = new JLabel("TEST2");
		// lblTest2.setIcon(new
		// ImageIcon("imagenes\\koshi-quieto-respirando.gif"));
		// lblTest2.setBounds(p1x * 64, p1y * 64 + 64, 64, 64);

		for (int i = 0; i < finFil; i++) {
			for (int j = 0; j < finCol; j++) {
				// System.out.print(" ");
				if (i == p1y && j == p1x) {

					v.getContentPane().getComponent(1).setBounds(p1x * 64, p1y * 64 + 64, 64, 64);
					// v.getContentPane().revalidate();
					v.getContentPane().repaint();
					// System.out.print(p1);
				} else if (i == p2y && j == p2x) {

					v.getContentPane().getComponent(2).setBounds(p2x * 64, p2y * 64 + 64, 64, 64);
					// v.getContentPane().revalidate();
					v.getContentPane().repaint();
				}

				// else System.out.print(mat.mapaValores[i][j].getTipo());
			}
			// System.out.println("");
		}
		// SwingUtilities.updateComponentTreeUI(v);

		// v.repaint();
		// v.repaint();
		// System.out.println("");

	}
}
