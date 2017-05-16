package fr.malkav.modele;

public class Category {

	private int id;
	private String code;
	private String name;
	private boolean more;

	public Category() {
	}

	public Category(int id, String code, String name, boolean more) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.more = more;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMore() {
		return more;
	}

	public void setMore(boolean more) {
		this.more = more;
	}

}
