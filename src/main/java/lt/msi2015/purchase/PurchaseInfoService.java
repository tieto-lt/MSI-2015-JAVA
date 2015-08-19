package lt.msi2015.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.shop.ShopItem;
import lt.msi2015.shop.ShopRepository;

@Service
public class PurchaseInfoService {
	
	@Autowired
	PurchaseInfoRepository purchaseRepo;
	
	@Autowired
	ShopRepository shopRepo;
	
	public boolean buy(PurchaseInfoDto info) {
		
		if(purchaseRepo.save(
				new PurchaseInfo(
					info.getId(),
					info.getUserId(),
					info.getShopItemId())
				) != null) {
			
			return subShopItemAmount(info.getShopItemId());
		} else {
			return false;
		}
	}
	
	private boolean subShopItemAmount(Long shopItemId) {
		ShopItem item = shopRepo.findById(shopItemId);
		Integer itemQuantity = item.getQuantity();
		item.setQuantity(itemQuantity - 1);
		return shopRepo.save(item) != null;
	}
}
