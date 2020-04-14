package model;

public class Model {

	private static TransactionDAO transactionDAO;
	private static PersonneDAO personneDAO;
	
	public static TransactionDAO getTransactionInstance() {
		
		if(Model.transactionDAO == null) {
			
			Model.transactionDAO = new TransactionDAO();
		}
		
		return Model.transactionDAO;
	}
	
	public static PersonneDAO getPersonneInstance() {
		
		if(Model.personneDAO == null) {
			
			Model.personneDAO = new PersonneDAO();
		}
		
		return Model.personneDAO;
	}
}
