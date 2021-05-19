package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operation database table.
 * 
 */
@Entity
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numOperation;

	private float montant;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;

	public Operation() {
	}

	public int getNumOperation() {
		return this.numOperation;
	}

	public void setNumOperation(int numOperation) {
		this.numOperation = numOperation;
	}

	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}