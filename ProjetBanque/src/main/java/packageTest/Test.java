package packageTest;

import java.util.ArrayList;
import java.util.List;

import DAO.ClientDAO;
import model.Client;

public class Test {

	public static void main(String[] args) {
		
		ClientDAO dao1 = new ClientDAO();		
		
		//pour tester l'ajout d'un client
			//Client c3 = new Client (10, "Dalo", "ILO", "Tunis 2");
			//dao1.ajouterClient(c3);
		
				
		//pour tester la suppression d'un client
			dao1.supprimerClientById(55);
		
				
		//pour tester la modification d'un client
			Client c55 = new Client(6, "GGGGG", "AAAAA", "EPPPPPP");
			dao1.modifierClient(c55);
			
			
		

	}

}
