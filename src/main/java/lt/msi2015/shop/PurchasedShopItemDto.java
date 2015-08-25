package lt.msi2015.shop;

import java.util.Date;

import lt.msi2015.util.Dto;

public class PurchasedShopItemDto extends Dto {

	private Long id;
	private String name;
	private byte[] image;
	private Integer price;
	private Date dateAdded;
	
	/*
	 * Constructors
	 */
	public PurchasedShopItemDto() {
		
	}
	
	public PurchasedShopItemDto(Long id,
								String name,
								byte[] image,
								Integer price,
								Date dateAdded) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.dateAdded = dateAdded;
	}
	
	/*
	 * Getters and Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
