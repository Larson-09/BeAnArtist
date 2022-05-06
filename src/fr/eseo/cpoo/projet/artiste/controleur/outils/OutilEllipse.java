package fr.eseo.cpoo.projet.artiste.controleur.outils;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		
		Ellipse ellipse = new Ellipse(this.getDebut());
	    double hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
	    double largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();
	    Coordonnees newPosition = new Coordonnees();
	    
	    if (hauteur < 0 && largeur < 0) {
	      ellipse.setPosition(this.getFin());
	      hauteur = this.getDebut().getOrdonnee() - this.getFin().getOrdonnee();
	      largeur = this.getDebut().getAbscisse() - this.getFin().getAbscisse();
	    }else if (hauteur < 0) {
	      newPosition.setAbscisse(this.getFin().getAbscisse()-largeur);
	      newPosition.setOrdonnee(this.getFin().getOrdonnee());
	      ellipse.setPosition(newPosition);
	      hauteur = this.getDebut().getOrdonnee() - this.getFin().getOrdonnee();
	    }else if(largeur < 0) {
	      newPosition.setAbscisse(this.getFin().getAbscisse());
	      newPosition.setOrdonnee(this.getFin().getOrdonnee()-hauteur);
	      ellipse.setPosition(newPosition);
	      largeur = this.getDebut().getAbscisse() - this.getFin().getAbscisse();
	    }
	    ellipse.setHauteur(hauteur);
	    ellipse.setLargeur(largeur);
	    return new VueEllipse(ellipse);
		
	    /*
	     * Le probleme est qu'apres un certain nombre de drag and drop depuit en bas a gauche vers en haut a droite, l'ellipse se met à se display à la position par defaut
	     * 
	     * 
	     */
	    
//		// Recuperer les coordonnees de debut et fin
//		double debutX = this.getDebut().getAbscisse();
//		double debutY = this.getDebut().getOrdonnee();
//		
//		double finX = this.getFin().getAbscisse();
//		double finY = this.getFin().getOrdonnee();
//		
//		// Determiner la largeur et la hauteur
//		double largeur = Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse());
//		double hauteur = Math.abs(this.getFin().getOrdonnee() - this.getDebut().getOrdonnee());
//		
//		// DEterminer la position
//		Coordonnees position;
//		
//
//		if(finX >= debutX && finY >= debutY) {
//			position = this.getDebut();
//		}
//		else if(finX <= debutX && finY >= debutY){
//			position = new Coordonnees(finX, debutY);
//		}
//		else if (finX <= debutX && finY <= debutY){
//			position = this.getFin();
//		}
//		else if (finX >= debutX && finY >= debutX) {
//			position = new Coordonnees(debutX, finY);
//		}
//		else {
//			position = new Coordonnees();
//		}
//		
//		Ellipse e = new Ellipse(position, largeur, hauteur);
//		return new VueEllipse(e);
	}

}
