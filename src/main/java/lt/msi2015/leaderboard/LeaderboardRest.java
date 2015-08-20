package lt.msi2015.leaderboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardRest {

	@Autowired
	LeaderboardService leaderboardService;
	
	@RequestMapping(value = "/api/leaderboard", method = RequestMethod.GET)
	List<LeaderboardEntryDto> leaderboard() {
		List<LeaderboardEntryDto> sortedEntries = leaderboardService.getLeaderboardSortedEntries();
		return leaderboardService.getSublistOfFive(sortedEntries);
	}
	
}
