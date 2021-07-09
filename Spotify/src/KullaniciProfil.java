
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;



import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;

public class KullaniciProfil extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private	DefaultTableModel model;
	private	String songID,genreID;
	private String turid;
	private	JLabel lblNewLabel;
	private JRadioButton rdbtnOde;
	private String kullanıcıid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciProfil frame = new KullaniciProfil();
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
	public KullaniciProfil() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				rdbtnOde = new JRadioButton("ÖDENDİ");
				rdbtnOde.setBounds(634, 307, 103, 21);
				contentPane.add(rdbtnOde);
				rdbtnOde.setVisible(false);
				String kontrol="pre";
				if (Giriş.kullaniciAbone.equals(kontrol)) {
				rdbtnOde.setVisible(true);
				if (Giriş.kullaniciOdeme.equals("odedi")) {
					rdbtnOde.setSelected(true);
				}
				else {
					rdbtnOde.setSelected(false);
				}
				}
				
				
			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 819, 671);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			
			JButton btnHepsiniEKle = new JButton("TÜMÜNÜ AKTAR");
			btnHepsiniEKle.setForeground(Color.GREEN);
			btnHepsiniEKle.setBackground(Color.BLACK);
			btnHepsiniEKle.setFont(new Font("Tahoma", Font.BOLD, 10));
			
			btnHepsiniEKle.setBounds(505, 367, 124, 29);
			contentPane.add(btnHepsiniEKle);
			
			JButton btnPLY = new JButton("PLAY");
			btnPLY.setForeground(Color.GREEN);
			btnPLY.setBackground(Color.BLACK);
			btnPLY.setFont(new Font("Tahoma", Font.BOLD, 10));
			
			btnPLY.setBounds(505, 317, 124, 29);
			contentPane.add(btnPLY);
			
			JButton btnTakipEt = new JButton("TAKİP ET");
			btnTakipEt.setForeground(Color.GREEN);
			btnTakipEt.setBackground(Color.BLACK);
			btnTakipEt.setFont(new Font("Tahoma", Font.BOLD, 10));
			
			btnTakipEt.setBounds(181, 167, 89, 21);
			contentPane.add(btnTakipEt);
		
			JButton btnListeyeEkle = new JButton("LİSTEME EKLE");
			btnListeyeEkle.setBackground(Color.BLACK);
			btnListeyeEkle.setForeground(Color.GREEN);
			btnListeyeEkle.setBounds(505, 419, 124, 29);
			contentPane.add(btnListeyeEkle);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(74, 302, 352, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_6 = new JButton("TAKİP EDİLENLER");
		
		btnNewButton_6.setForeground(Color.GREEN);
		btnNewButton_6.setBackground(new Color(0, 0, 0));
		btnNewButton_6.setBounds(21, 202, 150, 29);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("KULLANICI BUL");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
					model.addColumn("Kullanici ID");
					model.addColumn("Kullanici Adi");
					model.addColumn("Üyelik");
		
				 try {
					 String query= "Select kullanici_id,kullanici_adi,kullanici_tur from kullanici " ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
					if (!(r.getString("kullanici_adi").equals("admin"))) {
						
					
					
						model.addRow(new Object[]{
								
							r.getString("kullanici_id"),r.getString("kullanici_adi"),r.getString("kullanici_tur")
							
						});
					
					table.setModel(model);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(40);
					table.getColumnModel().getColumn(1).setPreferredWidth(40);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
					}
					else {
						continue;
					}
					}
					
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setForeground(Color.GREEN);
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setBounds(21, 163, 150, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnKullaniciJazz = new JButton("JAZZ LİSTEM");
		btnKullaniciJazz.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnKullaniciJazz.setForeground(Color.GREEN);
		btnKullaniciJazz.setBackground(Color.BLACK);
		
		btnKullaniciJazz.setBounds(399, 244, 124, 29);
		contentPane.add(btnKullaniciJazz);
		
		JButton btnKullaniciRock = new JButton("ROCK LİSTEM");
		btnKullaniciRock.setForeground(Color.GREEN);
		btnKullaniciRock.setBackground(Color.BLACK);
		btnKullaniciRock.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnKullaniciRock.setBounds(399, 202, 121, 29);
		contentPane.add(btnKullaniciRock);
		
		JButton btnKullaniciPop = new JButton("POP LİSTEM");
		btnKullaniciPop.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnKullaniciPop.setForeground(Color.GREEN);
		
		btnKullaniciPop.setBackground(Color.BLACK);
		btnKullaniciPop.setBounds(399, 157, 121, 29);
		contentPane.add(btnKullaniciPop);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(25, 11, 85, 29);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText(Giriş.kullaniciAdi.toUpperCase());
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\SPOTIFY.png"));
		lblNewLabel_1.setBounds(227, 10, 391, 68);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ANA MENÜYE DÖN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				KullaniciPanel menü=new KullaniciPanel();
				menü.setVisible(true);
				
				menü.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(629, 150, 136, 21);
		contentPane.add(btnNewButton);
		
		JButton btnTakipPop = new JButton("Kullanıcı Pop Listesi Getir");
		btnTakipPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takipCalmaListesiGetir("1");
			}
		});
		btnTakipPop.setBackground(Color.BLACK);
		btnTakipPop.setForeground(Color.GREEN);
		btnTakipPop.setBounds(84, 525, 162, 34);
		contentPane.add(btnTakipPop);
		
		JButton btnTakipRock = new JButton("Kullanıcı Rock Listesi Getir");
		btnTakipRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takipCalmaListesiGetir("2");
			}
		});
		btnTakipRock.setForeground(Color.GREEN);
		btnTakipRock.setBackground(Color.BLACK);
		btnTakipRock.setBounds(264, 525, 162, 34);
		contentPane.add(btnTakipRock);
		
		JButton btnTakipJazz = new JButton("Kullanıcı Jazz Listesi Getir");
		btnTakipJazz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				takipCalmaListesiGetir("3");
			}
		});
		btnTakipJazz.setForeground(Color.GREEN);
		btnTakipJazz.setBackground(Color.BLACK);
		btnTakipJazz.setBounds(181, 569, 162, 34);
		contentPane.add(btnTakipJazz);
		
		
		 
		
	
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				songID=(String) model.getValueAt(table.getSelectedRow(), 0);
			    genreID=(String)model.getValueAt(table.getSelectedRow(), 2); 
			    kullanıcıid=(String) model.getValueAt(table.getSelectedRow(), 0);
			    
				
			}
		});
		btnListeyeEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  
    			ResultSet result,r;
    			Connection connect;
    			PreparedStatement state,s;
    			int x;
    			String query="SELECT calmalistesi_id from calma_listesi where sahip_id="+Giriş.kullanici +" and tur_id="+(String)model.getValueAt(table.getSelectedRow(), 2) +" ";
    			try {
    				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
    		        s=connect.prepareStatement(query);
    		        r=s.executeQuery();
    		        r.next();
    		        x=r.getInt(1);
    		       
    		     
    		     String query2="INSERT INTO calma_listesi_sarki (liste_id,sarki_id) VALUES(?,?)";
    		     state=connect.prepareStatement(query2);
    		           state.setInt(1, x);
    		   
    		        state.setString(2, (String) model.getValueAt(table.getSelectedRow(), 0));
    		        state.executeUpdate();
    			} catch (SQLException eX) {
    				JOptionPane.showMessageDialog(null, "AYNI SARKI LISTEDE BULUNMAKTADIR");
    				eX.printStackTrace();
    			}
    			
				
				
				
				
			}
		});
		btnKullaniciPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				calmaListesiGetir(1);
			}
		});
		
		btnKullaniciRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calmaListesiGetir(2);
			}
		});
		btnKullaniciJazz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calmaListesiGetir(3);
			}
		});
		btnTakipEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
    			Connection connect;
    			PreparedStatement state,s;
    			String tür=(String) model.getValueAt(table.getSelectedRow(), 2);
    			String kontrol="pre";
    			if(tür.equals(kontrol)) {
    			String query="INSERT INTO takipedilen_kullanici (kullanici_id,takipedilen_id) values (?,?)";
    			try {
    				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
    		        s=connect.prepareStatement(query);
    		        s.setInt(1, Giriş.kullanici);
    	    		  
    		        s.setString(2, (String) model.getValueAt(table.getSelectedRow(), 0));
    		        s.executeUpdate();
    		       
    		     
    			} catch (SQLException eX) {
    				// TODO Auto-generated catch block
    				JOptionPane.showMessageDialog(null, "BU KULLANICIYI TAKIP EDİYORSUNUZ");
    				eX.printStackTrace();
    			}
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "NORMAL KULLANICI TAKIP EDILEMEZ");
    				
    			}
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
				Connection connect;
				PreparedStatement state,s;
				  model=new DefaultTableModel();
				  model.addColumn("Kullanici ID");
					model.addColumn("Kullanici Adi");
					model.addColumn("Üyelik");
				
				 try {
					 String query= "SELECT * FROM kullanici where kullanici.kullanici_id IN (select takipedilen_id from takipedilen_kullanici where kullanici_id="+Giriş.kullanici+") "; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
							r.getString("kullanici_id"),r.getString("kullanici_adi"),r.getString("kullanici_tur")
							
						});
					}
					table.setModel(model);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(40);
					table.getColumnModel().getColumn(1).setPreferredWidth(40);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
		
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPLY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect;
				PreparedStatement state;
				try {
					String query="UPDATE sarki SET dinelenmeSayisi=dinelenmeSayisi+1 WHERE sarki_id="+(String)model.getValueAt(table.getSelectedRow(), 0)+" ";
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
			state=connect.prepareStatement(query);
			state.executeUpdate();
				}
			    catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
			    }
				try {
					String query="UPDATE ulkesarki SET dinlenme_sayisi=dinlenme_sayisi+1 WHERE sarkiID="+(String)model.getValueAt(table.getSelectedRow(), 0)+" and ulkeID="+Giriş.kullanici_ulke +" ";
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
			state=connect.prepareStatement(query);
			state.executeUpdate();
				}
			    catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
			    }
			}
			
		});
		btnHepsiniEKle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result,r;
    			Connection connect;
    			PreparedStatement state,s;
    			
    			int y;
				String query="SELECT calmalistesi_id from calma_listesi where sahip_id="+Giriş.kullanici +" and tur_id="+turid +" ";
    			
				try {
    				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
    		        state=connect.prepareStatement(query);
    		        result=state.executeQuery();
    		        result.next();
    		        y=result.getInt(1);
    		        for (int i = 0; i < table.getRowCount(); i++) {
 	    		       
        				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
        		     
        		     String query2="INSERT INTO calma_listesi_sarki (liste_id,sarki_id) VALUES(?,?)";
        		     state=connect.prepareStatement(query2);
        		           state.setInt(1, y);
        		   
        		        state.setString(2, (String) model.getValueAt(i, 0));
        		        state.executeUpdate();
        			 
			}
				}
				catch (SQLException eX) {
    				
    				eX.printStackTrace();
    			}
				
			
			
			}
		});
		
		
		}
	
	
	public void calmaListesiGetir(int turID) {
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		  model=new DefaultTableModel();
		  model.addColumn("sarki_id");
			model.addColumn("Şarkı Adı");
			model.addColumn("turID");
			model.addColumn("Tur Adi");
			model.addColumn("album_id");
			model.addColumn("Album Adi");
			model.addColumn("Şarkıcı Adi");
			model.addColumn("Şarkı Süresi");
			
			model.addColumn("Dinlenme Sayisi");
			model.addColumn("Tarih");

			int y;
			String query="SELECT calmalistesi_id from calma_listesi where sahip_id="+Giriş.kullanici +" and tur_id="+turID +" ";
			
			try {
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
		        state=connect.prepareStatement(query);
		        result=state.executeQuery();
		        result.next();
		        y=result.getInt(1);
		        
		   String      query2="SELECT * FROM sarki where sarki.sarki_id IN (select sarki_id from calma_listesi_sarki where liste_id="+y+ ") ";
		         s=connect.prepareStatement(query2);
    		        r=s.executeQuery();
    		        while(r.next()) {
						model.addRow(new Object[]{
								r.getString("sarki_id"),r.getString("sarki_adi"),r.getString("turID"),turAdi(r.getInt("turID")),r.getString("album_id"),albumAdi(r.getInt("album_id")),sarkiciAdı(r.getInt("sarki_id")),r.getString("sure"),r.getString("dinelenmeSayisi"),r.getString("tarih")
							
						});
					}
    		        table.setModel(model);
					table.setAutoResizeMode(0);
					table.getColumnModel().getColumn(0).setPreferredWidth(30);
					table.getColumnModel().getColumn(1).setPreferredWidth(70);
					table.getColumnModel().getColumn(2).setPreferredWidth(30);
					table.getColumnModel().getColumn(3).setPreferredWidth(30);
					table.getColumnModel().getColumn(4).setPreferredWidth(60);
					table.getColumnModel().getColumn(5).setPreferredWidth(60);
					table.getColumnModel().getColumn(6).setPreferredWidth(70);
					table.getColumnModel().getColumn(7).setPreferredWidth(70);
					table.getColumnModel().getColumn(8).setPreferredWidth(70);
			}
			catch (SQLException eX) {
				// TODO Auto-generated catch block
				eX.printStackTrace();
			}
		
	}
	
	
	public void takipCalmaListesiGetir(String turID) {
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		
		  
			 String query= "SELECT * FROM sarki where sarki.sarki_id IN (select sarki_id from calma_listesi_sarki where liste_id IN (select calmalistesi_id from calma_listesi where sahip_id="+
					 kullanıcıid+" and tur_id="+turID+")) "; 
			 turid=turID;
		 try {
			
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
	        s=connect.prepareStatement(query);
			r=s.executeQuery();
			model=new DefaultTableModel();
			model.addColumn("sarki_id");
			model.addColumn("Şarkı Adı");
			model.addColumn("turID");
			model.addColumn("Tur Adi");
			model.addColumn("album_id");
			model.addColumn("Album Adi");
			model.addColumn("Şarkıcı Adı");
			model.addColumn("Şarkı Süresi");
			
			model.addColumn("Dinlenme Sayisi");
			model.addColumn("Tarih");
			while(r.next()) {
				model.addRow(new Object[]{
						r.getString("sarki_id"),r.getString("sarki_adi"),r.getString("turID"),turAdi(r.getInt("turID")),r.getString("album_id"),albumAdi(r.getInt("album_id")),sarkiciAdı(r.getInt("sarki_id")),r.getString("sure"),r.getString("dinelenmeSayisi"),r.getString("tarih")
					
				});
				
			}
		
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(70);
			table.getColumnModel().getColumn(2).setPreferredWidth(30);
			table.getColumnModel().getColumn(3).setPreferredWidth(30);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(60);
			table.getColumnModel().getColumn(6).setPreferredWidth(70);
			table.getColumnModel().getColumn(7).setPreferredWidth(70);
			table.getColumnModel().getColumn(8).setPreferredWidth(70);
	
		 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	public String albumAdi(int id) {
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		 
			String y=" ";
			String query="SELECT album_adi from album where album_id="+id+" ";
			
			try {
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
		        state=connect.prepareStatement(query);
		        result=state.executeQuery();
		        result.next();
		        y=result.getString(1);
			}
			catch (SQLException eX) {
				// TODO Auto-generated catch block
				eX.printStackTrace();
			}
		
		
		return y;
	}
	public String turAdi(int id) {
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		 
			String y=" ";
			String query="SELECT ad from tur where ID="+id+" ";
			
			try {
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
		        state=connect.prepareStatement(query);
		        result=state.executeQuery();
		        result.next();
		        y=result.getString(1);
			}
			catch (SQLException eX) {
				// TODO Auto-generated catch block
				eX.printStackTrace();
			}
		
		
		return y;
	}
	public String sarkiciAdı(int id) {
		ResultSet result,r;
		Connection connect;
		PreparedStatement state,s;
		 
			String y=" ";
			String query="select sanatci_adi from sanatci where  sanatci_id IN (select sanatci_id from sarki_sanatci where sarki_id="+id+") ";
			
			try {
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
		        state=connect.prepareStatement(query);
		        result=state.executeQuery();
		        result.next();
		        y=result.getString(1);
			}
			catch (SQLException eX) {
				// TODO Auto-generated catch block
				eX.printStackTrace();
			}
		
		
		return y;
	}
	}
	
	
	

