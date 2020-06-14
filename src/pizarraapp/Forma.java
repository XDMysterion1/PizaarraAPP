
package pizarraapp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class Forma {
    	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	private Color color;   		 
	private Color colorRelleno;
	private BasicStroke carrera; 
	private String mensaje;
	
	public boolean transparente;
	
	private int forma;
	private Font fuente;
	
	public int grupo = 0;
	
	
	public Forma(int x1, int y1,int x2, int y2, Color color,BasicStroke carrera, int forma,Color relleno,boolean transparente){
		this.x1		      = x1;
		this.x2 	      = x2;
		this.y1 	      = y1;
		this.y2 	      = y2;
		this.color        = color;
		this.carrera      = carrera;
		this.forma 	      = forma;
		this.grupo 	      = 0;
		this.colorRelleno = relleno;
		this.transparente = transparente;
	}
        public Forma(int x1, int y1, int longitudFuente, Font fuente, Color color, BasicStroke carrera, int forma, String mensaje){
		this.x1 	  = x1;
		this.y1 	  = y1;
		this.y2 	  = 0;
		this.fuente   = fuente;
		this.x2 	  = longitudFuente;
		this.color 	  = color;
		this.carrera  = carrera;
		this.forma 	  = forma;
		this.grupo    = 0;
		this.mensaje  = mensaje;
	}
	
	public Forma(int x1, int y1,int x2, int y2, Color color,BasicStroke carrera, int forma,int grupo){
		this.x1      = x1;
		this.x2      = x2;
		this.y1      = y1;
		this.y2      = y2;
		this.color   = color;
		this.carrera = carrera;
		this.forma   = forma;
		this.grupo   = grupo;
		
	}
        public int getForma(){
		return this.forma;
	}
	public String getMensaje() {
		return this.mensaje;
	}
	public Font getFuente() {
		return this.fuente;
	}
	public int getx1(){
		return this.x1;
	}
	public int getx2(){
		return this.x2;
	}
	public int gety1(){
		return this.y1;
	}
	public int gety2(){
		return this.y2;
	}
	public Color getColor(){
		return this.color;
	}
	public Color getColorRelleno(){
		return this.colorRelleno;
	}
	public BasicStroke getCarrera(){
		return this.carrera;
	}
	public boolean getTransparente(){
		return this.transparente;
	}
	
	public int getGrupo(){
		return this.grupo;
	}
    
}
