package lt.msi2015.purchase;

import java.util.Date;

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

	@NotNull
	private Date buyDate;
	
	@NotNull
	private Boolean isReceived;
	
	/*
	 * Constructors
	 */
	public PurchaseInfo() {
		
	}
	
	public PurchaseInfo(Long userId, Long shopItemId, Boolean isReceived) {
		super();
		this.userId = userId;
		this.shopItemId = shopItemId;
		this.buyDate = new Date();
		this.isReceived = isReceived;
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

	public Date getBuyDate() {
		return buyDate;
	}

	public void toggleReceived() {
		this.isReceived = !isReceived;
	}
}
