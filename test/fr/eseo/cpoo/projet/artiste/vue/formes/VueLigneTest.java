package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ligne;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessinTest;

public class VueLigneTest {

	// CONSTRUCTEUR DES TESTS ========================================================================
    public VueLigneTest() {
    	test();
    }
   
    // TESTS ========================================================================
    private void test() {
    	
    	// Creer un panneau dessin
    	PanneauDessin pd = new PanneauDessin();
    	
    	// Ajouter des lignes au panneau
    	pd.ajouterVueForme(new VueLigne(new Ligne()));
    	pd.ajouterVueForme(new VueLigne(new Ligne(20, 30)));
    	pd.ajouterVueForme(new VueLigne(new Ligne(new Coordonnees(10,10), 30, 30)));
    	
    	// Creer une fenetre principale
        JFrame frameTestDefaut = new JFrame("Etre un Artiste");
        
        // Ajouter un panneau dessin
        frameTestDefaut.setContentPane(pd);
        
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
                new VueLigneTest();
            }
        });
    }
}
