package fr.eseo.cpoo.projet.artiste.vue.ihm;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class PanneauBarreEtat extends javax.swing.JPanel implements java.awt.event.MouseMotionListener {

	
	  private JLabel valeurX;
	  private JLabel valeurY;
	  private final PanneauDessin panneauDessin;
  
	  public PanneauBarreEtat(PanneauDessin panneauDessin) {
	     this.panneauDessin = panneauDessin;
	     this.panneauDessin.addMouseMotionListener(this);
	     this.setLayout(new FlowLayout());
	     
	     this.valeurX = new JLabel("x: 0");
	     this.valeurY = new JLabel("y: 0");
	     this.add(valeurX);
	     this.add(valeurY);
	  }
	  
	  @Override
	  public void mouseDragged(MouseEvent e) {
	    // TODO Auto-generated method stub
	    this.mouseMoved(e);
	  }

	  @Override
	  public void mouseMoved(MouseEvent e) {
	    Coordonnees coords = new Coordonnees(e.getX(),e.getY());
	    this.mettreAJourAffichage(coords);
	  }

	  private void mettreAJourAffichage(Coordonnees coords) {
	    this.valeurX.setText("x: "+String.valueOf(coords.getAbscisse()));
	    this.valeurY.setText("y: "+String.valueOf(coords.getOrdonnee()));
	  }
}