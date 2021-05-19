package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;

public class ClientDAO implements Serializable {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetBanque"); 
			entityManager = emf.createEntityManager();	}
		return entityManager;	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;	}
	
	public ClientDAO() {}
	

	//méthode qui ajoute un nouveau client
	public int ajouterClient(Client cli) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(cli);
			getEntityManager().getTransaction().commit();	}
		catch (Exception e)
		{
			if (getEntityManager().getTransaction() != null)
				{	getEntityManager().getTransaction().rollback();
					return 1;	}
		e.printStackTrace(); }
		finally {	
					if (getEntityManager() != null )
						{getEntityManager().close();	}
		return 0;	}	
		}
	
		public List<Client> afficherClients() {
			Query query = getEntityManager().createNamedQuery("Client.findAll");
			@SuppressWarnings("unchecked")
			List <Client> liste= query.getResultList();
			return liste;	}
		
		//méthode qui cherche un client by id
			public Client chercherClientById(int byId) {
				getEntityManager().getTransaction().begin();
				Client cl_cher = getEntityManager().find(Client.class, byId);
				getEntityManager().getTransaction().commit();
				return cl_cher;	}
			
		//méthode qui supprime un client by id
			public int supprimerClientById(int byId) {
				try {
					Client cl_sup = chercherClientById(byId);
					getEntityManager().getTransaction().begin();
					getEntityManager().remove(cl_sup);
					getEntityManager().getTransaction().commit();
				}
					catch (Exception f)
						{
							if (getEntityManager().getTransaction() != null)
								getEntityManager().getTransaction().rollback();
							return 1;	}			
				return 0;	}

		//méthode qui modifie les données d'un client by id
		public int modifierClientById(int byId, String newName, String newLastName, String newAdress) {
			Client cl_mod = chercherClientById(byId);
			getEntityManager().getTransaction().begin();
			cl_mod.setNom(newName);
			cl_mod.setPrenom(newLastName);
			cl_mod.setAdresse(newAdress);
			getEntityManager().merge(cl_mod);
			getEntityManager().getTransaction().commit();
			return 0;
			}
	
}
