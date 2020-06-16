package pizarraapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class DibujarMarco extends JFrame {

    private JPanel panelContenido;
    private PizarraPanel tintaPanel;
    private JMenuBar barraMenu;
    private JToolBar barraHerramienta;
    private JToolBar cc1;
    private JScrollPane sp;

    private int AnchoPanelTinta;
    private int LargoPanelTinta;
    private final Color background = Color.GRAY;

    public DibujarMarco() {

        AnchoPanelTinta = 1300;
        LargoPanelTinta = 700;

        panelContenido = new JPanel();
        panelContenido.setLayout(null);

        barraHerramienta = (new BarraHerramienta(this)).getBarraHerramienta();

        cc1 = (new SelectorColor(this)).getBarraHerrramienta();

        tintaPanel = new PizarraPanel(0, this, AnchoPanelTinta, LargoPanelTinta);

        this.add(cc1, BorderLayout.AFTER_LAST_LINE);
        sp = new JScrollPane();
        sp.setLocation(10, 10);
        sp.setViewportView(tintaPanel);
        sp.setSize(AnchoPanelTinta, LargoPanelTinta);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panelContenido.add(sp);
        panelContenido.setBackground(background);

        this.addWindowListener(new WindowCloser());

        this.setJMenuBar(barraMenu);
        this.add(barraHerramienta, BorderLayout.EAST);
        this.add(panelContenido);

    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }

    public PizarraPanel getTintaPanel() {
        return this.tintaPanel;
    }

    public DibujarMarco getDibujarMarco() {
        return this;
    }

    public JScrollPane getSP() {
        return this.sp;
    }

}
