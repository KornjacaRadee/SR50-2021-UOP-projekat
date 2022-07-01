package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import knjige.Biblioteka;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BibliotekaWindow extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField naziv;
	private JTextField adresa;
	private JTextField telefon;
	private JTextField vreme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliotekaWindow frame = new BibliotekaWindow();
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
	public BibliotekaWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		naziv = new JTextField();
		naziv.setColumns(10);
		naziv.setBounds(179, 47, 145, 25);
		panel.add(naziv);
		
		adresa = new JTextField();
		adresa.setColumns(10);
		adresa.setBounds(179, 83, 145, 25);
		panel.add(adresa);
		
		telefon = new JTextField();
		telefon.setColumns(10);
		telefon.setBounds(179, 119, 145, 25);
		panel.add(telefon);
		
		vreme = new JTextField();
		vreme.setColumns(10);
		vreme.setBounds(179, 155, 145, 25);
		panel.add(vreme);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		lblNewLabel.setBounds(58, 52, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresa");
		lblNewLabel_1.setBounds(58, 88, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Broj Telefona");
		lblNewLabel_2.setBounds(58, 124, 70, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Radno Vreme");
		lblNewLabel_3.setBounds(58, 160, 84, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Promeni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nazivv = naziv.getText();
				String adresaa = adresa.getText();
				String telefonn = telefon.getText();
				String vremee = vreme.getText();
				if(nazivv.equals("") || adresaa.equals("") || telefonn.equals("") || vremee.equals("")) {
					JOptionPane.showMessageDialog(null, "Pogresno uneti podatci");
				}else {
				String sadrzaj = nazivv + "|" + adresaa + "|" + telefonn + "|" + vremee + "|" + "\n";
				try {
					File korisniciFile = new File("src/fajlovi/biblioteka.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
					writer.write(sadrzaj);
					writer.close();
				}catch(IOException e1){
					System.out.println("Greska prilikom ucitavanja datoteke: " + e1.getMessage());
				}
				
			}
			}
		});
		btnNewButton.setBounds(235, 207, 89, 23);
		panel.add(btnNewButton);
	}
}
