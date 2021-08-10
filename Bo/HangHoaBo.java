package Bo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Bean.HangHoaBean;
import Dao.DungChung;
import Dao.HangHoaDao;

public class HangHoaBo {
	HangHoaDao hdao = new HangHoaDao();
	ArrayList<HangHoaBean> ds;
	DungChung dc =new DungChung();
	public ArrayList<HangHoaBean> gethh() throws Exception{
		ds = hdao.getHH();
		return ds;
	}
	
	public DefaultTableModel napbang(String tb) throws Exception{
		return dc.napbang(tb);
	}
	
	public int Them(String IDHangHoa, String TenHangHoa, int SoLuong, Double DonGia, String DonVi, String IDNCC) throws Exception{
		for(HangHoaBean hh: ds)
			if(hh.getIdhh().equals(IDHangHoa))
				return 0;
		HangHoaBean hh = new HangHoaBean(IDHangHoa, TenHangHoa, SoLuong, DonGia, DonVi, IDNCC);
		ds.add(hh);
		return hdao.Them(IDHangHoa, TenHangHoa, SoLuong, DonGia, DonVi, IDNCC);
	}
	
	public int Sua(String IDHangHoa, String TenHangHoa, int sl, Double dg, String DonVi, String IDNCC) throws Exception{
		for(HangHoaBean hh: ds)
			if(hh.getIdhh().equals("IDHangHoa")) {
				hh.setTenhh(IDHangHoa);
				hh.setSoluong(sl);
				hh.setDongia(dg);
				hh.setIdncc(IDNCC);
			}
		return hdao.Sua(IDHangHoa, TenHangHoa, sl, dg, DonVi, IDNCC);
	}
	
	public int UpdateSoLuong(String IDHangHoa, int soluong) throws Exception{

		return hdao.UpdateSoLuong(IDHangHoa,soluong );
	}
	
	public int Xoa(String IDHangHoa) throws Exception {
		for(HangHoaBean hh: ds)
			if(hh.getIdhh().equals("IDHangHoa")) {
				ds.remove(hh);
				break;
			}
		return hdao.Xoa(IDHangHoa);
	}

}
