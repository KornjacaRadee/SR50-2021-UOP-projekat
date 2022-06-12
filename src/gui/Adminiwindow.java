package gui;

import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import ljudi.Admin;
import ljudi.Pol;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Adminiwindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField ime;
	private JTextField prezime;
	private JTextField jmbg;
	private JTextField korisnickoIme;
	private JTextField sifra;
	private JTextField adresa;
	private JTextField polo;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminiwindow frame = new Adminiwindow();
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
	private JTextField plata;
	public Adminiwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 434, 317);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 227, 138);
		model = new DefaultTableModel();
		Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","KORISNICKO IME","SIFRA","PLATA"};
		Object[] row = new Object[9];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajAdmine();
        for(Admin admin1 : biblioteka.getAdmini()) {
        	row[0] = admin1.getId();
        	row[1] = admin1.getIme();
        	row[2] = admin1.getPrezime();
        	row[3] = admin1.getAdresa();
        	row[4] = admin1.getJMBG();
        	row[5] = admin1.getPolovi();
        	row[6] = admin1.getKorisnickoIme();
        	row[7] = admin1.getKorisnickaSifra();
        	row[8] = admin1.getPlata();
        	System.out.println(row[2]);
            model.addRow(row);
		}
		table.setModel(model);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(247, 24, 46, 14);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(328, 21, 86, 20);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(247, 55, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(247, 86, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresa");
		lblNewLabel_3.setBounds(247, 244, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JMBG");
		lblNewLabel_4.setBounds(247, 117, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Korisnicko ime");
		lblNewLabel_5.setBounds(247, 149, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Sifra");
		lblNewLabel_5_1.setBounds(247, 177, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		ime = new JTextField();
		ime.setBounds(328, 52, 86, 20);
		panel.add(ime);
		ime.setColumns(10);
		
		prezime = new JTextField();
		prezime.setColumns(10);
		prezime.setBounds(328, 83, 86, 20);
		panel.add(prezime);
		
		jmbg = new JTextField();
		jmbg.setColumns(10);
		jmbg.setBounds(328, 114, 86, 20);
		panel.add(jmbg);
		
		korisnickoIme = new JTextField();
		korisnickoIme.setColumns(10);
		korisnickoIme.setBounds(328, 146, 86, 20);
		panel.add(korisnickoIme);
		
		sifra = new JTextField();
		sifra.setColumns(10);
		sifra.setBounds(328, 174, 86, 20);
		panel.add(sifra);
		
		adresa = new JTextField();
		adresa.setBounds(328, 241, 86, 20);
		panel.add(adresa);
		adresa.setColumns(10);
		
		polo = new JTextField();
		polo.setBounds(328, 205, 86, 20);
		panel.add(polo);
		polo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Pol");
		lblNewLabel_6.setBounds(247, 208, 46, 14);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnNewButton.setBounds(119, 160, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String row0 = String.valueOf(id.getText());
				String row1 = String.valueOf(ime.getText());
				String row2 = String.valueOf(prezime.getText());
				String row3 = String.valueOf(adresa.getText());
				String row4 = String.valueOf(jmbg.getText());
				Pol row5 = Pol.valueOf(polo.getText());
				String row6 = String.valueOf(korisnickoIme.getText());
				String row7 = String.valueOf(sifra.getText());
				Double row8 = Double.valueOf(plata.getText());
				Admin admin = new Admin(row0,row1,row2,row3,row4,row5,row6,row7,row8);
		        ArrayList<Admin> admini = new ArrayList<Admin>();
		        admini.add(admin);
		        biblioteka.setAdmini(admini);
		        biblioteka.snimiAdmine();
		        JOptionPane.showMessageDialog(null, "Uspesno dodat admin");
		        
				
			}
			// Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","KORISNICKO IME","SIFRA","PLATA"};
		});
		btnNewButton_1.setBounds(10, 160, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.setBounds(10, 227, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel Labla = new JLabel("Plata");
		Labla.setBounds(247, 279, 46, 14);
		panel.add(Labla);
		
		plata = new JTextField();
		plata.setBounds(328, 276, 86, 20);
		panel.add(plata);
		plata.setColumns(10);
	}
	
	
	private void updateTable() {
		// TODO Auto-generated method stub
		
	}
}
