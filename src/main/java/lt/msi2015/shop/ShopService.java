package lt.msi2015.shop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.msi2015.purchase.PurchaseInfo;
import lt.msi2015.purchase.PurchaseInfoRepository;
import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service
public class ShopService {
	
	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	PurchaseInfoRepository purchaseInfoRepo;
	
	@Autowired
	UserRepository userRepo;

	@Transactional
	boolean save(ShopItem item) {
		if (imageIsValid(item.getImageType())) {
			return shopRepository.save(item) != null;
		}
		
		return false;
	}
	
	@Transactional
	ShopItemDto getShopItem(Long id) {
		ShopItem item = shopRepository.findById(id);
		if (item != null) {
			return new ShopItemDto(item.getId(), item.getName(), item.getDescription(),
					item.getImage(), item.getQuantity(), item.getValue(), item.getImageName(), item.getImageType(), item.getDateAdded());
		}
		return null;
	}
	
	@Transactional
	boolean updateShopItem(ShopItemDto itemEdited) {
		if (!imageIsValid(itemEdited.imageType)) {
			return false;
		}
		
		return updateItemInfo(itemEdited);
	}
	
	private boolean updateItemInfo(ShopItemDto itemEdited) {
		ShopItem itemInDatabase = shopRepository.findById(itemEdited.id);
		if (itemInDatabase != null) {
			softDeleteItem(itemInDatabase.getId());
			return save(new ShopItem(itemEdited.name,
							  itemEdited.description,
							  itemEdited.image,
							  itemEdited.quantity,
							  itemEdited.value,
							  itemEdited.imageName,
							  itemEdited.imageType));
		}
		
		return false;
	}
	
	boolean imageIsValid(String type) {
		return (type.equals("image/jpeg")) || (type.equals("image/png")) || (type.equals("image/gif"));
	}

	@Transactional
	public ShopItem softDeleteItem(Long id) {
		ShopItem shopItem = shopRepository.findById(id);
		shopItem.setDeleted(true);
		return shopRepository.save(shopItem);
	}

	@Transactional
	public List<PurchasedShopItemDto> getUserPurchases(Long userId) {
		List<PurchasedShopItemDto> purchaseList = new ArrayList<> ();
		List<PurchaseInfo> purchasedShopItems =  purchaseInfoRepo.findAllByUserId(userId);
		
		SimpleDateFormat dateForHistoryDisplay = new SimpleDateFormat("YYYY-MM-dd");
		
		for (PurchaseInfo purchasedItemInfo: purchasedShopItems) {
			ShopItem item = shopRepository.findById(purchasedItemInfo.getShopItemId());
			
			purchaseList
				.add(new PurchasedShopItemDto(item.getId(),
											  item.getName(),
											  item.getImage(),
											  item.getValue(),
											  purchasedItemInfo.getBuyDate(),
											  dateForHistoryDisplay
											  .format(purchasedItemInfo.getBuyDate()).toString())
			);
		
		}
		
		return purchaseList;
	}

	public List<PurchasedItemsAdminDto> getAllPurchases() {
		List<PurchasedItemsAdminDto> purchaseList = new ArrayList<> ();
		List<PurchaseInfo> purchasedShopItems =  purchaseInfoRepo.findAll();
		
		SimpleDateFormat dateForHistoryDisplay = new SimpleDateFormat("YYYY-MM-dd");
		
		for (PurchaseInfo purchasedItemInfo: purchasedShopItems) {
			ShopItem item = shopRepository.findById(purchasedItemInfo.getShopItemId());
			User user = userRepo.findById(purchasedItemInfo.getUserId());
			
			purchaseList
				.add(new PurchasedItemsAdminDto(item.getId(),
											  item.getName(),
											  user.getFirstName() + " " + user.getLastName(),
											  item.getImage(),
											  item.getValue(),
											  purchasedItemInfo.getBuyDate(),
											  dateForHistoryDisplay
											  .format(purchasedItemInfo.getBuyDate()).toString())
			);
		
		}
		
		return purchaseList;
	}
}
