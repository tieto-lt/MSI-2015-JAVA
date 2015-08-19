package lt.msi2015.purchase;

import org.springframework.data.repository.Repository;

public interface PurchaseInfoRepository extends Repository<PurchaseInfo, Long> {
	PurchaseInfo save(PurchaseInfo info);
}