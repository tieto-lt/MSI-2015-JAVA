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
public class ShopItemEntity extends Dto {
	
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
	@Min(0)
	@Max(99)
	private Integer quantity;
	
	@NotNull
	@Min(1)
	@Max(9999)
	private Integer value;


	public ShopItemEntity(String name, String description, byte[] image, Integer quantity, Integer value) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
		this.value = value;
	}
	
}
