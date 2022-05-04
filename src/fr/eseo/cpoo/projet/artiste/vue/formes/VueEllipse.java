package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.modele.formes.Forme;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ligne;

public class VueEllipse extends VueForme {

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
		
		// Transformer la forme en ellipse (polymorphisme)
        Ellipse ellipse = (Ellipse) this.getForme();
        
        int x = (int) ellipse.getPosition().getAbscisse();
        int y = (int) ellipse.getPosition().getOrdonnee();
        int largeur = (int) ellipse.getLargeur();
        int hauteur = (int) ellipse.getHauteur();
        
        g2d.drawOval(x, y, largeur, hauteur); 

	}

}
