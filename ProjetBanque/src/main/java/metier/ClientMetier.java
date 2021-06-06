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

	
	//méthode qui affiche tous les clients
	public List <Client> getListeClients() {
		listeClients = dao.afficherClients();
		return listeClients;	}
	
	
	/*public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;	}	*/
	

	//méthode qui ajoute un client
	public void ajouterClient() {
		if (dao.ajouterClient(cl) == 0)
			{	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout effectué avec succés");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}
		else {	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout d'un Client", "Ajout non effectué");
				RequestContext.getCurrentInstance().showMessageInDialog(message);	}	}
	
	
	//méthode qui cherche un client by id
	public void chercherClientById(int id) {
		dao.chercherClientById(id);	}
		
			
	//méthode qui supprime un client by id
	public void supprimerClientById(int id) {
		dao.supprimerClientById(id);	}
	
		
	//méthode qui modifie les données d'un client
	public void modifierClient(Client cl) {
		dao.modifierClient(cl);		}

}