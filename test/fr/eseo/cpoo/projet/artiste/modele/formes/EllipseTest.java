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
	public void testConstructeurPositionLargeurHauteur() {
		Ellipse e = new Ellipse(new Coordonnees(5.5, 8.5), 10.5, 15.5);
		
		assertEquals(new Coordonnees(5.5, 8.5), e.getPosition(), "Test getPosition");
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
	
	// TEST METHODES =================================================================================
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/ellipse/DT_perimetre")
	public void testPerimetre(double positionX, double positionY, double largeur, double hauteur, double perimetreAttendu) {
		
		Ellipse e = new Ellipse(new Coordonnees(positionX, positionY), largeur, hauteur);
		assertEquals(perimetreAttendu, e.perimetre());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/ellipse/DT_aire")
	public void testAire(double positionX, double positionY, double largeur, double hauteur, double aireAttendu) {
		
		Ellipse e = new Ellipse(new Coordonnees(positionX, positionY), largeur, hauteur);
		assertEquals(aireAttendu, e.aire());
	}
	
	@Test
	public void testToString() {
		Ellipse e = new Ellipse(new Coordonnees(5.5, 8.5), 10.5, 15.5);
		String chaineAttendu = "[Ellipse] pos : (5,5 , 8,5) petit rayon : 5.25 grand rayon : 5.25 périmètre : 82.44 aire : 127.82";
		assertEquals(chaineAttendu, e.toString());
	}
	
	
	

	
	

}
