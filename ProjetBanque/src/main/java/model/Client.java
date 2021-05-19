package model;

import java.io.Serializable;
import javax.persistence.*;


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

	//uni-directional one-to-one association to Cartetechnologique
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="id_client2")
	private Cartetechnologique cartetechnologique;

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

	public Cartetechnologique getCartetechnologique() {
		return this.cartetechnologique;
	}

	public void setCartetechnologique(Cartetechnologique cartetechnologique) {
		this.cartetechnologique = cartetechnologique;
	}

	public Client(int id, String adresse, String nom, String prenom, Cartetechnologique cartetechnologique) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.cartetechnologique = cartetechnologique;
	}
	
	

}