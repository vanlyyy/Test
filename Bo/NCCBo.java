package Bo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Bean.NCCBean;
import Dao.DungChung;
import Dao.NCCDao;

public class NCCBo {
	NCCDao nccdao = new NCCDao();
	ArrayList<NCCBean> ds;
	public ArrayList<NCCBean> getNCC () throws Exception{
		ds = nccdao.getNCC();
		return ds;
	}
	public DefaultTableModel napbang(String tb) throws Exception{
		DungChung dc = new DungChung();
		return dc.napbang(tb);
	}
	public int Them(String idncc,String tenncc,String diachi) throws Exception{
		for(NCCBean n: ds)
			if(n.getIdncc().equals(idncc))
				return 0;
		NCCBean ncc = new NCCBean(idncc, tenncc, diachi);
		ds.add(ncc);
		return nccdao.Them(idncc, tenncc, diachi);
	}
	public int Sua(String idncc,String tenncc,String diachi) throws Exception{
		for(NCCBean n: ds)
			if(n.getIdncc().equals(idncc)) {
				n.setTenncc(tenncc);
				n.setDiachi(diachi);
			}
		return nccdao.Sua(idncc, tenncc, diachi);		
	}
	public int Xoa(String idncc) throws Exception{
		for(NCCBean n: ds)
			if(n.getIdncc().equals(idncc)) {
				ds.remove(n);
				break;
			}
		return nccdao.Xoa(idncc);
	}


}
