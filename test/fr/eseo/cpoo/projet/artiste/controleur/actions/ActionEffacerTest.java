package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessinTest;

public class ActionEffacerTest {

	// CONSTRUCTEUR DES TESTS ========================================================================
    public ActionEffacerTest() {
        test();
    }
   
    // TESTS ========================================================================
    private void test() {
    	
    	// Creer une fenetre, un panneau dessin et un panneau outil
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin pd = new PanneauDessin();
		PanneauBarreOutils po = new PanneauBarreOutils(pd);
		
		// Ajouter les panneaux a la fenetre
		frame.add(pd);
		frame.add(po,BorderLayout.EAST);
		
		pd.associerOutil(new OutilLigne());
		
		// Parametrer la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600,800));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
}
    
    // MAIN ========================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new ActionEffacerTest();
            }
        });
    }
}
