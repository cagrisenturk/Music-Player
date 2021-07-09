import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class Kayıt extends JFrame {

	private JPanel contentPane;
	private JTextField kullacıcıadField;
	private JTextField emailField;
	private JPasswordField şifre1Field;
	private JPasswordField şifre2Field;
	private JComboBox Ülke = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kayıt frame = new Kayıt();
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
	public Kayıt() {
		setTitle("Kayıt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel KAYIT = new JLabel("");
		KAYIT.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\KAYITFORMU.png"));
		KAYIT.setFont(new Font("Tahoma", Font.BOLD, 14));
		KAYIT.setBounds(184, 10, 360, 41);
		contentPane.add(KAYIT);
		
		JButton kayıtButonu = new JButton("Kayıt Ol");
		kayıtButonu.setBackground(Color.WHITE);
		kayıtButonu.setFont(new Font("Tahoma", Font.BOLD, 14));
		kayıtButonu.setBounds(294, 319, 186, 38);
		contentPane.add(kayıtButonu);
		
		JLabel lblKullancAd = new JLabel("Kullanıcı Adı :");
		lblKullancAd.setForeground(Color.WHITE);
		lblKullancAd.setBackground(Color.WHITE);
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKullancAd.setBounds(23, 81, 104, 29);
		contentPane.add(lblKullancAd);
		
		kullacıcıadField = new JTextField();
		kullacıcıadField.setFont(new Font("Tahoma", Font.BOLD, 14));
		kullacıcıadField.setColumns(10);
		kullacıcıadField.setBounds(137, 81, 179, 29);
		contentPane.add(kullacıcıadField);
		
		JLabel lblUlke = new JLabel("Ülke:");
		lblUlke.setForeground(Color.WHITE);
		lblUlke.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUlke.setBounds(23, 198, 104, 29);
		contentPane.add(lblUlke);
		
		JLabel lblEMail = new JLabel("Email :");
		lblEMail.setForeground(Color.WHITE);
		lblEMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEMail.setBounds(23, 159, 104, 29);
		contentPane.add(lblEMail);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailField.setColumns(10);
		emailField.setBounds(137, 159, 179, 29);
		contentPane.add(emailField);
		
		JLabel lblSifre = new JLabel("Şifre :");
		lblSifre.setForeground(Color.WHITE);
		lblSifre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSifre.setBounds(23, 120, 104, 29);
		contentPane.add(lblSifre);
		
		JLabel lblI = new JLabel("Üyelik Türü :");
		lblI.setForeground(Color.WHITE);
		lblI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblI.setBounds(23, 237, 104, 29);
		contentPane.add(lblI);
		
		JLabel lblSifreyiDogrula = new JLabel("Şifreyi Doğrula :");
		lblSifreyiDogrula.setForeground(Color.WHITE);
		lblSifreyiDogrula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSifreyiDogrula.setBounds(335, 120, 119, 29);
		contentPane.add(lblSifreyiDogrula);
		
		JRadioButton rdbtnNormalÜyelik = new JRadioButton("Normal");
		rdbtnNormalÜyelik.setBackground(Color.WHITE);
		rdbtnNormalÜyelik.setSelected(true);
		rdbtnNormalÜyelik.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNormalÜyelik.setBounds(124, 243, 103, 21);
		contentPane.add(rdbtnNormalÜyelik);
		
		JRadioButton rdbtnPremium = new JRadioButton("Premium");
		rdbtnPremium.setBackground(Color.WHITE);
		rdbtnPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnPremium.setBounds(229, 243, 103, 21);
		contentPane.add(rdbtnPremium);
		
		şifre1Field = new JPasswordField();
		şifre1Field.setFont(new Font("Tahoma", Font.BOLD, 13));
		şifre1Field.setBounds(137, 120, 181, 29);
		contentPane.add(şifre1Field);
		
		şifre2Field = new JPasswordField();
		şifre2Field.setFont(new Font("Tahoma", Font.BOLD, 13));
		şifre2Field.setBounds(469, 120, 181, 29);
		contentPane.add(şifre2Field);
		
		
		ButtonGroup butongrup=new ButtonGroup();
		butongrup.add(rdbtnNormalÜyelik);
		butongrup.add(rdbtnPremium);
		
		JLabel lblHesabnzVarM = new JLabel("Hesabınız Var Mı?  Giriş Yap?");
		
		lblHesabnzVarM.setForeground(Color.GREEN);
		lblHesabnzVarM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHesabnzVarM.setBounds(307, 367, 147, 38);
		contentPane.add(lblHesabnzVarM);
		
		

		Ülke.setBounds(137, 204, 86, 22);
		contentPane.add(Ülke);
		
		kayıtButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kullaiciadi =kullacıcıadField.getText();
				int kullaniciulke =Ülke.getSelectedIndex()+1;
				String kullaniciEmail =emailField.getText();
				String sifre1=String.valueOf(şifre1Field.getPassword());
				String sifre2=String.valueOf(şifre2Field.getPassword());
				String üyelik= "normal";
				
				if (rdbtnPremium.isSelected()) {
					üyelik="pre";
				}
				if (kontrol()) {
					if (!kullaniciadiKontrol(kullaiciadi)) {
						
						PreparedStatement pStatement;
						 ResultSet rs;
						 Connection myCnt;
						 String kullanicikaydi="INSERT INTO kullanici(kullanici_adi,kullanici_sifre,kullanici_ulkeID,kullanici_tur,kullanici_email,kullanici_ode) VALUES(?,?,?,?,?,?)";
						 try {
							myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
							pStatement=myCnt.prepareStatement(kullanicikaydi);
							pStatement.setString(1, kullaiciadi);
							pStatement.setString(2, sifre1);
							pStatement.setInt(3, kullaniciulke);
							pStatement.setString(4, üyelik);
							pStatement.setString(5, kullaniciEmail);
							if (üyelik.equals("pre")) {
								pStatement.setString(6, "odemedi");
							}
							else {
								pStatement.setString(6,null);
							}
							
							if (pStatement.executeUpdate()!=0) {
								JOptionPane.showMessageDialog(null,"Kaydınız Olusmustur");
							for (int i = 1; i < 4; i++) {
								
							
								String sorgu="INSERT INTO calma_listesi(sahip_id,tur_id) VALUES(?,?)";
								 try {
										myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
										pStatement=myCnt.prepareStatement(sorgu);
										pStatement.setInt(1, maxBul());
										pStatement.setInt(2, i);
										pStatement.executeUpdate();
								 }
								 catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
							}
							
							}
							else {
								JOptionPane.showMessageDialog(null,"Bilgilerinizi Kontrol Ediniz");
							}
							
						 } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
					}
				}
				
				
				
				
			}
		});
		lblHesabnzVarM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Giriş giriş=new Giriş();
				giriş.setVisible(true);
				giriş.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
				
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
	
	public boolean kontrol() {
		String kullaiciadi =kullacıcıadField.getText();
		int kullaniciulke =Ülke.getSelectedIndex()+1;
		String kullaniciEmail =emailField.getText();
		String sifre1=String.valueOf(şifre1Field.getPassword());
		String sifre2=String.valueOf(şifre2Field.getPassword());
	
		if (kullaiciadi.trim().equals("")||
				 kullaniciEmail.trim().equals("")|| sifre1.trim().equals("")
				|| sifre2.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Bir Veya Birden fazla alan boş bırakıldı","Boş Alan",2);
			return false;
		}
		else if (!sifre1.equals(sifre2)) {
			JOptionPane.showMessageDialog(null, "Şifreler Uyuşmuyor");	
			return false;
	}
		else {
			return true;
		}
	
	}
	
	 public boolean kullaniciadiKontrol(String kullaniciadi) {
		 PreparedStatement statement;
		 ResultSet rs;
		 Connection myCnt;
		 boolean kullaniciadiDurumu=false;
		 
		 String arama =("SELECT * FROM kullanici WHERE kullanici_adi =?");
		 
		 try {
			myCnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","1234");
			statement=myCnt.prepareStatement(arama);
			statement.setString(1, kullaniciadi);
			rs=statement.executeQuery();
			
			if (rs.next()) {
				kullaniciadiDurumu=true;
				JOptionPane.showMessageDialog(null,"Bu kullanıcıadı kullanılıyor","Kullanıcıadı Hatası" ,2);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return kullaniciadiDurumu;
	}

	 public int maxBul() {
			Connection c;
			PreparedStatement s;
			ResultSet r;
			 int x=0;
			 String query1 = "SELECT MAX(kullanici_id) FROM kullanici";
				try {
					 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify", "root", "1234");
						s=c.prepareStatement(query1)	;
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


