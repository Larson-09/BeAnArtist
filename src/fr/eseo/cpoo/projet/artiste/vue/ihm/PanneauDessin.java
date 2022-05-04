package fr.eseo.cpoo.projet.artiste.vue.ihm;

import java.util.ArrayList;
import java.util.List;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import fr.eseo.cpoo.projet.artiste.controleur.outils.Outil;
import fr.eseo.cpoo.projet.artiste.vue.formes.VueForme;


public class PanneauDessin extends JPanel {
	
	// CONSTANTES ============================================================================
	public static final int LARGEUR_PAR_DEFAUT = 450;
	public static final int  HAUTEUR_PAR_DEFAUT = 450;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	
	// ATTRIBUTS ============================================================================
	private final List<VueForme> vueFormes;
	private Outil outilCourant;
	
	// CONSTRUCTEURS ============================================================================
	public PanneauDessin(int largeur, int hauteur, Color couleur) {

		this.vueFormes = new ArrayList<VueForme>();
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setBackground(couleur);
	}
	
	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}
	
	// GETTERS / SETTERS ============================================================================
	public List<VueForme> getVueFormes(){
		return this.vueFormes;
	}
	
	public void ajouterVueForme(VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}
	
	public Outil getOutilCourant() {
		return this.outilCourant;
	}
	
	private void setOutilCourant(Outil outil) {
		this.outilCourant = outil;
	}
	
	// METHODE ============================================================================
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		
		for(VueForme vueForme : this.getVueFormes()) {
			vueForme.affiche(g2D);
		}
		
		g2D.dispose();
	}
	
	public void associerOutil(Outil outil) {
		if(outil != null) {
            this.dissocierOutil();
            this.setOutilCourant(outil);
            outil.setPanneauDessin(this);
            this.addMouseListener(outil);
            this.addMouseMotionListener(outil);
		}
		
	}

	public void dissocierOutil() {
		if(this.outilCourant != null) {
            this.removeMouseListener(this.outilCourant);
            this.removeMouseMotionListener(this.outilCourant);
            this.getOutilCourant().setPanneauDessin(null);
            this.outilCourant = null;
		}
	}
	

}
