package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import knjige.Biblioteka;
import knjige.ZanrKnjige;
import ljudi.TipClanarine;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZanroviWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ide;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZanroviWindow frame = new ZanroviWindow();
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
	private JTextField opiso;
	public ZanroviWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 599, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				ide.setText((String) model.getValueAt(i,0));
				opiso.setText((String) model.getValueAt(i,1));
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"OZNAKA","OPIS"};
		Object[] row = new Object[2];
		model.setColumnIdentifiers(column);
		biblioteka.ucitajZanrove();
        for(ZanrKnjige zanr : biblioteka.getZanrovi()) {
        	row[0] = zanr.getOznaka();
        	row[1] = zanr.getOpis();
            model.addRow(row);
            System.out.println(row[0]);
        }		
		
		table.setBounds(10, 11, 227, 138);
		
		
		table.setModel(model);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Oznaka");
		lblNewLabel.setBounds(275, 24, 71, 14);
		panel.add(lblNewLabel);
		
		ide = new JTextField();
		ide.setBounds(335, 21, 169, 20);
		panel.add(ide);
		ide.setColumns(10);
		
		JButton btnNewButton = new JButton("Ukloni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				int brojac = 0;
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/zanrovi1.txt");
			      File existing = new File("fajlovi/zanrovi.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(ZanrKnjige clan : biblioteka.getZanrovi()) {
			        	if(clan == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			        		ZanrKnjige admin = new ZanrKnjige(clan.getOznaka(),clan.getOpis());
					        ArrayList<ZanrKnjige> admini1 = new ArrayList<ZanrKnjige>();
					        admini1.add(admin);
					        biblioteka.setZanrovi(admini1);
					        biblioteka.snimiZanr(true,"zanrovi1.txt");
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
			       System.out.println(existing.delete());
		           temp.renameTo(existing);
				
			}
			
		});
		btnNewButton.setBounds(119, 160, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String row0 = String.valueOf(ide.getText());
				String row1 = String.valueOf(opiso.getText());
				ZanrKnjige admin = new ZanrKnjige(row0,row1);
		        ArrayList<ZanrKnjige> admini1 = new ArrayList<ZanrKnjige>();
		        admini1.add(admin);
		        biblioteka.setZanrovi(admini1);
		        row[0] = row0;
		        row[1] = row1;
		        model.addRow(row);
		        biblioteka.snimiZanr(true,"zanrovi.txt");
				
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
			      biblioteka.ucitajAdmine();
			      File temp = new File("fajlovi/zanrovi1.txt");
			      File existing = new File("fajlovi/zanrovi.txt");
			      temp.delete();
			      try {
					temp.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			        for(ZanrKnjige clan : biblioteka.getZanrovi()) {
			        	if(clan == null) {
			        		break;
			        	}
			        	else if(brojac != i) {
			        		ZanrKnjige admin = new ZanrKnjige(clan.getOznaka(),clan.getOpis());
					        ArrayList<ZanrKnjige> admini1 = new ArrayList<ZanrKnjige>();
					        admini1.add(admin);
					        biblioteka.setZanrovi(admini1);
					        biblioteka.snimiZanr(true,"zanrovi1.txt");
			                brojac += 1;
			            } else {
						};
			            
		               
			        }
		            String row0 = String.valueOf(ide.getText());
					String row1 = String.valueOf(opiso.getText());
					ZanrKnjige admin = new ZanrKnjige(row0,row1);
			        ArrayList<ZanrKnjige> admini1 = new ArrayList<ZanrKnjige>();
			        admini1.add(admin);
			        biblioteka.setZanrovi(admini1);
			        biblioteka.snimiZanr(true,"zanrovi1.txt");
			        
			       System.out.println(existing.delete());
		           temp.renameTo(existing);
		           
			        
			        int rowCount = table.getRowCount();
				      for (int a = rowCount-1; a >= 0; a--) {
				          model.removeRow(a);
				      }
				      biblioteka.ucitajZanrove();
				        for(ZanrKnjige admin1 : biblioteka.getZanrovi()) {
				        	row[0] = admin1.getOznaka();
				        	row[1] = admin1.getOpis();
				            model.addRow(row);
				        }

			}
			
		});
		btnNewButton_2.setBounds(10, 204, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Opis");
		lblNewLabel_1.setBounds(275, 68, 71, 14);
		panel.add(lblNewLabel_1);
		
		opiso = new JTextField();
		opiso.setBounds(335, 65, 169, 20);
		panel.add(opiso);
		opiso.setColumns(10);
	}
}
