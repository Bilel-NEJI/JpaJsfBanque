package DAO;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;

public class ClientDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager=null;
	
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
		int res=0;
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(cli);
			getEntityManager().getTransaction().commit();
			}	catch (Exception e)	{
										if (getEntityManager().getTransaction() != null)
											{	getEntityManager().getTransaction().rollback();
										res=1;	}
				}
		 return res;	}

	
		//méthode qui affiche les clients
		public List<Client> afficherClients() {
			Query query = getEntityManager().createNamedQuery("Client.findAll");
			@SuppressWarnings("unchecked")
			List <Client> liste = query.getResultList();
			return liste;	}
		
		
		//méthode qui cherche un client by id
		public Client chercherClientById(int ed) {
			Client res = entityManager.find(Client.class, ed);
			return res;	}

			
		//méthode qui supprime un client by id
		public int supprimerClientById(int id) {
			Client clientAsup = chercherClientById(id);
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(clientAsup);
			//getEntityManager().merge(clientAsup);
			getEntityManager().getTransaction().commit();
			return 0;
			}

			
		//méthode qui modifie les données d'un client
		public int modifierClient(Client cl) {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(cl);
			getEntityManager().getTransaction().commit();
			return 1;
			}
	
}
