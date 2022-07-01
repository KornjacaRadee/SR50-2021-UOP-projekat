package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import knjige.Iznajmljivanje;
import knjige.Primerak;
import ljudi.Admin;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class iznajmljivanjeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField zaposleni;
	private JTextField clan;
	private JTextField datumIznajmljivanja;
	private JTextField datumVracanja;
	private JTextField naslovKnjige;
	private JTable table;
	DefaultTableModel model;
	DefaultTableModel modelo;
	DefaultTableModel modeloo;
	private JTable iznajmljeno;
	private JTable primerci;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iznajmljivanjeWindow frame = new iznajmljivanjeWindow();
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
	private JTable iznajmiti;
	public iznajmljivanjeWindow() {
		setTitle("Izdavanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 1014, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		zaposleni = new JTextField();
		zaposleni.setBounds(662, 35, 142, 20);
		panel.add(zaposleni);
		zaposleni.setColumns(10);
		
		clan = new JTextField();
		clan.setBounds(662, 103, 142, 20);
		panel.add(clan);
		clan.setColumns(10);
		
		datumIznajmljivanja = new JTextField();
		datumIznajmljivanja.setBounds(862, 35, 142, 20);
		panel.add(datumIznajmljivanja);
		datumIznajmljivanja.setColumns(10);
		
		datumVracanja = new JTextField();
		datumVracanja.setBounds(862, 105, 142, 20);
		panel.add(datumVracanja);
		datumVracanja.setColumns(10);
		
		naslovKnjige = new JTextField();
		naslovKnjige.setBounds(862, 187, 142, 20);
		panel.add(naslovKnjige);
		naslovKnjige.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Zaposleni");
		lblNewLabel.setBounds(662, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clan");
		lblNewLabel_1.setBounds(662, 80, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Datum iznajmljivanja");
		lblNewLabel_2.setBounds(867, 11, 137, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Datum vracanja");
		lblNewLabel_3.setBounds(862, 80, 111, 14);
		panel.add(lblNewLabel_3);
		
		JLabel dassdas = new JLabel("Naslov knjige");
		dassdas.setBounds(862, 164, 111, 14);
		panel.add(dassdas);
		
		JButton btnNewButton = new JButton("Iznajmi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sadrzaj = "";
				String zaposleni1 = zaposleni.getText();
				String clan1 = clan.getName();
				LocalDate datumIznajmljivanja1 = LocalDate.parse(datumIznajmljivanja.getText());
				LocalDate datumVracanja1 = LocalDate.parse(datumVracanja.getText());
				Integer redovi = iznajmiti.getRowCount();
				Integer i = 0;
				String sviPrimerki = "";
				System.out.println(sviPrimerki);
				while(i < redovi) {
					sviPrimerki += iznajmiti.getValueAt(i, 1) + ",";
					i += 1;
				}
				System.out.println(sviPrimerki);
				sadrzaj = zaposleni1 + "|" + clan1 + "|" + datumIznajmljivanja1 + "|" + datumVracanja1  + "|"+  redovi  + "|" + sviPrimerki + "\n";
				try {
					File korisniciFile = new File("src/fajlovi/iznajmljeno.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile,true));
					writer.write(sadrzaj);
					writer.close();
				}catch(IOException e1){
					System.out.println("Greska prilikom ucitavanja datoteke: " + e1.getMessage());
				}
				
				
				
			}
		});
		btnNewButton.setBounds(884, 266, 111, 49);
		panel.add(btnNewButton);
		
		iznajmljeno = new JTable();
		iznajmljeno.setBackground(new Color(255, 255, 204));
		iznajmljeno.setBounds(10, 31, 631, 167);
		panel.add(iznajmljeno);
		modeloo = new DefaultTableModel();
		Object[] column2 = {"ID","IME","PREZIME","ADRESA","JMBG","asdd"};
		modeloo.setColumnIdentifiers(column2); 
		Object[] row2 = new Object[8];
		biblioteka.ucitajIznajmljeno();
        for(Iznajmljivanje admin1 : biblioteka.getIznajmljivanje()) {
        	row2[0] = admin1.getZaposleni();
        	row2[1] = admin1.getClan();
        	row2[2] = admin1.getDatumIznajmljivanja();
        	row2[3] = admin1.getDatumVracanja();
        	row2[4] = admin1.getPrimerakk();
        	row2[5] = admin1.getNaslovKnjige();
        	System.out.println(row2[5]);
            modeloo.addRow(row2);
		}
		iznajmljeno.setModel(modeloo);
		panel.add(iznajmljeno);
		modeloo.setColumnIdentifiers(column2);
		
		
		
		
		primerci = new JTable();
		primerci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = primerci.getSelectedRow();
				Object[] row = new Object[2];
				row[0] = primerci.getValueAt(i, 0);
				row[1] = primerci.getValueAt(i,6);
				modelo.addRow(row);
				
				}
			
		});
		primerci.setFont(new Font("Tahoma", Font.PLAIN, 11));
		primerci.setBounds(10, 240, 631, 132);
		model = new DefaultTableModel();
		Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","ID"};
		Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajPrimerakKnjige();
		biblioteka.ucitajIznajmljeno();
		String sviId = "";
		 for(Iznajmljivanje admin1 : biblioteka.getIznajmljivanje()) {
			 sviId += admin1.getPrimerakk();
			}
		 String[] lineSplit = sviId.split("\\,");
		 System.out.println(lineSplit);
		
		 boolean skip = false;
        for(Primerak admin1 : biblioteka.getPrimerak()) {
        	row[0] = admin1.getKnjiga();
        	row[1] = admin1.getBrojStrana();
        	row[2] = admin1.getPovez();
        	row[3] = admin1.getGodinaStampanja();
        	row[4] = admin1.getJezikStampanja();
        	row[5] = admin1.isDostupnost();
        	row[6] = admin1.getId();
   		 for(int i = 0; i <= lineSplit.length - 1; i++) {
   			 String provera = lineSplit[i];
   			 System.out.println(provera);
   			 inner:
   			 if(provera.equals(admin1.getId())) {
   				 skip = true;
   				 break;
   			 }else {
   				 skip = false;
   			 }
   			 System.out.println(skip);
   			 }
   		 System.out.println("--------------------------------------------------");
   		 
   		 
        	if(skip == true) {
        		System.out.println("Skipped");
        		continue;
        	}else {
        		System.out.println(" Not Skipped");
        		model.addRow(row);
        	}
   		 }
            
		
		primerci.setRowSelectionAllowed(true);
		primerci.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		primerci.setModel(model);
		panel.add(primerci);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Iznajmljene");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 9, 111, 14);
		panel.add(lblNewLabel_5);
		
		JLabel dasd = new JLabel("Primerci");
		dasd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dasd.setBounds(10, 215, 85, 14);
		panel.add(dasd);
		
		iznajmiti = new JTable();
		iznajmiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = iznajmiti.getSelectedRow();
				System.out.println(iznajmiti.getValueAt(i, 0));
				modelo.removeRow(i);
			}
		});
		iznajmiti.setBounds(662, 152, 174, 68);
		modelo = new DefaultTableModel();
		Object[] columnn = {"ID","IME"};
		Object[] roww = new Object[2];
		modelo.setColumnIdentifiers(columnn);
		panel.add(iznajmiti);
		iznajmiti.setModel(modelo);
		
		JLabel Iznajmiti = new JLabel("Iznajmiti");
		Iznajmiti.setBounds(662, 134, 46, 14);
		panel.add(Iznajmiti);
		
		JButton vrati = new JButton("Vrati knjigu");
		vrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		vrati.setBounds(694, 266, 104, 49);
		panel.add(vrati);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		
		
	}
}
