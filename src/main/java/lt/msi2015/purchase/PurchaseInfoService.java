package lt.msi2015.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.shop.ShopItem;
import lt.msi2015.shop.ShopRepository;
import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service
public class PurchaseInfoService {
	
	@Autowired
	PurchaseInfoRepository purchaseRepo;
	
	@Autowired
	ShopRepository shopRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	public boolean buy(PurchaseInfoDto info) {
		
		User user = userRepo.findById(info.getUserId());
		ShopItem item = shopRepo.findById(info.getShopItemId());
		
		if((item.getQuantity() == 0) || (!subPoints(user, item))) {
			return false;
		}
		
		if(purchaseRepo.save(
				new PurchaseInfo(
					info.getUserId(),
					info.getShopItemId(),
					new Boolean(false))
				) != null) {
			return subShopItemAmount(info.getShopItemId());
		} else {
			return false;
		}
	}
	

	public boolean togglePurchase(Long id){
		List<PurchaseInfo> list = purchaseRepo.findById(id);
		if(list.isEmpty()){
			return false;
		} else {
			PurchaseInfo info = list.get(0);
			info.toggleReceived();
			purchaseRepo.save(info);
			return true;
		}
	}
	
	
	/*
	 * private methods
	 */
	private boolean subShopItemAmount(Long shopItemId) {
		ShopItem item = shopRepo.findById(shopItemId);
		Integer itemQuantity = item.getQuantity();
		item.setQuantity(itemQuantity - 1);
		return shopRepo.save(item) != null;
	}
	
	private boolean subPoints(User user, ShopItem item) {
		
		if(user.getUserPoints() >= item.getValue()) {
			user.setUserPoints(user.getUserPoints() - item.getValue());
			return true;
		}
		
		return false;
	}
}
