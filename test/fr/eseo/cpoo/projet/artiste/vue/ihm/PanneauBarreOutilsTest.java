package fr.eseo.cpoo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauBarreOutilsTest {
	
	public PanneauBarreOutilsTest() {
		test();
	}
  
	private void test() {
		
		// Creer une fenetre, un panneau dessin et un panneau barre etat
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin pd = new PanneauDessin();
		PanneauBarreOutils pbo = new PanneauBarreOutils(pd);
		
		// Ajouter les panneaux a la fenetre
		frame.add(pd);
		frame.add(pbo,BorderLayout.EAST);
		
		// Parametrer la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600,800));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
  
  public static void main(String [] args) {
	    SwingUtilities.invokeLater(new Runnable(){
	    @Override
	    public void run() {
	       new PanneauBarreOutilsTest();
	    }
	   });
	  }

}
