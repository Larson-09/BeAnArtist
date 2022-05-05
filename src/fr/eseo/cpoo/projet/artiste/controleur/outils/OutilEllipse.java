package fr.eseo.cpoo.projet.artiste.controleur.outils;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		
		// Recuperer les coordonnees de debut et fin
		double debutX = this.getDebut().getAbscisse();
		double debutY = this.getDebut().getOrdonnee();
		
		double finX = this.getFin().getAbscisse();
		double finY = this.getFin().getOrdonnee();
		
		// Determiner la largeur et la hauteur
		double largeur = Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse());
		double hauteur = Math.abs(this.getFin().getOrdonnee() - this.getDebut().getOrdonnee());
		
		// DEterminer la position
		Coordonnees position;
		

		if(finX >= debutX && finY >= debutY) {
			position = this.getDebut();
		}
		else if(finX <= debutX && finY >= debutY){
			position = new Coordonnees(finX, debutY);
		}
		else if (finX <= debutX && finY <= debutY){
			position = this.getFin();
		}
		else if (finX >= debutX && finY >= debutX) {
			position = new Coordonnees(debutX, finY);
		}
		else {
			position = new Coordonnees();
		}
		
		Ellipse e = new Ellipse(position, largeur, hauteur);
		return new VueEllipse(e);
	}

}
