package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import DAO.CompteDAO;
import model.Compte;

public class CompteMetier implements Serializable {

	private Compte cpt = new Compte();
	private CompteDAO dao = new CompteDAO();
	private List <Compte> listeComptes = new ArrayList <Compte> ();

	public CompteMetier() {}

	public Compte getCl() {
		return cpt;	}

	public void setCl(Compte cl) {
		this.cpt = cpt;	}
	

	//m�thode qui affiche tous les comptes
	public List <Compte> getListeComptes() {
		listeComptes = dao.afficherComptes();
		return listeComptes;	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;	}

	//m�thode qui ajoute un client
	public void ajouterCompte() {
		if (dao.ajouterCompte(cpt) == 0)
			{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Compte", "Ajout effectu� avec succ�s");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}
		else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Compte", "Ajout non effectu�");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//m�thode qui cherche un client by id
		public void chercherClientById(int byId) {
				
					}
			
	//m�thode qui supprime un compte by numCompte
		public void supprimerCompteByNumCompte(int numCompte) {
			if (dao.supprimerCompteByNumCompte(numCompte) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Compte by numCompte", "Suppression effectu�e avec succ�s");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Compte by numCompte", "Suppression non effectu�e");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//m�thode qui modifie le solde d'un compte by numCompte
		public void modifierCompteByNumCompte(int numCompte, float sld) {
			if (dao.modifierCompteByNumCompte(numCompte, sld) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise � jour du solde Compte by numCompte", "Mise � jour effectu�e avec succ�s");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise � jour du solde Compte by numCompte", "Mise � jour non effectu�e");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}
			}

}