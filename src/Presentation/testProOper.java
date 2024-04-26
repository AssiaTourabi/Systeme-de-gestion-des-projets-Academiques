package Presentation;

import java.awt.HeadlessException;
import java.sql.SQLException;

/**
 * @author oki
 *
 */
public class testProOper {

	public static void main(String[] args) throws HeadlessException, SQLException {
		// TODO Auto-generated method stub
		// ControlleurProjet controlleurPr = new ControlleurProjet();
		// controlleurPr.demmarrerApplication();
		// ControlleurEtape controlleur = new ControlleurEtape();
		// controlleur.demmarrerApplication();
		ControlleurEtudiant controlleurEntr = new ControlleurEtudiant();
		controlleurEntr.demmarrerApplication();
		// controlleurAdministrateur admin = new controlleurAdministrateur();

		// admin.demmarrerApplication();
	}

}
