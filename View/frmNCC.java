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
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Bo.NCCBo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmNCC extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtten;
	private JTextField txtdc;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNCC frame = new frmNCC();
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
	NCCBo nbo= new NCCBo();
	public frmNCC() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					nbo.getNCC();
					table.setModel(nbo.napbang("NhaCungCap"));
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setTitle("Cửa hàng tiện lợi HMZ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 903, 481);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin nhà cung cấp");
		lblNewLabel.setIcon(new ImageIcon(frmNCC.class.getResource("/icons/Actions-help-about-icon-48.png")));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 32));
		lblNewLabel.setBounds(207, 9, 490, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IDNCC");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(81, 95, 90, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên NCC");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(81, 144, 90, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(83, 187, 90, 33);
		contentPane.add(lblNewLabel_3);
		
		txtid = new JTextField();
		txtid.setBackground(new Color(230, 230, 250));
		txtid.setForeground(new Color(0, 0, 0));
		txtid.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		txtid.setBounds(181, 92, 216, 36);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtten = new JTextField();
		txtten.setBackground(new Color(230, 230, 250));
		txtten.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		txtten.setColumns(10);
		txtten.setBounds(181, 136, 216, 36);
		contentPane.add(txtten);
		
		txtdc = new JTextField();
		txtdc.setBackground(new Color(230, 230, 250));
		txtdc.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		txtdc.setColumns(10);
		txtdc.setBounds(183, 187, 214, 36);
		contentPane.add(txtdc);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon(frmNCC.class.getResource("/icons/rsz_button-add-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idncc = txtid.getText();
					String tenncc= txtten.getText();
					String diachi = txtdc.getText();
					if(nbo.Them(idncc, tenncc, diachi)==1) JOptionPane.showMessageDialog(null,"Đã thêm");
					else JOptionPane.showMessageDialog(null, "Lỗi");
					table.setModel(nbo.napbang("NhaCungCap"));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnNewButton.setBounds(465, 92, 103, 54);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(frmNCC.class.getResource("/icons/Actions-document-edit-icon-16.png")));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idncc = txtid.getText();
					String tenncc= txtten.getText();
					String diachi = txtdc.getText();
					if(nbo.Sua(idncc, tenncc, diachi)==1) JOptionPane.showConfirmDialog(null,"Đã sửa");
					else JOptionPane.showMessageDialog(null, "Lỗi");
					table.setModel(nbo.napbang("NhaCungCap"));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnSa.setForeground(Color.BLACK);
		btnSa.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnSa.setBackground(new Color(216, 191, 216));
		btnSa.setBounds(465, 156, 103, 54);
		contentPane.add(btnSa);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon(frmNCC.class.getResource("/icons/Actions-edit-delete-icon-16.png")));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int t=JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?");
					if(t==0) {
						String idncc = txtid.getText();
						nbo.Xoa(idncc);
						table.setModel(nbo.napbang("NhaCungCap"));
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnXa.setForeground(Color.BLACK);
		btnXa.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnXa.setBackground(new Color(216, 191, 216));
		btnXa.setBounds(590, 92, 103, 54);
		contentPane.add(btnXa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 230, 698, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				txtid.setText(table.getValueAt(d, 0).toString());
				txtten.setText(table.getValueAt(d, 1).toString());
				txtdc.setText(table.getValueAt(d, 2).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID Nh\u00E0 Cung C\u1EA5p", "T\u00EAn Nh\u00E0 Cung C\u1EA5p", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		table.getColumnModel().getColumn(1).setPreferredWidth(206);
		table.getColumnModel().getColumn(2).setPreferredWidth(154);
		table.setBackground(SystemColor.activeCaption);
		table.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
	}
}
