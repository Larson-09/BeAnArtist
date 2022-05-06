package fr.eseo.cpoo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;
import fr.eseo.cpoo.projet.artiste.modele.formes.Forme;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil {
	
	// ATTRIBUT =========================================================
	private Forme formeSelectionnee;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Verifier que l'utilisateur a bien clicke dans une forme
		Coordonnees mouseCoords = new Coordonnees(e.getX(), e.getY());
		Forme formeSelectionner;
		boolean estFormeTrouvee = false;
		
		for(VueForme vf : this.getPanneauDessin().getVueFormes()) {
			if(vf.getForme().contient(mouseCoords)) {
				this.formeSelectionnee = vf.getForme();
				estFormeTrouvee = true;
			}
		}
		
		// Afficher une boite de dialogue
		if(estFormeTrouvee) {
			JOptionPane.showMessageDialog(this.getPanneauDessin(), this.formeSelectionnee.toString(), ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
		}
		
		

		
		
	}
	

}
