package fr.eseo.cpoo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionEffacer;

public class PanneauBarreOutils extends JPanel {
	
	// ATTRIBUTS ====================================
	private PanneauDessin panneauDessin;
	
	// CONSTRUCTEUR =================================
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		
		this.initComponents();
	}

	private void initComponents() {
		
		// Ajouter un bouton Effacer
		JButton boutonEffacer = new JButton(new ActionEffacer(this.panneauDessin));
		boutonEffacer.setName(ActionEffacer.NOM_ACTION);
		this.add(boutonEffacer);
	}

}
