package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import knjige.Povez;
import knjige.Primerak;
import ljudi.Admin;
import ljudi.Pol;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PrimerakWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField knjiga;
	private JTextField brojStrana;
	private JTextField povez;
	private JTextField godinaStampanja;
	private JTextField jezik;
	private JTextField dostupnost;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	Biblioteka biblioteka = new Biblioteka();
	private JTextField ide;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimerakWindow frame = new PrimerakWindow();
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
	public PrimerakWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 720, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				knjiga.setText((String) model.getValueAt(i,0));
				brojStrana.setText(String.valueOf(model.getValueAt(i,1)));
				String poli = "greska";
				if(model.getValueAt(i,2) == Pol.valueOf("MUSKI")) {
					poli = "MEK";
				}else {
					poli = "TVRD";
				};
				povez.setText(poli);
				godinaStampanja.setText(String.valueOf(model.getValueAt(i,3)));
				jezik.setText((String) model.getValueAt(i,4));
				String dostupno = "";
				if ((Boolean) model.getValueAt(i,5) == true) {
					dostupno = "DA";
				}else {
					dostupno = "NE";
				}
				dostupnost.setText(dostupno);
				ide.setText((String) model.getValueAt(i, 6));
			}
		});
		table.setBounds(10, 14, 464, 138);
		model = new DefaultTableModel();
		Object[] column = {"ID","IME","PREZIME","ADRESA","JMBG","POL","ID"};
		Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajPrimerakKnjige();
        for(Primerak admin1 : biblioteka.getPrimerak()) {
        	row[0] = admin1.getKnjiga();
        	row[1] = admin1.getBrojStrana();
        	row[2] = admin1.getPovez();
        	row[3] = admin1.getGodinaStampanja();
        	row[4] = admin1.getJezikStampanja();
        	row[5] = admin1.isDostupnost();
        	row[6] = admin1.getId();
            model.addRow(row);
		}
		table.setModel(model);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Knjiga");
		lblNewLabel.setBounds(519, 14, 46, 14);
		panel.add(lblNewLabel);
		
		knjiga = new JTextField();
		knjiga.setBounds(600, 11, 86, 20);
		panel.add(knjiga);
		knjiga.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajPrimerakKnjige();
			      File temp = new File("src/fajlovi/primerci1.txt");
			      File existing = new File("src/fajlovi/primerci.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(Primerak admin1 : biblioteka.getPrimerak()) {
			        	if(admin1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Primerak admin = new Primerak( admin1.getKnjiga() , admin1.getBrojStrana() , admin1.getPovez() , admin1.getGodinaStampanja() , admin1.getJezikStampanja() , admin1.isDostupnost(),admin1.getId());
			                ArrayList<Primerak> admini = new ArrayList<Primerak>();
			                admini.add(admin);
			                biblioteka.setPrimerak(admini);
			                biblioteka.snimiPrimerke("primerci1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
			           
			       System.out.println(temp.renameTo(existing));
			       
			       
			}
		});
				
			
		btnNewButton.setBounds(119, 160, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String row0 = String.valueOf(knjiga.getText());
				Integer row1 = Integer.valueOf(brojStrana.getText());
				Povez row2 = Povez.valueOf(povez.getText());
				Integer row3 = Integer.valueOf(godinaStampanja.getText());
				String row4 = String.valueOf(jezik.getText());
				Boolean dostupan = false;
				String row6 = String.valueOf(ide.getText());
				if(String.valueOf(dostupnost.getText()) == "DA") {
					dostupan = true;
				}else {
					
				}
				Boolean row5 = dostupan;
				Primerak admin = new Primerak(row0,row1,row2,row3,row4,row5,row6);
		        ArrayList<Primerak> admini = new ArrayList<Primerak>();
		        admini.add(admin);
		        biblioteka.setPrimerak(admini);
		        biblioteka.snimiPrimerke("primerci.txt",true);
		        JOptionPane.showMessageDialog(null, "Uspesno dodat admin");
		        Object[] row = new Object[7];
		        row[0] = row0;
		        row[1] = row1;
		        row[2] = row2;
		        row[3] = row3;
		        row[4] = row4;
		        row[5] = row5;
		        model.addRow(row);
			}
		});
		btnNewButton_1.setBounds(10, 160, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajPrimerakKnjige();
			      File temp = new File("src/fajlovi/primerci1.txt");
			      File existing = new File("src/fajlovi/primerci.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(Primerak admin1 : biblioteka.getPrimerak()) {
			        	if(admin1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Primerak admin = new Primerak( admin1.getKnjiga() , admin1.getBrojStrana() , admin1.getPovez() , admin1.getGodinaStampanja() , admin1.getJezikStampanja() , admin1.isDostupnost(),admin1.getId());
			                ArrayList<Primerak> admini = new ArrayList<Primerak>();
			                admini.add(admin);
			                biblioteka.setPrimerak(admini);
			                biblioteka.snimiPrimerke("primerci1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
			           
			       System.out.println(temp.renameTo(existing));
				
			       String row0 = String.valueOf(knjiga.getText());
					Integer row1 = Integer.valueOf(brojStrana.getText());
					Povez row2 = Povez.valueOf(povez.getText());
					Integer row3 = Integer.valueOf(godinaStampanja.getText());
					String row4 = String.valueOf(jezik.getText());
					Boolean dostupan = false;
					String row6 = String.valueOf(ide.getText());
					if(String.valueOf(dostupnost.getText()) == "DA") {
						dostupan = true;
					}else {
						
					}
					Boolean row5 = dostupan;
					Primerak admin = new Primerak(row0,row1,row2,row3,row4,row5,row6);
			        ArrayList<Primerak> admini = new ArrayList<Primerak>();
			        admini.add(admin);
			        biblioteka.setPrimerak(admini);
			        biblioteka.snimiPrimerke("primerci.txt",true);
			        
			        Object[] row = new Object[7];
			        row[0] = row0;
			        row[1] = row1;
			        row[2] = row2;
			        row[3] = row3;
			        row[4] = row4;
			        row[5] = row5;
			        row[6] = row6;
 			        model.addRow(row);
			}
				
		});
		btnNewButton_2.setBounds(243, 163, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Broj strana");
		lblNewLabel_1.setBounds(519, 45, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Povez");
		lblNewLabel_2.setBounds(519, 76, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Godina Stampanja");
		lblNewLabel_4.setBounds(519, 107, 71, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("Jezik");
		lblNewLabel_5_1.setBounds(519, 135, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		brojStrana = new JTextField();
		brojStrana.setBounds(600, 42, 86, 20);
		panel.add(brojStrana);
		brojStrana.setColumns(10);
		
		povez = new JTextField();
		povez.setColumns(10);
		povez.setBounds(600, 73, 86, 20);
		panel.add(povez);
		
		godinaStampanja = new JTextField();
		godinaStampanja.setColumns(10);
		godinaStampanja.setBounds(600, 104, 86, 20);
		panel.add(godinaStampanja);
		
		jezik = new JTextField();
		jezik.setColumns(10);
		jezik.setBounds(600, 132, 86, 20);
		panel.add(jezik);
		
		dostupnost = new JTextField();
		dostupnost.setBounds(600, 163, 86, 20);
		panel.add(dostupnost);
		dostupnost.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dostupnost");
		lblNewLabel_3.setBounds(519, 166, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Id");
		lblNewLabel_5.setBounds(521, 199, 46, 14);
		panel.add(lblNewLabel_5);
		
		ide = new JTextField();
		ide.setColumns(10);
		ide.setBounds(600, 196, 86, 20);
		panel.add(ide);
	}
}
