package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.KhachHangBean;

public class KhachHangDao {
	DungChung dc= new DungChung();
	
	public ArrayList<KhachHangBean> getKH() throws Exception{
		dc.KetNoi();
		ArrayList<KhachHangBean> ds= new ArrayList<KhachHangBean>();
		String sql ="select * from KhachHang";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String idkh = rs.getString("IDKhachHang");
			String hoten = rs.getString("TenKhachHang");
			String diachi = rs.getString("DiaChi");
			String htttoan = rs.getString("HinhThucThanhToan");
			KhachHangBean kh = new KhachHangBean(idkh,hoten,diachi,htttoan);
			ds.add(kh);
		}
		rs.close();
		return ds;
	}
	
	public int Them(String IDKhachHang, String TenKhachHang, String DiaChi, String HinhThucThanhToan) throws Exception {
		String sql="insert into KhachHang(IDKhachHang,TenKhachHang, DiaChi,HinhThucThanhToan) values(?,?,?,?)";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, IDKhachHang);
		cmd.setString(2, TenKhachHang);
		cmd.setString(3, DiaChi);
		cmd.setString(4, HinhThucThanhToan);
		return cmd.executeUpdate();
	}
	
	public int Sua(String IDKhachHang, String TenKhachHang, String DiaChi, String HinhThucThanhToan) throws Exception {
		String sql="update KhachHang set TenKhachHang=?, DiaChi=?, HinhThucThanhToan=? where IDKhachHang=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, TenKhachHang);
		cmd.setString(2, DiaChi);
		cmd.setString(3, HinhThucThanhToan);
		cmd.setString(4, IDKhachHang);
		return cmd.executeUpdate();
	}
	
	public int Xoa(String IDKhachHang) throws Exception{
		String sql="delete from KhachHang where IDKhachHang=?";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setString(1, IDKhachHang);
		return cmd.executeUpdate();
	}
	

}
