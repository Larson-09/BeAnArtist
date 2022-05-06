package fr.eseo.cpoo.projet.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.cpoo.projet.artiste.modele.Coloriable;
import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public abstract class Forme  {
	
	// CONSTANTES ==============================================================================
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;

	// PARAMETRES ==============================================================================
	private double largeur ;
	private double hauteur ;
	private Coordonnees position ;
	
	// CONSTRUCTORS ==============================================================================
	public Forme (){
		this (new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme ( double largeur , double hauteur ){
		this (new Coordonnees() ,largeur, hauteur );
	}
	
	public Forme (Coordonnees position ){
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT );
	}
	
	public Forme (Coordonnees position , double largeur , double hauteur){
		this.setPosition (position);
		this.setLargeur (largeur);
		this.setHauteur (hauteur);
	}
	
	// GETTERS ==============================================================================
	public Coordonnees getPosition (){
		return this.position ;
	}
	
	public double getLargeur() {
		return this.largeur;
	}

	
	public double getHauteur() {
		return this.hauteur;
	}
	
	// SETTERS ==============================================================================
	public void setPosition ( Coordonnees position ){
		this . position = position ;
	}
	
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	// AUTRES METHODES ==============================================================================
	
	public double getCadreMinX() {
		return Math.min(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + largeur);
	}
	
	public double getCadreMinY() {
		return Math.min(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + hauteur);
	}
	
	public double getCadreMaxX() {
		return Math.max(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + largeur);
	}
	
	public double getCadreMaxY() {
		return Math.max(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + hauteur);
	}
	
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.setPosition(new Coordonnees(nouvelleAbscisse, nouvelleOrdonnee));
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.setPosition(new Coordonnees(this.getPosition().getAbscisse() + deltaX, 
										this.getPosition().getOrdonnee() + deltaY));
	}
	
	
	// METHODES ABSTRAITES ==============================================================================
	
	public abstract double aire ();
	public abstract double perimetre ();
	public abstract boolean contient(Coordonnees coordonnees);
	
	// METHODES PROTECTED ==============================================================================
	protected double arrondir(double valeur, int nbDecimales) {
		
		double a = Math.pow(10, nbDecimales);
		return Math.round(valeur * a) / a;
	}
	
	protected String adapterFormat(double valeur) {
	      String pattern = "###.0#";
	      Locale defLocal = Locale.getDefault();

	      DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(defLocal);
	      decimalFormat.applyPattern(pattern);

	      return decimalFormat.format(valeur);
	}
	
	// METHODES COLORIABLES ==============================================================================
	
	// METHODES OJBET =======================================================================================
	
	@Override
	public boolean equals(Object obj){
		  
		// L'objet est null
		if(obj == null) return false;
  
		// L'objet est lui même
		if(obj instanceof Forme && this == obj) return true;
  
		// L'objet à les meme coordonnees
		Forme autreForme = (Forme)obj;
				
		if (this.getPosition().equals(autreForme.getPosition()) && 
			this.getLargeur() == autreForme.getLargeur() && 
			this.getHauteur() == autreForme.getHauteur()) {
			
			return true;
		}
		else {
			return false;
		}
	}




	
	
	
	
	
	
	
	
	
	
	
	
	

}
