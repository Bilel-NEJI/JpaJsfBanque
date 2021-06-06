package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numCompte;

	private float solde;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	public Compte() {
	}

	public int getNumCompte() {
		return this.numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Compte(int numCompte, float solde, Client client) {
		super();
		this.numCompte = numCompte;
		this.client = client;
		this.solde = solde;
	}
	
	public Compte(int numCompte, float solde) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
	}

}