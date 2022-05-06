package fr.eseo.cpoo.projet.artiste.modele.formes;

import java.text.Normalizer.Form;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Ellipse extends Forme{

	
	// CONSTRUCTEURS =================================================================================================
	
	public Ellipse (){
		this (new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Ellipse (double largeur , double hauteur){
		this (new Coordonnees() ,largeur, hauteur);
	}
	
	public Ellipse (Coordonnees position ){
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT );
	}
	
	public Ellipse (Coordonnees position , double largeur , double hauteur){
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
	}
	
	
    // GETTERS =======================================================================================
	
	@Override
	public void setLargeur(double largeur) throws IllegalArgumentException{
		
		if (largeur < 0) {
			throw new IllegalArgumentException("setLargeur : la valeur passée en paramètre ne peut pas être négative");
		}
		
		super.setLargeur(largeur);
	}

	@Override
	public void setHauteur(double hauteur) {
		
		if (hauteur < 0) {
			throw new IllegalArgumentException("setHauteur : la valeur passée en paramètre ne peut pas être négative");
		}
		
		super.setHauteur(hauteur);
	}

	
    // METHODES SURCHARGES =======================================================================================
	
	@Override
	public double perimetre() {
		
		// Determiner le petit et le grand rayon
		double a = Math.min(this.getHauteur(), this.getLargeur()) / 2;
		double b = Math.max(this.getHauteur(), this.getLargeur()) / 2;
		double h = Math.pow( (a - b) / (a + b), 2);
		
		double perimetre;
		
		perimetre = Math.PI * (a + b) * ( 1 + (3*h) / (10 + Math.sqrt(4 - 3*h)) );
		
		return this.arrondir(perimetre, 2);
	}
	
	@Override
	public double aire() {
		double aire = Math.PI * (this.getHauteur() / 2) * (this.getLargeur() / 2);
		return this.arrondir(aire, 2);
	}
	
	@Override
	public boolean contient(Coordonnees c) {
		
		// Determiner le centre de l'ellipse
		double h = this.getPosition().getAbscisse() + this.getLargeur() / 2;
		double k = this.getPosition().getOrdonnee() + this.getHauteur() / 2;
		
		// Reucperer les coordonnes a verifier
		double x = c.getAbscisse();
		double y = c.getOrdonnee();
		
		// Determiner le petit et le grand rayon
		double majorR = Math.max(this.getHauteur(), this.getLargeur()) / 2;
		double minorR = Math.min(this.getHauteur(), this.getLargeur()) / 2;
		
		// Calcul
		double res = Math.pow(x - h, 2) / Math.pow(majorR, 2) + Math.pow(y - k, 2) / Math.pow(minorR, 2);
		return res <= 1;
	}
	
	// METHODES OJBET =======================================================================================
	
	@Override
	public String toString() {
		
        return "[" + this.getClass().getSimpleName() +"] " +
        		"pos : " + this.getPosition().toString() + 
        		" petit rayon : " +  Math.min(this.getHauteur(), this.getLargeur()) / 2 +
                " grand rayon : " + Math.max(this.getHauteur(), this.getLargeur()) / 2 + 
                " perimètre : " + this.perimetre() + 
                " aire : " + this.aire();
	}
    

}
