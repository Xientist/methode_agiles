package model;

public class Model {

	private static TransactionDAO instance;
	
	public static TransactionDAO getInstance() {
		
		if(Model.instance == null) {
			
			Model.instance = new TransactionDAO();
		}
		
		return Model.instance;
	}
}
