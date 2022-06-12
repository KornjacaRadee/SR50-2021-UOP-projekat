package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import knjige.Biblioteka;
import ljudi.Admin;
import ljudi.Bibliotekar;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;



public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Biblioteka biblioteka = new Biblioteka();
	public login() {
		setType(Type.UTILITY);
		setTitle("LOG IN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 495, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(193, 11, 105, 88);
		panel.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(155, 141, 173, 31);
		panel.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(155, 203, 173, 31);
		panel.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Korisnicko ime:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(155, 121, 143, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sifra:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(155, 183, 143, 18);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =(String)user.getText();
				String password = (String)pass.getText();
				biblioteka.ucitajAdmine();
				biblioteka.ucitajBibliotekare();
				String log = "";
				for(Admin admin1 : biblioteka.getAdmini()) {
					 if(admin1.getKorisnickoIme().equals(username) && admin1.getKorisnickaSifra().equals(password)) {
						 log = "admin";
				     }
				}
				if (log == "") {
					for(Bibliotekar bibliotekar : biblioteka.getBibliotekari()) {
						if(bibliotekar.getKorisnickoIme().equals(username) && bibliotekar.getKorisnickaSifra().equals(password)) {
							 log = "bibliotekar";
					     }
					}
				}
				if(log == "admin") {
					 JOptionPane.showMessageDialog(null, "Admin uspesno ulogovan");
					 Mainwindow Main = new Mainwindow();
					Main.setVisible(true);
					Main.setTitle("Admin panel");
					setVisible(false);
				}else if(log == "bibliotekar") {
					JOptionPane.showMessageDialog(null, "Bibliotekar uspesno ulogovan");
					 Mainwindow Main = new Mainwindow();
					 Main.setTitle("Bibliotekar panel");
					Main.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Log in neuspesan pokusajte ponovo ili potrazite pomoc");
				}
				}
				
		});
		
		// 6
		// 7
		btnNewButton.setBounds(193, 268, 89, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("pomoc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setBounds(396, 306, 89, 23);
		panel.add(btnNewButton_1);
	}
}
