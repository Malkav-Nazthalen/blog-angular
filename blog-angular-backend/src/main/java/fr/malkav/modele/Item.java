package fr.malkav.modele;

public class Item extends ItemLite {

	private String content;

	public Item() {
	}
	
	public Item(int id, String name, Category category, User creator, String imageHeadUrl, String commentaire,
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
