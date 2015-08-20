package lt.msi2015.pointsTransferInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;


@RestController
public class PointsTransferInfoRest {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PointsTransferInfoRepository transfersRepo;
	
	@Autowired
	PointsTransferInfoService service;
	
	@RequestMapping(value = "/api/points/send", method = RequestMethod.POST)
	ResponseEntity<PointsTransferInfo> save(@RequestBody PointsTransferInfoDto info) {
		if (!service.save(info))
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/points", method = RequestMethod.GET)
	List<ExistingPointsTransferInfoDto> get() {
		return service.getAllTransfers();
	}
	
	@RequestMapping(value = "/api/newsfeed", method = RequestMethod.GET)
	public List<NewsFeedDto> getUser() {
		
		List<NewsFeedDto> newsFeed = new ArrayList<NewsFeedDto>();
		
		List<PointsTransferInfo> allTransfers = transfersRepo.findAll();
		
		SimpleDateFormat s = new SimpleDateFormat("MMdd");
		
		for (PointsTransferInfo transfer : allTransfers) {
			User fromUser  = userRepo.findById(transfer.fromUserID);
			User toUser  = userRepo.findById(transfer.toUserID);
			NewsFeedDto entry = new NewsFeedDto(
					fromUser.getFirstName(),
					fromUser.getLastName(),
					toUser.getFirstName(),
					toUser.getLastName(),
					transfer.getPoints(),
					transfer.getComment(),
					s.format(transfer.getDateCreated()).toString()
					);
			newsFeed.add(entry);
		}
		
		
		return newsFeed;

	}
}
