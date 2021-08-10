package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.NCCBean;

public class NCCDao {
	DungChung dc = new DungChung();
	
	public ArrayList<NCCBean> getNCC() throws Exception {
		dc.KetNoi();
		ArrayList<NCCBean> ds = new ArrayList<NCCBean>();
		String sql = "select * from NhaCungCap";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String idncc = rs.getString("IDNCC");
			String tenncc = rs.getString("TenNCC");
			String diachi = rs.getString("DiaChi");
			NCCBean ncc = new NCCBean(idncc, tenncc, diachi);
			ds.add(ncc);
		}
		rs.close();
		return ds;
	}
	
	public int Them(String idncc,String tenncc,String diachi) throws Exception{
		String sql="insert into NhaCungCap(IDNCC,TenNCC,DiaChi) values (?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, idncc);
		cmd.setString(2, tenncc);
		cmd.setString(3, diachi);
		return cmd.executeUpdate();
	}
	
	public int Sua(String idncc,String tenncc,String diachi) throws Exception{
		String sql="update NhaCungCap set TenNCC= ?,DiaChi=? where IDNCC=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenncc);
		cmd.setString(2, diachi);
		cmd.setString(3, idncc);
		return cmd.executeUpdate();
	}
	
	public int Xoa(String idncc) throws Exception {
		String sql="delete from NhaCungCap where idncc=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, idncc);
		return cmd.executeUpdate();
	}
}
