package gui;

import java.awt.BorderLayout;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
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
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Admini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 894, 385);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id.setText((String) model.getValueAt(i,0));
				ime.setText((String) model.getValueAt(i,1));
				prezime.setText((String) model.getValueAt(i,2));
				adresa.setText((String) model.getValueAt(i,3));
				jmbg.setText((String) model.getValueAt(i,4));
				String poli = "";
				if(model.getValueAt(i,5) == Pol.valueOf("MUSKI")) {
					poli = "MUSKI";
				}else {
					poli = "ZENSKI";
				};
				polo.setText(poli);
				korisnickoIme.setText((String) model.getValueAt(i, 6));
				sifra.setText((String) model.getValueAt(i,7));
				double temp = (double) model.getValueAt(i, 8);
				String temp1 = temp+"";
				plata.setText(temp1);
				
		// Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","KORISNICKO IME","SIFRA","PLATA"};
			}
		});
		table.setBounds(10, 11, 610, 355);
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
		lblNewLabel.setBounds(642, 20, 46, 14);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(723, 11, 161, 20);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(642, 51, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(642, 76, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresa");
		lblNewLabel_3.setBounds(642, 234, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JMBG");
		lblNewLabel_4.setBounds(642, 107, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Korisnicko ime");
		lblNewLabel_5.setBounds(642, 139, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Sifra");
		lblNewLabel_5_1.setBounds(642, 167, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		ime = new JTextField();
		ime.setBounds(723, 42, 161, 20);
		panel.add(ime);
		ime.setColumns(10);
		
		prezime = new JTextField();
		prezime.setColumns(10);
		prezime.setBounds(723, 73, 161, 20);
		panel.add(prezime);
		
		jmbg = new JTextField();
		jmbg.setColumns(10);
		jmbg.setBounds(723, 104, 161, 20);
		panel.add(jmbg);
		
		korisnickoIme = new JTextField();
		korisnickoIme.setColumns(10);
		korisnickoIme.setBounds(723, 136, 161, 20);
		panel.add(korisnickoIme);
		
		sifra = new JTextField();
		sifra.setColumns(10);
		sifra.setBounds(723, 164, 161, 20);
		panel.add(sifra);
		
		adresa = new JTextField();
		adresa.setBounds(723, 231, 161, 20);
		panel.add(adresa);
		adresa.setColumns(10);
		
		polo = new JTextField();
		polo.setBounds(723, 195, 161, 20);
		panel.add(polo);
		polo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Pol");
		lblNewLabel_6.setBounds(642, 198, 46, 14);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/admini1.txt");
			      File existing = new File("fajlovi/admini.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(Admin admin1 : biblioteka.getAdmini()) {
			        	if(admin1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Admin admin = new Admin( admin1.getId() , admin1.getIme() , admin1.getPrezime() , admin1.getAdresa() , admin1.getJMBG() , admin1.getPolovi() , admin1.getKorisnickoIme() , admin1.getKorisnickaSifra() , admin1.getPlata());
			                ArrayList<Admin> admini = new ArrayList<Admin>();
			                admini.add(admin);
			                biblioteka.setAdmini(admini);
			                biblioteka.snimiAdmine("admini1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
			           
		           temp.renameTo(existing);
				
			}
		});
		btnNewButton.setBounds(696, 297, 89, 23);
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
		        biblioteka.snimiAdmine("admini.txt",true);
		        JOptionPane.showMessageDialog(null, "Uspesno dodat admin");
		        int rowCount = table.getRowCount();
		      for (int i = rowCount - 1; i >= 0; i--) {
		          model.removeRow(i);
		      }
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
		        
				
			}
			// Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","KORISNICKO IME","SIFRA","PLATA"};
		});
		btnNewButton_1.setBounds(795, 297, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/admini1.txt");
			      File existing = new File("fajlovi/admini.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(Admin admin1 : biblioteka.getAdmini()) {
			        	if(admin1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Admin admin = new Admin( admin1.getId() , admin1.getIme() , admin1.getPrezime() , admin1.getAdresa() , admin1.getJMBG() , admin1.getPolovi() , admin1.getKorisnickoIme() , admin1.getKorisnickaSifra() , admin1.getPlata());
			                ArrayList<Admin> admini = new ArrayList<Admin>();
			                admini.add(admin);
			                biblioteka.setAdmini(admini);
			                biblioteka.snimiAdmine("admini1.txt",true);
			                brojac += 1;
			            } else {

			                brojac += 1;
						};
				        
			            
		               
			        }
			       System.out.println(existing.delete());
		           temp.renameTo(existing);
		           
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
			        ArrayList<Admin> admini1 = new ArrayList<Admin>();
			        admini1.add(admin);
			        biblioteka.setAdmini(admini1);
			        biblioteka.snimiAdmine("admini.txt",true);
			        
			        
			        int rowCount = table.getRowCount();
				      for (int a = rowCount-1; a >= 0; a--) {
				          model.removeRow(a);
				      }
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
				        
						
					}
			        
				
			
				
			
		});
		btnNewButton_2.setBounds(696, 343, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel Labla = new JLabel("Plata");
		Labla.setBounds(642, 269, 46, 14);
		panel.add(Labla);
		
		plata = new JTextField();
		plata.setBounds(723, 266, 161, 20);
		panel.add(plata);
		plata.setColumns(10);
		

	}
	
	
	private void updateTable() {
		// TODO Auto-generated method stub
		
	}
}
