package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import knjige.Knjiga;
import knjige.ZanrKnjige;
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
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class KnjigeWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField naslov;
	private JTextField orgNaslov;
	private JTextField pisac;
	private JTextField godinaIzdavanja;
	private JTextField jezik;
	private JTextField zanr;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnjigeWindow frame = new KnjigeWindow();
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
	private JTextField opisoa;
	private final Action action = new SwingAction();
	public KnjigeWindow() {
		setTitle("Knjige");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(-10, 11, 1003, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id.setText((String) model.getValueAt(i,0));
				naslov.setText((String) model.getValueAt(i,1));
				orgNaslov.setText((String) model.getValueAt(i,2));
				pisac.setText((String) model.getValueAt(i,3));
				godinaIzdavanja.setText(String.valueOf(model.getValueAt(i,4)));
				jezik.setText((String) model.getValueAt(i,5));
				opisoa.setText((String) model.getValueAt(i,6));
				zanr.setText((String) model.getValueAt(i,7));
			}
		});
		table.setBounds(10, 11, 657, 396);
		panel.add(table);
		model = new DefaultTableModel();
		Object[] column = {"ID","NASLOV","PREZIME","ADRESA","JMBG","POL","KORISNICKO IME","DAS"};
		Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajKnjige();
		for(Knjiga knjiga2 : biblioteka.getKnjiga()) {
        	row[0] = knjiga2.getId();
        	row[1] = knjiga2.getNaslov();
        	row[2] = knjiga2.getOrgNaslov();
        	row[3] = knjiga2.getPisac();
        	row[4] = knjiga2.getGodinaIzdavanja();
        	row[5] = knjiga2.getJezik();
        	row[6] = knjiga2.getOpis();
        	row[7] = knjiga2.getZanr();
        	model.addRow(row);
		}
		
		
		table.setModel(model);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(716, 14, 46, 14);
		panel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(797, 11, 184, 20);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      File temp = new File("src/fajlovi/knjige1.txt");
			      File existing = new File("src/fajlovi/knjige.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        biblioteka.ucitajKnjige();
			        for(Knjiga knjiga1 : biblioteka.getKnjiga()) {
			        	if(knjiga1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Knjiga admin = new Knjiga( knjiga1.getId() , knjiga1.getNaslov() , knjiga1.getOrgNaslov() , knjiga1.getPisac() , knjiga1.getGodinaIzdavanja() , knjiga1.getJezik() , knjiga1.getOpis(),knjiga1.getZanr());
			                ArrayList<Knjiga> admini = new ArrayList<Knjiga>();
			                admini.add(admin);
			                biblioteka.setKnjiga(admini);
			                biblioteka.snimiKnjige("knjige1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			        System.out.println(existing.delete());
			        temp.renameTo(existing);
			           
				
			}
		});
			
		btnNewButton.setBounds(892, 359, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String row0 = String.valueOf(id.getText());
				String row1 = String.valueOf(naslov.getText());
				String row2 = String.valueOf(orgNaslov.getText());
				String row3 = String.valueOf(pisac.getText());
				Integer row4 = Integer.valueOf(godinaIzdavanja.getText());
				String row5 = String.valueOf(jezik.getText());
				String row6 = String.valueOf(opisoa.getText());
				String row7 = String.valueOf(zanr.getText());
				
				
				
				Knjiga admin = new Knjiga(row0,row1,row2,row3,row4,row5,row6,row7);
		        ArrayList<Knjiga> admini = new ArrayList<Knjiga>();
		        admini.add(admin);
		        biblioteka.setKnjiga(admini);
		        biblioteka.snimiKnjige("knjige.txt",true);
		        JOptionPane.showMessageDialog(null, "Uspesno dodata knjiga");
		        Object[] row321 = new Object[8];
		        
		        row321[0] = row0;
		        row321[1] = row1;
		        row321[2] = row2;
		        row321[3] = row3;
		        row321[4] = row4;
		        row321[5] = row5;
		        row321[6] = row6;
		        row321[7] = row7;
		        
		        	System.out.println(row[2]);
		            model.addRow(row321);
				
			
				
			}});
		btnNewButton_1.setBounds(793, 415, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			private JComboBox zanrovi;

			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      File temp = new File("src/fajlovi/knjige1.txt");
			      File existing = new File("src/fajlovi/knjige.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        biblioteka.ucitajKnjige();
			        for(Knjiga knjiga1 : biblioteka.getKnjiga()) {
			        	if(knjiga1 == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	Knjiga admin = new Knjiga( knjiga1.getId() , knjiga1.getNaslov() , knjiga1.getOrgNaslov() , knjiga1.getPisac() , knjiga1.getGodinaIzdavanja() , knjiga1.getJezik() , knjiga1.getOpis(),knjiga1.getZanr());
			                ArrayList<Knjiga> admini = new ArrayList<Knjiga>();
			                admini.add(admin);
			                biblioteka.setKnjiga(admini);
			                biblioteka.snimiKnjige("knjige1.txt",true);
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			        System.out.println(existing.delete());
			        temp.renameTo(existing);
			        
			        String row0 = String.valueOf(id.getText());
					String row1 = String.valueOf(naslov.getText());
					String row2 = String.valueOf(orgNaslov.getText());
					String row3 = String.valueOf(pisac.getText());
					Integer row4 = Integer.valueOf(godinaIzdavanja.getText());
					String row5 = String.valueOf(jezik.getText());
					String row6 = String.valueOf(opisoa.getText());
					String row7 = String.valueOf(zanrovi.getSelectedItem());
					
					
					
					Knjiga admin = new Knjiga(row0,row1,row2,row3,row4,row5,row6,row7);
			        ArrayList<Knjiga> admini = new ArrayList<Knjiga>();
			        admini.add(admin);
			        biblioteka.setKnjiga(admini);
			        biblioteka.snimiKnjige("knjige.txt",true);
			        
			        int rowCount = table.getRowCount();
			        while (table.getRowCount() > 0) {
			        	model.removeRow(0);
			        }
			        biblioteka.ucitajKnjige();
					for(Knjiga knjiga2 : biblioteka.getKnjiga()) {
			        	row[0] = knjiga2.getId();
			        	row[1] = knjiga2.getNaslov();
			        	row[2] = knjiga2.getOrgNaslov();
			        	row[3] = knjiga2.getPisac();
			        	row[4] = knjiga2.getGodinaIzdavanja();
			        	row[5] = knjiga2.getJezik();
			        	row[6] = knjiga2.getOpis();
			        	row[7] = knjiga2.getZanr();
			        	model.addRow(row);
					}
			        
				
			}
				
			
		});
		btnNewButton_2.setBounds(793, 359, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Naslov");
		lblNewLabel_1.setBounds(716, 45, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Org Naslov");
		lblNewLabel_2.setBounds(716, 76, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Pisac");
		lblNewLabel_4.setBounds(716, 107, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Godina izdavanja");
		lblNewLabel_5.setBounds(716, 139, 71, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Jezik");
		lblNewLabel_5_1.setBounds(716, 167, 46, 14);
		panel.add(lblNewLabel_5_1);
		
		naslov = new JTextField();
		naslov.setBounds(797, 42, 184, 20);
		panel.add(naslov);
		naslov.setColumns(10);
		
		orgNaslov = new JTextField();
		orgNaslov.setColumns(10);
		orgNaslov.setBounds(797, 73, 184, 20);
		panel.add(orgNaslov);
		
		pisac = new JTextField();
		pisac.setColumns(10);
		pisac.setBounds(797, 104, 184, 20);
		panel.add(pisac);
		
		godinaIzdavanja = new JTextField();
		godinaIzdavanja.setColumns(10);
		godinaIzdavanja.setBounds(797, 136, 184, 20);
		panel.add(godinaIzdavanja);
		
		jezik = new JTextField();
		jezik.setColumns(10);
		jezik.setBounds(797, 164, 184, 20);
		panel.add(jezik);
		
		JLabel lblNewLabel_6 = new JLabel("Opis");
		lblNewLabel_6.setBounds(716, 231, 46, 14);
		panel.add(lblNewLabel_6);
		
		zanr = new JTextField();
		zanr.setBounds(797, 195, 184, 20);
		panel.add(zanr);
		zanr.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Zanr");
		lblNewLabel_3.setBounds(716, 198, 46, 14);
		panel.add(lblNewLabel_3);
		
		opisoa = new JTextField();
		opisoa.setBounds(797, 231, 184, 23);
		panel.add(opisoa);
		opisoa.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox zanrovi = new JComboBox();
		List<String> zanr = new ArrayList<String>();
		 biblioteka.ucitajZanrove();
		 for(ZanrKnjige zanr1 : biblioteka.getZanrovi()) {
			 zanrovi.addItem(zanr1.getOznaka());
		 }
		 
		 
		zanrovi.setBounds(797, 275, 184, 22);
		panel.add(zanrovi);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
