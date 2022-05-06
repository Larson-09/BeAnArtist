package fr.eseo.cpoo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilForme;
import fr.eseo.cpoo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.cpoo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction {
	
	// CONSTANTES ========================================================
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	
	// ATTRIBUT ==========================================================
	private PanneauDessin panneauDessin;
	private String choix;
	
	// CONSTRUCTEUR ======================================================
	public ActionChoisirForme(PanneauDessin panneauDessin, String choix) {
		super(choix);
		this.panneauDessin = panneauDessin;
		this.choix = choix;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		switch(e.getActionCommand()){
		
		case NOM_ACTION_LIGNE:
			this.panneauDessin.associerOutil(new OutilLigne());
			break;
			
		case NOM_ACTION_ELLIPSE:
			this.panneauDessin.associerOutil(new OutilEllipse());
			break;
			
		case NOM_ACTION_CERCLE:
			this.panneauDessin.associerOutil(new OutilCercle());
			break;
		default:
			break;
		}
		
	}

}
