package fr.malkav.modele;

public class ItemLite extends ItemName {

	private User creator;
	private String imageHeadUrl;
	private String commentaire;

	public ItemLite() {
	}
	
	public ItemLite(int id, String name, Category category, User creator, String imageHeadUrl, String commentaire) {
		super(id, name, category);
		this.creator = creator;
		this.imageHeadUrl = imageHeadUrl;
		this.commentaire = commentaire;
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

}
