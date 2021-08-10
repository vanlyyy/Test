//package View;
//
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import Bean.KhachHangBean;
//import Dao.DungChung;
//import Dao.KhachHangDao;
//
//public class test {
//
//	public static void main(String[] args) {
////		try {
////			DungChung dc= new DungChung();
////			dc.KetNoi();
////			ResultSet rs= dc.getbang("NhanVien");
////			while (rs.next()) {
////				System.out.println(rs.getString(1));
////				System.out.println(rs.getString(2));
////				System.out.println(rs.getString(3));
////				System.out.println("--------------");
////			}
////			rs.close();
////			
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		
////		try {
////			DungChung dc= new DungChung();
////			dc.KetNoi();
////			ResultSet rs= dc.getbang("HangHoa");
////			while (rs.next()) {
////				System.out.println(rs.getString(1));
////				System.out.println(rs.getString(2));
////				System.out.println(rs.getFloat(3));
////				System.out.println(rs.getFloat(4));
////				System.out.println(rs.getString(5));
////				System.out.println(rs.getString(6));;
////				System.out.println("--------------");
////			}
////			rs.close();
////			
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		KhachHangDao kh = new KhachHangDao();
//		try {
//			DungChung dc= new DungChung();
//			dc.KetNoi();
//			ResultSet rs= dc.getbang("KhachHang");
////			kh.TimKiem("Nguyễn Thị Hòa");
//			while (rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//				System.out.println("--------------");
//			}
//			rs.close();
//			System.out.println("Khách hàng tìm kiếm là: ");
////			ArrayList<KhachHangBean> ds=new ArrayList<KhachHangBean>();
////			ds=kh.TimKiem("Hòa");
//			for(KhachHangBean n: kh.TimKiem("Nguyễn Thị Hòa")) {
//				System.out.println(n.getIdkh());
//				System.out.println(n.getHoten());
//			}
//				
////			if(kh.TimKiem("Hòa")!=null)
////				System.out.println(" có ");
////			else System.out.println(" Khhoong");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}
