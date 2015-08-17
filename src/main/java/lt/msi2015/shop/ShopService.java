package lt.msi2015.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	ShopRepository shopRepository;
	
	boolean save(ShopItem item) {
		return shopRepository.save(item) != null;
	}
	
}
