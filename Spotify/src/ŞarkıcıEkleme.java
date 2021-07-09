import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ŞarkıcıEkleme extends JFrame {

	Connection connect;
	PreparedStatement state;
	ResultSet result;
	private String şarkıcıId;
	private String şarkıcıAdı;
	private int ülkeId;
	
	private JPanel contentPane;
	private JComboBox Ülke;
	private JTextField textAdı;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ŞarkıcıEkleme frame = new ŞarkıcıEkleme();
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
	public ŞarkıcıEkleme() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				bilgiGoster();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1000, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1177, 807);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textAdı = new JTextField();
		textAdı.setBounds(197, 176, 86, 20);
		panel.add(textAdı);
		textAdı.setColumns(10);
		
		 Ülke = new JComboBox();
		Ülke.setBounds(197, 246, 86, 22);
		panel.add(Ülke);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(571, 137, 173, 235);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("EKLE");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="INSERT INTO sanatci (sanatci_adi,ulke_id) VALUES(?,?)";
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
			state=connect.prepareStatement(query)	;
			state.setString(1, textAdı.getText());
			state.setInt(2, Ülke.getSelectedIndex()+1);
			
			state.executeUpdate();
			JOptionPane.showMessageDialog(null, "YOU ADD SUCCESFULLY");
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			bilgiGoster();
				
			}
		});
		
		btnAdd.setBounds(47, 464, 102, 69);
		panel.add(btnAdd);
		
		JButton btnEdt = new JButton("DÜZENLE");
		btnEdt.setForeground(Color.BLACK);
		btnEdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdt.setBackground(Color.WHITE);
		btnEdt.setBounds(181, 464, 102, 69);
		panel.add(btnEdt);
		
		JButton btnDelete = new JButton("SİL");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(312, 464, 102, 69);
		panel.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("ŞARKICI ADI :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(44, 173, 120, 20);
		panel.add(lblNewLabel);
		
		JLabel lbllke = new JLabel("ÜLKE :");
		lbllke.setForeground(Color.GREEN);
		lbllke.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllke.setBackground(Color.BLACK);
		lbllke.setBounds(44, 245, 86, 20);
		panel.add(lbllke);
		
		JButton btnarkEklemeyDn = new JButton("Şarkı Eklemeye Dön");
		
		btnarkEklemeyDn.setForeground(Color.BLACK);
		btnarkEklemeyDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnarkEklemeyDn.setBackground(Color.WHITE);
		btnarkEklemeyDn.setBounds(552, 464, 147, 69);
		panel.add(btnarkEklemeyDn);
		
		JButton btnAdminPanelineDn = new JButton("Admin Paneline Dön");
		
		btnAdminPanelineDn.setForeground(Color.BLACK);
		btnAdminPanelineDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdminPanelineDn.setBackground(Color.WHITE);
		btnAdminPanelineDn.setBounds(755, 464, 147, 69);
		panel.add(btnAdminPanelineDn);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\SARKICI.png"));
		lblNewLabel_1.setBounds(380, 10, 391, 68);
		panel.add(lblNewLabel_1);
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				şarkıcıId=(String) model.getValueAt(table.getSelectedRow(), 0);
				textAdı.setText((String)model.getValueAt(table.getSelectedRow(),1));
			}
		});
		btnEdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			şarkıcıAdı=textAdı.getText();
			
			ülkeId=Ülke.getSelectedIndex()+1;
	
			try {
				String query="UPDATE sanatci SET sanatci_adi='"+şarkıcıAdı+"',"+
			"ulke_id="+ülkeId+" WHERE sanatci_id="+şarkıcıId;
				
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
		state=connect.prepareStatement(query)	;
		
		state.executeUpdate();
		JOptionPane.showMessageDialog(null, "YOU UPDATE SUCCESFULLY");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		bilgiGoster();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="DELETE FROM sanatci WHERE sanatci_id="+şarkıcıId;
					
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
			state=connect.prepareStatement(query)	;
			
			state.executeUpdate();
			JOptionPane.showMessageDialog(null, "YOU DELETE SUCCESFULLY");
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			bilgiGoster();
			}
		});
		btnarkEklemeyDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ŞarkıEkleme şarkıEkleme = new ŞarkıEkleme(); 
				şarkıEkleme.setVisible(true);
				
				şarkıEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnAdminPanelineDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Admin admin= new Admin();
				admin.setVisible(true);
				
				admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	
		ülkeGetir();
	}
	public void ülkeGetir() {
		ResultSet r4;
		Connection c;
		PreparedStatement s4;
		try {
	String query4="SELECT ulke_adi From ulke";
	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");

	s4=c.prepareStatement(query4);
	r4=s4.executeQuery(query4);
	
	while (r4.next()) {
		String name4=r4.getString("ulke_adi");
		Ülke.addItem(name4);
	}
	
	
	
		
	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void bilgiGoster() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
		
		model.addColumn("sanatci_id");
		model.addColumn("sanatci_adi");
		model.addColumn("ulke_id");
		model.setRowCount(0);
		String query=" SELECT * FROM sanatci ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model.addRow(new Object[]{
						r.getString("sanatci_id"),r.getString("sanatci_adi"),r.getString("ulke_id")
						
					});
				}
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(60);
				table.getColumnModel().getColumn(1).setPreferredWidth(70);
				table.getColumnModel().getColumn(2).setPreferredWidth(40);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	}


