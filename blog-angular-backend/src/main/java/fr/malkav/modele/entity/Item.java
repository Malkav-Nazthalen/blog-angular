package fr.malkav.modele.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author jgrimm
 *
 */
@Entity
@Table(name = "PARAM_ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private int id;

	@Column(name = "ITEM_NAME", length = 20, nullable = false)
	private String name;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "CAT_ID", nullable = false)
	private Category category;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "USR_ID", nullable = false)
	private User creator;

	@Column(name = "ITEM_IMG_HEAD_URL", length = 100, nullable = false)
	private String imageHeadUrl;

	@Column(name = "ITEM_COMMENTS", length = 150, nullable = false)
	private String commentaire;

	@Lob
	@Column(name = "ITEM_CONTENT")
	private String content;

	public Item() {
		// Default empty constructor.
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getImageHeadUrl() {
		return imageHeadUrl;
	}

	public void setImageHeadUrl(String imageHeadUrl) {
		this.imageHeadUrl = imageHeadUrl;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
