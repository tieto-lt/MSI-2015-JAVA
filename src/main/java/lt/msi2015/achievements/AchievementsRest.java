package lt.msi2015.achievements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementsRest {

	@Autowired
	AchievementsService achievementsService;
	
	@RequestMapping(value = "/api/claim", method = RequestMethod.POST) 
	ResponseEntity<?> claimAchievements (@RequestBody AchievementDto dto){
		
		achievementsService.claimAchievement(dto);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
