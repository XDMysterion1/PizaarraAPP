
package pizarraapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class BarraHerramienta {
    	private JToolBar 	  barraHerramientBar;
	private JButton 	  lapiz;
	private JButton		  linea;
	private JButton 	  rectangulo;
	private JButton 	  circulo;
	private JButton 	  texto;
	private JButton 	  borrador;
	private JButton 	  llenar;
	private JButton 	  deshacer;
	private JButton 	  rehacer;
	private JButton 	  limpiar;
	private Dimension         nuevaDimencion = new Dimension(700,500);
	private JButton 	  guardar;
	private JButton 	  abrir;
	private JButton 	  nuevoArchivo;
	private DibujarMarco      marco;  
        
        public BarraHerramienta(DibujarMarco marco) {
               	this.marco = marco;
		this.initializeToolBar();
		limpiar.addActionListener(this);
		rectangulo.addActionListener(this);
		linea.addActionListener(this);
		circulo.addActionListener(this);
		borrador.addActionListener(this);
		lapiz.addActionListener(this);
		deshacer.addActionListener(this);
		rehacer.addActionListener(this);
		texto.addActionListener(this);
		guardar.addActionListener(this);
		abrir.addActionListener(this);
		nuevoArchivo.addActionListener(this);

	}
        private void initializeToolBar() {
	
		barraHerramientBar = new JToolBar(JToolBar.VERTICAL);
		barraHerramientBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		barraHerramientBar.setFloatable(false);
		barraHerramientBar.setLayout(new GridLayout(18,0));

		guardar      = new JButton("Guardar",        new ImageIcon(this.getClass().getResource("")));
		abrir 	     = new JButton("Abrir",	     new ImageIcon(this.getClass().getResource("")));
		nuevoArchivo = new JButton("Nuevo",	     new ImageIcon(this.getClass().getResource("")));
		lapiz 	     = new JButton("Lapiz",	     new ImageIcon(this.getClass().getResource("")));
		linea 	     = new JButton("Linea",          new ImageIcon(this.getClass().getResource("")));
		rectangulo   = new JButton("Rectangulo",     new ImageIcon(this.getClass().getResource("")));
		circulo      = new JButton("Circulo",        new ImageIcon(this.getClass().getResource("")));
		texto 	     = new JButton("Etiqueta",	     new ImageIcon(this.getClass().getResource("")));
		borrador     = new JButton("Borrador",       new ImageIcon(this.getClass().getResource("")));
		deshacer     = new JButton("Deshacer",       new ImageIcon(this.getClass().getResource("")));
		rehacer      = new JButton("Rehacer",        new ImageIcon(this.getClass().getResource("")));
		limpiar      = new JButton("Limpiar",        new ImageIcon(this.getClass().getResource("")));
		
		barraHerramientBar.add(nuevoArchivo);
		barraHerramientBar.add(abrir);
		barraHerramientBar.add(guardar);
		barraHerramientBar.add(lapiz);
		barraHerramientBar.add(linea);
		barraHerramientBar.add(rectangulo);
		barraHerramientBar.add(circulo);
		barraHerramientBar.add(texto);
		barraHerramientBar.add(borrador);
		barraHerramientBar.add(limpiar);
		barraHerramientBar.add(deshacer);
		barraHerramientBar.add(rehacer);
	}
        public void actionPerformed(ActionEvent ae) {
		Object fuente = ae.getSource();

		if (fuente == limpiar) {
			marco.getTintaPanel().limpiar();
		} else if (fuente == lapiz) {
			marco.getTintaPanel().setHerramienta(0);
		} else if (fuente == linea) {
			marco.getTintaPanel().setHerramienta(1);
		} else if (fuente == rectangulo) {
			marco.getTintaPanel().setHerramienta(2);
		} else if (fuente == circulo){
			marco.getTintaPanel().setHerramienta(3);
		} else if (fuente == texto) {
			marco.getTintaPanel().setHerramienta(5);			
		} else if (fuente == borrador) {
			marco.getTintaPanel().setHerramienta(6);
		} else if (fuente == llenar) {
			marco.getTintaPanel().setHerramienta(7);
		} 

	}
	 public JToolBar getBarraHerramienta() {
		return this.barraHerramientBar;
	}
    
}
