package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import DAO.OperationDAO;
import model.Operation;

public class OperationMetier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Operation op = new Operation();
	private OperationDAO dao = new OperationDAO();
	private List <Operation> listeOperations = new ArrayList <Operation> ();
	//private List <Operation> listeCOperations2 = new ArrayList <Operation> ();

	public OperationMetier() {}

	public Operation getOp() {
		return op;	}

	public void setOp(Operation op) {
		this.op = op;	}

	
	//m�thode qui affiche tous les operations
	public List <Operation> getListeOperations() {
		listeOperations = dao.afficherOperations();
		return listeOperations;	}
	
	
	/*public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;	}	*/
	

	//m�thode qui ajoute une operation
	public void ajouterOperation() {
		dao.ajouterOperation(op);	}
	
	
	//m�thode qui cherche une operation by num
	public void chercherOperationByNum(int num) {
		dao.chercherOperationByNum(num);	}
		
			
	//m�thode qui supprime une operation by num
	public void supprimerOperationByNum(int num) {
		dao.supprimerOperationByNum(num);	}
	
		
	//m�thode qui modifie les donn�es d'une operation
	public void modifierOperation(Operation op) {
		dao.modifierOperation(op);		}

}