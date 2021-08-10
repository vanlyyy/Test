package Bean;

public class JComboboxCustom {
	private String key;
	private String value;
	
	@Override
    public String toString()
    {
        return key;
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
	public JComboboxCustom(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
}
