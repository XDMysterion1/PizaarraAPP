
package pizarraapp;

import java.awt.Dimension;
import javax.swing.JFrame;

public class PizarraApp {

    public static void main(String[] args) {
        	DibujarMarco marco = new DibujarMarco();
		marco.setTitle("Pizarra");
                marco.setSize(new Dimension(1300,720));
                marco.setExtendedState(JFrame.NORMAL);
		marco.setVisible(true);
    }
    
}
