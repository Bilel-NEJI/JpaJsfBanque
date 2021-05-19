package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import DAO.ClientDAO;
import model.Client;

public class ClientMetier implements Serializable {

	private Client cl = new Client();
	private ClientDAO dao = new ClientDAO();
	private List <Client> listeClients = new ArrayList <Client> ();

	public ClientMetier() {}

	public Client getCl() {
		return cl;	}

	public void setCl(Client cl) {
		this.cl = cl;	}
	

	//méthode qui affiche tous les clients
	public List <Client> getListeClients() {
		listeClients = dao.afficherClients();
		return listeClients;	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;	}

	//méthode qui ajoute un client
	public void ajouterClient() {
		if (dao.ajouterClient(cl) == 0)
			{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout effectué avec succés");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}
		else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout non effectué");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//méthode qui cherche un client by id
		public void chercherClientById(int byId) {
				
					}
			
	//méthode qui supprime un client by id
		public void supprimerClientById(int byId) {
			if (dao.supprimerClientById(byId) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Client by Id", "Suppression effectuée avec succés");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Client by Id", "Suppression non effectuée");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//méthode qui modifie le nom d'un client by id
		public void modifierClientById(int byId, String newName, String newLastName, String newAdress) {
			if (dao.modifierClientById(byId, newName, newLastName, newAdress) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour du nom-Client by Id", "Mise à jour effectuée avec succés");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour du nom-Client by Id", "Mise à jour non effectuée");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}
			}

}