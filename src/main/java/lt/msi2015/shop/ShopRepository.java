package lt.msi2015.shop;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface ShopRepository extends Repository<ShopItem, Long> {
	List<ShopItem> findAll();
	ShopItem save(ShopItem item);
}
