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
	

	//m�thode qui affiche tous les clients
	public List <Client> getListeClients() {
		listeClients = dao.afficherClients();
		return listeClients;	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;	}

	//m�thode qui ajoute un client
	public void ajouterClient() {
		if (dao.ajouterClient(cl) == 0)
			{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout effectu� avec succ�s");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}
		else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout non effectu�");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//m�thode qui cherche un client by id
		public void chercherClientById(int byId) {
				
					}
			
	//m�thode qui supprime un client by id
		public void supprimerClientById(int byId) {
			if (dao.supprimerClientById(byId) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Client by Id", "Suppression effectu�e avec succ�s");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression d'un Client by Id", "Suppression non effectu�e");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
		
		
	//m�thode qui modifie le nom d'un client by id
		public void modifierClientById(int byId, String newName, String newLastName, String newAdress) {
			if (dao.modifierClientById(byId, newName, newLastName, newAdress) == 0)
				{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise � jour du nom-Client by Id", "Mise � jour effectu�e avec succ�s");
					RequestContext.getCurrentInstance().showMessageInDialog(message);	}
				else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise � jour du nom-Client by Id", "Mise � jour non effectu�e");
						RequestContext.getCurrentInstance().showMessageInDialog(message);	}
			}

}