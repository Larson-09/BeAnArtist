package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Ellipse extends Forme{

	
	// CONSTRUCTEURS =================================================================================================
	
	public Ellipse (){
		this (new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Ellipse ( double largeur , double hauteur ){
		this (new Coordonnees() ,largeur, hauteur );
	}
	
	public Ellipse (Coordonnees position ){
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT );
	}
	
	public Ellipse (Coordonnees position , double largeur , double hauteur){
		super(position, largeur, hauteur);
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
		
		super.setLargeur(hauteur);
	}

	
    // METHODES SURCHARGES =======================================================================================
	
	@Override
	public double perimetre() {
		
		// Determiner le petit et le grand rayon
		double a = Math.min(this.getHauteur(), this.getLargeur());
		double b = Math.max(this.getHauteur(), this.getLargeur());
		double h = Math.pow( (a - b) / (a + b), 2);
		
		double perimetre;
		
		perimetre = Math.PI * (a + b);
		perimetre *= 1 + (3*h) / (10 + Math.sqrt(4 - 3*h));
		
		return perimetre;
	}
	
	@Override
	public double aire() {
		return Math.PI * (this.getHauteur() / 2) * (this.getLargeur() / 2);
	}
	
	// METHODES OJBET =======================================================================================
	
	@Override
	public String toString() {
		
        return "[" + this.getClass().getSimpleName() +"] " +
        		"pos : " + this.getPosition().toString() + 
        		" petit rayon : " + (Math.min(this.getLargeur(), this.getHauteur()) / 2) +
                " grand rayon : " + (Math.max(this.getLargeur(), this.getLargeur()) / 2) + 
                " périmètre : " + this.perimetre() + 
                " aire : " + this.aire();
	}
    
}
