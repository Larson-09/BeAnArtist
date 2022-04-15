package fr.eseo.cpoo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.*;

import java.text.Normalizer.Form;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class EllipseTest {
	
	private Ellipse ellipse;

	@BeforeEach
	void setUp() throws Exception {
		this.ellipse = new Ellipse();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.ellipse = null;
	}
	
	// TESTS CONSTRUCTEURS =================================================================================
	
	@Test
	public void testConstructeurVide() {
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), "Test largeur par defaut");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), "Test hauteur par defaut");
	}
	
	@Test
	public void testConstructeurLargeurHauteur() {
		Ellipse e = new Ellipse(10.5, 15.5);
		
		assertEquals(10.5, e.getLargeur(), "Test getLargeur");
		assertEquals(15.5, e.getHauteur(), "Test getHauteur");
	}
	
	@Test
	public void testConstructeurPosition() {
		Ellipse e = new Ellipse(new Coordonnees(5.5, 8.5));
		
		assertEquals(new Coordonnees(5.5, 8.5), e.getPosition(), "Test getPosition");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), "Test getLargeur");
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), "Test getHauteur");
	}
	
	@Test
	public void testConstructeurPositionLargeurHauteur() {
		Ellipse e = new Ellipse(new Coordonnees(5.5, 8.5), 10.5, 15.5);
		
		assertEquals(new Coordonnees(5.5, 8.5), e.getPosition(), "Test getPosition");
		assertEquals(10.5, e.getLargeur(), "Test getLargeur");
		assertEquals(15.5, e.getHauteur(), "Test getHauteur");
	}
	
	// TEST SETTERS =================================================================================
	
	@Test
	public void testSetLargeurNegatifException() {
	    assertThrows(IllegalArgumentException.class, ()->{
	            ellipse.setHauteur(-1.5);
	    	});
	}
	
	@Test
	public void testSetHauteurNegatifException() {
	    assertThrows(IllegalArgumentException.class, ()->{
	            ellipse.setLargeur(-1.5);
	    	});
	}
	
	// TESTS METHODES =================================================================================
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/ellipse/DT_perimetre")
	public void testPerimetre(double largeur, double hauteur, double perimetreAttendu) {
		
		this.ellipse.setLargeur(largeur);
		this.ellipse.setHauteur(hauteur);
		assertEquals(perimetreAttendu, this.ellipse.perimetre());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/ellipse/DT_aire")
	public void testAire(double largeur, double hauteur, double aireAttendu) {
		
		this.ellipse.setLargeur(largeur);
		this.ellipse.setHauteur(hauteur);		
		assertEquals(aireAttendu, this.ellipse.aire());
	}
	
	@Test
	public void testToString() {
		Ellipse e = new Ellipse(new Coordonnees(10, 10), 25, 15);
		
		String posXY = e.adapterFormat(10.0);
		String petitRayon = e.adapterFormat(10.5 / 2);
		String grandRayon = e.adapterFormat(15.5 / 2);
		String perimetre = e.adapterFormat(63.82);
		String aire = e.adapterFormat(294.52);
		
		String chaineAttendu = "[Ellipse] pos : (10,0 , 10,0) petit rayon : 7.5 grand rayon : 12,5 périmètre : 63.82 aire : 294,52";
		assertEquals(chaineAttendu, e.toString());
	}
	
	
	

	
	

}
