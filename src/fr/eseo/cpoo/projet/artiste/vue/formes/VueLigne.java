package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.cpoo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {

	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		
		// Transformer la forme en ligne (polymorphisme)
        Ligne ligne = (Ligne) super.forme;
        
        int x1 = (int)Math.round(ligne.getC1().getAbscisse());
        int y1 = (int)Math.round(ligne.getC1().getOrdonnee());
        
        int x2 = (int)Math.round(ligne.getC2().getAbscisse());
        int y2 = (int)Math.round(ligne.getC2().getOrdonnee());
        g2d.drawLine(x1, y1, x2, y2); 

	}

}
