package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Operation;

public class OperationDAO implements Serializable {

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
		
		public OperationDAO() {}
		

		//méthode qui ajoute une nouvelle operation
		public int ajouterOperation(Operation op) {
			int res=0;
			try {
				getEntityManager().getTransaction().begin();
				getEntityManager().persist(op);
				getEntityManager().getTransaction().commit();
				}	catch (Exception e)	{
											if (getEntityManager().getTransaction() != null)
												{	getEntityManager().getTransaction().rollback();
											res=1;	}
					}
			 return res;	}

		
			//méthode qui affiche les operations
			public List<Operation> afficherOperations() {
				Query query = getEntityManager().createNamedQuery("Operation.findAll");
				@SuppressWarnings("unchecked")
				List <Operation> liste = query.getResultList();
				return liste;	}
			
			
			//méthode qui cherche une operation by num
			public Operation chercherOperationByNum(int num) {
				Operation res = entityManager.find(Operation.class, num);
				return res;	}

				
			//méthode qui supprime un client by id
			public int supprimerOperationByNum(int num) {
				Operation operationAsup = chercherOperationByNum(num);
				getEntityManager().getTransaction().begin();
				getEntityManager().merge(operationAsup);
				getEntityManager().remove(operationAsup);
				getEntityManager().getTransaction().commit();
				return 0;
				}

				
			//méthode qui modifie les données d'une operation
			public int modifierOperation(Operation op) {
				getEntityManager().getTransaction().begin();
				getEntityManager().merge(op);
				getEntityManager().getTransaction().commit();
				return 1;
				}

}
