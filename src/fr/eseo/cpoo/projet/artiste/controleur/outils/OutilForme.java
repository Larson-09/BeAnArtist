package fr.eseo.cpoo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Forme;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Si on fait un double click
		if(e.getClickCount() == 2) {
				
			this.setDebut(new Coordonnees(e.getX(), e.getY()));
			this.setFin(new Coordonnees(e.getX() + Forme.LARGEUR_PAR_DEFAUT , e.getY() + Forme.HAUTEUR_PAR_DEFAUT));
			
			// Creer et ajouter la vue forme
			VueForme vf = creerVueForme();
			this.getPanneauDessin().ajouterVueForme(vf);
			
			// Mettre à jour le panneau
			this.getPanneauDessin().repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		// Mettre à jour les coordonnes de fin
		this.setFin(new Coordonnees(e.getX(), e.getY()));
					
		// Verification
		if(!this.getDebut().equals(this.getFin())) {
			// Creer et ajouter la vue forme
			VueForme vf = creerVueForme();
			this.getPanneauDessin().ajouterVueForme(vf);
			
			// Mettre à jour le panneau
			this.getPanneauDessin().repaint();
		}
		
	}
	
	protected abstract VueForme creerVueForme();
}
