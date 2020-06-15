/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizarraapp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author celier
 */
public class PizarraPanel extends JPanel implements MouseListener, MouseMotionListener {

    private final int HERRAMIENTA_LAPIZ = 0;
    private final int HERRAMIENTA_LINEA = 1;

    private final int LINEA = 1;

    private BasicStroke carrera = new BasicStroke((float) 2);
    BufferedImage canvas;
    Graphics2D graphics2D;
    private int activarHerramienta = 0;
    private DibujarMarco marco;

    private Stack<Forma> formas;   // Pila 
    private Stack<Forma> remoto;
    private Stack<Forma> avance;

    private int agrupado;

    int x1, y1, x2, y2;

    private boolean arrastrado = false;
    private Color colorActual;
    private Color rellenoColor;
    private boolean transparente;

    private int anchoPanelTinta;
    private int largoPanelTinta;

    public PanelPintura(int f, DibujarMarco marco, int width, int height) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        anchoPanelTinta = dim.width - 150;
        largoPanelTinta = dim.height - 160;
        this.setSize(anchoPanelTinta - 3, largoPanelTinta - 3);
        this.setPreferredSize(new Dimension(anchoPanelTinta - 3, largoPanelTinta - 3));
        this.setLayout(null);
        setDoubleBuffered(true);
        setLocation(10, 10);
        this.setBackground(Color.red);
        colorActual = Color.BLACK;
        this.rellenoColor = Color.white;
        setFocusable(true);
        requestFocus();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.marco = marco;
        this.formas = new Stack<Forma>();
        this.remoto = new Stack<Forma>();
        this.agrupado = 1;
        this.avance = new Stack<Forma>();
        this.transparente = true;
    }

    public void paintComponent(Graphics g) {
        if (canvas == null) {
            canvas = new BufferedImage(anchoPanelTinta, largoPanelTinta, BufferedImage.TYPE_INT_ARGB);
            graphics2D = canvas.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            limpiar();
        }
        g.drawImage(canvas, 0, 0, null);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Forma s : formas) {

            g2.setColor(s.getColor());
            g2.setStroke(s.getCarrera());

            if (s.getForma() == LINEA) {
                g2.drawLine(s.getx1(), s.gety1(), s.getx2(), s.gety2());
            }

        }
        if (avance.size() > 0) {
            Forma s = avance.pop();
            g2.setColor(s.getColor());
            g2.setStroke(s.getCarrera());
            if (s.getForma() == LINEA) {
                g2.drawLine(s.getx1(), s.gety1(), s.getx2(), s.gety2());

            }

        }

    }

    public void setHerramienta(int herramienta) {
        this.activarHerramienta = herramienta;
    }

    public void limpiar() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        formas.removeAllElements();
        remoto.removeAllElements();
        repaint();
        graphics2D.setColor(colorActual);
    }

    public void setColor(Color c) {
        colorActual = c;
        graphics2D.setColor(c);

    }

    public void setLlenarColor(Color c) {
        this.rellenoColor = c;
    }

    public void setThickness(float f) {
        carrera = new BasicStroke(f);
        graphics2D.setStroke(carrera);
    }

    public void setTransparente(Boolean b) {
        this.transparente = b;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        Color primario = colorActual;
        Color secundario = rellenoColor;
        if (SwingUtilities.isRightMouseButton(e)) {
            primario = secundario;
            secundario = colorActual;
        }
        x2 = e.getX();
        y2 = e.getY();
        arrastrado = true;
        if (activarHerramienta == HERRAMIENTA_LAPIZ) {
            formas.push(new Forma(x1, y1, x2, y2, primario, carrera, 1, agrupado));
            repaint();
            x1 = x2;
            y1 = y2;
        } else if (activarHerramienta == HERRAMIENTA_LINEA) {
            avance.push(new Forma(x1, y1, x2, y2, primario, carrera, 1, secundario, transparente));
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        agrupado++;
        Color primary = colorActual;
        Color secondary = rellenoColor;
        if (SwingUtilities.isRightMouseButton(e)) {
            primary = secondary;
            secondary = colorActual;
        }

        if (activarHerramienta == HERRAMIENTA_LINEA && arrastrado) {
            formas.push(new Forma(x1, y1, x2, y2, primary, carrera, 1, rellenoColor, transparente));
            repaint();
        }
        arrastrado = false;
        remoto.removeAllElements();
        repaint();
    }

    public void setAnchoPanelTinta(int width) {
        this.anchoPanelTinta = width;
    }

    public void setlargoPanelTinta(int height) {
        this.largoPanelTinta = height;
    }

    public void setTintaPanel(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = canvas.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.setSize(width - 3, height - 3);
        this.setPreferredSize(new Dimension(width - 3, height - 3));
        limpiar();

    }

}
