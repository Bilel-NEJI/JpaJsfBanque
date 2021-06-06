package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;
import model.Compte;

public class CompteDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetBanque"); 
			entityManager = emf.createEntityManager();	}
		return entityManager;	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;	}
	
	public CompteDAO() {}
	

	//méthode qui ajoute un nouveau compte
	public int ajouterCompte(Compte cpt) {
		int res=0;
		
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(cpt);
			getEntityManager().getTransaction().commit();
			}
		catch (Exception e)
		{
			if (getEntityManager().getTransaction() != null)
				{	getEntityManager().getTransaction().rollback();
				res=1;
				}
		}
		 return res;	}
	
	
	//méthode qui affiche les clients
		public List<Compte> afficherComptes() {
			Query query = getEntityManager().createNamedQuery("Compte.findAll");
			@SuppressWarnings("unchecked")
			List <Compte> liste2 = query.getResultList();
			return liste2;	}
		
		
		//méthode qui cherche un compte by numCompte
			public Compte chercherCompteByNumCompte(int numCompte) {
				Compte res = entityManager.find(Compte.class, numCompte);
				return res;  }
			
		//méthode qui supprime un compte by numCompte
			public int supprimerCompteByNumCompte(int numCmpte) {
				int y = 0;
				Compte compteAsup = chercherCompteByNumCompte(numCmpte);
				getEntityManager().getTransaction().begin();
				getEntityManager().remove(compteAsup);
				getEntityManager().merge(compteAsup);
				getEntityManager().getTransaction().commit();
				return y;
				}

		//méthode qui modifie le solde d'un compte by numCompte
		public int modifierCompteByNumCompte(Compte cpt) {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(cpt);
			getEntityManager().getTransaction().commit();
			return 1;
			}
	
}
