package Bean;

import java.util.Date;

public class HoaDonBean {
	private int idhd;
	private String idkh;
	private String idnv;
	private Date ngaymua;
//	private static int count=0;
//	public String autoID() {
//		this.idhd="HD" + count++;
//		return this.idhd;
//	}
	public HoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonBean(int idhd, String idkh, String idnv, Date ngaymua) {
		super();
		this.idhd = idhd;
		this.idkh = idkh;
		this.idnv = idnv;
		this.ngaymua = ngaymua;
	}
	public int getIdhd() {
		return idhd;
	}
	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}
	public String getIdkh() {
		return idkh;
	}
	public void setIdkh(String idkh) {
		this.idkh = idkh;
	}
	public String getIdnv() {
		return idnv;
	}
	public void setIdnv(String idnv) {
		this.idnv = idnv;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
}
