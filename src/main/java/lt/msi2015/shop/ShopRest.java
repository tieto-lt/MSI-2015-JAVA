package lt.msi2015.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopRest {
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "/api/shop/items", method = RequestMethod.GET)
	List<ShopItemDto> getShopItems() {
		List<ShopItemDto> items = new ArrayList<>();
		for (ShopItem shopItem : shopRepository.findAll()) {
			items.add(new ShopItemDto(shopItem.getId(), 
									shopItem.getName(), 
									shopItem.getDescription(), 
									shopItem.getImage(), 
									shopItem.getQuantity(), 
									shopItem.getValue(),
									shopItem.getImageType(),
									shopItem.getImageName(),
									shopItem.getDateAdded())
					);
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
	

	@RequestMapping(value = "/api/shop/deleteItem/{id}", method = RequestMethod.DELETE)
	boolean deleteItem(@PathVariable Long id) {
		if(shopRepository.findById(id) == null){
			return false;
		} else {
			shopRepository.delete(id);
			return true;
		}
	}

	@RequestMapping(value = "api/shop/item/{id}", method = RequestMethod.GET) 
	ResponseEntity<ShopItemDto> getShopItem (@PathVariable Long id){
		ShopItemDto item = shopService.getShopItem(id);
		if (item != null)
			return new ResponseEntity<>(item, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "api/shop/updateItem", method = RequestMethod.POST) 
	ResponseEntity<?> updateShopItem (@RequestBody ShopItemDto item){
		if (shopService.updateShopItem(item))
			return new ResponseEntity<>(null, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}
