package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;;

public class ActionEffacer extends AbstractAction {
	
	// CONSTANTES DE CLASSE ==============================
	public static final String NOM_ACTION = "Effacer tout";
	
	// ATTRIBUT ==========================================
	private PanneauDessin panneauDessin;
	
	// CONSTRUCTEUR
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Demander confirmation a l'utilisateur
		JFrame frameConfirmer = new JFrame();
		
		int resp = JOptionPane.showConfirmDialog(
				frameConfirmer, 
				"Voulez vous vraiment effacer toutes les formes ?", 
				NOM_ACTION,
				JOptionPane.YES_NO_OPTION
				);	
		
		// Si confirmation, effacer les formes
		if (resp == 0) {
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();
		}
		
		
	}

}
