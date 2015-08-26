package lt.msi2015.purchase;

import java.util.List;

import org.springframework.data.repository.Repository;
import java.lang.Long;
import lt.msi2015.purchase.PurchaseInfo;

public interface PurchaseInfoRepository extends Repository<PurchaseInfo, Long> {
	PurchaseInfo save(PurchaseInfo info);
	List<PurchaseInfo> findAll();
	List<PurchaseInfo> findAllByUserId(Long userId);
	List<PurchaseInfo> findById(Long id);
}