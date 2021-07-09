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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ŞarkıEkleme extends JFrame {

	Connection connect;
	PreparedStatement state;
	ResultSet result;
	private String şarkıİd;
	private String şarkıAdı;
	private String türİd;
	private String albümİd;
	private String şarkıcıİd;
	private String süre;
	private String tarih;
	
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private DefaultTableModel model2=new DefaultTableModel();
	private DefaultTableModel model3=new DefaultTableModel();
	private JPanel contentPane;
	private JTextField textŞarkıAdı;
	private JTextField textSüresi;
	private JTextField textTarih;
	private JTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEdt;
	private JButton btnSarkiOlustur;
	private JButton btnAlbmnzOluturun;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	private JScrollPane scrollPane_3;
	private JTable table_3;
	private JButton btnAdminPanelineDn;
	private JButton btnGiriEkrannaDn;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ŞarkıEkleme frame = new ŞarkıEkleme();
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
	public ŞarkıEkleme() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				bilgiGoster();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1193, 846);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(137, 202, 102, 74);
		contentPane.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(137, 434, 144, 81);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 287, 103, 96);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		textŞarkıAdı = new JTextField();
		textŞarkıAdı.setBounds(173, 148, 86, 20);
		contentPane.add(textŞarkıAdı);
		textŞarkıAdı.setColumns(10);
		
		textSüresi = new JTextField();
		textSüresi.setBounds(173, 562, 86, 20);
		contentPane.add(textSüresi);
		textSüresi.setColumns(10);
		
		textTarih = new JTextField();
		textTarih.setBounds(173, 609, 86, 20);
		contentPane.add(textTarih);
		textTarih.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(707, 163, 270, 311);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("EKLE");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.WHITE);
		
		btnAdd.setBounds(82, 680, 102, 69);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("ŞARKI ADI:");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 151, 95, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblarkTr = new JLabel("ŞARKI TÜRÜ");
		lblarkTr.setForeground(Color.GREEN);
		lblarkTr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblarkTr.setBounds(10, 237, 111, 22);
		contentPane.add(lblarkTr);
		
		JLabel lblarkc = new JLabel("ŞARKICI");
		lblarkc.setForeground(Color.GREEN);
		lblarkc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblarkc.setBounds(10, 287, 86, 22);
		contentPane.add(lblarkc);
		
		JLabel lblAlbm = new JLabel("ALBÜM");
		lblAlbm.setForeground(Color.GREEN);
		lblAlbm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlbm.setBounds(10, 434, 86, 22);
		contentPane.add(lblAlbm);
		
		JLabel lblarkSresi = new JLabel("ŞARKI SÜRESİ :");
		lblarkSresi.setForeground(Color.GREEN);
		lblarkSresi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblarkSresi.setBounds(10, 560, 119, 22);
		contentPane.add(lblarkSresi);
		
		JLabel lblGncellemeTarihi = new JLabel("TARİH");
		lblGncellemeTarihi.setForeground(Color.GREEN);
		lblGncellemeTarihi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGncellemeTarihi.setBounds(10, 605, 86, 22);
		contentPane.add(lblGncellemeTarihi);
		
		btnDelete = new JButton("SİL");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(340, 680, 102, 69);
		contentPane.add(btnDelete);
		
		btnEdt = new JButton("DÜZENLE");
		btnEdt.setForeground(Color.BLACK);
		btnEdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdt.setBackground(Color.WHITE);
		btnEdt.setBounds(209, 680, 102, 69);
		contentPane.add(btnEdt);
		
		btnSarkiOlustur = new JButton("Şarkıcınızı oluşturun");
		
		btnSarkiOlustur.setHorizontalAlignment(SwingConstants.LEFT);
		btnSarkiOlustur.setForeground(Color.BLACK);
		btnSarkiOlustur.setBackground(Color.WHITE);
		btnSarkiOlustur.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSarkiOlustur.setBounds(319, 299, 189, 22);
		contentPane.add(btnSarkiOlustur);
		
		btnAlbmnzOluturun = new JButton("Albümünüzü oluşturun");
		
		btnAlbmnzOluturun.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlbmnzOluturun.setForeground(Color.BLACK);
		btnAlbmnzOluturun.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlbmnzOluturun.setBackground(Color.WHITE);
		btnAlbmnzOluturun.setBounds(319, 429, 207, 22);
		contentPane.add(btnAlbmnzOluturun);
		
		btnAdminPanelineDn = new JButton("Admin Paneline Dön");
		btnAdminPanelineDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Admin admin= new Admin();
				admin.setVisible(true);
				
				admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnAdminPanelineDn.setForeground(Color.BLACK);
		btnAdminPanelineDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdminPanelineDn.setBackground(Color.WHITE);
		btnAdminPanelineDn.setBounds(630, 680, 147, 69);
		contentPane.add(btnAdminPanelineDn);
		
		btnGiriEkrannaDn = new JButton("Giriş Ekranına Dön");
		btnGiriEkrannaDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Giriş giriş= new Giriş();
				giriş.setVisible(true);
				
				giriş.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnGiriEkrannaDn.setForeground(Color.BLACK);
		btnGiriEkrannaDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGiriEkrannaDn.setBackground(Color.WHITE);
		btnGiriEkrannaDn.setBounds(830, 680, 147, 69);
		contentPane.add(btnGiriEkrannaDn);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\SARKI.png"));
		lblNewLabel_1.setBounds(319, 10, 391, 68);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				şarkıİd=(String) model.getValueAt(table.getSelectedRow(), 0);
				textŞarkıAdı.setText((String)model.getValueAt(table.getSelectedRow(),1));
				textSüresi.setText((String)model.getValueAt(table.getSelectedRow(),4));
				textTarih.setText((String)model.getValueAt(table.getSelectedRow(),5));
				
			}
		});
		
		btnEdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			şarkıAdı=textŞarkıAdı.getText();
			türİd=(String)model3.getValueAt(table_3.getSelectedRow(), 0);
			şarkıcıİd=(String)model1.getValueAt(table_1.getSelectedRow(), 0);
			albümİd=(String)model2.getValueAt(table_2.getSelectedRow(), 0);
			süre=textSüresi.getText();
			tarih=textTarih.getText();
			String a=(String)model2.getValueAt(table_2.getSelectedRow(), 2);
			String b=((String)model3.getValueAt(table_3.getSelectedRow(), 0));
			if (a.equals(b)) {
				
			
			try {
				String query="UPDATE sarki SET sarki_adi='"+şarkıAdı+"',turID="+türİd+
			" ,album_id="+albümİd+",sure='"+süre+"', tarih='"+tarih+"' WHERE sarki_id="+şarkıİd;
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
		state=connect.prepareStatement(query)	;
		state.executeUpdate();
		JOptionPane.showMessageDialog(null, "YOU UPDATE SUCCESFULLY");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
			try {
				String query="UPDATE sarki_sanatci SET sanatci_id="+şarkıcıİd+" WHERE sarki_id="+şarkıİd;
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
		state=connect.prepareStatement(query);
		state.executeUpdate();
			}
		    catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
		    }
			bilgiGoster();
			}
			else{
				JOptionPane.showMessageDialog(null, "SARKI TURU VE ALBUM TURU AYNI DEGIL");
			}
			}
			
		
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="DELETE FROM sarki WHERE sarki_id="+şarkıİd;
					
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
		
		btnSarkiOlustur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ŞarkıcıEkleme şarkıcıekleme = new ŞarkıcıEkleme();
			şarkıcıekleme.setVisible(true);
			
			şarkıcıekleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		btnAlbmnzOluturun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AlbümEkle albümEkle = new AlbümEkle();
				albümEkle.setVisible(true);
				
				albümEkle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		sarkicigoster();
		albumgoster();
		türgöster();	
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String a=(String)model2.getValueAt(table_2.getSelectedRow(), 2);
			String b=((String)model3.getValueAt(table_3.getSelectedRow(), 0));
				if (a.equals(b)) {
			
				
				try {
					String query="INSERT INTO sarki (sarki_adi,turID,album_id,sure,tarih,dinelenmeSayisi) VALUES(?,?,?,?,?,?)";
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
			state=connect.prepareStatement(query)	;
			state.setString(1, textŞarkıAdı.getText());
			state.setString(2, (String)model3.getValueAt(table_3.getSelectedRow(), 0));
			state.setString(3, (String)model2.getValueAt(table_2.getSelectedRow(), 0));
			state.setString(4, textSüresi.getText());
			state.setString(5, textTarih.getText());
			state.setInt(6, 0);
			state.executeUpdate();
			JOptionPane.showMessageDialog(null, "YOU ADD SUCCESFULLY");
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			bilgiGoster();
		    try {
				String query="INSERT INTO sarki_sanatci (sarki_id,sanatci_id) VALUES(?,?)";
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
		state=connect.prepareStatement(query)	;
		state.setInt(1, maxBul() );
		state.setString(2, (String)model1.getValueAt(table_1.getSelectedRow(), 0));
		state.executeUpdate();
			}
		    catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		    try {
				for (int i = 1; i <= maxUlkeIDBul(); i++) {
					String query="INSERT INTO ulkesarki (ulkeID,sarkiID,dinlenme_sayisi) VALUES(?,?,?)";
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
					state=connect.prepareStatement(query)	;
					state.setInt(1, i);
					state.setInt(2,maxBul());
					state.setInt(3, 0);
					state.executeUpdate();
				}
		    	
			}
		    catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			
		    
	
				}
				else {
					JOptionPane.showMessageDialog(null, "SARKI TURU VE ALBUM TURU AYNI DEGIL");
					
				}
			}});
	
	}
	
	public void bilgiGoster() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
		model.addColumn("sarki_id");
		model.addColumn("sarki_adi");
		model.addColumn("turID");
		model.addColumn("album_id");	
		model.addColumn("sure");
		model.addColumn("tarih");
		
		model.setRowCount(0);
		String query=" SELECT * FROM sarki ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model.addRow(new Object[]{
						r.getString("sarki_id"),r.getString("sarki_adi"),r.getString("turID"),r.getString("album_id"),r.getString("sure"),r.getString("tarih")
						
					});
				}
				table.setModel(model);
				table.setAutoResizeMode(0);
				table.getColumnModel().getColumn(0).setPreferredWidth(45);
				table.getColumnModel().getColumn(1).setPreferredWidth(50);
				table.getColumnModel().getColumn(2).setPreferredWidth(30);
				table.getColumnModel().getColumn(3).setPreferredWidth(50);
				table.getColumnModel().getColumn(4).setPreferredWidth(30);
				table.getColumnModel().getColumn(5).setPreferredWidth(70);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	public void sarkicigoster() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
		model1.addColumn("sanatci_id");
		model1.addColumn("sanatci_adi");
		

		
		model1.setRowCount(0);
		String query=" SELECT sanatci_id,sanatci_adi FROM sanatci ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model1.addRow(new Object[]{
						r.getString("sanatci_id"),r.getString("sanatci_adi")
						
					});
				}
				table_1.setModel(model1);
				table_1.setAutoResizeMode(0);
				table_1.getColumnModel().getColumn(0).setPreferredWidth(45);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(50);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void albumgoster() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
		model2.addColumn("album_id");
		model2.addColumn("album_adi");
		model2.addColumn("tur_id");

		
		model2.setRowCount(0);
		String query=" SELECT album_id,album_adi,tur_id FROM album ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model2.addRow(new Object[]{
						r.getString("album_id"),r.getString("album_adi"),r.getString("tur_id")
						
					});
				}
				table_2.setModel(model2);
				table_2.setAutoResizeMode(0);
				table_2.getColumnModel().getColumn(0).setPreferredWidth(45);
				table_2.getColumnModel().getColumn(1).setPreferredWidth(50);
				table_2.getColumnModel().getColumn(2).setPreferredWidth(50);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void türgöster() {
		ResultSet r;
		Connection c;
		PreparedStatement s;
		model3.addColumn("ID");
		model3.addColumn("ad");
		

		
		model3.setRowCount(0);
		String query=" SELECT * FROM tur ";
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=c.prepareStatement(query)	;
				r=s.executeQuery();
				while(r.next()) {
					model3.addRow(new Object[]{
						r.getString("ID"),r.getString("ad")
						
					});
				}
				table_3.setModel(model3);
				table_3.setAutoResizeMode(0);
				table_3.getColumnModel().getColumn(0).setPreferredWidth(45);
				table_3.getColumnModel().getColumn(1).setPreferredWidth(50);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 public int maxBul() {
	Connection c;
	PreparedStatement s;
	ResultSet r;
	 int x=0;
	 String query1 = "SELECT MAX(sarki_id) FROM sarki ";
		try {
			 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=connect.prepareStatement(query1)	;
			 r=s.executeQuery();
			r.next();
			 x=r.getInt(1);
		
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return x;
 }
	

public int maxUlkeIDBul() {
	Connection c;
	PreparedStatement s;
	ResultSet r;
	 int x=0;
	 String query1 = "SELECT MAX(ulkeID) FROM ulke ";
		try {
			 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
				s=connect.prepareStatement(query1)	;
			 r=s.executeQuery();
			r.next();
			 x=r.getInt(1);
			
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return x;
 }
	}



