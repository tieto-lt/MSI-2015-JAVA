package lt.msi2015.points_transfer_info;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// points/send

@RestController
public class PointsTransferInfoRest {
	
	@Autowired
	PointsTransferInfoRepository repo;
	
	@RequestMapping(value = "/points/send", method = RequestMethod.POST)
	PointsTransferInfo save(
		@RequestBody PointsTransferInfoDto info
	) {
		return repo.save(new PointsTransferInfo(info.fromUser, info.toUser, info.points));
	}
	
}
