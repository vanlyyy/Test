package Bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Bean.KhachHangBean;
import Dao.DungChung;
import Dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao = new KhachHangDao();
	ArrayList<KhachHangBean> ds;
	
	public ArrayList<KhachHangBean> getkh() throws Exception {
		ds = khdao.getKH();
		return ds;
	}
	
	public DefaultTableModel napbang(String tb) throws Exception {
		DungChung dc= new DungChung();
		return dc.napbang(tb);
	}
	
	public int Them(String IDKhachHang, String TenKhachHang, String DiaChi, String HinhThucThanhToan) throws Exception {
		for(KhachHangBean n: ds)
			if(n.getIdkh().equals(IDKhachHang)) 
				return 0;
		KhachHangBean kh = new KhachHangBean(IDKhachHang, TenKhachHang, DiaChi, HinhThucThanhToan);
		ds.add(kh);
		return khdao.Them(IDKhachHang, TenKhachHang, DiaChi, HinhThucThanhToan);
	}
	
	public int Sua(String IDKhachHang, String TenKhachHang, String DiaChi, String HinhThucThanhToan) throws Exception {
		for(KhachHangBean khbean: ds)
			if(khbean.getIdkh().equals(IDKhachHang)) {
				khbean.setHoten(TenKhachHang);
				khbean.setDiachi(DiaChi);
				khbean.setHtttoan(HinhThucThanhToan);
			}
		return khdao.Sua(IDKhachHang, TenKhachHang, DiaChi, HinhThucThanhToan);	
	}
	
	public int Xoa(String IDKhachHang) throws Exception {
		for(KhachHangBean khbean: ds)
			if(khbean.getIdkh().equals(IDKhachHang)) {
				ds.remove(khbean);
				break;
			}
		return khdao.Xoa(IDKhachHang);
	}
	

	public DefaultTableModel TimKiem(String TenKhachHang) throws Exception{
		DungChung dc= new DungChung();
		DefaultTableModel mh = new DefaultTableModel();
		ResultSet rs = dc.getbang("KhachHang") ;
		ResultSetMetaData mt = rs.getMetaData();
		int socot = mt.getColumnCount();
		for(int i=1;i<=socot; i++)
			mh.addColumn(mt.getColumnName(i));
		String sql = "select * from KhachHang where TenKhachHang like ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, "%"+TenKhachHang+"%");
		ResultSet rs1 = cmd.executeQuery();
		while(rs1.next()) {
			mh.addRow(new Object[] {rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4)});
		}
		rs1.close();
		return mh;
	}
	
	public DefaultTableModel TimKiemTen(String TenKhachHang) throws Exception{
		DungChung dc= new DungChung();
		DefaultTableModel mh = new DefaultTableModel();
		ResultSet rs = dc.getbang("KhachHang") ;
		ResultSetMetaData mt = rs.getMetaData();
		int socot = mt.getColumnCount();
		for(int i=1;i<=socot; i++)
			mh.addColumn(mt.getColumnName(i));
		String sql = "select * from KhachHang where TenKhachHang like ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, "%"+TenKhachHang+"%");
		ResultSet rs1 = cmd.executeQuery();
		while(rs1.next()) {
			mh.addRow(new Object[] {rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4)});
		}
		rs1.close();
		return mh;
	}
	
	
	
}
