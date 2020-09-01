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
		assertThat(resultat.size()).isEqualTo(0);
		assertThat(resultat.isEmpty());
	}

	// TODO
	@Test
	void ajouterPlatCasPassants() {
		
		List<Plat> resultatAvant = platDaoMemoire.listerPlats();
		int sizeAvant = resultatAvant.size();
		
		platDaoMemoire.ajouterPlat("Test1", 100000);
		
		List<Plat> resultatApres = platDaoMemoire.listerPlats();
		
		int sizeApres = resultatApres.size();
		assertThat(sizeAvant<sizeApres);
		
		assertThat(resultatApres.get(resultatApres.size()-1).getNom().equals("Test1"));	// On check que le dernier plat ajouté correspont à notre plats ajoutés
	}
}
