package Modelo;

public class Celda {
	char tipo;
	
	public Celda() {
		this.tipo = 0;		
	}
	
	public Celda(char tipo) {
		this.tipo = tipo;
	}
	
	public Celda(Celda celda) {
		this.tipo = celda.tipo;
	}
	
	public int tipoCelda() //para saber lo que hay en la celda
	{
		/*Se retorna un número segun lo que haya en esa celda
		/* si es 1 camino vacío para koshi,
		 * si es 2 camino vacío para mono
		 * si es 3 roca
		 * si es 4 roca gigante
		 * si es 5 Agua
		 * si es 6 ...
		 * si es 7 ...
		 * si es 8 ...
		 * si es 9 ...
		 */
		if(tipo=='S') return 1; //camino koshi
		if(tipo=='N') return 2; //camino mono
		if(tipo=='R') return 3; //rio
		if(tipo=='c') return 4; //piedra impasable
		if(tipo=='p') return 5; //roca gigante
		if(tipo=='E') return 6; //enemigo
		if(tipo=='T') return 7; //terreno trigger
		if(tipo=='Y') return 8; //objeto de apoyo
		if(tipo=='D') return 9; //Especial
		if(tipo=='J') return 10; //JABALI
		if(tipo=='C') return 11; //Accion individual
		return 0;
	}
	
	public char getTipo() { //para saber que caracter hay en la celda y poder imprimir el mapa
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
	

}
