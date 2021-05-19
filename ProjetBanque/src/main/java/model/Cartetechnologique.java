package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cartetechnologique database table.
 * 
 */
@Entity
@NamedQuery(name="Cartetechnologique.findAll", query="SELECT c FROM Cartetechnologique c")
public class Cartetechnologique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int numCarte;

	@Column(name="id_client2")
	private int idClient2;

	private float soldeCarte;

	public Cartetechnologique() {
	}

	public int getNumCarte() {
		return this.numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public int getIdClient2() {
		return this.idClient2;
	}

	public void setIdClient2(int idClient2) {
		this.idClient2 = idClient2;
	}

	public float getSoldeCarte() {
		return this.soldeCarte;
	}

	public void setSoldeCarte(float soldeCarte) {
		this.soldeCarte = soldeCarte;
	}

}