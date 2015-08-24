package lt.msi2015.shop;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	ShopRepository shopRepository;

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
			itemInDatabase.setName(itemEdited.name);
			itemInDatabase.setDescription(itemEdited.description);
			itemInDatabase.setImage(itemEdited.image);
			itemInDatabase.setValue(itemEdited.value);
			itemInDatabase.setQuantity(itemEdited.quantity);
			itemInDatabase.setImageType(itemEdited.imageType);
			itemInDatabase.setDateAdded(new Date());
			return shopRepository.save(itemInDatabase) != null;
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
}
