package lt.msi2015.shop;

import java.util.Date;

import lt.msi2015.util.Dto;

public class PurchasedItemsAdminDto extends Dto {

	private Long id;
	private String name;
	private String buyersName;
	private byte[] image;
	private Integer price;
	private Date dateAdded;
	private String dateToDisplay;
	
	/*
	 * Constructors
	 */
	public PurchasedItemsAdminDto() {
		
	}
	
	public PurchasedItemsAdminDto(Long id,
								String name,
								String buyersName,
								byte[] image,
								Integer price,
								Date dateAdded,
								String dateToDisplay) {
		this.id = id;
		this.name = name;
		this.buyersName = buyersName;
		this.image = image;
		this.price = price;
		this.dateAdded = dateAdded;
		this.dateToDisplay = dateToDisplay;
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

	public String getDateToDisplay() {
		return dateToDisplay;
	}

	public void setDateToDisplay(String dateToDisplay) {
		this.dateToDisplay = dateToDisplay;
	}

	public String getBuyersName() {
		return buyersName;
	}

	public void setBuyersName(String buyersName) {
		this.buyersName = buyersName;
	}
}
