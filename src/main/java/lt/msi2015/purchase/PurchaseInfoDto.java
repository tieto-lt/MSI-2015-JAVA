package lt.msi2015.purchase;

import lt.msi2015.util.Dto;

public class PurchaseInfoDto extends Dto {

	private Long userId;
	private Long shopItemId;
	
	public PurchaseInfoDto() {
		super();
	}

	public PurchaseInfoDto(Long userId, Long shopItemId) {
		super();
		this.userId = userId;
		this.shopItemId = shopItemId;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getShopItemId() {
		return shopItemId;
	}
}
