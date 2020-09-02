package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;

@SpringJUnitConfig({ JpaConfig.class, PlatDaoJpa.class })
@ActiveProfiles({ "jpa", "service1" })
public class PlatDaoJpaIntregrationTest {

	@Autowired
	private PlatDaoJpa dao;
	//Bean named 'platDaoJpa' is expected to be of type 'dev.dao.PlatDaoJpa' but was actually of type 'com.sun.proxy.$Proxy49' , ask Rossi

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
