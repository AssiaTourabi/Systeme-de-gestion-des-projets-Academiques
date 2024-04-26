package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class connexion {

	public static Connection getConnexion() {
		try {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "HappyThatMySQL1.");
			props.put("serverTimezone", "Africa/Casablanca");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", props);
			return cn;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
