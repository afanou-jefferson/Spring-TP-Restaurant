package dev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.entite.Plat;

public class PlatMapper<T> implements RowMapper<Plat> {
	
	  // cette méthode est invoquée pour chaque ligne de résultat SQL
	  public Plat mapRow(ResultSet rs, int rowNum) throws SQLException {
	  Plat p = new Plat();
	  //p.setId(rs.getInt("id_plat")); // A utiliser si on veux intégrer la gestion d'ID dans le jdbc
	  p.setNom(rs.getString("nom_plat"));
	  p.setPrixEnCentimesEuros(rs.getInt("prix_plat"));
	  return p;
	  }

	}
