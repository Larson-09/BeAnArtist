package fr.eseo.cpoo.projet.artiste.modele.formes;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {

    // CONSTRUCTEURS =======================================================================================

	public Cercle(){
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		this(new Coordonnees(), taille);
	}
	
	public Cercle(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
    // SETTERS =======================================================================================

	@Override
	public void setLargeur(double taille) {
		
		if (taille < 0) {
			throw new IllegalArgumentException("setLargeur : la valeur passée en paramètre ne peut pas être négative");
		}
		
		super.setHauteur(taille);
		super.setLargeur(taille);
	}

	@Override
	public void setHauteur(double taille) {
		
		if (taille < 0) {
			throw new IllegalArgumentException("setLargeur : la valeur passée en paramètre ne peut pas être négative");
		}
		
		this.setLargeur(taille);
	}
	
	// METHODES SURCHARGEES ==============================================================================

	@Override
	public double aire() {
		double aire = Math.PI * Math.pow(this.getLargeur() / 2, 2);
		return this.arrondir(aire, 2);
	}
	
	@Override
	public double perimetre() {
		double perimetre = 2 * Math.PI * this.getLargeur() /2;
		return this.arrondir(perimetre, 2);
	}
	
	// METHODES OJBET ==============================================================================
	
	public String toString() {
		
		return "[" + this.getClass().getSimpleName() +"]" +
        		" pos : " + this.getPosition().toString() + 
        		" rayon : " + this.getLargeur() / 2 +
                " périmètre : " + this.perimetre() + 
                " aire : " + this.aire();
	}
    
}
