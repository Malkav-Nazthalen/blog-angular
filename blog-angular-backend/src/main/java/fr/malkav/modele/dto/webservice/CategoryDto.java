package fr.malkav.modele.dto.webservice;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

	private int id;
	private String code;
	private String name;
	private boolean more;
	private CategoryDto parent;
	private List<CategoryDto> listOfChildCategory = new ArrayList<>();

	public CategoryDto() {
	}

	public CategoryDto(int id, String code, String name, boolean more) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.more = more;
	}

	public CategoryDto(int id, String code, String name, boolean more, List<CategoryDto> listOfChildCategory) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.more = more;
		this.listOfChildCategory = listOfChildCategory;
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

	public List<CategoryDto> getListOfChildCategory() {
		return listOfChildCategory;
	}

	public void setListOfChildCategory(List<CategoryDto> listOfChildCategory) {
		this.listOfChildCategory = listOfChildCategory;
	}

	public CategoryDto getParent() {
		return parent;
	}

	public void setParent(CategoryDto parent) {
		this.parent = parent;
	}
}
