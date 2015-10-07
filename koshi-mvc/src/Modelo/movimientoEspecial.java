package Modelo;

import java.util.ArrayList;

public class movimientoEspecial {
	private  int tipo;
	private  int index;
	private  String combinacion;
	private ArrayList<String> prioridad;
	private ArrayList<Plano2D> posiciones;
	
	public movimientoEspecial(int tipo, String combinacion){
		prioridad = new ArrayList<String>();
		posiciones = new ArrayList<Plano2D>();
		this.tipo=tipo;
		this.combinacion=combinacion;
		this.index=0;
	}

	public int getTipo() {
		return tipo;
	}

	public String getCombinacion() {
		return combinacion;
	}
	public String getPrioridad(int index){
		return prioridad.get(index);
	}
	public void   setPrioridad(String priori){
		this.prioridad.add(priori);
	}
	public Plano2D getPosicion(int index){
		return posiciones.get(index);
	}
	public void setPosicion(int x, int y){
		Plano2D plano = new Plano2D(x,y);
		this.posiciones.add(plano);
	}
	public boolean verificarCombinacion(String combinacion){
		String aux = this.combinacion.toLowerCase();
		if(aux.equals(combinacion))return true;
		else return false;
	}
	public String toString(){
		String mensaje = tipo + " " + combinacion + " " + prioridad.toString();
		String messaje="";
		for(int i=0;i<this.posiciones.size();i++){
			messaje = messaje+" "+posiciones.get(i).toString();
		}
		mensaje= mensaje + " "+messaje;
		return mensaje;
	}
	public int longitud(){
		return prioridad.size();
	}
	public int getIndex(){
		return index;
	}
	public void setIndex(int index){
		this.index=index;
	}
}
