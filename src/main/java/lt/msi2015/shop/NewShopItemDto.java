package lt.msi2015.shop;

public class NewShopItemDto {

	public String name;
	public String description;
	public byte[] image;
	public String imageContentType;
	public Integer quantity;
	public Integer value;

	public NewShopItemDto() {}

	public NewShopItemDto(String name, String description, byte[] image, String imageContentType, Integer quantity, Integer value) {
			this.name = name;
			this.description = description;
			this.image = image;
			this.quantity = quantity;
			this.value = value;
			this.imageContentType = imageContentType;
		}

}
