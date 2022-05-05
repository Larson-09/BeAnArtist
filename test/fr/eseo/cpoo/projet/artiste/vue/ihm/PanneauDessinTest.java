package fr.eseo.cpoo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauDessinTest {
	
	// CONSTRUCTEUR DES TESTS ========================================================================
    public PanneauDessinTest() {
        testConstructeurParDefaut();
        testConstructeur();
    }
   
    // TESTS ========================================================================
    private void testConstructeurParDefaut() {
    	
    	// Creer une fenetre principale
        JFrame frameTestDefaut = new JFrame("Etre un Artiste");
        
        // Ajouter un panneau dessin
        frameTestDefaut.add(new PanneauDessin());
        
        // Pack les modifications
        frameTestDefaut.pack();
        
        // Placer la fenetre principale au centre de l'ecran
        frameTestDefaut.setLocationRelativeTo(null);
        
        // Rendre la fenetre visible
        frameTestDefaut.setVisible(true);
    }
    
    private void testConstructeur() {
    	
    	// Creer une fenetre principale
        JFrame frameTest = new JFrame("Blues du Businessman");
        
        // Ajouter un panneau dessin
        frameTest.setContentPane(new PanneauDessin(500,500,java.awt.Color.blue));
        
        // Pack les modifications
        frameTest.pack();
        
        // Placer la fenetre principale au centre de l'ecran
        frameTest.setLocationRelativeTo(null);
        
        // Rendre la fenetre visible
        frameTest.setVisible(true);
    }
    
    // MAIN ========================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new PanneauDessinTest();
            }
        });
    }
}