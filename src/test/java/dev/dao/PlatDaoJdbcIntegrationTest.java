package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { JdbcTestConfig.class })
@SpringJUnitConfig({ JdbcTestConfig.class, PlatDaoJdbc.class })
@ActiveProfiles({ "jdbc" })
public class PlatDaoJdbcIntegrationTest {

	@Autowired
	private PlatDaoJdbc dao;

	@Test
	public void listerPlatsNonVideTest() {
		int tailleListe = dao.listerPlats().size();
		assertThat(tailleListe > 0);
	}

	@Test
	public void ajouterPlatTest() {
		int tailleListeAvant = dao.listerPlats().size();
		dao.ajouterPlat("abcdef", 100000);
		int tailleListApres = dao.listerPlats().size();

		assertThat(tailleListApres == tailleListeAvant + 1);
	}

}
