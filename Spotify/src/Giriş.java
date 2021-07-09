import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Giriş extends JFrame {

	private JPanel contentPane;
	private JTextField kullanıcıField_1;
	private JPasswordField sifreField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	static int kullanici,kullanici_ulke;
	static String kullaniciAdi,kullaniciAbone,kullaniciOdeme;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giriş  frame = new Giriş();
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
	public Giriş() {
		setTitle("Spotify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKullancAd = new JLabel("Kullanıcı Adı :");
		lblKullancAd.setForeground(Color.GREEN);
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKullancAd.setBounds(29, 118, 104, 29);
		contentPane.add(lblKullancAd);
		
		kullanıcıField_1 = new JTextField();
		kullanıcıField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		kullanıcıField_1.setColumns(10);
		kullanıcıField_1.setBounds(143, 118, 179, 29);
		contentPane.add(kullanıcıField_1);
		
		JLabel lblifre = new JLabel("Şifre :");
		lblifre.setForeground(Color.GREEN);
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblifre.setBounds(29, 183, 104, 29);
		contentPane.add(lblifre);
		
		sifreField = new JPasswordField();
		sifreField.setBounds(143, 185, 179, 29);
		contentPane.add(sifreField);
		
		JButton girisButonu = new JButton("Giris");
		girisButonu.setBackground(Color.WHITE);
		girisButonu.setFont(new Font("Tahoma", Font.BOLD, 14));
		girisButonu.setBounds(143, 247, 186, 38);
		contentPane.add(girisButonu);
		
		lblNewLabel = new JLabel("Hesabınız Yok Mu?  Yeni Bir Hesap Oluştur?");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(143, 295, 216, 38);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Admin Paneline Git");
		
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 343, 137, 38);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\SPOTIFY.png"));
		lblNewLabel_2.setBounds(56, -2, 391, 68);
		contentPane.add(lblNewLabel_2);
		
		girisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				ResultSet rs;
				String kullaniciadi =kullanıcıField_1.getText();
				String sifre =String.valueOf(sifreField.getPassword());
				Connection myCnt;
				String arama= "SELECT * FROM kullanici WHERE kullanici_adi = ? AND kullanici_sifre = ?";
				if (kullaniciadi.trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Lütfen Kullanıcı Adı Giriniz","Kullanıcı Adı",2);
				}
				else if (sifre.trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Lütfen Şifre Giriniz","Şifre",2);
				}
				else {
					try {
						myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
						ps=myCnt.prepareStatement(arama);
						ps.setString(1, kullaniciadi);
						ps.setString(2, sifre);
						rs= ps.executeQuery();
						kullaniciAdi=kullaniciadi;
						if (rs.next()) {
							setVisible(false);
							kullaniciAdi=kullaniciadi;
							KullaniciPanel menü=new KullaniciPanel();
							menü.setVisible(true);
							
							menü.setLocationRelativeTo(null);
						// KAPATILACAK	
						}
						else {
							JOptionPane.showMessageDialog(null,"Şifre Veya Kullanıcı Adı Hatalı","Hatalı Giriş",2);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						String query2= "SELECT kullanici_id from kullanici where kullanici_adi='"+kullaniciadi+"'";
						myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
						ps=myCnt.prepareStatement(query2);
						rs=ps.executeQuery();
				   	  rs.next();
							kullanici= rs.getInt(1);
							
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					try {
						String query2= "SELECT kullanici_ulkeID from kullanici where kullanici_adi='"+kullaniciadi+"'";
						myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
						ps=myCnt.prepareStatement(query2);
						rs=ps.executeQuery();
				   	  rs.next();
							kullanici_ulke= rs.getInt(1);
							
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					try {
						String query2= "SELECT kullanici_tur from kullanici where kullanici_adi='"+kullaniciadi+"'";
						myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
						ps=myCnt.prepareStatement(query2);
						rs=ps.executeQuery();
				   	  rs.next();
							kullaniciAbone= rs.getString(1);
							
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					try {
						String query2= "SELECT kullanici_ode from kullanici where kullanici_adi='"+kullaniciadi+"'";
						myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
						ps=myCnt.prepareStatement(query2);
						rs=ps.executeQuery();
				   	  rs.next();
							kullaniciOdeme= rs.getString(1);
							
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
	
		
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Kayıt kayıt=new Kayıt();
				kayıt.setVisible(true);
				
				kayıt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PreparedStatement ps;
				ResultSet rs;
				String kullaniciadi =kullanıcıField_1.getText();
				String sifre =String.valueOf(sifreField.getPassword());
				Connection myCnt;
				
				String arama= "SELECT * FROM kullanici WHERE kullanici_adi = ? AND kullanici_sifre = ?";
				try {
					myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
					ps=myCnt.prepareStatement(arama);
					ps.setString(1, kullaniciadi);
					ps.setString(2, sifre);
					rs= ps.executeQuery();
					
					if (rs.next()) {
						setVisible(false);
						kullaniciAdi=kullaniciadi;
						Admin admin=new Admin();
						admin.setVisible(true);
						
						admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}
					else {
						JOptionPane.showMessageDialog(null,"Şifre Veya Kullanıcı Adı Hatalı","Hatalı Giriş",2);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	}
	
	
	
	
	
}
