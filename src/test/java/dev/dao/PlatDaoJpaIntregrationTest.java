package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;

@SpringJUnitConfig({ JpaConfig.class })
@ActiveProfiles({ "jpa", "service1" })
public class PlatDaoJpaIntregrationTest {

	@Autowired
	private PlatDaoJpa dao;

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
