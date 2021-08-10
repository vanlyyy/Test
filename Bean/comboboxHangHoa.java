package Bean;

public class comboboxHangHoa {
	private String key; //IdHH
	private String value;//Ten HH
	private Double dongia;
	private String donvi;
	private int soluong;
	
	@Override
	public String toString() {
		return key;
	}

	public comboboxHangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public comboboxHangHoa(String key, String value, Double dongia, String donvi, int soluong) {
		super();
		this.key = key;
		this.value = value;
		this.dongia = dongia;
		this.donvi = donvi;
		this.soluong = soluong;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
}
