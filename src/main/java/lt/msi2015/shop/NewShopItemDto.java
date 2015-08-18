package lt.msi2015.shop;

public class NewShopItemDto {

	public String name;
	public String description;
	public byte[] image;
	public Integer quantity;
	public Integer value;
	public String imageName;
	public String imageType;

	public NewShopItemDto() {}

	public NewShopItemDto(String name, String description, byte[] image,
				Integer quantity, Integer value, String imageName, String imageType) {
			this.name = name;
			this.description = description;
			this.image = image;
			this.quantity = quantity;
			this.value = value;
			this.imageName = imageName;
			this.imageType = imageType;
		}

}
