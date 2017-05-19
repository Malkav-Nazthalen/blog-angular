package fr.malkav.modele.dto.data;

public class ItemNameData {

	private int id;
	private String name;
	private int categoryId;

	public ItemNameData() {
	}

	public ItemNameData(int id, String name, int categoryId) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
