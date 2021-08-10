package Bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.HoaDonBean;
import Dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao hdDao = new HoaDonDao();
	ArrayList<HoaDonBean> ds;
	public ArrayList<HoaDonBean> getHd() throws Exception{
		ds = hdDao.getHD();
		return ds;
	}
	public String NgayHienTai() throws Exception{
		Date date = new Date();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String cd = dd.format(date);
		return cd;
}
	
	public int Them(String idkh, String idnv, Date ngaymua) throws Exception {
		return hdDao.Them( idkh, idnv, ngaymua);
	}
}
