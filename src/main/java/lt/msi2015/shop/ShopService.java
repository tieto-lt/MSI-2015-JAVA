package lt.msi2015.shop;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	ShopRepository shopRepository;
	
	@Transactional
	boolean save(ShopItem item) {
		if (isImageValid(item.getImageType()))
			return shopRepository.save(item) != null;
		return false;
	}
	
	@Transactional
	ShopItemDto getShopItem(Long id) {
		ShopItem item = shopRepository.findById(id);
		return new ShopItemDto(item.getId(), item.getName(), item.getDescription(),
				item.getImage(), item.getQuantity(), item.getValue(), item.getImageName(), item.getImageType());
	}
	
	@Transactional
	boolean updateShopItem(ShopItemDto itemEdited) {
		if (!isImageValid(itemEdited.imageType))
			return false;
		
		updateItemInfo(itemEdited);
		return true;
	}
	
	private void updateItemInfo(ShopItemDto itemEdited) {
		ShopItem itemInDatabase = shopRepository.findById(itemEdited.id);
		itemInDatabase.setName(itemEdited.name);
		itemInDatabase.setDescription(itemEdited.description);
		itemInDatabase.setImage(itemEdited.image);
		itemInDatabase.setValue(itemEdited.value);
		itemInDatabase.setQuantity(itemEdited.quantity);
		itemInDatabase.setImageType(itemEdited.imageType);
	}
	
	boolean isImageValid(String type) {
		return (type == "image/jpeg") || (type == "image/png") || (type == "image/gif");
	}
}
