package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Compte;

public class CompteDAO implements Serializable {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetBanque"); 
			entityManager = emf.createEntityManager();	}
		return entityManager;	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;	}
	
	public CompteDAO() {}
	

	//méthode qui ajoute un nouveau client
	public int ajouterCompte(Compte cpt) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(cpt);
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
	
		public List<Compte> afficherComptes() {
			Query query = getEntityManager().createNamedQuery("Compte.findAll");
			@SuppressWarnings("unchecked")
			List <Compte> liste= query.getResultList();
			return liste;	}
		
		//méthode qui cherche un compte by numCompte
			public Compte chercherCompteByNumCompte(int numCompte) {
				getEntityManager().getTransaction().begin();
				Compte cpt_cher = getEntityManager().find(Compte.class, numCompte);
				getEntityManager().getTransaction().commit();
				return cpt_cher;	}
			
		//méthode qui supprime un compte by numCompte
			public int supprimerCompteByNumCompte(int byNumCompte) {
				try {
					Compte cpt_sup = chercherCompteByNumCompte(byNumCompte);
					getEntityManager().getTransaction().begin();
					getEntityManager().remove(cpt_sup);
					getEntityManager().getTransaction().commit();
				}
					catch (Exception f)
						{
							if (getEntityManager().getTransaction() != null)
								getEntityManager().getTransaction().rollback();
							return 1;	}			
				return 0;	}

		//méthode qui modifie le solde d'un compte by numCompte
		public int modifierCompteByNumCompte(int numCompte, float sld) {
			Compte cpt_mod = chercherCompteByNumCompte(numCompte);
			getEntityManager().getTransaction().begin();
			cpt_mod.setSolde(sld);
			getEntityManager().merge(cpt_mod);
			getEntityManager().getTransaction().commit();
			return 0;
			}
	
}
