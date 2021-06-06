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
	//private List <Client> listeClients2 = new ArrayList <Client> ();

	public ClientMetier() {}

	public Client getCl() {
		return cl;	}

	public void setCl(Client cl) {
		this.cl = cl;	}

	
	//m�thode qui affiche tous les clients
	public List <Client> getListeClients() {
		listeClients = dao.afficherClients();
		return listeClients;	}
	
	
	/*public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;	}	*/
	

	//m�thode qui ajoute un client
	public void ajouterClient() {
		if (dao.ajouterClient(cl) == 0)
			{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout effectu� avec succ�s");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}
		else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout non effectu�");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
	
	
	//m�thode qui cherche un client by id
	public void chercherClientById(int id) {
		dao.chercherClientById(id);	}
		
			
	//m�thode qui supprime un client by id
	public void supprimerClientById(int id) {
		dao.supprimerClientById(id);	}
	
		
	//m�thode qui modifie les donn�es d'un client
	public void modifierClient(Client cl) {
		dao.modifierClient(cl);		}

}