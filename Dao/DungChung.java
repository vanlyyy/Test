package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.DefaultTableModel;

public class DungChung {
	public static Connection cn;
	
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		
		String url="jdbc:sqlserver://DESKTOP-7VC9MRJ\\SQLEXPRESS:1433;databaseName=NienLuan2020; user=sa; password=123";
		cn=DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	
	public ResultSet getbang(String tb) throws Exception{
		String sql="select * from " + tb;
		PreparedStatement cmd =cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery(); 
		return rs;
		
	}
	
	public DefaultTableModel napbang(String tb) throws Exception{
		DefaultTableModel mh = new DefaultTableModel();
		ResultSet rs = getbang(tb);
		ResultSetMetaData mt = rs.getMetaData();
		
		int socot = mt.getColumnCount();
		for(int i=1; i<=socot; i++)
			mh.addColumn(mt.getColumnName(i));
		
		while(rs.next()) {
			Object[] t = new Object[socot];
			for(int i=1;i<=socot;i++) 
				t[i-1]= rs.getString(i);
			mh.addRow(t);
		}
		return mh;
	}
}
