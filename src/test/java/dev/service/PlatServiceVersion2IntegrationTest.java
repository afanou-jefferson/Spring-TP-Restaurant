package dev.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.config.AppConfig;
import dev.exception.PlatException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@ActiveProfiles({"memoire", "service2"}) 
public class PlatServiceVersion2IntegrationTest {

	@Autowired
	private PlatServiceVersion2 serviceV2;

	@Test
	public void testAjouterPlatNomPrixValide() {
		int tailleListeAvant = serviceV2.listerPlats().size();
		serviceV2.ajouterPlat("abcdef", 100000);
		int tailleListApres = serviceV2.listerPlats().size();

		assertThat(tailleListApres == tailleListeAvant + 1);
	}

	@Test
	void testAjouterPlatInvalidePrix() throws PlatException {
		PlatException exception = assertThrows(PlatException.class, () -> serviceV2.ajouterPlat("abcdef", 1));
		assertEquals("le prix d'un plat doit être supérieur à 10 €", exception.getMessage());
	}

}
