package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHome frame = new frmHome();
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
	public frmHome() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Cửa hàng tiện lợi HMZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CỬA HÀNG TIỆN LỢI HMZ");
		lblNewLabel.setBounds(142, 10, 596, 136);
		lblNewLabel.setForeground(new Color(255, 0, 153));
		lblNewLabel.setIcon(new ImageIcon(frmHome.class.getResource("/icons/rsz_12203183.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JButton btnKH = new JButton("KHÁCH HÀNG");
		btnKH.setBounds(42, 202, 218, 62);
		btnKH.setForeground(Color.RED);
		btnKH.setIcon(new ImageIcon(frmHome.class.getResource("/icons/Person-Male-Light-icon-24.png")));
		btnKH.setFont(new Font("Stencil", Font.BOLD, 23));
		btnKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKhachHang f = new frmKhachHang();
				f.setVisible(true);
			}
		});
		btnKH.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnKH);
		
		JButton btnHH = new JButton("HÀNG HÓA");
		btnHH.setBounds(302, 202, 209, 62);
		btnHH.setIcon(new ImageIcon(frmHome.class.getResource("/icons/new-icon-48.png")));
		btnHH.setFont(new Font("Stencil", Font.BOLD, 23));
		btnHH.setForeground(Color.RED);
		btnHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHangHoa f = new frmHangHoa();
				f.setVisible(true);
			}
		});
		btnHH.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnHH);
		
		JButton btnNCC = new JButton("NHÀ CUNG CÂP");
		btnNCC.setBounds(570, 202, 234, 62);
		btnNCC.setIcon(new ImageIcon(frmHome.class.getResource("/icons/Apps-preferences-desktop-user-password-icon-24.png")));
		btnNCC.setFont(new Font("Stencil", Font.BOLD, 23));
		btnNCC.setForeground(Color.RED);
		btnNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNCC f = new frmNCC();
				f.setVisible(true);
			}
		});
		btnNCC.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(btnNCC);
		
		JButton btnHan = new JButton("HÓA ĐƠN");
		btnHan.setIcon(new ImageIcon(frmHome.class.getResource("/icons/Actions-document-edit-icon-32.png")));
		btnHan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHoaDon f = new frmHoaDon();
				f.setVisible(true);
			}
		});
		btnHan.setForeground(Color.RED);
		btnHan.setFont(new Font("Sitka Text", Font.BOLD, 23));
		btnHan.setBackground(SystemColor.inactiveCaptionBorder);
		btnHan.setBounds(302, 297, 209, 62);
		contentPane.add(btnHan);
	}
}
