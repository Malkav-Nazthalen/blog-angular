package fr.malkav.modele.dto.webservice;

public class ItemNameDto {

	private int id;
	private String name;
	private CategoryDto category;

	public ItemNameDto() {
	}
	
	public ItemNameDto(int id, String name, CategoryDto category) {
		this.id = id;
		this.name = name;
		this.category = category;
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

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

}
