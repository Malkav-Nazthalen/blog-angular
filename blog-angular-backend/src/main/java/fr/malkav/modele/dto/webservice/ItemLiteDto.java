package fr.malkav.modele.dto.webservice;

public class ItemLiteDto extends ItemNameDto {

	private UserDto creator;
	private String imageHeadUrl;
	private String commentaire;

	public ItemLiteDto() {
	}
	
	public ItemLiteDto(int id, String name, CategoryDto category, UserDto creator, String imageHeadUrl, String commentaire) {
		super(id, name, category);
		this.creator = creator;
		this.imageHeadUrl = imageHeadUrl;
		this.commentaire = commentaire;
	}

	public UserDto getCreator() {
		return creator;
	}

	public void setCreator(UserDto creator) {
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
