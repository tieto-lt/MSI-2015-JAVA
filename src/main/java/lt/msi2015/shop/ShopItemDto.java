package lt.msi2015.shop;

import java.util.Date;

import lt.msi2015.util.Dto;

public class ShopItemDto extends Dto {

	public Long id;
	public String name;
	public String description;
	public byte[] image;
	public Integer quantity;
	public Integer value;
	public String imageName;
	public String imageType;
	public Date dateAdded;
	
	public ShopItemDto() {}
	
	public ShopItemDto(Long id, String name, String description, 
			byte[] image, Integer quantity, Integer value, String imageName, String imageType, Date dateAdded) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.value = value;
		this.imageName = imageName;
		this.imageType = imageType;
		this.dateAdded = dateAdded;
	}
	
}
