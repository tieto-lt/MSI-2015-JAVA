package lt.msi2015.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.msi2015.applicationSettings.ApplicationSetting;

@RestController
public class ShopRest {
	
	@Autowired
	private ShopRepository repository;
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "/api/shop/items", method = RequestMethod.GET)
	List<ShopItemDto> getShopItems() {
		List<ShopItemDto> items = new ArrayList<>();
		for (ShopItem shopItem : repository.findAll()) {
			items.add(new ShopItemDto(shopItem.getId(), 
									shopItem.getName(), 
									shopItem.getDescription(), 
									shopItem.getImage(), 
									shopItem.getQuantity(), 
									shopItem.getValue()));
		}
		
		return items;
	}
	
	@RequestMapping(value = "/api/shop/addItem", method = RequestMethod.POST)
	ResponseEntity<?> addNewItem(@RequestBody NewShopItemDto item) {
		if (!shopService.save(new ShopItem(item))) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
