package fr.malkav.modele.dto.data;

public class ItemLiteData extends ItemNameData {

	private int creatorId;
	private String imageHeadUrl;
	private String commentaire;

	public ItemLiteData() {
	}

	public ItemLiteData(int id, String name, int categoryId, int creatorId, String imageHeadUrl, String commentaire) {
		super(id, name, categoryId);
		this.creatorId = creatorId;
		this.imageHeadUrl = imageHeadUrl;
		this.commentaire = commentaire;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
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
