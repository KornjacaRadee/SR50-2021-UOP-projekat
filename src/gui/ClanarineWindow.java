package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ljudi.Admin;
import ljudi.Clan;
import ljudi.Pol;
import knjige.Biblioteka;
import ljudi.TipClanarine;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClanarineWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ide;
	private JTextField naziv;
	private JTextField cena;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	Biblioteka biblioteka = new Biblioteka();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClanarineWindow frame = new ClanarineWindow();
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
	public ClanarineWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 480, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				ide.setText((String) model.getValueAt(i,0));
				naziv.setText((String) model.getValueAt(i,1));
				double temp = (double) model.getValueAt(i, 2);
				String temp1 = temp+"";
				cena.setText(temp1);
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"ID","NAZIV","CENA"};
		Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajTipClanarine();
        for(TipClanarine admin1 : biblioteka.getTipClanarine()) {
        	row[0] = admin1.getId();
        	row[1] = admin1.getNaziv();
        	row[2] = admin1.getCena();
        	System.out.println(row[2]);
            model.addRow(row);
        }
        model.addColumn(row);
		table.setBounds(10, 11, 227, 162);
		table.setModel(model);
		panel.add(table);
		
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(247, 24, 46, 14);
		panel.add(lblNewLabel);
		
		ide = new JTextField();
		ide.setBounds(328, 21, 142, 20);
		panel.add(ide);
		ide.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/tipClanarine.txt");
			      File existing = new File("fajlovi/tipClan.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(TipClanarine clan : biblioteka.getTipClanarine()) {
			        	if(clan == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	TipClanarine admin = new TipClanarine( clan.getId() , clan.getNaziv() , Double.valueOf(clan.getCena()));
			                ArrayList<TipClanarine> admini = new ArrayList<TipClanarine>();
			                admini.add(admin);
			                biblioteka.setTipClanarine(admini);
			                biblioteka.snimiTipClanarine(true,"tipClanarine.txt");
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
		           temp.renameTo(existing);
				
			}
			
		});
		btnNewButton.setBounds(381, 114, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/tipClanarine.txt");
			      File existing = new File("fajlovi/tipClan.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(TipClanarine clan : biblioteka.getTipClanarine()) {
			        	if(clan == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			            	TipClanarine admin = new TipClanarine( clan.getId() , clan.getNaziv() , Double.valueOf(clan.getCena()));
			                ArrayList<TipClanarine> admini = new ArrayList<TipClanarine>();
			                admini.add(admin);
			                biblioteka.setTipClanarine(admini);
			                biblioteka.snimiTipClanarine(true,"tipClanarine.txt");
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
		           temp.renameTo(existing);
		           
				
			}
		});
		btnNewButton_1.setBounds(275, 114, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Azuriraj");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/tipClanarine.txt");
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
		           
		           String row0 = String.valueOf(ide.getText());
					String row1 = String.valueOf(naziv.getText());
					Double row8 = Double.valueOf(cena.getText());
					TipClanarine admin = new TipClanarine(row0,row1,row8);
			        ArrayList<TipClanarine> admini1 = new ArrayList<TipClanarine>();
			        admini1.add(admin);
			        biblioteka.setTipClanarine(admini1);
			        biblioteka.snimiTipClanarine(true,"tipClan.txt");
			        
			        int rowCount = table.getRowCount();
				      for (int a = rowCount-1; a >= 0; a--) {
				          model.removeRow(a);
				      }
				      biblioteka.ucitajTipClanarine();
				        for(TipClanarine admin1 : biblioteka.getTipClanarine()) {
				        	row[0] = admin1.getId();
				        	row[1] = admin1.getNaziv();
				        	row[2] = admin1.getCena();
				        	System.out.println(row[2]);
				            model.addRow(row);
				        }
				      
				
			}
		});
		btnNewButton_2.setBounds(381, 148, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Naziv");
		lblNewLabel_1.setBounds(247, 55, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cena");
		lblNewLabel_2.setBounds(247, 86, 71, 14);
		panel.add(lblNewLabel_2);
		
		naziv = new JTextField();
		naziv.setBounds(328, 52, 142, 20);
		panel.add(naziv);
		naziv.setColumns(10);
		
		cena = new JTextField();
		cena.setColumns(10);
		cena.setBounds(328, 83, 142, 20);
		panel.add(cena);
	}
}
