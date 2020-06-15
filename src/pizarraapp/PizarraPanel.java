/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizarraapp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author celier
 */
public class PizarraPanel extends JPanel implements MouseListener,MouseMotionListener{
    private final int HERRAMIENTA_LAPIZ      = 0;
    private final int HERRAMIENTA_LINEA      = 1;

    private final int LINEA           = 1;

    private BasicStroke carrera = new BasicStroke((float) 2);
    BufferedImage canvas;
    Graphics2D graphics2D;
    private int activarHerramienta     = 0;
    private DibujarMarco marco;
    
    
    private int agrupado;
		
    int x1, y1, x2, y2;
		
    private boolean arrastrado        = false;
    private Color colorActual;    
    private Color rellenoColor;       
    private boolean transparente; 
		
    private int anchoPanelTinta;   
    private int largoPanelTinta;
    
    public PizarraPanel(int f, DibujarMarco marco, int width, int height){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	anchoPanelTinta = dim.width - 150;
	largoPanelTinta = dim.height- 160;
        this.setSize(anchoPanelTinta - 3, largoPanelTinta - 3);
	this.setPreferredSize(new Dimension(anchoPanelTinta - 3,largoPanelTinta - 3));
        this.setLayout(null);
	setDoubleBuffered(true);
	setLocation(10, 10);
	this.setBackground(Color.red);
    }
    
    public void setHerramienta(int herramienta) {
	this.activarHerramienta= herramienta;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setAnchoPanelTinta(int width){
	this.anchoPanelTinta = width;
    }
    
    public void setlargoPanelTinta(int height){
	this.largoPanelTinta = height;
    }
    
}
