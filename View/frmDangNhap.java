package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bean.BienToanCuc;
import Dao.DungChung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class frmDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtten;
	private JPasswordField txtmk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangNhap frame = new frmDangNhap();
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
	public frmDangNhap() {
		setBackground(new Color(176, 224, 230));
		setTitle("Cửa hàng tiện lợi HMZ ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CỬA HÀNG TIỆN LỢI HMZ");
		lblNewLabel.setIcon(new ImageIcon(frmDangNhap.class.getResource("/icons/rsz_12203183.png")));
		lblNewLabel.setForeground(new Color(255, 0, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(75, 0, 596, 136);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(frmDangNhap.class.getResource("/icons/Login-icon-32.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("")) JOptionPane.showMessageDialog(null, "Vui lòng nhập Username");
				else if(txtmk.getText().equals("")) JOptionPane.showMessageDialog(null, "Vui lòng nhập Password");
				else {
					try {
			
						DungChung dc = new DungChung();
						dc.KetNoi();
						String sql = "select * from TaiKhoan where Username=? and Password=?";
						PreparedStatement cmd=dc.cn.prepareStatement(sql);
						cmd.setString(1, txtten.getText());
						cmd.setString(2, txtmk.getText());
						ResultSet rs = cmd.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							frmHome h = new frmHome();
							h.setVisible(true);
							BienToanCuc idnv= new BienToanCuc();
							idnv.setIdNhanVien(rs.getString("IDNhanVien"));
//							System.out.println(idnv.getIdNhanVien());
						}
						else JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
		btnLogin.setForeground(Color.RED);
		btnLogin.setFont(new Font("Stencil", Font.BOLD, 23));
		btnLogin.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogin.setBounds(146, 277, 155, 46);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("reset");
		btnReset.setIcon(new ImageIcon(frmDangNhap.class.getResource("/icons/Actions-document-edit-icon-32.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtten.setText("");
				txtmk.setText("");
			}
		});
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Stencil", Font.BOLD, 23));
		btnReset.setBackground(SystemColor.inactiveCaptionBorder);
		btnReset.setBounds(320, 277, 155, 46);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setIcon(new ImageIcon(frmDangNhap.class.getResource("/icons/Person-Male-Light-icon-24.png")));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(135, 139, 155, 46);
		contentPane.add(lblNewLabel_1);
		
		txtten = new JTextField();
		txtten.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtten.setColumns(10);
		txtten.setBounds(306, 147, 169, 35);
		contentPane.add(txtten);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setIcon(new ImageIcon(frmDangNhap.class.getResource("/icons/Question-Help-icon-16.png")));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(135, 199, 155, 46);
		contentPane.add(lblNewLabel_1_1);
		
		txtmk = new JPasswordField();
		txtmk.setBounds(306, 207, 169, 35);
		contentPane.add(txtmk);
		
		JLabel lblNewLabel_2 = new JLabel("MỜI BẠN ĐĂNG NHẬP");
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(281, 102, 240, 34);
		contentPane.add(lblNewLabel_2);
	}
}
