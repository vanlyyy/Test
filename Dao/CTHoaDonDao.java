package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.ChiTietHoaDonBean;


public class CTHoaDonDao {
	DungChung dc = new DungChung();
	public ArrayList<ChiTietHoaDonBean> getCT() throws Exception{
		dc.KetNoi();
		ArrayList<ChiTietHoaDonBean> ds = new ArrayList<ChiTietHoaDonBean>();
		String sql ="select * from ChiTietHoaDon";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			int idhd = rs.getInt("IDHoaDon");
			String idkh = rs.getString("IDHangHoa");
			int soluong = rs.getInt("SoLuong");
			ChiTietHoaDonBean ct = new ChiTietHoaDonBean(idhd, idkh, soluong);
			ds.add(ct);
		}
		rs.close();
		return ds;
	}
	public int Them(int idhd, String idhh, int soluong) throws Exception {
		String sql="insert into ChiTietHoaDon(IDHoaDon,IDHangHoa, SoLuong) values(?,?,?)";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		cmd.setInt(1, idhd);
		cmd.setString(2, idhh);
		cmd.setInt(3, soluong);
		return cmd.executeUpdate();
	}


}
