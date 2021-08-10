package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Bo.HangHoaBo;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmHangHoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtten;
	private JTextField txtsl;
	private JTextField txtdg;
	private JTextField txtdv;
	private JTextField txtidncc;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHangHoa frame = new frmHangHoa();
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
	HangHoaBo hbo = new HangHoaBo();
	public frmHangHoa() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					hbo.gethh();
					table.setModel(hbo.napbang("HangHoa"));
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setTitle("Cửa hàng tiện lợi HMZ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1185, 689);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN SẢN PHẨM");
		lblNewLabel.setIcon(new ImageIcon(frmHangHoa.class.getResource("/icons/HHH.png")));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 32));
		lblNewLabel.setBounds(137, 10, 539, 152);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID hàng hóa");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 164, 112, 46);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtid.setBounds(151, 172, 169, 35);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên hàng hóa");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(23, 216, 118, 46);
		contentPane.add(lblNewLabel_1_1);
		
		txtten = new JTextField();
		txtten.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtten.setColumns(10);
		txtten.setBounds(151, 224, 169, 35);
		contentPane.add(txtten);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số lượng");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 272, 112, 46);
		contentPane.add(lblNewLabel_1_2);
		
		txtsl = new JTextField();
		txtsl.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtsl.setColumns(10);
		txtsl.setBounds(151, 280, 169, 35);
		contentPane.add(txtsl);
		
		JLabel lblNewLabel_1_3 = new JLabel("Đơn giá");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(23, 328, 112, 46);
		contentPane.add(lblNewLabel_1_3);
		
		txtdg = new JTextField();
		txtdg.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtdg.setColumns(10);
		txtdg.setBounds(151, 336, 169, 35);
		contentPane.add(txtdg);
		
		JLabel lblNewLabel_1_4 = new JLabel("Đơn vị tính");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(23, 384, 112, 46);
		contentPane.add(lblNewLabel_1_4);
		
		txtdv = new JTextField();
		txtdv.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtdv.setColumns(10);
		txtdv.setBounds(151, 392, 169, 35);
		contentPane.add(txtdv);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID NCC");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_5.setBounds(23, 440, 112, 46);
		contentPane.add(lblNewLabel_1_5);
		
		txtidncc = new JTextField();
		txtidncc.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		txtidncc.setColumns(10);
		txtidncc.setBounds(151, 448, 169, 35);
		contentPane.add(txtidncc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 172, 810, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				txtid.setText(table.getValueAt(d, 0).toString());
				txtten.setText(table.getValueAt(d, 1).toString());
				txtsl.setText(table.getValueAt(d, 2).toString());
				txtdg.setText(table.getValueAt(d, 3).toString());
				txtdv.setText(table.getValueAt(d, 4).toString());
				txtidncc.setText(table.getValueAt(d, 5).toString());
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID h\u00E0ng h\u00F3a", "T\u00EAn h\u00E0ng h\u00F3a", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "\u0110\u01A1n v\u1ECB t\u00EDnh", "ID NCC"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(74);
		table.getColumnModel().getColumn(1).setPreferredWidth(243);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(67);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = txtid.getText();
					String ten = txtten.getText();
					int sl = Integer.parseInt(txtsl.getText());
					Double dg = Double.parseDouble(txtdg.getText());
					String dv = txtdv.getText();
					String idncc = txtidncc.getText();
					if(hbo.Them(id, ten, sl, dg, dv, idncc)==1) JOptionPane.showMessageDialog(null, "Đã thêm");
					else JOptionPane.showMessageDialog(null, "Lỗi");
					table.setModel(hbo.napbang("HangHoa"));
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(frmHangHoa.class.getResource("/icons/rsz_1button-add-icon.png")));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.setBounds(23, 510, 118, 54);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = txtid.getText();
					String ten = txtten.getText();
					int sl = Integer.parseInt(txtsl.getText());
					Double dg = Double.parseDouble(txtdg.getText());
					String dv = txtdv.getText();
					String idncc = txtidncc.getText();
					if(hbo.Sua(id, ten, sl, dg, dv, idncc) == 1) JOptionPane.showMessageDialog(null, "Đã sửa");
					else JOptionPane.showMessageDialog(null, "lỗi");
					table.setModel(hbo.napbang("HangHoa"));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnSa.setIcon(new ImageIcon(frmHangHoa.class.getResource("/icons/Actions-document-edit-icon-32.png")));
		btnSa.setForeground(Color.BLACK);
		btnSa.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnSa.setBackground(new Color(216, 191, 216));
		btnSa.setBounds(163, 510, 118, 54);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?");
					if(t==0) {
						String id = txtid.getText();
						hbo.Xoa(id);
						table.setModel(hbo.napbang("HangHoa"));
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnXa.setIcon(new ImageIcon(frmHangHoa.class.getResource("/icons/Button-Close-icon-16.png")));
		btnXa.setForeground(Color.BLACK);
		btnXa.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnXa.setBackground(new Color(216, 191, 216));
		btnXa.setBounds(95, 574, 103, 54);
		contentPane.add(btnXa);
	}
}
