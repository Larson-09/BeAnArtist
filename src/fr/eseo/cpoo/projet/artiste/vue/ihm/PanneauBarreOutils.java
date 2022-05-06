package fr.eseo.cpoo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.cpoo.projet.artiste.controleur.actions.ActionSelectionner;

public class PanneauBarreOutils extends JPanel {
	
	// ATTRIBUTS ====================================
	private PanneauDessin panneauDessin;
	
	// CONSTRUCTEUR =================================
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		
		// Associer le panneau dessin
		this.panneauDessin = panneauDessin;
		
		// Associer un layout
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		
		// Initialiser les compsants de la barre outil
		this.initComponents();
	}

	private void initComponents() {
		
		// Ajouter un bouton Effacer
		JButton boutonEffacer = new JButton(new ActionEffacer(this.panneauDessin));
		boutonEffacer.setName(ActionEffacer.NOM_ACTION);
		this.add(ActionEffacer.NOM_ACTION, boutonEffacer);
		
		// Ajouter un bouton choisir forme
		ButtonGroup groupeBouton = new ButtonGroup();
		
		JToggleButton choisirLigne = new JToggleButton(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_LIGNE));
		choisirLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		groupeBouton.add(choisirLigne);
		this.add(choisirLigne);
		
		JToggleButton choisirEllipse = new JToggleButton(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		choisirEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		groupeBouton.add(choisirEllipse);
		this.add(choisirEllipse);
		
		JToggleButton choisirCercle = new JToggleButton(new ActionChoisirForme(this.panneauDessin, ActionChoisirForme.NOM_ACTION_CERCLE));
		choisirCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		groupeBouton.add(choisirCercle);
		this.add(choisirCercle);
		
		// Ajouter un bouton selectionner
		JToggleButton selectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
		selectionner.setName(ActionSelectionner.NOM_ACTION);
		groupeBouton.add(selectionner);
		this.add(selectionner);
		
	}
		
}
