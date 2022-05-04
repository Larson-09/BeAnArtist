package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Cercle;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	// CONSTRUCTEUR DES TESTS ========================================================================
    public VueCercleTest() {
    	test();
    	test2();
    }
   
    
    private void test2() {
    	Random rand = new Random();
    	double abs = rand.nextDouble()*100;
    	double ord = rand.nextDouble()*100;
    	double larg = rand.nextDouble()*100;
    	Cercle c = new Cercle(new Coordonnees(abs,ord),larg);
    	VueCercle vc = new VueCercle(c);
    	System.out.println(vc.getForme().equals(c));
    }
    
    // TESTS ========================================================================
    private void test() {
    	
    	// Creer un panneau dessin
    	PanneauDessin pd = new PanneauDessin();
    	
    	// Ajouter des lignes au panneau
    	pd.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(50,50), 55)));
    	    	
    	// Creer une fenetre principale
        JFrame frameTestDefaut = new JFrame("Vue Cercle Test");
        
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
                new VueCercleTest();
            }
        });
    }
}
