package Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.HangHoaBean;


public class HangHoaDao {
	DungChung dc = new DungChung();
	public ArrayList<HangHoaBean> getHH() throws Exception{
		dc.KetNoi();
		ArrayList<HangHoaBean> ds = new ArrayList<HangHoaBean>();
		String sql ="select * from HangHoa";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			String idhh = rs.getString("IDHangHoa");
			String tenhh = rs.getString("TenHangHoa");
			int soluong = rs.getInt("SoLuong");
			Double dongia = rs.getDouble("DonGia");
			String donvi = rs.getString("DonVi");
			String idncc = rs.getString("IDNCC");
			HangHoaBean hh = new HangHoaBean(idhh, tenhh, soluong, dongia, donvi, idncc);
			ds.add(hh);
		}
		rs.close();
		return ds;
	}
	
	public int Them(String IDHangHoa, String TenHangHoa, int soLuong, Double donGia, String DonVi, String IDNCC) throws Exception{
		String sql = "insert into HangHoa(IDHangHoa,TenHangHoa,SoLuong,DonGia,DonVi,IDNCC) values(?,?,?,?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, IDHangHoa);
		cmd.setString(2, TenHangHoa);
		cmd.setInt(3, soLuong);
		cmd.setDouble(4, donGia);
		cmd.setString(5, DonVi);
		cmd.setString(6, IDNCC);
		return cmd.executeUpdate();
	}
	
	public int Sua(String IDHangHoa, String TenHangHoa, int sl, Double DonGia, String DonVi, String IDNCC) throws Exception{
		String sql = "update HangHoa set TenHangHoa=?,SoLuong=?,DonGia=?,DonVi=?,IDNCC=? where IDHangHoa = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, TenHangHoa);
		cmd.setInt(2, sl);
		cmd.setDouble(3, DonGia);
		cmd.setString(4, DonVi);
		cmd.setString(5, IDNCC);
		cmd.setString(6, IDHangHoa);
		return cmd.executeUpdate();
	}
	public int UpdateSoLuong(String IDHangHoa,  int soluong) throws Exception{
		String sql = "update HangHoa set SoLuong=SoLuong-? where IDHangHoa = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setInt(1, soluong);
		cmd.setString(2, IDHangHoa);
		return cmd.executeUpdate();
	}
	
	public int Xoa(String IDHangHoa) throws Exception{
		String sql = "delete from HangHoa where IDHangHoa = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, IDHangHoa);
		return cmd.executeUpdate();
	}
}
