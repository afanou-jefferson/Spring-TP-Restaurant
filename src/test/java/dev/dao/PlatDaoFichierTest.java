package dev.dao;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;

@SpringJUnitConfig(PlatDaoFichier.class) // créer un contexte Spring avec un bean de type dev.dao.PlatDaoFichier
@TestPropertySource("classpath:test.properties") // déclare le profil à activer
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // Reset le context après chaque appel de la méthode test

public class PlatDaoFichierTest {

	@Autowired // Instancie "auto" une instance, gerée par Spring
	private PlatDaoFichier platDaoFichier;

	@Test
	public void TestAjoutPlat() {
		List<Plat> listAvant = platDaoFichier.listerPlats();
		int sizeAvant = listAvant.size();
		
		platDaoFichier.ajouterPlat("abcdef", 10000);
		
		List<Plat> listApres = platDaoFichier.listerPlats();
		int sizeApres = listApres.size();
		
		Assertions.assertThat(sizeAvant + 1 == sizeApres);
		Assertions.assertThat(listApres.size()).isEqualTo(1); //Check un seul plat dans la liste (this.platDaoFichier.listerPlats()).
	}
	
	@Test
	public void TestAjoutPlatBis() { // On re test la même méthode pour voir si le contexte est bien reset à chaque fois
		platDaoFichier.ajouterPlat("azerty", 10000);
		List<Plat> list = platDaoFichier.listerPlats();
		Assertions.assertThat(list.size()).isEqualTo(1);
	}
}
