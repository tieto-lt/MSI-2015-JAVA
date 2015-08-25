package lt.msi2015.purchase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PurchaseInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long shopItemId;

	/*
	 * Constructors
	 */
	public PurchaseInfo() {
		
	}
	
	public PurchaseInfo(Long userId, Long shopItemId) {
		super();
		this.userId = userId;
		this.shopItemId = shopItemId;
	}

	/*
	 * Getters and Setters
	 */
	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getShopItemId() {
		return shopItemId;
	}
	
}
