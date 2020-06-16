
package pizarraapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class BarraHerramienta implements ActionListener {
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

		guardar      = new JButton("Guardar");
		abrir 	     = new JButton("Abrir");
		nuevoArchivo = new JButton("Nuevo");
		lapiz 	     = new JButton("Lapiz");
		linea 	     = new JButton("Linea");
		rectangulo   = new JButton("Rectangulo");
		circulo      = new JButton("Circulo");
		texto 	     = new JButton("Etiqueta");
		borrador     = new JButton("Borrador");
		deshacer     = new JButton("Deshacer");
		rehacer      = new JButton("Rehacer");
		limpiar      = new JButton("Limpiar");
		
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
