package lt.msi2015.shop;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lt.msi2015.util.Dto;

@Entity
public class ShopItem extends Dto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max=30)
	private String name;
	
	@NotNull
	@Size(max=300)
	private String description;
	
	@Lob
	@NotNull
	@Column(columnDefinition = "LONGBLOB", length=2097152)
	private byte[] image;
	
	@NotNull
	private String imageType;
	
	@NotNull
	private String imageName;
	
	@NotNull
	@Min(0)
	@Max(99)
	private Integer quantity;
	
	@NotNull
	@Min(1)
	@Max(9999)
	private Integer value;
	
	@NotNull
	private Date dateAdded;
	
	public ShopItem() {
		super();
	}

	public ShopItem(String name,
				String description, 
				byte[] image, 
				Integer quantity, 
				Integer value, 
				String imageName, 
				String imageType) {
		
		this.name = name;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.value = value;
		this.imageName = imageName;
		this.imageType = imageType;
		this.dateAdded = new Date();
		
	}
	
	public ShopItem(NewShopItemDto newShopItemDto) {
		this.name = newShopItemDto.name;
		this.description = newShopItemDto.description;
		this.image = newShopItemDto.image;
		this.quantity = newShopItemDto.quantity;
		this.value = newShopItemDto.value;
		this.imageName = newShopItemDto.imageName;
		this.imageType = newShopItemDto.
				imageType;
		this.dateAdded = new Date();
	}

	/*
	 * GettersAnd setters
	 */
	@Override
	public String toString() {
		return this.name;
	}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getValue() {
		return value;
	}


	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String getImageType() {
		return imageType;
	}


	public void setImageType(String imageType) {
		this.imageType = imageType;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}	
	
	
}
