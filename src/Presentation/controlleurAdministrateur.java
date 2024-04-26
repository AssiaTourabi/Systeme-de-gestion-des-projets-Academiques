package Presentation;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;

public class controlleurAdministrateur {

	private FeneteAdmin CAdmin;

	public controlleurAdministrateur() {
		super();
	}

	public void demmarrerApplication() throws HeadlessException, SQLException {
		this.CAdmin = new FeneteAdmin(this);
		// this.CAdmin.pack();
		this.CAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.CAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.CAdmin.setVisible(true);
	}

}
