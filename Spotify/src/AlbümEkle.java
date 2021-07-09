import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class AlbümEkle extends JFrame {

	Connection connect;
	PreparedStatement state;
	ResultSet result;
	private String albumid;
	private String albumadi;
	private String tarih;
	private int tür;
	private JButton btnarkEklemeyDn;
	private JPanel contentPane;
	private JTextField albumAdiText;
	private JTextField tarihText;
	private JTable table;
	private DefaultTableModel model=new DefaultTableModel();;
	private JButton btnAdminPanelineDn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlbümEkle frame = new AlbümEkle();
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
	public AlbümEkle() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				bilgiGoster();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1069, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1177, 807);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(704, 149, 213, 314);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ALBÜM ADI:");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(39, 128, 118, 55);
		panel.add(lblNewLabel);
		
		JLabel lblReleasedate = new JLabel("TARİH :");
		lblReleasedate.setForeground(Color.GREEN);
		lblReleasedate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReleasedate.setBounds(39, 252, 129, 55);
		panel.add(lblReleasedate);
		
		JLabel lblGenre = new JLabel("TÜR :");
		lblGenre.setForeground(Color.GREEN);
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGenre.setBounds(39, 332, 102, 55);
		panel.add(lblGenre);
		
		albumAdiText = new JTextField();
		albumAdiText.setBackground(Color.WHITE);
		albumAdiText.setBounds(167, 139, 202, 36);
		panel.add(albumAdiText);
		albumAdiText.setColumns(10);
		
		tarihText = new JTextField();
		tarihText.setBounds(167, 264, 202, 36);
		panel.add(tarihText);
		tarihText.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                    POP", "                  ROCK", "                   JAZZ"}));
		comboBox.setBounds(167, 341, 202, 37);
		panel.add(comboBox);
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.setForeground(Color.BLACK);
		btnEkle.setBackground(Color.WHITE);
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						String query="INSERT INTO album (album_adi,tarih,tur_id) VALUES(?,?,?)";
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				state=connect.prepareStatement(query)	;
				state.setString(1, albumAdiText.getText());
				state.setString(2, tarihText.getText());
				state.setInt(3, comboBox.getSelectedIndex()+1);
				
				state.executeUpdate();
				JOptionPane.showMessageDialog(null, "YOU ADD SUCCESFULLY");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				bilgiGoster();
		
			  
			
			}
		});
		btnEkle.setBounds(39, 602, 102, 69);
		panel.add(btnEkle);
		
		JButton btnDuzenle = new JButton("DÜZENLE");
		
		btnDuzenle.setForeground(Color.BLACK);
		btnDuzenle.setBackground(Color.WHITE);
		btnDuzenle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDuzenle.setBounds(167, 602, 102, 69);
		panel.add(btnDuzenle);
		
		JButton btnSil = new JButton("SİL");
		
		btnSil.setForeground(Color.BLACK);
		btnSil.setBackground(Color.WHITE);
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSil.setBounds(298, 602, 102, 69);
		panel.add(btnSil);
		
		btnarkEklemeyDn = new JButton("Şarkı Eklemeye Dön");
		btnarkEklemeyDn.setForeground(Color.BLACK);
		btnarkEklemeyDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnarkEklemeyDn.setBackground(Color.WHITE);
		btnarkEklemeyDn.setBounds(544, 602, 147, 69);
		panel.add(btnarkEklemeyDn);
		
		btnAdminPanelineDn = new JButton("Admin Paneline Dön");
		btnAdminPanelineDn.setForeground(Color.BLACK);
		btnAdminPanelineDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdminPanelineDn.setBackground(Color.WHITE);
		btnAdminPanelineDn.setBounds(747, 602, 147, 69);
		panel.add(btnAdminPanelineDn);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\ALBUM.png"));
		lblNewLabel_1_1.setBounds(332, 10, 391, 68);
		panel.add(lblNewLabel_1_1);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				albumid=(String) model.getValueAt(table.getSelectedRow(), 0);
				albumAdiText.setText((String)model.getValueAt(table.getSelectedRow(),1));
				tarihText.setText((String)model.getValueAt(table.getSelectedRow(),2));
				
			}
		});
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			albumadi=albumAdiText.getText();
			tarih=tarihText.getText();
			tür=comboBox.getSelectedIndex()+1;
	
			try {
				String query="UPDATE album SET album_adi='"+albumadi+"',"+
			"tarih='"+tarih+"',tur_id="+tür+" WHERE album_id="+albumid;
				
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
		
		
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="DELETE FROM album WHERE album_id="+albumid;
					
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
	
	}
	
	public void bilgiGoster() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
		
		model.addColumn("album_id");
		model.addColumn("album_adi");
		model.addColumn("tarih");
		model.addColumn("tur_id");
		model.setRowCount(0);
		
		String query=" SELECT * FROM album ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model.addRow(new Object[]{
						r.getString("album_id"),r.getString("album_adi"),r.getString("tarih"),r.getString("tur_id")
						
					});
				}
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(60);
				table.getColumnModel().getColumn(2).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setPreferredWidth(30);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	}


