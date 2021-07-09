import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 868, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ŞARKI EKLE");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ŞarkıEkleme şarkıEkleme = new ŞarkıEkleme();
				şarkıEkleme.setVisible(true);
				şarkıEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(384, 102, 154, 38);
		contentPane.add(btnNewButton);
		
		JButton btnarkcEkle = new JButton("ŞARKICI EKLE");
		btnarkcEkle.setForeground(Color.GREEN);
		btnarkcEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ŞarkıcıEkleme şarkıcıEkleme = new ŞarkıcıEkleme();
				şarkıcıEkleme.setVisible(true);
				şarkıcıEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnarkcEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnarkcEkle.setBackground(Color.BLACK);
		btnarkcEkle.setBounds(384, 177, 154, 38);
		contentPane.add(btnarkcEkle);
		
		JButton btnAlbmEkle = new JButton("ALBÜM EKLE");
		btnAlbmEkle.setForeground(Color.GREEN);
		
		btnAlbmEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlbmEkle.setBackground(Color.BLACK);
		btnAlbmEkle.setBounds(384, 253, 154, 38);
		contentPane.add(btnAlbmEkle);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\csent\\Desktop\\java\\Spotify\\SPOTIFY.png"));
		lblNewLabel_1.setBounds(250, 10, 391, 68);
		contentPane.add(lblNewLabel_1);
		
		JButton btnGiriEkrannaDn = new JButton("Giriş Ekranına Dön");
		btnGiriEkrannaDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Giriş giriş= new Giriş();
				giriş.setVisible(true);
				
				giriş.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnGiriEkrannaDn.setForeground(Color.GREEN);
		btnGiriEkrannaDn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGiriEkrannaDn.setBackground(Color.BLACK);
		btnGiriEkrannaDn.setBounds(384, 317, 154, 38);
		contentPane.add(btnGiriEkrannaDn);
	
	btnAlbmEkle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			AlbümEkle albümEkle = new AlbümEkle();
			albümEkle.setVisible(true);
			albümEkle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	});

}
}