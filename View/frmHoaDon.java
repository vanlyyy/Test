package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Bean.BienToanCuc;
import Bean.HangHoaBean;
import Bean.HoaDonBean;
import Bean.JComboboxCustom;
import Bean.KhachHangBean;
import Bean.comboboxHangHoa;
import Bo.CTHDBo;
import Bo.HangHoaBo;
import Bo.HoaDonBo;
import Bo.KhachHangBo;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.Color;


public class frmHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable tblHoaDon;
	private JTextField txtSL;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHoaDon frame = new frmHoaDon();
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

	JComboBox cmbKH = new JComboBox();
	JComboBox cmbHangHoa = new JComboBox();
	HoaDonBo hdBo = new HoaDonBo();
	CTHDBo ctBo = new CTHDBo();
	HangHoaBo hhBo = new HangHoaBo();
	private JTextField txtHoTen;
	private JTextField txtTenHang;
	private JTextField txtIdNV;
	private JTextField txtNgayMua;
	public frmHoaDon() {
		setTitle("Cửa hàng tiện lợi HMZ");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					BienToanCuc b = new BienToanCuc();
					txtIdNV.setText(b.getIdNhanVien());
					
					KhachHangBo khBo = new KhachHangBo();
					ArrayList<KhachHangBean> dsKH = khBo.getkh();
					for(KhachHangBean kh: dsKH ) {
						String key = kh.getIdkh();
						String value = kh.getHoten();
						JComboboxCustom item = new JComboboxCustom(key, value);
						cmbKH.addItem(item);
					}
					
					HangHoaBo hhBo = new HangHoaBo();
					ArrayList<HangHoaBean> dsHH = hhBo.gethh();
					for(HangHoaBean hh: dsHH) {
						String key = hh.getIdhh();
						String value = hh.getTenhh();
						Double dongia= hh.getDongia();
						String donvi= hh.getDonvi();
						int soluong= hh.getSoluong();
						comboboxHangHoa item = new comboboxHangHoa(key, value, dongia, donvi, soluong);
						cmbHangHoa.addItem(item);
					}
					HoaDonBean hdBean = new HoaDonBean();
					txtNgayMua.setText(hdBo.NgayHienTai());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 957, 668);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 28));
		lblNewLabel.setBounds(270, 6, 377, 58);
		contentPane.add(lblNewLabel);
		cmbKH.setBackground(new Color(253, 245, 230));
		cmbKH.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				Object item = cmbKH.getSelectedItem();
				String value = ((JComboboxCustom)item).getValue();
//				System.out.println(value + ' ' + item);
				txtHoTen.setText(value);
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cmbKH.setBounds(168, 121, 127, 30);
		contentPane.add(cmbKH);
		
		JButton btnNewButton = new JButton("Thanh toán");
		btnNewButton.setForeground(new Color(210, 105, 30));
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object item = cmbKH.getSelectedItem();
					String idkh = ((JComboboxCustom)item).getKey();
					String idnv = txtIdNV.getText();
					SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
					Date ngaymua = dd.parse(txtNgayMua.getText());
					int idhd = hdBo.Them(idkh, idnv, ngaymua);
					
					int d = tblHoaDon.getRowCount();
					int kt=0;
					for(int i=0; i<d;i++) {
						String idhh = tblHoaDon.getValueAt(i, 0).toString();
						int soluong = Integer.parseInt((String) tblHoaDon.getValueAt(i, 4));
						kt = ctBo.Them(idhd, idhh, soluong);
						hhBo.UpdateSoLuong(idhh, soluong);
					}
					if (kt==1) JOptionPane.showMessageDialog(null, "Đã thanh toán");
					else JOptionPane.showMessageDialog(null, "Lỗi");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(764, 559, 134, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng tiền");
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblNewLabel_2.setBounds(639, 509, 127, 34);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 261, 917, 225);
		contentPane.add(scrollPane);
		
		tblHoaDon = new JTable();
		tblHoaDon.setBackground(new Color(255, 239, 213));
		tblHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID h\u00E0ng h\u00F3a", "T\u00EAn h\u00E0ng h\u00F3a", "\u0110\u01A1n v\u1ECB t\u00EDnh", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng"
			}
		));
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(101);
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(154);
		tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(93);
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(82);
		scrollPane.setViewportView(tblHoaDon);
		
		txtSL = new JTextField();
		txtSL.setBackground(new Color(253, 245, 230));
		txtSL.setBounds(516, 205, 96, 30);
		contentPane.add(txtSL);
		txtSL.setColumns(10);
		cmbHangHoa.setBackground(new Color(253, 245, 230));
		cmbHangHoa.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				Object item = cmbHangHoa.getSelectedItem();
				String value = ((comboboxHangHoa)item).getValue();
				txtTenHang.setText(value);
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		
		
		cmbHangHoa.setBounds(168, 161, 127, 30);
		contentPane.add(cmbHangHoa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(255, 69, 0));
		btnThem.setBackground(new Color(240, 230, 140));
		btnThem.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		JLabel txtTong = new JLabel("0.0");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = cmbHangHoa.getSelectedItem();
				DefaultTableModel mh =(DefaultTableModel)tblHoaDon.getModel();
				Object[] t = new Object[6];
				t[0]=((comboboxHangHoa)item).getKey();
				t[1]=txtTenHang.getText();
				t[2]=((comboboxHangHoa)item).getDonvi();
				t[3]=((comboboxHangHoa)item).getDongia();
				t[4]=txtSL.getText();
				Double a= ((comboboxHangHoa)item).getDongia() * Double.parseDouble(txtSL.getText());
//				t[5]=a.toString();
				t[5]=a;
				if(Double.parseDouble(txtSL.getText()) <= ((comboboxHangHoa)item).getSoluong()) {
					mh.addRow(t);
				}
				else JOptionPane.showMessageDialog(null, "Số lượng hàng không đủ");
				
				double total = 0;
				for(int i=0; i<tblHoaDon.getRowCount();i++) {
//					double amount = Double.parseDouble((String)tblHoaDon.getValueAt(i, 5));
					double amount = (double) tblHoaDon.getValueAt(i, 5);
					total= total+ amount;
				}
				txtTong.setText(String.valueOf(total));
			}
		});
		btnThem.setBounds(715, 191, 96, 40);
		contentPane.add(btnThem);
		
		txtHoTen = new JTextField();
		txtHoTen.setBackground(new Color(253, 245, 230));
		txtHoTen.setEditable(false);
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(516, 122, 147, 30);
		contentPane.add(txtHoTen);
		
		txtTenHang = new JTextField();
		txtTenHang.setBackground(new Color(253, 245, 230));
		txtTenHang.setEditable(false);
		txtTenHang.setColumns(10);
		txtTenHang.setBounds(516, 161, 147, 32);
		contentPane.add(txtTenHang);
		
	
		txtTong.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		txtTong.setBounds(792, 499, 127, 46);
		contentPane.add(txtTong);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID Nhân Viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setBounds(23, 78, 109, 21);
		contentPane.add(lblNewLabel_1_1);
		
		txtIdNV = new JTextField();
		txtIdNV.setBackground(new Color(250, 250, 210));
		txtIdNV.setForeground(new Color(0, 0, 0));
		txtIdNV.setEditable(false);
		txtIdNV.setColumns(10);
		txtIdNV.setBounds(168, 74, 127, 30);
		contentPane.add(txtIdNV);
		
		txtNgayMua = new JTextField();
		txtNgayMua.setBackground(new Color(253, 245, 230));
		txtNgayMua.setEditable(false);
		txtNgayMua.setColumns(10);
		txtNgayMua.setBounds(516, 76, 147, 30);
		contentPane.add(txtNgayMua);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID Khách Hàng");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(23, 121, 140, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("ID Hàng Hóa");
		lblNewLabel_1_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(23, 161, 119, 24);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Họ tên khách hàng");
		lblNewLabel_1_1_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_4.setBounds(336, 130, 157, 21);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ngày mua");
		lblNewLabel_1_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(336, 84, 109, 21);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Tên hàng hóa");
		lblNewLabel_1_1_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_5.setBounds(336, 161, 127, 30);
		contentPane.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Số lượng");
		lblNewLabel_1_1_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_6.setBounds(336, 207, 109, 21);
		contentPane.add(lblNewLabel_1_1_6);
		
		JButton btnDanhSchHa = new JButton("Danh sách hóa đơn");
		btnDanhSchHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDanhSachHD f = new frmDanhSachHD();
				f.setVisible(true);
			}
		});
		btnDanhSchHa.setForeground(new Color(220, 20, 60));
		btnDanhSchHa.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDanhSchHa.setBackground(new Color(255, 228, 225));
		btnDanhSchHa.setBounds(10, 515, 238, 40);
		contentPane.add(btnDanhSchHa);
	}
}
