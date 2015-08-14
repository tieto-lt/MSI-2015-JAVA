package lt.msi2015.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopRest {
	
	@Autowired
	private ShopRepository repository;
	
	@RequestMapping(value = "/api/shop/items", method = RequestMethod.GET)
	List<ShopItemDto> getShopItems() {
		List<ShopItemDto> items = new ArrayList<>();
		for (ShopItem shopItem : repository.findAll()) {
			items.add(new ShopItemDto(shopItem.id, shopItem.name, 
					shopItem.description, shopItem.image, shopItem.quantity, shopItem.value));
		}
		
		return items;
	}
}
