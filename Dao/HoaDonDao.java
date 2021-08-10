package Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Bean.HoaDonBean;

public class HoaDonDao {
	DungChung dc = new DungChung();
	public ArrayList<HoaDonBean> getHD() throws Exception{
		dc.KetNoi();
		ArrayList<HoaDonBean> ds = new ArrayList<HoaDonBean>();
		String sql ="select * from HoaDon";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			int idhd = rs.getInt("IDHoaDon");
			String idkh = rs.getString("IDKhachHang");
			String idnv = rs.getString("IDNhanVien");
			Date ngaymua = rs.getDate("NgayMua");
			HoaDonBean hd = new HoaDonBean(idhd, idkh, idnv, ngaymua);
			ds.add(hd);
		}
		rs.close();
		return ds;
	}
	
	public int Them(String idkh, String idnv, Date ngaymua) throws Exception {
		String sql="insert into HoaDon(IDKhachHang, IDNhanVien,NgayMua) values(?,?,?)";
		PreparedStatement cmd=dc.cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		cmd.setString(1, idkh);
		cmd.setString(2, idnv);
		cmd.setDate(3,new java.sql.Date(ngaymua.getTime()));
		int id=0;
		cmd.executeUpdate();
		ResultSet rs= cmd.getGeneratedKeys();
		if(rs.next())
			id = rs.getInt(1);
		return id;
	}
}
