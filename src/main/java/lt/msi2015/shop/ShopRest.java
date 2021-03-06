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
			if (!shopItem.isDeleted()) {
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
		}
		
		return items;
	}
	
	@RequestMapping(value = "/admin/shop/addItem", method = RequestMethod.POST)
	ResponseEntity<?> addNewItem(@RequestBody NewShopItemDto item) {
		if (!shopService.save(new ShopItem(item))) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/admin/shop/deleteItem/{id}", method = RequestMethod.DELETE)
	boolean deleteItem(@PathVariable Long id) {
		if(shopRepository.findById(id) == null){
			return false;
		} else {
			return shopService.softDeleteItem(id) != null;
		}
	}

	@RequestMapping(value = "api/shop/item/{id}", method = RequestMethod.GET) 
	ResponseEntity<ShopItemDto> getShopItem (@PathVariable Long id){
		ShopItemDto item = shopService.getShopItem(id);
		if (item != null)
			return new ResponseEntity<>(item, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/admin/shop/updateItem", method = RequestMethod.POST) 
	ResponseEntity<?> updateShopItem (@RequestBody ShopItemDto item){
		if (shopService.updateShopItem(item))
			return new ResponseEntity<>(null, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "api/shop/userPurchasedItems/{userId}", method = RequestMethod.GET) 
	ResponseEntity<?> getUserPurchases (@PathVariable Long userId){
		List<PurchasedShopItemDto> purchasedItems = shopService.getUserPurchases(userId);
		if (purchasedItems != null)
			return new ResponseEntity<>(purchasedItems, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/admin/shop/allPurchasedItems", method = RequestMethod.GET) 
	ResponseEntity<?> getAllPurchases (){
		List<PurchasedItemsAdminDto> purchasedItems = shopService.getAllPurchases();
		if (purchasedItems != null)
			return new ResponseEntity<>(purchasedItems, HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
}
