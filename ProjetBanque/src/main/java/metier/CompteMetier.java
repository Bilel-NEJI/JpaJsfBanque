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
	

	//méthode qui affiche tous les comptes
	public List <Compte> getListeComptes() {
		listeComptes = dao.afficherComptes();
		return listeComptes;	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;	}

	//méthode qui ajoute un client
	public void ajouterCompte() {
		if (dao.ajouterCompte(cpt) == 0)
			{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Compte", "Ajout effectué avec succés");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}
		else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Compte", "Ajout non effectué");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//méthode qui cherche un client by id
		public void chercherClientById(int byId) {
				
					}
			
	//méthode qui supprime un compte by numCompte
		public void supprimerCompteByNumCompte(int numCompte) {
			if (dao.supprimerCompteByNumCompte(numCompte) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Compte by numCompte", "Suppression effectuée avec succés");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Compte by numCompte", "Suppression non effectuée");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//méthode qui modifie le solde d'un compte by numCompte
		public void modifierCompteByNumCompte(int numCompte, float sld) {
			if (dao.modifierCompteByNumCompte(numCompte, sld) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour du solde Compte by numCompte", "Mise à jour effectuée avec succés");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour du solde Compte by numCompte", "Mise à jour non effectuée");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}
			}

}