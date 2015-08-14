package lt.msi2015.shop;

import lt.msi2015.util.Dto;

public class ShopItemDto extends Dto {

	public Long id;
	public String name;
	public String description;
	public byte[] image;
	public Integer quantity;
	public Integer value;
	
	public ShopItemDto() {}
	
	public ShopItemDto(Long id, String name, String description, byte[] image, Integer quantity, Integer value) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.value = value;
	}
	
	
}
