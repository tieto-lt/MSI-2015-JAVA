package lt.msi2015.pointsTransferInfo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import java.lang.Long;
import lt.msi2015.pointsTransferInfo.PointsTransferInfo;

public interface PointsTransferInfoRepository extends CrudRepository<PointsTransferInfo, Long> {
	List<PointsTransferInfo> findAll();
	List<PointsTransferInfo> findByFromUserID(Long fromuserid);
	List<PointsTransferInfo> findByToUserID(Long touserid);
}
