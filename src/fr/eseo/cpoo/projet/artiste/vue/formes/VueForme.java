package fr.eseo.cpoo.projet.artiste.vue.formes;

import java.text.Normalizer.Form;

import fr.eseo.cpoo.projet.artiste.modele.formes.Forme;

public abstract class VueForme {
	
	// ATTRIBUTS ================================================
	protected final Forme forme;
	
	// CONSTRUCTOR ================================================
	public VueForme(Forme forme) {
		this.forme = forme;
	}
	
	// GETTERS ================================================
	public Forme getForme() {
		return this.forme;
	}
	
	// METHODES ================================================
	public abstract void affiche(java.awt.Graphics2D g2d);

}
