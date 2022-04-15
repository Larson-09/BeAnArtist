package fr.eseo.cpoo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import fr.eseo.cpoo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	Cercle cercle;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cercle = new Cercle();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// TESTS CONSTRUCTEURS =================================================================================

	@Test
	public void testConstructeurVide() {
		assertEquals(new Coordonnees(), this.cercle.getPosition());
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, cercle.getLargeur(), "Test taille par defaut");
	}
	
	@Test
	public void testConstructeurTaille() {
		Cercle c = new Cercle(10.5);
		assertEquals(10.5, c.getLargeur(), "Test getLargeur");
		assertEquals(10.5, c.getHauteur(), "Test getHauteur");
	}
	
	@Test
	public void testConstructeurPosition() {
		Cercle c = new Cercle(new Coordonnees(5.5, 8.5));
		
		assertEquals(new Coordonnees(5.5, 8.5), c.getPosition(), "Test getPosition");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, c.getLargeur(), "Test getLargeur");
		assertEquals(Forme.LARGEUR_PAR_DEFAUT, c.getHauteur(), "Test getHauteur");
	}
	
	@Test
	public void testConstructeurPositionLargeurHauteur() {
		Cercle c = new Cercle(new Coordonnees(5.5, 8.5), 10.5);
		
		assertEquals(new Coordonnees(5.5, 8.5), c.getPosition(), "Test getPosition");
		assertEquals(10.5, c.getLargeur(), "Test getLargeur");
		assertEquals(10.5, c.getHauteur(), "Test getHauteur");
	}
	
	// TESTS SETTERS =================================================================================
	
	@Test
	public void testSetLargeurNegatifException() {
	    assertThrows(IllegalArgumentException.class, ()->{
	            cercle.setHauteur(-1.5);
	    	});
	}
	
	@Test
	public void testSetHauteurNegatifException() {
	    assertThrows(IllegalArgumentException.class, ()->{
	            cercle.setLargeur(-1.5);
	    	});
	}
	
	// TESTS METHODES =================================================================================
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/cercle/DT_perimetre")
	public void testPerimetre(double taille, double perimetreAttendu) {
		
		cercle.setLargeur(taille);
		assertEquals(perimetreAttendu, cercle.perimetre());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="dt/cercle/DT_aire")
	public void testAire(double taille, double aireAttendu) {
		
		this.cercle.setLargeur(taille);
		assertEquals(aireAttendu, this.cercle.aire());
	}
	
	@Test
	public void testToString() {
		this.cercle.setLargeur(50.50);
		String chaineAttendu = "[Cercle] pos : (0,0 , 0,0) rayon : 25.25 périmètre : 158.65 aire : 2002.96";
		assertEquals(chaineAttendu, this.cercle.toString());
	}
	


}
