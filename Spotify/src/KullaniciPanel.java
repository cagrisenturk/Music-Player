
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

public class KullaniciPanel extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private	DefaultTableModel model;
	private	String songID,genreID;
	private String turid;
	private	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciPanel frame = new KullaniciPanel();
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
	public KullaniciPanel() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 819, 671);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		
		JButton btnPopIlk10 = new JButton("POP");
		btnPopIlk10.setBackground(Color.BLACK);
		btnPopIlk10.setForeground(Color.GREEN);
		btnPopIlk10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				türgetir(1);
				
			}
		});
		
		JButton btnRockIlk10 = new JButton("ROCK");
		btnRockIlk10.setForeground(Color.GREEN);
		btnRockIlk10.setBackground(Color.BLACK);
		btnRockIlk10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				türgetir(2);
				
				
			}
		});
		
		JButton btnJazzIlk10 = new JButton("JAZZ");
		btnJazzIlk10.setForeground(Color.GREEN);
		btnJazzIlk10.setBackground(Color.BLACK);
		btnJazzIlk10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				türgetir(3);
			}
		});
		
		JButton btnUlkeIlk10 = new JButton("ÜLKE");
		btnUlkeIlk10.setForeground(Color.GREEN);
		btnUlkeIlk10.setBackground(Color.BLACK);
			
			JButton btnAlbumSarki = new JButton("ALBÜME GİT");
			btnAlbumSarki.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnAlbumSarki.setForeground(Color.GREEN);
			btnAlbumSarki.setBackground(Color.BLACK);
			
			btnAlbumSarki.setBounds(172, 219, 151, 33);
			contentPane.add(btnAlbumSarki);
			
			JButton btnAlbumler = new JButton("ALBÜMLERİ GÖRÜNTÜLE");
			btnAlbumler.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnAlbumler.setForeground(Color.GREEN);
			btnAlbumler.setBackground(Color.BLACK);
			
			btnAlbumler.setBounds(172, 164, 151, 31);
			contentPane.add(btnAlbumler);
			
			JButton btnPLY = new JButton("PLAY");
			btnPLY.setForeground(Color.GREEN);
			btnPLY.setBackground(Color.BLACK);
			btnPLY.setFont(new Font("Tahoma", Font.BOLD, 10));
			
			btnPLY.setBounds(550, 449, 118, 33);
			contentPane.add(btnPLY);
		
			JButton btnListeyeEkle = new JButton("LİSTEME EKLE");
			btnListeyeEkle.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnListeyeEkle.setForeground(Color.GREEN);
			btnListeyeEkle.setBackground(Color.BLACK);
			btnListeyeEkle.setBounds(550, 385, 118, 33);
			contentPane.add(btnListeyeEkle);
			
	

		btnUlkeIlk10.setBounds(25, 196, 89, 23);
		contentPane.add(btnUlkeIlk10);
		btnJazzIlk10.setBounds(25, 295, 89, 23);
		contentPane.add(btnJazzIlk10);
		btnRockIlk10.setBounds(25, 262, 89, 23);
		contentPane.add(btnRockIlk10);
		btnPopIlk10.setBounds(25, 229, 89, 23);
		contentPane.add(btnPopIlk10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(97, 368, 352, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnDunyaIlk10 = new JButton("DÜNYA");
		btnDunyaIlk10.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDunyaIlk10.setBackground(Color.BLACK);
		btnDunyaIlk10.setForeground(Color.GREEN);
		btnDunyaIlk10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					model.addColumn("Şarkıcı Adı");
					model.addColumn("Şarkı Süresi");
					
					model.addColumn("Dinlenme Sayisi");
					model.addColumn("Tarih");
		
				 try {
					 String query= "Select *from sarki order by dinelenmeSayisi desc limit 10" ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
			        s=connect.prepareStatement(query);
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
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnDunyaIlk10.setBounds(25, 163, 89, 23);
		contentPane.add(btnDunyaIlk10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(436, 120, 85, 29);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText(Giriş.kullaniciAdi.toUpperCase());
		
		JLabel lblNewLabel_3 = new JLabel("TOP 10");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setBounds(25, 126, 89, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("KEŞFET");
		lblNewLabel_3_1.setForeground(Color.GREEN);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(188, 122, 89, 21);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnProfileGit = new JButton("PROFİLİME GİT");
		btnProfileGit.setForeground(Color.GREEN);
		btnProfileGit.setBackground(Color.BLACK);
		btnProfileGit.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProfileGit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				KullaniciProfil kullaniciProfil=new KullaniciProfil();
				kullaniciProfil.setVisible(true);
			}
		});
		btnProfileGit.setBounds(398, 164, 123, 31);
		contentPane.add(btnProfileGit);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\profilebanner.png"));
		lblNewLabel_4.setBounds(387, 120, 151, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\SPOTIFY.png"));
		lblNewLabel_1.setBounds(173, 10, 391, 68);
		contentPane.add(lblNewLabel_1);
		
	
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				songID=(String) model.getValueAt(table.getSelectedRow(), 0);
			    genreID=(String)model.getValueAt(table.getSelectedRow(), 2); 
			    
				
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
		btnAlbumler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet r2;
				Connection c;
				PreparedStatement s2;
				model=new DefaultTableModel();
				model.addColumn("album_id");
				model.addColumn("album_adi");
				model.addColumn("tarih");
				model.addColumn("tur_id");	
			
				try {
					
					String query2="SELECT * From album";
					
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
			
			s2=c.prepareStatement(query2)	;
			r2=s2.executeQuery(query2);
			
			
			
				
			while(r2.next()) {
				model.addRow(new Object[]{
						r2.getString("album_id"),r2.getString("album_adi"),r2.getString("tarih"),r2.getString("tur_id")
					
				});
			}
	        table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			
			}
				 catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
				
			}
		});
		btnAlbumSarki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {ResultSet result,r;
			Connection connect;
			PreparedStatement state,s;
			  
				 String query= "SELECT * FROM sarki where album_id= "+(String)model.getValueAt(table.getSelectedRow(), 0)+""; 
				 
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
		});
		
		
		
		btnUlkeIlk10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					model.addColumn("Şarkıcı Adı");
					model.addColumn("Şarkı Süresi");
					
					model.addColumn("Ülkede Dinlenme Sayisi");
					
		
				 try {
					 String query= "select sarki_id,sarki_adi,turID,album_id,sure,dinlenme_sayisi from sarki,ulkesarki "+
				 "where ulkesarki.ulkeID="+Giriş.kullanici_ulke+" and sarki.sarki_id=ulkesarki.sarkiID order by ulkesarki.dinlenme_sayisi desc limit 10" ; 
					connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
			        s=connect.prepareStatement(query);
					r=s.executeQuery();
					while(r.next()) {
						model.addRow(new Object[]{
								r.getString("sarki_id"),r.getString("sarki_adi"),r.getString("turID"),turAdi(r.getInt("turID")),r.getString("album_id"),albumAdi(r.getInt("album_id")),sarkiciAdı(r.getInt("sarki_id")),r.getString("sure"),r.getString("dinlenme_sayisi")
							
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
					
					
			
			
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		
		
		}
	
	
	public void türgetir(int turID)
	{
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
			model.addColumn("Şarkıcı Adı");
			model.addColumn("Şarkı Süresi");
			
			model.addColumn("Dinlenme Sayisi");
			model.addColumn("Tarih");

		 try {
			 String query= "Select *from sarki where turID="+turID +" order by dinelenmeSayisi desc limit 10 " ; 
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
	        s=connect.prepareStatement(query);
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
	
	
	

