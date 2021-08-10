package Bean;

public class ChiTietHoaDonBean {
	private int idhd;
	private String idhh;
	private int soluong;
	public ChiTietHoaDonBean(int idhd, String idhh, int soluong) {
		super();
		this.idhd = idhd;
		this.idhh = idhh;
		this.soluong = soluong;
	}
	public ChiTietHoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdhd() {
		return idhd;
	}
	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}
	public String getIdhh() {
		return idhh;
	}
	public void setIdhh(String idhh) {
		this.idhh = idhh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	

}
