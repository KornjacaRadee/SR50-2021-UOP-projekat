package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainwindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow frame = new Mainwindow();
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
	public Mainwindow() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 778, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Biblioteka");
		lblNewLabel.setBounds(271, 5, 293, 84);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 69));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADMINI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(getTitle().equals("Admin panel")) {
					Adminiwindow frame = new Adminiwindow();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Nemate dozvolu");
				};
				
			}
		});
		btnNewButton.setBounds(86, 149, 126, 76);
		panel.add(btnNewButton);
		
		JButton btnBibliotekari = new JButton("BIBLIOTEKARI");
		btnBibliotekari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(getTitle().equals("Admin panel")) {
					BibliotekariWindow frame = new BibliotekariWindow();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Nemate dozvolu");
				};
				
			}
		});
		btnBibliotekari.setBounds(86, 281, 126, 76);
		panel.add(btnBibliotekari);
		
		JButton btnClanovi = new JButton("CLANOVI");
		btnClanovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClanoviWindow frame = new ClanoviWindow();
				frame.setVisible(true);
			}
		});
		btnClanovi.setBounds(86, 414, 126, 76);
		panel.add(btnClanovi);
		
		JButton btnKnjige = new JButton("KNJIGE");
		btnKnjige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KnjigeWindow frame = new KnjigeWindow();
				frame.setVisible(true);
			}
		});
		btnKnjige.setBounds(343, 149, 126, 76);
		panel.add(btnKnjige);
		
		JButton btnPrimerci = new JButton("PRIMERCI");
		btnPrimerci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrimerakWindow frame = new PrimerakWindow();
				frame.setVisible(true);
			}
		});
		btnPrimerci.setBounds(343, 281, 126, 76);
		panel.add(btnPrimerci);
		
		JButton btnZanrovi = new JButton("ZANROVI");
		btnZanrovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZanroviWindow frame = new ZanroviWindow();
				frame.setVisible(true);
			}
		});
		btnZanrovi.setBounds(583, 281, 126, 76);
		panel.add(btnZanrovi);
		
		JButton btnTipClanarine = new JButton("TIP CLANARINE");
		btnTipClanarine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClanarineWindow frame = new ClanarineWindow();
				frame.setVisible(true);
			}
		});
		btnTipClanarine.setBounds(583, 149, 126, 76);
		panel.add(btnTipClanarine);
		
		JButton izdaja = new JButton("IZDAVANJE");
		izdaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(getTitle().equals("Admin panel")) {
					JOptionPane.showMessageDialog(null, "Nemate dozvolu");
				}else {
					iznajmljivanjeWindow frame = new iznajmljivanjeWindow();
					frame.setVisible(true);
				};
			
			}
		});
		izdaja.setBounds(343, 414, 126, 76);
		panel.add(izdaja);
		
		
		JButton login = new JButton("Log in");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTitle().equals("Admin panel") || getTitle().equals("Bibliotekar panel")) {
					JOptionPane.showMessageDialog(null, "Vec ste ulogovani");
					login.setBackground(Color.RED);
				}else {
					login frame = new login();
					frame.setVisible(true);
					setVisible(false);
				};
			}
		});
		login.setBackground(new Color(204, 255, 153));
		login.setBounds(635, 499, 110, 37);
		panel.add(login);

		

	}
}
