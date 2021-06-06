package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import DAO.CompteDAO;
import model.Compte;

public class CompteMetier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Compte cpt = new Compte();
	private CompteDAO dao = new CompteDAO();
	private List <Compte> listeComptes = new ArrayList <Compte> ();

	
	public CompteMetier() {}

	public Compte getCpt() {
		return cpt;	}

	public void setCpt(Compte cpt) {
		this.cpt = cpt;	}
	

	//m�thode qui affiche tous les comptes
	public List <Compte> getListeComptes() {
		listeComptes = dao.afficherComptes();
		return listeComptes;	}

	
	/*public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;	}*/

	
	//m�thode qui ajoute un client
	public void ajouterCompte() {
		dao.ajouterCompte(cpt);		}
		
		
	//m�thode qui cherche un client by id
		public void chercherClientById(int numCompte) {
			dao.chercherCompteByNumCompte(numCompte);		}
			
	//m�thode qui supprime un compte by numCompte
		public void supprimerCompteByNumCompte(int numCompte) {
			dao.supprimerCompteByNumCompte(numCompte);	}
				
		
		
	//m�thode qui modifie le solde d'un compte by numCompte
		public void modifierCompteByNumCompte(int numCompte, float sld) {
			dao.modifierCompteByNumCompte(cpt);		}

}