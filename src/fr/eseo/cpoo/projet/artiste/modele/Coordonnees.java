package fr.eseo.cpoo.projet.artiste.modele;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Coordonnees {
	
	public static final double ABSCISSE_PAR_DEFAUT = 0 ;
	public static final double ORDONNEE_PAR_DEFAUT = 0 ;

	
	double abscisse;
	double ordonnee;
	
	// CONSTRUCTEURS ===================================================================================================
	public Coordonnees() {
		this.deplacerVers(this.ABSCISSE_PAR_DEFAUT, this.ORDONNEE_PAR_DEFAUT);
	}
	
	public Coordonnees(double abcisse, double ordonnee) {
		this.deplacerVers(abcisse, ordonnee);
	}
	
	// GETTERS and SETTERS ===============================================================================================
	public double getAbscisse() {
		return this.abscisse;
	}
	
	public double getOrdonnee() {
		return this.ordonnee;
	}
	
	public void setAbscisse(double abcisse) {
		this.abscisse = abcisse;
	}
	
	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	
	// AUTRES METHODES ===============================================================================================
	
	public void deplacerVers(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}
	
	public double distanceVers(Coordonnees autreCoordonnees) {
		
		double deltaAbcisse = this.getAbscisse() - autreCoordonnees.getAbscisse();
		double deltaOrdonnee = this.getOrdonnee() - autreCoordonnees.getOrdonnee();
		
		double distance = Math.sqrt( Math.pow(deltaAbcisse, 2) + Math.pow(deltaOrdonnee, 2));
		return distance;
	}
	
	public double angleVers(Coordonnees autreCoordonnees) {

		return Math.atan2(autreCoordonnees.getOrdonnee() - this.getOrdonnee(), autreCoordonnees.getAbscisse() - this.getAbscisse());
	}
	
	@Override
	public String toString() {
		
	      String pattern = "##0.0#";

	      Locale enlocale  = new Locale("en", "US");
	      Locale dalocale  = new Locale("da", "DK");
	      Locale defLocal = Locale.getDefault();

	      DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(defLocal);
	      decimalFormat.applyPattern(pattern);

	      String abs =  decimalFormat.format(this.getAbscisse());
	      String ord =  decimalFormat.format(this.getOrdonnee());
	   		
	      return  "(" + abs + " , " + ord + ")" ;  
	}
	
	@Override
	public boolean equals(Object obj){
		  
		// L'objet est null
		if(obj == null) return false;
  
		// L'objet est lui même
		if(obj instanceof Coordonnees && this == obj) return true;
  
		// L'objet à les meme coordonnees
		Coordonnees autreCoord = (Coordonnees)obj;
				
		if (this.getAbscisse() == autreCoord.getAbscisse() && this.getOrdonnee() == autreCoord.getOrdonnee()) {
			return true;
		}
		else {
			return false;
		}
	}

}
