package lt.msi2015.pointsTransferInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.msi2015.category.Category;
import lt.msi2015.category.CategoryDto;
import lt.msi2015.category.CategoryRepository;
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
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/api/points/send", method = RequestMethod.POST)
	ResponseEntity<PointsTransferInfo> save(@RequestBody PointsTransferInfoDto info) {
		if (!service.save(info))
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/api/points", method = RequestMethod.GET)
//	List<ExistingPointsTransferInfoDto> get() {
//		return service.getAllTransfers();
//	}
	
	@RequestMapping(value = "/api/newsfeed", method = RequestMethod.GET)
	public List<NewsFeedDto> getNewsfeed() {
		
		List<NewsFeedDto> newsFeed = new ArrayList<NewsFeedDto>();
		
		List<PointsTransferInfo> allTransfers = transfersRepo.findAll();
		
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");	
		
		for (PointsTransferInfo transfer : allTransfers) {
			User fromUser = userRepo.findById(transfer.fromUserID);
			User toUser = userRepo.findById(transfer.toUserID);
			Category category = transfer.getCategory();
			NewsFeedDto entry = new NewsFeedDto(
				fromUser.getId(),
				toUser.getId(),
				fromUser.getImage(),
				toUser.getImage(),
				fromUser.getFirstName(),
				fromUser.getLastName(),
				toUser.getFirstName(),
				toUser.getLastName(),
				transfer.getPoints(),
				transfer.getComment(),
				s.format(transfer.getDateCreated()).toString(),
				transfer.getDateCreated(),
				new CategoryDto(category.getId(), category.getName()) 
			);
			newsFeed.add(entry);
		}
		
		
		return newsFeed;

	}
	
	//FOR PROFILE NEWS FEED*************************
	
	@RequestMapping(value = "/api/profileNewsfeed/{id}", method = RequestMethod.GET)
	public List<NewsFeedDto> getprofileNewsfeed(@PathVariable Long id) {
		
		List<NewsFeedDto> newsFeed = new ArrayList<NewsFeedDto>();
		
		List<PointsTransferInfo> allTransfers = transfersRepo.findAll();
		
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
		
		for (PointsTransferInfo transfer : allTransfers) {
				// Only user newsfeed
			if(id == transfer.fromUserID || id == transfer.toUserID) {
				User fromUser  = userRepo.findById(transfer.fromUserID);
				User toUser  = userRepo.findById(transfer.toUserID);
				Category category = transfer.getCategory();
				NewsFeedDto entry = new NewsFeedDto(
					fromUser.getId(),
					toUser.getId(),
					fromUser.getImage(),
					toUser.getImage(),
					fromUser.getFirstName(),
					fromUser.getLastName(),
					toUser.getFirstName(),
					toUser.getLastName(),
					transfer.getPoints(),
					transfer.getComment(),
					s.format(transfer.getDateCreated()).toString(),
					transfer.getDateCreated(),
					new CategoryDto(category.getId(), category.getName())
				);
				newsFeed.add(entry);
			}
		}
		return newsFeed;
	}
	
}