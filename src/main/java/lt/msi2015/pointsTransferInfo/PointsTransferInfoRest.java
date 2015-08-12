package lt.msi2015.pointsTransferInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PointsTransferInfoRest {
	
	@Autowired
	PointsTransferInfoService service;
	
	@RequestMapping(value = "/api/points/send", method = RequestMethod.POST)
	ResponseEntity<PointsTransferInfo> save(@RequestBody PointsTransferInfoDto info) {
		System.out.println("xxx");
		if (!service.save(info))
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
