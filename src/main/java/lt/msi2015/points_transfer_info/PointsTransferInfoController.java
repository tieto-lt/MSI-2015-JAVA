package lt.msi2015.points_transfer_info;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// points/send

@RestController
public class PointsTransferInfoController {
	
	@Autowired
	PointsTransferInfoRepository repo;
	
	@RequestMapping(value = "/points/send", method = RequestMethod.GET)
	PointsTransferInfo save(
		@RequestParam String from,
		@RequestParam String to,
		@RequestParam Integer points
	) {
		PointsTransferInfo info = new PointsTransferInfo(from, to, points, new Date());
		return repo.save(info);
	}
	
}
