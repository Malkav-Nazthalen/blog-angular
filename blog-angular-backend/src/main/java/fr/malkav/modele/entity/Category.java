package fr.malkav.modele.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARAM_CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAT_ID", nullable = false, length = 9)
	private int id;

	@Column(name = "CAT_CODE", length = 50, nullable = false)
	private String code;

	@Column(name = "CAT_NAME", length = 100, nullable = false)
	private String name;

	@Column(name = "CAT_MORE", nullable = true)
	private Boolean more;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "CAT_PARENT_ID", nullable = true)
	private Category categoryParent;

	@OneToMany(mappedBy = "categoryParent", orphanRemoval = true)
	private List<Category> listOfChild = new ArrayList<>();

	public Category() {
		// Empty default constructor.
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

	public Boolean getMore() {
		return more;
	}

	public void setMore(Boolean more) {
		this.more = more;
	}

	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}

	public List<Category> getListOfChild() {
		return listOfChild;
	}

	public void setListOfChild(List<Category> listOfChild) {
		this.listOfChild = listOfChild;
	}

}
