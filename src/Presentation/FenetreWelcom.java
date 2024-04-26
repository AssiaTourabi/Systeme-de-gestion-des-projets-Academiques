package Presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreWelcom extends JFrame {
	private JFrame frmLogin;
	private JLabel welcomLabel;
	private JLabel merhaba;
	private JButton loginBtn;
	private JLabel bienvenueLabel;

	public FenetreWelcom() throws HeadlessException {
		super();

		this.initialiser();
		this.dessiner();
		this.action();

	}

	public void initialiser() {

		frmLogin = new JFrame();
		bienvenueLabel = new JLabel("Bienvenue");

		welcomLabel = new JLabel("Welcome");

		merhaba = new JLabel("مرحبا");

		loginBtn = new JButton("Login");

	}

	public void dessiner() {

		frmLogin.setTitle("welcome\r\n");
		// this.pack();
		frmLogin.getContentPane().setBackground(new Color(149, 131, 254));

		frmLogin.setBounds(450, 190, 2500, 700);
		// frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLayout(null);

		bienvenueLabel.setBounds(259, 368, 248, 51);
		bienvenueLabel.setBackground(new Color(240, 240, 240));
		bienvenueLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		frmLogin.add(bienvenueLabel);

		welcomLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		welcomLabel.setBounds(245, 247, 199, 43);
		frmLogin.add(welcomLabel);

		merhaba.setFont(new Font("Tahoma", Font.ITALIC, 40));
		merhaba.setBounds(427, 430, 284, 52);
		frmLogin.add(merhaba);

		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));

		loginBtn.setBackground(new Color(255, 255, 255));

		loginBtn.setBounds(377, 521, 172, 30);
		frmLogin.add(loginBtn);
		frmLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.setVisible(true);
	}

	public void action() {
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FentreLogin log = new FentreLogin(new Controlleurlogin());
			}

		});

	}
}
