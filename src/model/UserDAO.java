package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	final static String URL = "jdbc:mysql://localhost:3306/budget_managment?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final static String LOGIN = "root";
	final static String PASS = "";
	
	
	
	public UserDAO() {
		System.out.println("exist");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.err.println(	"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
	
	public int verifyUser(String mdp) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM utilisateur WHERE Passeword=?");
			ps.setString(1, mdp);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("exist");
				//retour = new Personne(rs.getInt("ID"), rs.getString("Nom"));
			}else 
				System.out.println("exist pas ");

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception t) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception t) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception t) {
			}
		}
		
		
		
		
		return 0;
	}
	
	
	
	
	
	
}
