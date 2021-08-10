package Bean;

public class HangHoaBean {
	private String idhh;
	private String tenhh;
	private int soluong;
	private Double dongia;
	private String donvi;
	private String idncc;
	
	public String getIdhh() {
		return idhh;
	}
	public void setIdhh(String idhh) {
		this.idhh = idhh;
	}
	public String getTenhh() {
		return tenhh;
	}
	public void setTenhh(String tenhh) {
		this.tenhh = tenhh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Double getDongia() {
		return dongia;
	}
	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}
	public String getDonvi() {
		return donvi;
	}
	public void setDonvi(String donvi) {
		this.donvi = donvi;
	}
	public String getIdncc() {
		return idncc;
	}
	public void setIdncc(String idncc) {
		this.idncc = idncc;
	}
	public HangHoaBean(String idhh, String tenhh, int soluong, Double dongia, String donvi, String idncc) {
		super();
		this.idhh = idhh;
		this.tenhh = tenhh;
		this.soluong = soluong;
		this.dongia = dongia;
		this.donvi = donvi;
		this.idncc = idncc;
	}
	public HangHoaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
