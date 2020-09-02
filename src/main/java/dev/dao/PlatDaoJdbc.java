package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;
import dev.mapper.PlatMapper;

@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {

	private JdbcTemplate jdbcTemplate; // Outil JdbcTemplate fourni par Spring Jdbc

	public PlatDaoJdbc(DataSource dataSource) { // Injection de la source de données
		this.jdbcTemplate = new JdbcTemplate(dataSource); // Création d’une instance du JdbcTemplate à partir de la														// source de données
	}

	@Override
	public List<Plat> listerPlats() {

		String sql = "SELECT * FROM PLAT";

		List<Plat> listePlat = this.jdbcTemplate.query(sql, new PlatMapper()); // utilisation du JdbcTemplate pour
																					// exécuter une requête SQL et
																					// récupérer un résultat
		return listePlat;

	}

	@Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

		String sql = "insert into plat(nom_plat, prix_plat) values(?, ?)";
		
		this.jdbcTemplate.update(sql,nomPlat, prixPlat);
	
	}

}
