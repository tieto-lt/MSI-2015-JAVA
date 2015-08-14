package lt.msi2015.shop;

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
	public Long id;
	
	@NotNull
	@Size(max=30)
	public String name;
	
	@NotNull
	@Size(max=300)
	public String description;
	
	@Lob
	@NotNull
	@Column(columnDefinition = "LONGBLOB", length=2097152)
	public byte[] image;
	
	@NotNull
	@Min(0)
	@Max(99)
	public Integer quantity;
	
	@NotNull
	@Min(1)
	@Max(9999)
	public Integer value;
	
	public ShopItem() {
		super();
	}


	public ShopItem(String name, String description, byte[] image, Integer quantity, Integer value) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.value = value;
	}


	@Override
	public String toString() {
		return this.name;
	}
	
	
	
}
