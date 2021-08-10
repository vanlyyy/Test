package Bean;

public class NCCBean {
	private String idncc;
	private String tenncc;
	private String diachi;
	public NCCBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NCCBean(String idncc, String tenncc, String diachi) {
		super();
		this.idncc = idncc;
		this.tenncc = tenncc;
		this.diachi = diachi;
	}
	public String getIdncc() {
		return idncc;
	}
	public void setIdncc(String idncc) {
		this.idncc = idncc;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
}
