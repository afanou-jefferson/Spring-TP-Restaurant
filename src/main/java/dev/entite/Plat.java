package dev.entite;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plat")
public class Plat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_plat")
	private int id;
	
	@Column(name="nom_plat")
    private String nom;
    
    @Column(name="prix_plat")
    private Integer prixEnCentimesEuros;

    public Plat() {} // Constructeur vide pour JPA
    
    public Plat(int idPlat, String nomPlat, int prixPlatEnCentimes) {
    	this.id = idPlat;
    	this.nom = nomPlat;
    	this.prixEnCentimesEuros = prixPlatEnCentimes;
    }

    public Plat(String nom, Integer prixEnCentimesEuros) {
        this.nom = nom;
        this.prixEnCentimesEuros = prixEnCentimesEuros;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrixEnCentimesEuros() {
        return prixEnCentimesEuros;
    }

    public void setPrixEnCentimesEuros(Integer prixEnCentimesEuros) {
        this.prixEnCentimesEuros = prixEnCentimesEuros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return nom.equals(plat.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

}
