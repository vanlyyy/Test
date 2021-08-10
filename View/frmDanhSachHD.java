package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Bo.KhachHangBo;
import Dao.DungChung;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDanhSachHD extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDanhSachHD frame = new frmDanhSachHD();
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
	public frmDanhSachHD() {
		setTitle("Cửa hàng tiện lợi HMZ");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					DungChung dc = new DungChung();
					DefaultTableModel mh = (DefaultTableModel)table.getModel();
					dc.KetNoi();
					String sql ="select hd.IDHoaDon, hd.IDKhachHang, kh.TenKhachHang, hd.NgayMua from HoaDon as hd, KhachHang as kh where hd.IDKhachHang=kh.IDKhachHang";
					PreparedStatement cmd=dc.cn.prepareStatement(sql);
					ResultSet rs= cmd.executeQuery();
					
					while(rs.next()) {
						Object[] t = new Object[4];
						t[0] = rs.getInt("IDHoaDon");
						t[1] = rs.getString("IDKhachHang");
						t[2] = rs.getString("TenKhachHang");
						t[3]= rs.getDate("NgayMua");
						mh.addRow(t);
					}
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 976, 534);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 25));
		lblNewLabel.setBounds(288, 14, 323, 55);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 120, 916, 321);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(176, 224, 230));
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID H\u00F3a \u0111\u01A1n", "ID Kh\u00E1ch h\u00E0ng", "H\u1ECD t\u00EAn Kh\u00E1ch h\u00E0ng", "Ng\u00E0y mua"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(81);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(228);
		table.getColumnModel().getColumn(3).setPreferredWidth(178);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập tên cần tìm: ");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1.setBounds(75, 81, 163, 27);
		contentPane.add(lblNewLabel_1);
		
		txtten = new JTextField();
		txtten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtten.setBounds(248, 79, 163, 29);
		contentPane.add(txtten);
		txtten.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DungChung dc= new DungChung();
//					DefaultTableModel mh1 = (DefaultTableModel)table.getModel();
					DefaultTableModel mh1 = new DefaultTableModel();
					mh1.addColumn("IDHoaDon");
					mh1.addColumn("IDKhachHang");
					mh1.addColumn("TenKhachHang");
					mh1.addColumn("NgayMua");
					String sql1 ="select hd.IDHoaDon, hd.IDKhachHang, kh.TenKhachHang, hd.NgayMua from HoaDon as hd, KhachHang as kh where hd.IDKhachHang=kh.IDKhachHang and kh.TenKhachHang like ?";
					PreparedStatement cmd1 = dc.cn.prepareStatement(sql1);
					cmd1.setString(1, "%"+ txtten.getText() +"%");
					ResultSet rs1 = cmd1.executeQuery();
					while(rs1.next()) 
//						mh1.addRow(new Object[] {rs1.getString("IDHoaDon"),rs1.getString("IDKhachHang"),rs1.getString("TenKhachHang"),rs1.getDate("NgayMua")});
						mh1.addRow(new Object[] {rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4)});
						rs1.close();
					table.setModel(mh1);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(490, 81, 100, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DungChung dc = new DungChung();
					DefaultTableModel mh = (DefaultTableModel)table.getModel();
					dc.KetNoi();
					String sql ="select hd.IDHoaDon, hd.IDKhachHang, kh.TenKhachHang, hd.NgayMua from HoaDon as hd, KhachHang as kh where hd.IDKhachHang=kh.IDKhachHang";
					PreparedStatement cmd=dc.cn.prepareStatement(sql);
					ResultSet rs= cmd.executeQuery();
					
					while(rs.next()) {
						Object[] t = new Object[4];
						t[0] = rs.getInt("IDHoaDon");
						t[1] = rs.getString("IDKhachHang");
						t[2] = rs.getString("TenKhachHang");
						t[3]= rs.getDate("NgayMua");
						mh.addRow(t);
					}
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(629, 81, 85, 27);
		contentPane.add(btnNewButton_1);
	}
}
