package fr.eseo.cpoo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Cercle;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		// Recuperer les coordonnees de debut et fin
		double debutX = this.getDebut().getAbscisse();
		double debutY = this.getDebut().getOrdonnee();
		
		double finX = this.getFin().getAbscisse();
		double finY = this.getFin().getOrdonnee();
		
		// Calculer la taille
		double taille = Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse());
		
		// DEterminer la position
		Coordonnees position;

		if(finX > debutX && finY > debutY) {
			position = this.getDebut();
		}
		else if(finX < debutX && finY > debutY){
			position = new Coordonnees(finX, debutY);
		}
		else if (finX < debutX && finY < debutY){
			position = this.getFin();
		}
		else if (finX > debutX && finY > debutX) {
			position = new Coordonnees(debutX, finY);
		}
		else {
			position = null;
		}
		
		Ellipse e = new Cercle(position, taille);
		return new VueEllipse(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Si on fait un double click
		if(e.getClickCount() == 2) {
				
			this.setDebut(new Coordonnees(e.getX(), e.getY()));
			this.setFin(new Coordonnees(e.getX() + Cercle.LARGEUR_PAR_DEFAUT , e.getY() + Cercle.LARGEUR_PAR_DEFAUT));
			
			// Creer et ajouter la vue forme
			VueForme vf = creerVueForme();
			this.getPanneauDessin().ajouterVueForme(vf);
			
			// Mettre à jour le panneau
			this.getPanneauDessin().repaint();
		}
	}
	
	

	
}
