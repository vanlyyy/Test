package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Bean.KhachHangBean;
import Bo.KhachHangBo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtHoTen;
	private JTextField txtThanhToan;
	private JTextField txtDiaChi;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKhachHang frame = new frmKhachHang();
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
	KhachHangBo khbo = new KhachHangBo();

	public frmKhachHang() {
		setBackground(new Color(255, 250, 240));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					khbo.getkh();
					table.setModel(khbo.napbang("KhachHang"));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setTitle("Cửa hàng tiện lợi HMZ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 946, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(frmKhachHang.class.getResource("/icons/Person-Male-Light-icon-48.png")));
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 32));
		lblNewLabel.setBounds(231, 10, 472, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID KHÁCH HÀNG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(31, 107, 135, 38);
		contentPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBackground(SystemColor.inactiveCaption);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtId.setBounds(176, 107, 220, 38);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("HỌ & TÊN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(31, 155, 135, 38);
		contentPane.add(lblNewLabel_1_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setBackground(SystemColor.inactiveCaption);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(176, 155, 220, 38);
		contentPane.add(txtHoTen);
		
		JLabel lblNewLabel_1_2 = new JLabel("HÌNH THỨC THANH TOÁN");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2.setBounds(453, 155, 212, 38);
		contentPane.add(lblNewLabel_1_2);
		
		txtThanhToan = new JTextField();
		txtThanhToan.setBackground(SystemColor.inactiveCaption);
		txtThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtThanhToan.setColumns(10);
		txtThanhToan.setBounds(691, 149, 225, 38);
		contentPane.add(txtThanhToan);
		
		JLabel lblNewLabel_1_3 = new JLabel("ĐỊA CHỈ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1_3.setBounds(453, 106, 135, 38);
		contentPane.add(lblNewLabel_1_3);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(SystemColor.inactiveCaption);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(691, 97, 225, 38);
		contentPane.add(txtDiaChi);
		
		JButton btnNewButton = new JButton("THÊM");
		btnNewButton.setIcon(new ImageIcon(frmKhachHang.class.getResource("/icons/rsz_button-add-icon.png")));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ID= txtId.getText();
					String Ten= txtHoTen.getText();
					String Dc= txtDiaChi.getText();
					String ht = txtThanhToan.getText();
					if(khbo.Them(ID, Ten, Dc, ht)==1) JOptionPane.showMessageDialog(null, "Đã thêm");
					else JOptionPane.showMessageDialog(null, "Lỗi");
					table.setModel(khbo.napbang("KhachHang"));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(31, 235, 100, 38);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("SỬA");
		btnSa.setIcon(new ImageIcon(frmKhachHang.class.getResource("/icons/Actions-document-edit-icon-16.png")));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ID= txtId.getText();
					String Ten= txtHoTen.getText();
					String Dc= txtDiaChi.getText();
					String ht = txtThanhToan.getText();
					if(khbo.Sua(ID, Ten, Dc, ht)==1) JOptionPane.showMessageDialog(null, "Đã sửa");
					else JOptionPane.showMessageDialog(null, "Lỗi");
					table.setModel(khbo.napbang("KhachHang"));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnSa.setBackground(SystemColor.activeCaption);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSa.setBounds(196, 235, 100, 38);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.setIcon(new ImageIcon(frmKhachHang.class.getResource("/icons/Actions-edit-delete-icon-16.png")));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?");
					if(t==0) {
						String ID = txtId.getText();
						khbo.Xoa(ID);
						table.setModel(khbo.napbang("KhachHang"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnXa.setBackground(SystemColor.activeCaption);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXa.setBounds(357, 235, 100, 38);
		contentPane.add(btnXa);
		
		JButton btnTmKim = new JButton("TÌM KIẾM");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input= JOptionPane.showInputDialog(null, "Nhập họ tên khách hàng cần tìm");
				if(input.length()>0) {
					try {
						table.setModel(khbo.TimKiem(input));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
		}});
		btnTmKim.setIcon(new ImageIcon(frmKhachHang.class.getResource("/icons/search-icon-24.png")));
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTmKim.setBounds(659, 235, 147, 38);
		contentPane.add(btnTmKim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(31, 293, 885, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				txtId.setText(table.getValueAt(d, 0).toString());
				txtHoTen.setText(table.getValueAt(d, 1).toString());
				txtDiaChi.setText(table.getValueAt(d, 2).toString());
				txtThanhToan.setText(table.getValueAt(d, 3).toString());
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(175, 238, 238));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID KH\u00C1CH H\u00C0NG", "H\u1ECC V\u00C0 T\u00CAN", "\u0110\u1ECAA CH\u1EC8", "H\u00CCNH TH\u1EE8C THANH TO\u00C1N"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(0).setMinWidth(17);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(117);
		table.getColumnModel().getColumn(3).setPreferredWidth(145);
		scrollPane.setViewportView(table);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtHoTen.setText("");
				txtDiaChi.setText("");
				txtThanhToan.setText("");
			}
		});
		btnReset.setIcon(new ImageIcon(frmKhachHang.class.getResource("/icons/open-file-icon-16.png")));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBackground(SystemColor.activeCaption);
		btnReset.setBounds(504, 235, 100, 38);
		contentPane.add(btnReset);
	}
}
