package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adresse;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Compte
	@OneToMany(mappedBy="client")
	private List<Compte> comptes;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setClient(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setClient(null);

		return compte;
	}
	
	public Client(int id, String nom, String prenom, String adresse, List<Compte> comptes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.comptes = comptes;
	}
	
	public Client(int id, String nom, String prenom, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

}