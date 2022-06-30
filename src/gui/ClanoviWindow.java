package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import ljudi.Admin;
import ljudi.Clan;
import ljudi.Pol;
import ljudi.TipClanarine;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClanoviWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField ime;
	private JTextField prezime;
	private JTextField jmbg;
	private JTextField brojClKarte;
	private JTextField tipClanarine;
	private JTextField brojMeseci;
	private JTextField datumUplate;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClanoviWindow frame = new ClanoviWindow();
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
	private JTextField adresaa;
	private JTextField pol;
	public ClanoviWindow() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 849, 519);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id.setText((String) model.getValueAt(i,0));
				ime.setText((String) model.getValueAt(i,1));
				prezime.setText((String) model.getValueAt(i,2));
				adresaa.setText((String) model.getValueAt(i,3));
				jmbg.setText((String) model.getValueAt(i,4));
				String poli = "";
				if(model.getValueAt(i,5) == Pol.valueOf("MUSKI")) {
					poli = "MUSKI";
				}else {
					poli = "ZENSKI";
				};
				pol.setText(poli);
				brojClKarte.setText((String) model.getValueAt(i, 6));
				tipClanarine.setText((String) model.getValueAt(i,7));
				datumUplate.setText ("" + (model.getValueAt(i, 8)));
				brojMeseci.setText("" + model.getValueAt(i,9));
				

			}
		});
		table.setBackground(new Color(255, 255, 204));
		table.setBounds(10, 11, 552, 340);
		model = new DefaultTableModel();
		Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","BROJ CL KARTE","TIP CLANARINE","DATUM UPLATE", "MESECI CLAN","AKTIVAN"};
		Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajClanove();
        for(Clan clan : biblioteka.getClanovi()) {
        	
        	row[0] = clan.getId();
        	row[1] = clan.getIme();
        	row[2] = clan.getPrezime();
        	row[3] = clan.getAdresa();
        	row[4] = clan.getJMBG();
        	row[5] = clan.getPolovi();
        	row[6] = clan.getBrojClanskeKarte();
        	row[7] = clan.getTip();
        	row[8] = clan.getDatumUplate();
        	row[9] = clan.getBrojMeseci();
        	row[10] = clan.isAktivnost();
            model.addRow(row);
		}
		table.setModel(model);
		panel.add(table);
		
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(586, 24, 46, 14);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(661, 24, 178, 20);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajClanove();
			      File temp = new File("src/fajlovi/clanovi1.txt");
			      File existing = new File("src/fajlovi/clanovi.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(Clan admin1 : biblioteka.getClanovi()) {
			        	if(admin1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Clan admin = new Clan( admin1.getId() , admin1.getIme() , admin1.getPrezime() , admin1.getAdresa() , admin1.getJMBG() , admin1.getPolovi() , admin1.getBrojClanskeKarte() , admin1.getTip() , admin1.getDatumUplate(),admin1.getBrojMeseci(),admin1.isAktivnost());
			                ArrayList<Clan> admini = new ArrayList<Clan>();
			                admini.add(admin);
			                biblioteka.setClanovi(admini);
			                biblioteka.snimiClanove("clanovi1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
			           
		           temp.renameTo(existing);
			}
		});
		btnNewButton.setBounds(639, 380, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String row0 = String.valueOf(id.getText());
				String row1 = String.valueOf(ime.getText());
				String row2 = String.valueOf(prezime.getText());
				String row3 = String.valueOf(adresaa.getText());
				String row4 = String.valueOf(jmbg.getText());
				Pol row5 = Pol.valueOf(pol.getText());
				String row6 = String.valueOf(brojClKarte.getText());
				String row7 = String.valueOf(tipClanarine.getText());
				LocalDate row8 = LocalDate.parse(datumUplate.getText());
				Integer row9 = Integer.parseInt(brojMeseci.getText());
				boolean row10 = true;
				biblioteka.ucitajTipClanarine();
				for(TipClanarine tipclan1 : biblioteka.getTipClanarine()) {
					if(row7.equals(tipclan1.getNaziv())) {
						Double cena = tipclan1.getCena();
						Integer meseci = row9;
						String popust = "";
						if(meseci == 6) {
							cena = (cena * 90) / 100;
							cena = cena * meseci;
							System.out.println(cena);
							popust = "10%";
							JOptionPane.showMessageDialog(null, "OSTVARILI STE " + popust + " POPUSTA, VAS RACUN IZNOSI " + cena);
							
						}else if(meseci == 12){
							cena = (cena * 80) / 100;
							cena = cena * meseci;
							popust = "20%";
							JOptionPane.showMessageDialog(null, "OSTVARILI STE " + popust + " POPUSTA, VAS RACUN IZNOSI " + cena);
						}
					}else {
						System.out.println("sledeci");
					}
	
				}
				
				
				Clan admin = new Clan(row0,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10);
		        ArrayList<Clan> admini = new ArrayList<Clan>();
		        admini.add(admin);
		        
		        biblioteka.setClanovi(admini);
		        biblioteka.snimiClanove("clanovi.txt",true);
		        JOptionPane.showMessageDialog(null, "Uspesno dodat korisnik,");
		        Object[] row = new Object[11];
		        row[0] = row0;
		        row[1] = row1;
		        row[2] = row2;
		        row[3] = row3;
		        row[4] = row4;
		        row[5] = row5;
		        row[6] = row6;
		        row[7] = row7;
		        row[8] = row8;
		        row[9] = row9;
		        row[10] = row10;
		        model.addRow(row);
		        
			}
		});
		btnNewButton_1.setBounds(750, 380, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajClanove();
			      File temp = new File("src/fajlovi/clanovi1.txt");
			      File existing = new File("src/fajlovi/clanovi.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(Clan admin1 : biblioteka.getClanovi()) {
			        	if(admin1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Clan admin = new Clan( admin1.getId() , admin1.getIme() , admin1.getPrezime() , admin1.getAdresa() , admin1.getJMBG() , admin1.getPolovi() , admin1.getBrojClanskeKarte() , admin1.getTip() , admin1.getDatumUplate(),admin1.getBrojMeseci(),admin1.isAktivnost());
			                ArrayList<Clan> admini = new ArrayList<Clan>();
			                admini.add(admin);
			                biblioteka.setClanovi(admini);
			                biblioteka.snimiClanove("clanovi1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
			           
		           temp.renameTo(existing);
					String row0 = String.valueOf(id.getText());
					String row1 = String.valueOf(ime.getText());
					String row2 = String.valueOf(prezime.getText());
					String row3 = String.valueOf(adresaa.getText());
					String row4 = String.valueOf(jmbg.getText());
					Pol row5 = Pol.valueOf(pol.getText());
					String row6 = String.valueOf(brojClKarte.getText());
					String row7 = String.valueOf(tipClanarine.getText());
					LocalDate row8 = LocalDate.parse(datumUplate.getText());
					Integer row9 = Integer.parseInt(brojMeseci.getText());
					boolean row10 = true;
					Clan admin = new Clan(row0,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10);
			        ArrayList<Clan> admini = new ArrayList<Clan>();
			        admini.add(admin);
			        biblioteka.setClanovi(admini);
			        biblioteka.snimiClanove("clanovi.txt",true);
			        Object[] row = new Object[11];
			        row[0] = row0;
			        row[1] = row1;
			        row[2] = row2;
			        row[3] = row3;
			        row[4] = row4;
			        row[5] = row5;
			        row[6] = row6;
			        row[7] = row7;
			        row[8] = row8;
			        row[9] = row9;
			        row[10] = admin.isAktivnost();
			        
			        model.addRow(row);
			}
		});
		btnNewButton_2.setBounds(639, 414, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ime");
		lblNewLabel_1.setBounds(586, 55, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezime");
		lblNewLabel_2.setBounds(586, 86, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Broj meseci");
		lblNewLabel_3.setBounds(586, 244, 71, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("JMBG");
		lblNewLabel_4.setBounds(586, 117, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Broj cl karte");
		lblNewLabel_5.setBounds(586, 149, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tip Clanarine");
		lblNewLabel_5_1.setBounds(586, 177, 71, 14);
		panel.add(lblNewLabel_5_1);
		
		ime = new JTextField();
		ime.setBounds(661, 55, 178, 20);
		panel.add(ime);
		ime.setColumns(10);
		
		prezime = new JTextField();
		prezime.setColumns(10);
		prezime.setBounds(661, 86, 178, 20);
		panel.add(prezime);
		
		jmbg = new JTextField();
		jmbg.setColumns(10);
		jmbg.setBounds(661, 117, 178, 20);
		panel.add(jmbg);
		
		brojClKarte = new JTextField();
		brojClKarte.setColumns(10);
		brojClKarte.setBounds(661, 149, 178, 20);
		panel.add(brojClKarte);
		
		tipClanarine = new JTextField();
		tipClanarine.setColumns(10);
		tipClanarine.setBounds(661, 177, 178, 20);
		panel.add(tipClanarine);
		
		brojMeseci = new JTextField();
		brojMeseci.setBounds(661, 244, 178, 20);
		panel.add(brojMeseci);
		brojMeseci.setColumns(10);
		
		datumUplate = new JTextField();
		datumUplate.setBounds(661, 208, 178, 20);
		panel.add(datumUplate);
		datumUplate.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Datum uplate");
		lblNewLabel_6.setBounds(586, 208, 71, 14);
		panel.add(lblNewLabel_6);
		
		JLabel adresa = new JLabel("Adresa");
		adresa.setBounds(586, 278, 46, 14);
		panel.add(adresa);
		
		adresaa = new JTextField();
		adresaa.setColumns(10);
		adresaa.setBounds(661, 275, 178, 20);
		panel.add(adresaa);
		
		JLabel lblPol = new JLabel("Pol");
		lblPol.setBounds(586, 308, 46, 14);
		panel.add(lblPol);
		
		pol = new JTextField();
		pol.setColumns(10);
		pol.setBounds(661, 306, 178, 20);
		panel.add(pol);
	}
}
