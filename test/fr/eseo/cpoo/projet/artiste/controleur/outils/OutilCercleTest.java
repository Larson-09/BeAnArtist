package fr.eseo.cpoo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {

	// CONSTRUCTEUR DES TESTS ========================================================================
    public OutilCercleTest() {
        test();
    }
   
    // TESTS ========================================================================
    private void test() {
    	
    	// Creer une fenetre avec un panneau dessin
        JFrame frameTestDefaut = new JFrame("TEST : Outil Cercle");
        PanneauDessin pd = new PanneauDessin();
        frameTestDefaut.add(pd);
        
        // Creer un outil ligne et l'addocier au panneau dessin
        pd.associerOutil(new OutilCercle());
        
        // Pack les modifications
        frameTestDefaut.pack();
        
        // Placer la fenetre principale au centre de l'ecran
        frameTestDefaut.setLocationRelativeTo(null);
        
        // Rendre la fenetre visible
        frameTestDefaut.setVisible(true);
    }

    
    // MAIN ========================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new OutilCercleTest();
            }
        });
    }
}
