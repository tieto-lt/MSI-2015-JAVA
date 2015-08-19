package lt.msi2015.pointsTransferInfo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lt.msi2015.user.User;

public interface PointsTransferInfoRepository extends CrudRepository<PointsTransferInfo, Long> {
	List<PointsTransferInfo> findAll();
}
