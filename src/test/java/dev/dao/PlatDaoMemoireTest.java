package dev.dao;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.entite.Plat;

class PlatDaoMemoireTest {
	private PlatDaoMemoire platDaoMemoire;


	@BeforeEach //Avant chaque test, on veut que cette methode s'execute, ici on fournis un nouveau DAO pour indépendance des tests
	void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}


	@Test
	void listerPlatsVideALInitialisation() {
		List<Plat> resultat = platDaoMemoire.listerPlats();
		assertThat(resultat.size() == 0);	
	}

	// TODO
	@Test
	void ajouterPlatCasPassants() {
		platDaoMemoire.ajouterPlat("Test1", 100000);
		List<Plat> resultat = platDaoMemoire.listerPlats();
		assertThat(resultat.get(resultat.size()).getNom().equals("Test1"));	// On check que le dernier plat ajouté correspont à notre plats ajoutés
	}
}
