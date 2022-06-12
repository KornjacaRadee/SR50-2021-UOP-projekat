package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ljudi.Admin;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class iznajmljivanjeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField zaposleni;
	private JTextField clan;
	private JTextField datumIznajmljivanja;
	private JTextField primerak;
	private JTextField datumVracanja;
	private JTextField naslovKnjige;
	private JTable table;
	DefaultTableModel model;
	private JTable table_1;
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
	public iznajmljivanjeWindow() {
		setTitle("Izdavanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 1014, 352);
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
		
		primerak = new JTextField();
		primerak.setBounds(662, 187, 142, 20);
		panel.add(primerak);
		primerak.setColumns(10);
		
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
		lblNewLabel_2.setBounds(867, 11, 111, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Datum vracanja");
		lblNewLabel_3.setBounds(862, 80, 111, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Primerak");
		lblNewLabel_4.setBounds(662, 164, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel dassdas = new JLabel("Naslov knjige");
		dassdas.setBounds(862, 164, 111, 14);
		panel.add(dassdas);
		
		JButton btnNewButton = new JButton("Iznajmi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(884, 266, 111, 49);
		panel.add(btnNewButton);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 204));
		table_1.setBounds(10, 11, 631, 319);
		panel.add(table_1);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
	}
}
