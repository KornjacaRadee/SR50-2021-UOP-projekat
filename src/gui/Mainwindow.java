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
		btnNewButton.setBounds(86, 149, 126, 76);
		panel.add(btnNewButton);
		
		JButton btnBibliotekari = new JButton("BIBLIOTEKARI");
		btnBibliotekari.setBounds(86, 281, 126, 76);
		panel.add(btnBibliotekari);
		
		JButton btnClanovi = new JButton("CLANOVI");
		btnClanovi.setBounds(86, 414, 126, 76);
		panel.add(btnClanovi);
		
		JButton btnKnjige = new JButton("KNJIGE");
		btnKnjige.setBounds(343, 149, 126, 76);
		panel.add(btnKnjige);
		
		JButton btnPrimerci = new JButton("PRIMERCI");
		btnPrimerci.setBounds(343, 281, 126, 76);
		panel.add(btnPrimerci);
		
		JButton btnZanrovi = new JButton("ZANROVI");
		btnZanrovi.setBounds(583, 281, 126, 76);
		panel.add(btnZanrovi);
		
		JButton btnTipClanarine = new JButton("TIP CLANARINE");
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

	}
}
