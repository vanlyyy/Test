package Bo;

import java.util.ArrayList;

import Bean.ChiTietHoaDonBean;
import Dao.CTHoaDonDao;

public class CTHDBo {
	CTHoaDonDao ctDao = new CTHoaDonDao();
	ArrayList<ChiTietHoaDonBean> ds;
	public ArrayList<ChiTietHoaDonBean> getCt() throws Exception{
		ds = ctDao.getCT();
		return ds;
	}
	public int Them(int idhd, String idhh, int soluong) throws Exception {
//		for(ChiTietHoaDonBean n: ds)
//			if(n.getIdhd().equals(idhd) && n.getIdhh().equals(idhh)) 
//				return 0;
//		ChiTietHoaDonBean ct = new ChiTietHoaDonBean(idhd, idhh, soluong);
//		ds.add(ct);
		return ctDao.Them(idhd, idhh, soluong);
	}
}
