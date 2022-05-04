package fr.eseo.cpoo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements javax.swing.event.MouseInputListener {

	// ATTRIBUTS ====================================================
	private PanneauDessin panneauDessin;
	private Coordonnees debut;
	private Coordonnees fin;
	
	
	// GETTERS / SETTERS ====================================================
	public Coordonnees getDebut() {
		return this.debut;
	}
	
	public Coordonnees getFin() {
		return this.fin;
	}
	
	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}
	
	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}
	
	public PanneauDessin getPanneauDessin() {
		return this.panneauDessin;
	}
	
	public void setPanneauDessin(PanneauDessin pd) {
		this.panneauDessin = pd;
	}
	
	// METHODES ====================================================
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setDebut(new Coordonnees(e.getX(), e.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
