package lt.msi2015.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseInfoService {
	
	@Autowired
	PurchaseInfoRepository purchaseRepo;
	
	public boolean buy(PurchaseInfoDto info) {

		return purchaseRepo.save(
				new PurchaseInfo(
					info.getId(),
					info.getUserId(),
					info.getShopItemId())
				) != null;
	}
}
