
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
    
}
