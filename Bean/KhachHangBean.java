package Bean;

public class KhachHangBean {
	private String idkh;
	private String hoten;
	private String diachi;
	private String htttoan;
	
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHangBean(String idkh, String hoten, String diachi, String htttoan) {
		super();
		this.idkh = idkh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.htttoan = htttoan;
	}

	public String getIdkh() {
		return idkh;
	}

	public void setIdkh(String idkh) {
		this.idkh = idkh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHtttoan() {
		return htttoan;
	}

	public void setHtttoan(String htttoan) {
		this.htttoan = htttoan;
	}
	
	
}
