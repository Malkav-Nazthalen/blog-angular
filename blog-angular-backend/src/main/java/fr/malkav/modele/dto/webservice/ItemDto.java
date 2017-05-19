package fr.malkav.modele.dto.webservice;

public class ItemDto extends ItemLiteDto {

	private String content;

	public ItemDto() {
	}
	
	public ItemDto(int id, String name, CategoryDto category, UserDto creator, String imageHeadUrl, String commentaire,
			String content) {
		super(id, name, category, creator, imageHeadUrl, commentaire);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
